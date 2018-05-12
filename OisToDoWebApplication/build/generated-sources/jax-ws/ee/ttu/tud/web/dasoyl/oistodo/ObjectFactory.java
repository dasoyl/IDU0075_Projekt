
package ee.ttu.tud.web.dasoyl.oistodo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ee.ttu.tud.web.dasoyl.oistodo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetTaskResponse_QNAME = new QName("http://www.tud.ttu.ee/web/dasoyl/OisToDo", "getTaskResponse");
    private final static QName _AddTaskResponse_QNAME = new QName("http://www.tud.ttu.ee/web/dasoyl/OisToDo", "addTaskResponse");
    private final static QName _GetToDoResponse_QNAME = new QName("http://www.tud.ttu.ee/web/dasoyl/OisToDo", "getToDoResponse");
    private final static QName _AddToDoResponse_QNAME = new QName("http://www.tud.ttu.ee/web/dasoyl/OisToDo", "addToDoResponse");
    private final static QName _GetToDoTaskListResponse_QNAME = new QName("http://www.tud.ttu.ee/web/dasoyl/OisToDo", "getToDoTaskListResponse");
    private final static QName _AddToDoTaskResponse_QNAME = new QName("http://www.tud.ttu.ee/web/dasoyl/OisToDo", "addToDoTaskResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ee.ttu.tud.web.dasoyl.oistodo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskType }
     * 
     */
    public TaskType createTaskType() {
        return new TaskType();
    }

    /**
     * Create an instance of {@link GetTaskRequest }
     * 
     */
    public GetTaskRequest createGetTaskRequest() {
        return new GetTaskRequest();
    }

    /**
     * Create an instance of {@link AddTaskRequest }
     * 
     */
    public AddTaskRequest createAddTaskRequest() {
        return new AddTaskRequest();
    }

    /**
     * Create an instance of {@link GetTaskListRequest }
     * 
     */
    public GetTaskListRequest createGetTaskListRequest() {
        return new GetTaskListRequest();
    }

    /**
     * Create an instance of {@link GetTaskListResponse }
     * 
     */
    public GetTaskListResponse createGetTaskListResponse() {
        return new GetTaskListResponse();
    }

    /**
     * Create an instance of {@link GetToDoRequest }
     * 
     */
    public GetToDoRequest createGetToDoRequest() {
        return new GetToDoRequest();
    }

    /**
     * Create an instance of {@link ToDoType }
     * 
     */
    public ToDoType createToDoType() {
        return new ToDoType();
    }

    /**
     * Create an instance of {@link AddToDoRequest }
     * 
     */
    public AddToDoRequest createAddToDoRequest() {
        return new AddToDoRequest();
    }

    /**
     * Create an instance of {@link GetToDoListRequest }
     * 
     */
    public GetToDoListRequest createGetToDoListRequest() {
        return new GetToDoListRequest();
    }

    /**
     * Create an instance of {@link GetToDoListResponse }
     * 
     */
    public GetToDoListResponse createGetToDoListResponse() {
        return new GetToDoListResponse();
    }

    /**
     * Create an instance of {@link GetToDoTaskListRequest }
     * 
     */
    public GetToDoTaskListRequest createGetToDoTaskListRequest() {
        return new GetToDoTaskListRequest();
    }

    /**
     * Create an instance of {@link ToDoTaskListType }
     * 
     */
    public ToDoTaskListType createToDoTaskListType() {
        return new ToDoTaskListType();
    }

    /**
     * Create an instance of {@link AddToDoTaskRequest }
     * 
     */
    public AddToDoTaskRequest createAddToDoTaskRequest() {
        return new AddToDoTaskRequest();
    }

    /**
     * Create an instance of {@link ToDoTaskType }
     * 
     */
    public ToDoTaskType createToDoTaskType() {
        return new ToDoTaskType();
    }

    /**
     * Create an instance of {@link TaskType.Name }
     * 
     */
    public TaskType.Name createTaskTypeName() {
        return new TaskType.Name();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tud.ttu.ee/web/dasoyl/OisToDo", name = "getTaskResponse")
    public JAXBElement<TaskType> createGetTaskResponse(TaskType value) {
        return new JAXBElement<TaskType>(_GetTaskResponse_QNAME, TaskType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tud.ttu.ee/web/dasoyl/OisToDo", name = "addTaskResponse")
    public JAXBElement<TaskType> createAddTaskResponse(TaskType value) {
        return new JAXBElement<TaskType>(_AddTaskResponse_QNAME, TaskType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToDoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tud.ttu.ee/web/dasoyl/OisToDo", name = "getToDoResponse")
    public JAXBElement<ToDoType> createGetToDoResponse(ToDoType value) {
        return new JAXBElement<ToDoType>(_GetToDoResponse_QNAME, ToDoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToDoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tud.ttu.ee/web/dasoyl/OisToDo", name = "addToDoResponse")
    public JAXBElement<ToDoType> createAddToDoResponse(ToDoType value) {
        return new JAXBElement<ToDoType>(_AddToDoResponse_QNAME, ToDoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToDoTaskListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tud.ttu.ee/web/dasoyl/OisToDo", name = "getToDoTaskListResponse")
    public JAXBElement<ToDoTaskListType> createGetToDoTaskListResponse(ToDoTaskListType value) {
        return new JAXBElement<ToDoTaskListType>(_GetToDoTaskListResponse_QNAME, ToDoTaskListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToDoTaskType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tud.ttu.ee/web/dasoyl/OisToDo", name = "addToDoTaskResponse")
    public JAXBElement<ToDoTaskType> createAddToDoTaskResponse(ToDoTaskType value) {
        return new JAXBElement<ToDoTaskType>(_AddToDoTaskResponse_QNAME, ToDoTaskType.class, null, value);
    }

}
