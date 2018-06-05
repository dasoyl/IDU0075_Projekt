/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp;


import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author darya
 */
public class ToDoApp {
    /**
     * @param args the command line arguments
     */
    private static final String API_TOKEN = "salajane";
    public static void main(String[] args) {
        String opNr = "";
        
        String type;
        String code;
        String tskId;
        
        String toDoDate;
        String dueDate;
        String studentName;
        String todoId;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        
        String qty;
        String punktid;
        String boonus;
        
        boolean isDone = true;
        
        System.out.println("Possible operations to choose:");
        System.out.println("'1' - addTask operation");
        System.out.println("'2' - addToDo operation");
        System.out.println("'3' - addToDoTask operation");
        System.out.println("'4' - getTask operation");
        System.out.println("'5' - getTaskList operation");
        System.out.println("'6' - getToDo operation");
        System.out.println("'7' - getToDoList operation");
        System.out.println("Type 'exit' to finish");
        
        while (isDone) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation number: ");
            String obj1 = scanner.nextLine();
            if (obj1.trim().equals("1")
                || obj1.trim().equals("2")
                || obj1.trim().equals("3")
                || obj1.trim().equals("4")
                || obj1.trim().equals("5")
                || obj1.trim().equals("6")
                || obj1.trim().equals("7")
                || obj1.trim().equals("exit")) {
                opNr = obj1.trim();
                System.out.println(chooseOperation(opNr) + " operation selected!");
            } else {
                System.out.println("Invalid operation number, try again!");
                System.out.println("Enter operation number: ");
                scanner.nextLine();
            }
            switch (opNr) {
                case "1":
                    System.out.println("Enter task type: (task | test)");
                    type = scanner.nextLine();
                    System.out.println("Enter task code: ");
                    code = scanner.nextLine();
                    AddTaskRequest tsk = new AddTaskRequest();
                    tsk.setToken(API_TOKEN);
                    tsk.setType(type);
                    tsk.setCode(code);
                    AddTaskResponse tskRsp = addTask(tsk);
                    if (tskRsp.getTask() != null) {
                        System.out.println("Task successfully added!");
                        isDone = false;
                        break;
                    } else {
                        System.out.println("Unsuccessful");
                        break;
                    }
                case "2":
                    System.out.println("Enter ToDo Date: (yyyy-mm-dd)");
                    toDoDate = scanner.nextLine();
                    System.out.println("Enter ToDo Due Date: (yyyy-mm-dd)");
                    dueDate = scanner.nextLine();
                    System.out.println("Enter ToDo Student name: ");
                    studentName = scanner.nextLine();
                    AddToDoRequest todo = new AddToDoRequest();
                    todo.setToken(API_TOKEN);
                    todo.setToDoDate(null);
                    todo.setDueDate(null);
                    todo.setStudentName(studentName);
                    AddToDoResponse todoRsp = addToDo(todo);
                    if (todoRsp.getTodo() != null) {
                        System.out.println("ToDo successfully added!");
                        isDone = false;
                        break;
                    } else {
                        System.out.println("Unsuccessful");
                        break;
                    }
                case "3":
                    System.out.println("Enter ToDo id: ");
                    todoId = scanner.nextLine();
                    System.out.println("Enter ToDo Task id: ");
                    tskId = scanner.nextLine();
                    System.out.println("Enter ToDo Task Quantity: ");
                    qty = scanner.nextLine();
                    System.out.println("Enter ToDo Task Points: ");
                    punktid = scanner.nextLine();
                    System.out.println("Enter ToDo Task Bonus / Deductions: (0.50/ -0.50) ");
                    boonus = scanner.nextLine();
                    AddToDoTaskRequest todoTask = new AddToDoTaskRequest();
                    todoTask.setToken(API_TOKEN);
                    todoTask.setQuantity(Double.parseDouble(qty));
                    todoTask.setPunktid(Double.parseDouble(punktid));
                    todoTask.setBoonus(Double.parseDouble(boonus));
                    todoTask.setToDoId(BigInteger.valueOf(Integer.valueOf(todoId)));
                    todoTask.setTaskId(BigInteger.valueOf(Integer.valueOf(tskId)));
                    AddToDoTaskResponse todoTaskRsp = addToDoTask(todoTask);
                    if (todoTaskRsp.getTodoTask() != null) {
                        System.out.println("ToDo Task successfully added!");
                        isDone = false;
                        break;
                    } else {
                        System.out.println("Unsuccessful");
                        break;
                    }
                case "4":
                    System.out.println("Enter task id: ");
                    String obj4 = scanner.nextLine().trim();
                    if (obj4 != null && obj4.matches("[-+]?\\d*\\.?\\d+")) {
                        tskId = obj4;
                        GetTaskRequest tskReq = new GetTaskRequest();
                        tskReq.setToken(API_TOKEN);
                        tskReq.setId(BigInteger.valueOf(Integer.valueOf(tskId)));
                        GetTaskResponse tskResp = getTask(tskReq);
                        if (tskResp.getTask() != null) {
                            System.out.println("Task id: " + tskResp.getTask().getId()
                                    + "\n Task type: " + tskResp.getTask().getType()
                                    + "\n Task code: " + tskResp.getTask().getCode());
                        } else {
                            System.out.println("Task with such id does not exist.");
                            break;
                        }
                    } else {
                        System.out.println("Invalid input!");
                        break;
                    }
                    isDone = false;
                    break;
                case "5":
                    GetTaskListRequest tskListReq = new GetTaskListRequest();
                    tskListReq.setToken(API_TOKEN);
                    getTaskList(tskListReq).getTask().forEach((task) -> {
                        System.out.println("id: " + task.getId()
                                + "  Type: " + task.getType()
                                + "  Code: " + task.getCode());
                    });
                    isDone = false;
                    break;
                case "6":
                    System.out.println("Enter ToDo id: ");
                    String obj6 = scanner.nextLine().trim();
                    if (obj6 != null && obj6.matches("[-+]?\\d*\\.?\\d+")) {
                        todoId = obj6;
                        GetToDoRequest todoReq = new GetToDoRequest();
                        todoReq.setToken(API_TOKEN);
                        todoReq.setId(BigInteger.valueOf(Integer.valueOf(todoId)));
                        GetToDoResponse todoResp = getToDo(todoReq);
                        if (todoResp.getTodo() != null) {
                            System.out.println("ToDo id: " + todoResp.getTodo().getId()
                                    + "\n ToDo date: " + todoResp.getTodo().getToDoDate()
                                    + "\n ToDo due date: " + todoResp.getTodo().getDueDate()
                                    + "\n Student Name: "+ todoResp.getTodo().getStudentName());
                        } else {
                            System.out.println("ToDo with such id does not exist.");
                            break;
                        }
                    } else {
                        System.out.println("Invalid input!");
                        break;
                    }
                    isDone = false;
                    break;
                case "7":
                    GetToDoListRequest todoListReq = new GetToDoListRequest();
                    todoListReq.setToken(API_TOKEN);
                    getToDoList(todoListReq).getToDo().forEach((td) -> {
                        System.out.println("id: " + td.getId()
                                + "  Type: " + td.getToDoDate()
                                + "  Code: " + td.getDueDate()
                                + "  Student Name: " + td.getStudentName() );
                    });
                    isDone = false;
                    break;
                case "exit":
                    isDone = false;
                    break;
            }
        }
        
    }



    /**
     * Current operation checker
     *
     * @param input
     * @return operation name
     */
    private static String chooseOperation(String input) {
        if (input != null) {
            switch (input) {
                case "1":
                    return "addTask";
                case "2":
                    return "addToDo";
                case "3":
                    return "addToDoTask";
                case "4":
                    return "getTask";
                case "5":
                    return "getTaskList";
                case "6":
                    return "getToDo";
                case "7":
                    return "getToDoList"; 
                case "exit":
                    return "Exit";
            }
        }
        return null;
    }

    private static AddTaskResponse addTask(AddTaskRequest parameter) {
        ToDoService service = new ToDoService();
        ToDoPortType port = service.getToDoPort();
        return port.addTask(parameter);
    }

    private static AddToDoResponse addToDo(AddToDoRequest parameter) {
        ToDoService service = new ToDoService();
        ToDoPortType port = service.getToDoPort();
        return port.addToDo(parameter);
    }

    private static AddToDoTaskResponse addToDoTask(AddToDoTaskRequest parameter) {
        ToDoService service = new ToDoService();
        ToDoPortType port = service.getToDoPort();
        return port.addToDoTask(parameter);
    }

    private static GetTaskResponse getTask(GetTaskRequest parameter) {
        ToDoService service = new ToDoService();
        ToDoPortType port = service.getToDoPort();
        return port.getTask(parameter);
    }

    private static GetTaskListResponse getTaskList(GetTaskListRequest parameter) {
        ToDoService service = new ToDoService();
        ToDoPortType port = service.getToDoPort();
        return port.getTaskList(parameter);
    }

    private static GetToDoResponse getToDo(GetToDoRequest parameter) {
        ToDoService service = new ToDoService();
        ToDoPortType port = service.getToDoPort();
        return port.getToDo(parameter);
    }

    private static GetToDoListResponse getToDoList(GetToDoListRequest parameter) {
        ToDoService service = new ToDoService();
        ToDoPortType port = service.getToDoPort();
        return port.getToDoList(parameter);
    }

    private static GetToDoTaskListResponse getToDoTaskList(GetToDoTaskListRequest parameter) {
        ToDoService service = new ToDoService();
        ToDoPortType port = service.getToDoPort();
        return port.getToDoTaskList(parameter);
    }
}