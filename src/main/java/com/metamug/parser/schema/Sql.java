//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2016.01.02 at 06:40:50 PM IST
//
package com.metamug.parser.schema;

import com.metamug.parser.exception.ResourceTestException;
import com.metamug.parser.service.ParserService;
import static com.metamug.parser.service.ParserService.MASON_DATASOURCE;
import static com.metamug.parser.service.ParserService.MASON_OUTPUT;
import static com.metamug.parser.service.ParserService.MPATH_EXPRESSION_PATTERN;
import static com.metamug.parser.service.ParserService.REQUEST_PARAM_PATTERN;
import com.metamug.parser.service.QueryManagerService;
import com.metamug.parser.service.ResourceTestService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.xpath.XPathExpressionException;
import org.apache.commons.text.StringEscapeUtils;
import org.xml.sax.SAXException;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sql", propOrder = {"value"})
public class Sql extends RequestChild{

    @XmlValue
    protected String value;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "requires")
    protected String requires;
    @XmlAttribute(name = "ref")
    protected String ref;
    @XmlAttribute(name = "when")
    protected String when;
    @XmlAttribute(name = "onblank")
    protected String onblank;
    @XmlAttribute(name = "onerror")
    protected String onerror;
    @XmlAttribute(name = "limit")
    protected String limit;
    @XmlAttribute(name = "offset")
    protected String offset;
    @XmlAttribute(name = "classname")
    protected String classname;
    @XmlAttribute(name = "type")
    protected SqlType type;
    @XmlAttribute(name = "status")
    protected Integer status;
    @XmlAttribute(name = "verbose")
    private Boolean verbose;
    @XmlAttribute(name = "output")
    private Boolean output;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the requires property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getRequires() {
        return requires;
    }

    /**
     * Sets the value of the requires property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setRequires(String value) {
        this.requires = value;
    }

    /**
     * Gets the value of the ref property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setRef(String value) {
        this.ref = value;
    }

    /**
     * Gets the value of the when property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getWhen() {
        return when;
    }

    /**
     * Sets the value of the when property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setWhen(String value) {
        this.when = value;
    }

    /**
     * Gets the value of the onblank property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getOnblank() {
        return onblank;
    }

    /**
     * Sets the value of the onblank property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setOnblank(String value) {
        this.onblank = value;
    }

    /**
     * Gets the value of the onerror property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getOnerror() {
        return onerror;
    }

    /**
     * Sets the value of the onerror property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setOnerror(String value) {
        this.onerror = value;
    }

    /**
     * Sets the value of limit property
     *
     * @return
     */
    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    /**
     * Gets the value of the classname property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClassname() {
        return classname;
    }

    /**
     * Sets the value of the classname property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setClassname(String value) {
        this.classname = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is {@link SqlType }
     *
     */
    public SqlType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is {@link SqlType }
     *
     */
    public void setType(SqlType value) {
        this.type = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * Sets the value of the verbose property.
     *
     * @param verbose allowed object is {@link Boolean}
     *
     */
    public void setVerbose(Boolean verbose) {
        this.verbose = verbose;
    }
    
    /**
     * Gets the value of the output property.
     *
     * @return possible object is {@link Boolean}.
     *
     */
    public Boolean getOutput() {
        if(output != null){
            return output;
        }else if(verbose != null){
            return verbose;
        }
        return null;
    }

    /**
     * Sets the value of the verbose property.
     *
     * @param output allowed object is {@link Boolean}
     *
     */
    public void setOutput(Boolean output) {
        this.output = output;
    }

    @Override
    public void print(XMLStreamWriter writer, ParserService parent) throws XMLStreamException, IOException, XPathExpressionException, ResourceTestException, SAXException {
        this.parent = parent;
        //Sql sql = this;
        parent.elementIds.put(getId(), this);

        if (getOnerror() != null && getOnerror().length() > 0) {
            startValidateTag(writer, getOnerror());
        }

        preProcessSqlElement();               

        printSqlTag(writer, true);

        if (getOnerror() != null && getOnerror().length() > 0) {
            closeValidateTag(writer);
        }
    }
    
    protected void preProcessSqlElement() throws IOException, ResourceTestException{
        String tag = getId();
        String ref = getRef();
        QueryManagerService service = new QueryManagerService();
        String url = parent.domain + "/" + parent.appName;
        String version = Double.toString(parent.resourceVersion);
        String sqlValue = ResourceTestService.preprocessSql(getValue());

        if (ref == null) {
            service.saveQueryWithTag(url, sqlValue, parent.resourceName, version, tag, getType().value(), parent.appName);
        } else {
            service.saveRefWithTag(url, ref, parent.resourceName, version, tag, parent.appName);
        }
    }
    
    /**
     * Prints Query tag along with necessary test conditions as mentioned in Query tag.
     *
     * @param writer XMLStreamWriter to write to JSP file.
     * @param addDatasource boolean whether or not to add datasource attribute - don't add if Sql is inside Transaction
     * @throws XMLStreamException
     * @throws IOException
     * @throws SAXException
     * @throws XPathExpressionException
     * @throws ResourceTestException
     */
    protected void printSqlTag(XMLStreamWriter writer, boolean addDatasource)
            throws XMLStreamException, IOException, SAXException, XPathExpressionException, ResourceTestException {
        //Check for empty tag
        if (!getValue().trim().isEmpty()) {
            if (getWhen() != null) {
                writer.writeStartElement("c:if");
                //String testString = getQuotedString(sql.getWhen());
                //writer.writeAttribute("test", enclose(testString.replace("$", "mtgReq.params")));
                
                String test = transformVariables(getWhen(),parent.elementIds,false);
                writeUnescapedData(" test=\""+enclose(StringEscapeUtils.unescapeXml(test))+"\"", parent.output);
                //String v = transformVariables(((Xparam) paramOrHeaderOrBody).getValue(),elementIds);
                //writeUnescapedData(" value=\""+StringEscapeUtils.unescapeXml(v)+"\"");
            }
            //Print params those are marked as 'requires' in <Sql>
            String requiredParams = getRequires();
            if (requiredParams != null) {
                for (String param : requiredParams.split(",")) {
                    writer.writeEmptyElement("m:param");
                    writer.writeAttribute("name", param);
                    writer.writeAttribute("type", "");
                    writer.writeAttribute("value", enclose("mtgReq.params['" + param + "']"));
                    writer.writeAttribute("isRequired", "true");
                }
            }

            if (getLimit() != null || getOffset() != null) {
                if (getType() != null && getType().value().equalsIgnoreCase("query")) {
                    if (getLimit() != null) {
                        writer.writeEmptyElement("m:param");
                        writer.writeAttribute("name", String.valueOf(getLimit()));
                        writer.writeAttribute("value", enclose("mtgReq.params['" + getLimit() + "']"));
                        writer.writeAttribute("type", "number");
                        writer.writeAttribute("defaultValue", "-1");
                    }
                } else {
                    throw new SAXException("Offset or limit attribute can't be used for Update query");
                }
            }

            writer.writeCharacters(System.lineSeparator());
            if (getType() != null && getType().value().equalsIgnoreCase("update")) {
                writer.writeStartElement("sql:update");
            } else {
                writer.writeStartElement("sql:query");
            }

            String var = getId();//"result";
            
            writer.writeAttribute("var", var);
            if(addDatasource){
                writer.writeAttribute("dataSource", enclose(MASON_DATASOURCE));
            }
            
            if (getLimit() != null || getOffset() != null) {
                if (getType() != null && getType().value().equalsIgnoreCase("query")) {
                    if (getLimit() != null) {
                        writer.writeAttribute("maxRows", enclose("mtgReq.params['" + getLimit() + "']"));
                    }

                    if (getOffset() != null) {
                        writer.writeAttribute("startRow", enclose("mtgReq.params['" + getOffset() + "']"));
                    }

                } else {
                    throw new SAXException("Offset or limit attribute can't be used for Update query");
                }
            }
            //writer.writeCharacters(System.lineSeparator());
            String sqlParams = getSqlParams(this);

            writeUnescapedCharacters(writer, sqlParams, parent.output);

            writer.writeEndElement();//End of <sql:query/update>
            //Store the sql data in map for <sql:query> or <sql:update>  

            writer.writeCharacters(System.lineSeparator());

            printSqlEnd(writer, var);
        }
    }
    
    protected void printSqlEnd(XMLStreamWriter writer, String var) throws XMLStreamException {
      
        boolean verbose = isVerbose(this);
              
        if( getType().value().equalsIgnoreCase("query") && (getClassname() != null) ){
            //if classname is given and type=query, print <m:execute> instead of <m:sqlOut> 
            writer.writeEmptyElement("m:execute");
            writer.writeAttribute("className", getClassname());                
            writer.writeAttribute("var", getId());
            writer.writeAttribute("param", enclose(var));
            writer.writeAttribute("output", String.valueOf(verbose));        
        } else{
            //if no classname and verbose, print <c:set>
            if(verbose)
                printTargetCSet(writer,enclose(MASON_OUTPUT),var,enclose(var)); 
        }
        
        if (getWhen() != null) {
            writer.writeEndElement(); //End of <c:if>
        }
    }
    
    protected String getSqlParams(HashMap<String,RequestChild> elementIds) throws ResourceTestException{
        parent.elementIds = elementIds;
        return getSqlParams(this);
    }

    protected String getSqlParams(Sql sql) throws ResourceTestException {
        String query = sql.getValue();
        LinkedList<String> params = new LinkedList<>();
        LinkedList<String> mpathParams = new LinkedList<>();
        
        collectVariables(params, mpathParams, query, parent.elementIds);
        
        String processedQuery = query;
        if (processedQuery.toLowerCase().contains(" like ")) {
            processedQuery = processVariablesInLikeClause(processedQuery);
        }
        
        String wildcardQry = processedQuery.replaceAll(REQUEST_PARAM_PATTERN, "? ");
        wildcardQry = wildcardQry.replaceAll(MPATH_EXPRESSION_PATTERN, "? ");
        
        String queryWithPlaceholder = processedQuery.replaceAll(REQUEST_PARAM_PATTERN, "?\\$R ");  
        queryWithPlaceholder = queryWithPlaceholder.replaceAll(MPATH_EXPRESSION_PATTERN, "?\\$M ");
       
        StringBuilder builder = new StringBuilder(escapeSpecialCharacters(wildcardQry));
        builder.append(System.lineSeparator());

        appendSqlParams(builder, params, mpathParams, queryWithPlaceholder);

        return builder.toString();
    }
    
    protected void appendSqlParams(StringBuilder builder, LinkedList<String> reqParams, LinkedList<String> mpathParams, String sql) throws ResourceTestException {
        for (int i = 0; i < sql.length()-3; i++){
            char c = sql.charAt(i);   
            char d = sql.charAt(i+1);
            if(c == '?' && d == '$'){     
                
                char e = sql.charAt(i+2);
                char f = sql.charAt(i+3);
                if(e == 'R' && f == ' '){
                    //append request params
                    String reqParam = reqParams.getFirst();
                    reqParams.removeFirst();
                    builder.append("<sql:param value=\"").append(getJspVariableForRequestParam(reqParam)).append("\"/>");
                    builder.append(System.lineSeparator());
                } else if (e == 'M' && f == ' '){
                    //append mpath variables
                    String mpathParam = mpathParams.getFirst();
                    mpathParams.removeFirst();
                    //System.out.println("Hello");
                    String elementId = getMPathId(mpathParam);
                    if(!parent.elementIds.containsKey(elementId)){
                        throw new ResourceTestException("Could not find element with ID: "+elementId);
                    }
                    //get type of element
                    RequestChild type = parent.elementIds.get(elementId);
                        
                    builder.append("<sql:param value=\"");
                    builder.append(type.extractFromMPath(mpathParam,elementId,true));
                    builder.append("\"/>");
                    builder.append(System.lineSeparator());
                }             
            }
        }
    }
    
    /**
     * Adds validation tag to catch exception generated by incorrect query.
     *
     * @param writer XMLStreamWriter to write to JSP file.
     * @param errorMessage Error message to be printed.
     * @throws XMLStreamException
     */
    protected void startValidateTag(XMLStreamWriter writer, String errorMessage) throws XMLStreamException {
        writer.writeStartElement("m:validate");
        writer.writeAttribute("onError", errorMessage);
    }
    
    /**
     * Closes the m:validate tag
     *
     * @param writer XMLStreamWriter to write to JSP file.
     * @throws XMLStreamException
     */
    protected void closeValidateTag(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeEndElement();
    }
    
    protected boolean isVerbose(Sql sql) {
        if (sql.getType().value().equalsIgnoreCase("update") && (sql.getOutput() != null && sql.getOutput())) {
            // type = update and verbose = true
            return true;
        } else {
            // type = query and verbose != false
            return sql.getType().value().equalsIgnoreCase("query") && (sql.getOutput() == null || sql.getOutput());
        }
    }

    @Override
    public List<String> getRequestParameters() {
        List<String> params = new ArrayList<>();
        getRequestParametersFromString(params,getWhen());
        getRequestParametersFromString(params, getValue());
        return params;
    }

    @Override
    public String extractFromMPath(String mpathVariable, String elementId, boolean enclose) {
        
        StringBuilder sb = new StringBuilder();
        
        // id.rows[0].name
        String rowIndex = "0";
        String colName = null;

        Pattern p = Pattern.compile("^\\$\\[(\\w+?)\\]\\[(\\d+?)\\]\\.(\\S+?)$");
        Matcher m = p.matcher(mpathVariable);

        if(m.find()) {
            rowIndex = m.group(2);
            colName = m.group(3);
        }
        
        String transformedVariable = elementId+".rows"+"["+rowIndex+"]."+colName;
        
        sb.append(transformedVariable);
        
        return enclose ? enclose(sb.toString()) : sb.toString();
    }
}