package ee.ttu.tud.web.dasoyl.oistodo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConstants;

/**
 *
 * @author darya
 */
@WebService(serviceName = "ToDoService", portName = "ToDoPort", endpointInterface = "ee.ttu.tud.web.dasoyl.oistodo.ToDoPortType", targetNamespace = "http://www.tud.ttu.ee/web/dasoyl/OisToDo", wsdlLocation = "WEB-INF/wsdl/ToDoWebService/ToDoService.wsdl")
public class ToDoWebService {
    static int nextTaskId = 1;
    static int nextToDoId = 1;
    static List<TaskType> taskList = new ArrayList<TaskType>();
    static List<ToDoType> toDoList = new ArrayList<ToDoType>();
    
    public ee.ttu.tud.web.dasoyl.oistodo.TaskType getTask(ee.ttu.tud.web.dasoyl.oistodo.GetTaskRequest parameter) {
        TaskType tsk = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getId().equals(parameter.getId())) {
                    tsk = taskList.get(i);
                }
            }   
        }
        return tsk;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.TaskType addTask(ee.ttu.tud.web.dasoyl.oistodo.AddTaskRequest parameter) {
        TaskType tsk = new TaskType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            if(parameter.getType().equalsIgnoreCase("task")||parameter.getType().equalsIgnoreCase("test")){
            tsk.setType(parameter.getType());
            tsk.setCode(parameter.getCode());
            tsk.setId(BigInteger.valueOf(nextTaskId++));
            taskList.add(tsk);
            }}
        return tsk;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.GetTaskListResponse getTaskList(ee.ttu.tud.web.dasoyl.oistodo.GetTaskListRequest parameter) {
        GetTaskListResponse response = new GetTaskListResponse();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (TaskType taskType : taskList) {
                response.getTask().add(taskType);
            }
        }
        return response;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.ToDoType getToDo(ee.ttu.tud.web.dasoyl.oistodo.GetToDoRequest parameter) {
        ToDoType td = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < toDoList.size(); i++) {
                if (toDoList.get(i).getId().equals(parameter.getId())) {
                    td = toDoList.get(i);
                }
            }    
        }
        return td;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.ToDoType addToDo(ee.ttu.tud.web.dasoyl.oistodo.AddToDoRequest parameter) {
        ToDoType td = new ToDoType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            td.setId(BigInteger.valueOf(nextToDoId++));
            td.setToDoDate(parameter.getToDoDate());
            td.setDueDate(parameter.getDueDate());
            td.setStudentName(parameter.getStudentName());
            td.setToDoTaskList(new ToDoTaskListType());
            toDoList.add(td);
        }
        return td;    }

    public ee.ttu.tud.web.dasoyl.oistodo.GetToDoListResponse getToDoList(ee.ttu.tud.web.dasoyl.oistodo.GetToDoListRequest parameter) {
        GetToDoListResponse response = new GetToDoListResponse();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (ToDoType toDoType : toDoList) {
                if (((parameter.getHasRelatedTasks().equalsIgnoreCase("ei" ) && (toDoType.getToDoTaskList() == null || toDoType.getToDoTaskList().getToDoTask().isEmpty()))
                        || (parameter.getHasRelatedTasks().equalsIgnoreCase("jah" ) && toDoType.getToDoTaskList() != null && !toDoType.getToDoTaskList().getToDoTask().isEmpty())) 
                    && (parameter.getStartDate() != null && parameter.getStartDate().compare(toDoType.getToDoDate())== DatatypeConstants.LESSER)
                    && (parameter.getEndDate() != null && parameter.getEndDate().compare(toDoType.getToDoDate())== DatatypeConstants.GREATER)    
                        ){
                    response.getToDo().add(toDoType);
                }
            }
        }
        return response;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.ToDoTaskListType getToDoTaskList(ee.ttu.tud.web.dasoyl.oistodo.GetToDoTaskListRequest parameter) {
        ToDoTaskListType toDoTaskList = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < toDoList.size(); i++) {
                if (toDoList.get(i).getId().equals(parameter.getToDoId())) {
                    toDoTaskList = toDoList.get(i).getToDoTaskList();
                }

            }    
        }
        return toDoTaskList;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.ToDoTaskType addToDoTask(ee.ttu.tud.web.dasoyl.oistodo.AddToDoTaskRequest parameter) {
        ToDoTaskType toDoTask = new ToDoTaskType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            GetTaskRequest taskRequest = new GetTaskRequest();
            taskRequest.setId(parameter.getTaskId());
            taskRequest.setToken(parameter.getToken());
            toDoTask.setTask(getTask(taskRequest));
            toDoTask.setQuantity(parameter.getQuantity());
            toDoTask.setPunktid(parameter.getPunktid());
            //toDoTask.setBoonus(parameter.getBoonus());
                    
            for (int i = 0; i < toDoList.size(); i++) {
                if (toDoList.get(i).getId().equals(parameter.getToDoId())) {
                    toDoList.get(i).getToDoTaskList().getToDoTask().add(toDoTask);
                    toDoList.get(i).setPunktideSumma(toDoList.get(i).getPunktideSumma() + toDoTask.getQuantity() * toDoTask.getPunktid());
                    //toDoList.get(i).setPunktideAdjustment(toDoList.get(i).getPunktidAdjustment() + toDoTask.getQuantity() * toDoTask.getBoonus());
                    return toDoTask;
                }   
            } 
        }
        return null;
    }
    
}
