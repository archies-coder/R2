//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2016.01.07 at 10:53:17 AM IST
//
package com.metamug.parser.schema;

import com.metamug.parser.exception.ResourceTestException;
import com.metamug.parser.service.ParserService;
import org.xml.sax.SAXException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.xpath.XPathExpressionException;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"desc", "request"})
@XmlRootElement(name = "Resource")
public class Resource extends XMLElement {

    @XmlElement(name = "Desc")
    protected Desc desc;
    @XmlElement(name = "Request")
    protected Set<Request> request;
    @XmlAttribute(name = "v", required = true)
    protected double version;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "parent")
    protected String parent;
    @XmlAttribute(name = "auth")
    protected String auth;

    public Resource(String id,double version) {
        this.version = version;
        this.id = id;
    }
    
    public Resource(Desc desc, double version, String id, String parent, String auth) {
        this.desc = desc;
        this.version = version;
        this.id = id;
        this.parent = parent;
        this.auth = auth;
    }

    public Resource(Resource r){
        desc = r.getDesc();
        request = r.getRequest();
        version = r.getVersion();
        id = r.getId();
        parent = r.getParent();
        auth = r.getAuth();
    }

    public Resource(){
    }    
    
    /**
     * Gets the value of the desc property.
     *
     * @return possible object is {@link String }
     *
     */
    public Desc getDesc() {
        if(desc == null){
            desc = new Desc();
        } 
        return desc;
    }

    public String getDescString() {
        if(desc != null && desc.getDesc().size() > 0){
            return desc.getDesc().get(0);
        }
        return null;
    }

    /**
     * Sets the value of the desc property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setDesc(Desc value) {
        this.desc = value;
    }

    public void setDescString(String value) {
        this.desc.setDesc(value);
    }

    /**
     * Gets the value of the request property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there is
     * not a <CODE>set</CODE> method for the request property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequest().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Request }
     *
     *
     * @return
     */
    public Set<Request> getRequest() {
        if (request == null) {
            request = new HashSet<>();
        }
        return this.request;
    }
    
    /**
     * Returns child request of this resource having same method and item attributes as given request
     * If child request with same method and item does not exist,
     *
     * @param req given request
     * @return child request of this resource
    */
    public Request getSimilarRequest(Request req) {
        for (Request r : getRequest()) {
            if(r.equals(req)){
                //request exists, return it
                return r;
            }
        }
        //request does not exist, add a new request with given item and resource and return it
        addRequest(req.getMethod(),req.getItem());
        return req;
    }
    
    /**
     * Appends elements from given request to child request of this resource with same method and item attributes
     * 
     * @param givenRequest
     */
    public void addRequestElements(Request givenRequest) {
        Request req = getSimilarRequest(givenRequest);
        req.appendElements(givenRequest);
    }
    
    public void addRequestElements(String xml) throws JAXBException{
        addRequestElements((Request) unmarshal(xml));
    }
    
    public void addRequest(Request request) {
        getRequest().add(request);
    }
    
    public void addRequest(Method method, String item) {
        Request req = new Request(method);
        req.setItem(item);
        getRequest().add(req);
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     */
    public double getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param version
     */
    public void setVersion(double version) {
        this.version = version;
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
     * Gets the value of the parent property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setParent(String value) {
        this.parent = value;
    }

    /**
     *
     * @return
     */
    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

//    @Override
    public String getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void print(XMLStreamWriter writer, ParserService parent) throws XMLStreamException, ResourceTestException, SAXException, XPathExpressionException, IOException {
        writer.writeStartElement("m:resource");

        //Add a Auth group resource tag
        if (getAuth() != null) {
            writer.writeAttribute("auth", getAuth());
        }

        //Add Parent attribute
        if (getParent() != null) {
            writer.writeAttribute("parentName", getParent());
        }

        writer.writeCharacters(System.lineSeparator());

        printRequest(writer, parent);

        writer.writeEndElement();//end m:resource
    }

    protected void printRequest(XMLStreamWriter writer, ParserService parent) throws ResourceTestException, IOException, SAXException, XPathExpressionException, XMLStreamException {
        for (Request req : getRequest()) {
            req.print(writer, parent);

            writer.writeCharacters(System.lineSeparator());
        }
    }
}
