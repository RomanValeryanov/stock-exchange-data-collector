//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.12 at 04:11:09 AM MSK 
//


package com.youtrack.view;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for comment complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="comment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="replies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="value" type="{}value" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="author" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="issueId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="deleted" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="shownForIssueAuthor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="created" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="updated" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comment", propOrder = {
        "replies",
        "value"
})
public class Comment {

    protected String replies;
    protected List<Value> value;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "author")
    protected String author;
    @XmlAttribute(name = "issueId")
    protected String issueId;
    @XmlAttribute(name = "deleted")
    protected String deleted;
    @XmlAttribute(name = "text")
    protected String text;
    @XmlAttribute(name = "shownForIssueAuthor")
    protected String shownForIssueAuthor;
    @XmlAttribute(name = "created")
    protected String created;
    @XmlAttribute(name = "updated")
    protected String updated;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the replies property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReplies() {
        return replies;
    }

    /**
     * Sets the value of the replies property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReplies(String value) {
        this.replies = value;
    }

    /**
     * Gets the value of the value property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Value }
     */
    public List<Value> getValue() {
        if (value == null) {
            value = new ArrayList<Value>();
        }
        return this.value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the author property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the issueId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIssueId() {
        return issueId;
    }

    /**
     * Sets the value of the issueId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIssueId(String value) {
        this.issueId = value;
    }

    /**
     * Gets the value of the deleted property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDeleted(String value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the text property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the shownForIssueAuthor property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShownForIssueAuthor() {
        return shownForIssueAuthor;
    }

    /**
     * Sets the value of the shownForIssueAuthor property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShownForIssueAuthor(String value) {
        this.shownForIssueAuthor = value;
    }

    /**
     * Gets the value of the created property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCreated(String value) {
        this.created = value;
    }

    /**
     * Gets the value of the updated property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUpdated(String value) {
        this.updated = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("issueId", issueId)
                .append("author", author)
                .append("value", value)
                .append("text", text)
                .append("id", id)
                .append("replies", replies)
                .append("deleted", deleted)
                .append("shownForIssueAuthor", shownForIssueAuthor)
                .append("created", created)
                .append("updated", updated)
                .append("name", name)
                .toString();
    }
}
