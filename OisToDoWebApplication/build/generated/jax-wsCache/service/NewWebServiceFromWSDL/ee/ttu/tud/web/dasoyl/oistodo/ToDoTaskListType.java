
package ee.ttu.tud.web.dasoyl.oistodo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for toDoTaskListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toDoTaskListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="toDoTask" type="{http://www.tud.ttu.ee/web/dasoyl/OisToDo}toDoTaskType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toDoTaskListType", propOrder = {
    "toDoTask"
})
public class ToDoTaskListType {

    protected List<ToDoTaskType> toDoTask;

    /**
     * Gets the value of the toDoTask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the toDoTask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getToDoTask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ToDoTaskType }
     * 
     * 
     */
    public List<ToDoTaskType> getToDoTask() {
        if (toDoTask == null) {
            toDoTask = new ArrayList<ToDoTaskType>();
        }
        return this.toDoTask;
    }

}
