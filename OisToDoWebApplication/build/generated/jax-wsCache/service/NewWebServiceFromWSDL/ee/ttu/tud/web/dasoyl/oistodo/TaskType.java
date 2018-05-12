
package ee.ttu.tud.web.dasoyl.oistodo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="name"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="task" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="kodutoo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="tunnitoo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="projekt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="test" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="aine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taskNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskType", propOrder = {
    "id",
    "code",
    "name",
    "aine",
    "taskNotes"
})
public class TaskType {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected TaskType.Name name;
    protected String aine;
    protected String taskNotes;

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
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link TaskType.Name }
     *     
     */
    public TaskType.Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskType.Name }
     *     
     */
    public void setName(TaskType.Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the aine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAine() {
        return aine;
    }

    /**
     * Sets the value of the aine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAine(String value) {
        this.aine = value;
    }

    /**
     * Gets the value of the taskNotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskNotes() {
        return taskNotes;
    }

    /**
     * Sets the value of the taskNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskNotes(String value) {
        this.taskNotes = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element name="task" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="kodutoo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="tunnitoo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="projekt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="test" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "task",
        "kodutoo",
        "tunnitoo",
        "projekt",
        "test"
    })
    public static class Name {

        protected String task;
        protected String kodutoo;
        protected String tunnitoo;
        protected String projekt;
        protected String test;

        /**
         * Gets the value of the task property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTask() {
            return task;
        }

        /**
         * Sets the value of the task property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTask(String value) {
            this.task = value;
        }

        /**
         * Gets the value of the kodutoo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKodutoo() {
            return kodutoo;
        }

        /**
         * Sets the value of the kodutoo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKodutoo(String value) {
            this.kodutoo = value;
        }

        /**
         * Gets the value of the tunnitoo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTunnitoo() {
            return tunnitoo;
        }

        /**
         * Sets the value of the tunnitoo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTunnitoo(String value) {
            this.tunnitoo = value;
        }

        /**
         * Gets the value of the projekt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProjekt() {
            return projekt;
        }

        /**
         * Sets the value of the projekt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProjekt(String value) {
            this.projekt = value;
        }

        /**
         * Gets the value of the test property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTest() {
            return test;
        }

        /**
         * Sets the value of the test property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTest(String value) {
            this.test = value;
        }

    }

}
