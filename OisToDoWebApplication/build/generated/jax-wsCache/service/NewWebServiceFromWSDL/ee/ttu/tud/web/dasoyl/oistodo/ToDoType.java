
package ee.ttu.tud.web.dasoyl.oistodo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for toDoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toDoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="toDoDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="studentName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="punktideSumma" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="punktidAdjustment" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="toDoTaskList" type="{http://www.tud.ttu.ee/web/dasoyl/OisToDo}toDoTaskListType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toDoType", propOrder = {
    "id",
    "toDoDate",
    "dueDate",
    "studentName",
    "punktideSumma",
    "punktidAdjustment",
    "toDoTaskList"
})
public class ToDoType {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar toDoDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dueDate;
    @XmlElement(required = true)
    protected String studentName;
    protected double punktideSumma;
    protected double punktidAdjustment;
    @XmlElement(required = true)
    protected ToDoTaskListType toDoTaskList;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the toDoDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDoDate() {
        return toDoDate;
    }

    /**
     * Sets the value of the toDoDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDoDate(XMLGregorianCalendar value) {
        this.toDoDate = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the studentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the value of the studentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStudentName(String value) {
        this.studentName = value;
    }

    /**
     * Gets the value of the punktideSumma property.
     * 
     */
    public double getPunktideSumma() {
        return punktideSumma;
    }

    /**
     * Sets the value of the punktideSumma property.
     * 
     */
    public void setPunktideSumma(double value) {
        this.punktideSumma = value;
    }

    /**
     * Gets the value of the punktidAdjustment property.
     * 
     */
    public double getPunktidAdjustment() {
        return punktidAdjustment;
    }

    /**
     * Sets the value of the punktidAdjustment property.
     * 
     */
    public void setPunktidAdjustment(double value) {
        this.punktidAdjustment = value;
    }

    /**
     * Gets the value of the toDoTaskList property.
     * 
     * @return
     *     possible object is
     *     {@link ToDoTaskListType }
     *     
     */
    public ToDoTaskListType getToDoTaskList() {
        return toDoTaskList;
    }

    /**
     * Sets the value of the toDoTaskList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToDoTaskListType }
     *     
     */
    public void setToDoTaskList(ToDoTaskListType value) {
        this.toDoTaskList = value;
    }

}
