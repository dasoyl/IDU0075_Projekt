/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ois;

import ee.ttu.tud.web.dasoyl.oistodo.AddTaskRequest;
import ee.ttu.tud.web.dasoyl.oistodo.GetTaskListRequest;
import ee.ttu.tud.web.dasoyl.oistodo.GetTaskListResponse;
import ee.ttu.tud.web.dasoyl.oistodo.GetTaskRequest;
import ee.ttu.tud.web.dasoyl.oistodo.GetToDoListResponse;
import ee.ttu.tud.web.dasoyl.oistodo.TaskType;
import ee.ttu.tud.web.dasoyl.oistodo.ToDoTaskListType;
import ee.ttu.tud.web.dasoyl.oistodo.ToDoTaskType;
import ee.ttu.tud.web.dasoyl.oistodo.ToDoType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConstants;

/**
 *
 * @author dasoyl
 */
@WebService(serviceName = "ToDoService", portName = "ToDoPort", endpointInterface = "ee.ttu.tud.web.dasoyl.oistodo.ToDoPortType", targetNamespace = "http://www.tud.ttu.ee/web/dasoyl/OisToDo", wsdlLocation = "WEB-INF/wsdl/ToDoWebService/oisToDoService.wsdl")
public class ToDoWebService {

   static int nextTaskId = 1;
    static int nextToDoId = 1;
    static List<TaskType> taskList = new ArrayList<TaskType>();
    static List<ToDoType> toDoList = new ArrayList<ToDoType>();
    
    public TaskType getTask(GetTaskRequest parameter) {
        TaskType pt = null;
        if (parameter.getToken().equalsIgnoreCase("IDK0075")) {
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getId().equals(parameter.getId())) {
                    pt = taskList.get(i);
                }
            }    
        }
        return pt;   
    }
    public TaskType addTask(AddTaskRequest parameter) {
        TaskType pt = new TaskType();
        if (parameter.getToken().equalsIgnoreCase("IDK0075")) {
            pt.setName(parameter.getName());
            pt.setCode(parameter.getCode());
            pt.setId(BigInteger.valueOf(nextTaskId++));
            taskList.add(pt);
        }
        return pt;
    }

    public GetTaskListResponse getTaskList(GetTaskListRequest parameter) {
        GetTaskListResponse response = new GetTaskListResponse();
        if (parameter.getToken().equalsIgnoreCase("IDK0075")) {
            for (TaskType taskType : taskList) {
                response.getTask().add(taskType);
            }
        }
        return response;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.ToDoType getToDo(ee.ttu.tud.web.dasoyl.oistodo.GetToDoRequest parameter) {
        ToDoType it = null;
        if (parameter.getToken().equalsIgnoreCase("IDK0075")) {
            for (int i = 0; i < toDoList.size(); i++) {
                if (toDoList.get(i).getId().equals(parameter.getId())) {
                    it = toDoList.get(i);
                }

            }    
        }
        return it;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.ToDoType addToDo(ee.ttu.tud.web.dasoyl.oistodo.AddToDoRequest parameter) {
        ToDoType it = new ToDoType();
        if (parameter.getToken().equalsIgnoreCase("IDK0075")) {
            it.setId(BigInteger.valueOf(nextToDoId++));
            it.setToDoDate(parameter.getToDoDate());
            it.setDueDate(parameter.getDueDate());
            it.setStudentName(parameter.getStudentName());
            it.setToDoTaskList(new ToDoTaskListType());
            toDoList.add(it);
        }
        return it;
    }

    public ee.ttu.tud.web.dasoyl.oistodo.GetToDoListResponse getToDoList(ee.ttu.tud.web.dasoyl.oistodo.GetToDoListRequest parameter) {
        GetToDoListResponse response = new GetToDoListResponse();
        if (parameter.getToken().equalsIgnoreCase("IDK0075")) {
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
        if (parameter.getToken().equalsIgnoreCase("IDK0075")) {
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
        if (parameter.getToken().equalsIgnoreCase("IDK0075")) {
            GetTaskRequest taskRequest = new GetTaskRequest();
            taskRequest.setId(parameter.getTaskId());
            taskRequest.setToken(parameter.getToken());
            toDoTask.setTask(getTask(taskRequest));
            toDoTask.setQuantity(parameter.getQuantity());
            toDoTask.setPunktid(parameter.getPunktid());
            toDoTask.setBoonus(parameter.getBoonus());
                    
            for (int i = 0; i < toDoList.size(); i++) {
                if (toDoList.get(i).getId().equals(parameter.getToDoId())) {
                    toDoList.get(i).getToDoTaskList().getToDoTask().add(toDoTask);
                    toDoList.get(i).setPunktideSumma(toDoList.get(i).getPunktideSumma() + toDoTask.getQuantity() * toDoTask.getPunktid());
                    toDoList.get(i).setPunktideAdjustment(toDoList.get(i).getPunktidAdjustment() + toDoTask.getQuantity() * toDoTask.getBoonus());
                    return toDoTask;
                }
            } 
        }
        return null;
    }
}