import React, { useState, useEffect, useContext } from 'react'
import { fetchResources } from 'api/apis'
import { useErrorModalContext } from 'providers/ErrorModalContext'
import { useLoadingContext } from 'providers/LoadingContext'
import CustomList from 'elements/CustomList'
import { ResourceContext } from 'providers/ResourceContext.jsx'

export default function ResourceList() {
  const [setError] = useErrorModalContext()
  const { state, handlers } = useContext(ResourceContext)

  const [loading, setLoading] = useLoadingContext()

  const [setConnectionError] = useState(false)
  const [data, setData] = useState([])

  const getResources = async () => {
    try {
      setLoading({
        type: 'open',
        payload: { message: `Getting Resources...` },
      })
      const { data } = await fetchResources()
      setData(data.data)
      setLoading({ type: 'close' })
    } catch (error) {
      setLoading({ type: 'close' })
      setConnectionError(true)
      return setError({
        type: 'open',
        payload: { message: error.message || 'Failed to get resources' },
      })
    }
  }

  useEffect(() => {
    getResources()
  }, [])

  const config = {
    data: [],
  }

  data.map((value) => {
    config.data.push({
      name: value.name,
      isActive: value.name === state.selectedResource.name,
      onClickItem: () =>
        handlers.setSelectedResource({
          ...state.selectedResource,
          name: value.name,
          version: value.version,
          created: value.created,
        }),
    })
  })

  return (
    <div>
      <h4
        style={{
          marginBottom: '11px',
          marginLeft: '5px',
        }}
      >
        Resources
      </h4>
      <CustomList listConfig={config} />
    </div>
  )
}
