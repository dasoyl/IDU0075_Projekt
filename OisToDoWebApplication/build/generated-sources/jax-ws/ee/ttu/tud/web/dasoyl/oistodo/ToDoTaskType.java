
package ee.ttu.tud.web.dasoyl.oistodo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for toDoTaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toDoTaskType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="task" type="{http://www.tud.ttu.ee/web/dasoyl/OisToDo}taskType"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="punktid" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toDoTaskType", propOrder = {
    "task",
    "quantity",
    "punktid",
    "boonus"
})
public class ToDoTaskType {

    @XmlElement(required = true)
    protected TaskType task;
    protected double quantity;
    protected double punktid;
    protected double boonus;

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link TaskType }
     *     
     */
    public TaskType getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskType }
     *     
     */
    public void setTask(TaskType value) {
        this.task = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(double value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the punktid property.
     * 
     */
    public double getPunktid() {
        return punktid;
    }

    /**
     * Sets the value of the punktid property.
     * 
     */
    public void setPunktid(double value) {
        this.punktid = value;
    }

    /**
     * Gets the value of the boonus property.
     * 
     */
    public double getBoonus() {
        return boonus;
    }

    /**
     * Sets the value of the boonus property.
     * 
     */
    public void setBoonus(double value) {
        this.boonus = value;
    }
}
