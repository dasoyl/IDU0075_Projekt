# IDU0075_Projekt
# Project in subject Veebiteenused (IDU0075)

## Contents
* [Introduction](#introduction)
* [Service main object](#service-main-objects)
  - [ToDo](#ToDo)
  - [Task](#Task)
* [Service operations](#service-operations)
  - [General information about service](#General-information-about-service)
      + [token](#token)
      + [WSDL](#wsdl)
* [SOAP API documentation](#soap-api-documentation)
  - [SOAP API Operations](#soap-api-operations)
  - [SOAP API Operations' documentation](#soap-api-operations-documentation)
      + [Error status SOAP](#error-status-soap)
* [REST API documentation](#rest-api-documentation)
  - [REST API Operations](#rest-api-Operations)
  - [REST API Operations documentation](#rest-api-operations-documentation)
      + [Error status REST](#error-status-rest)
* [Status codes meaning](#status-codes-meaning)
* [References](#references)



## Author
Darja Soylu 155059IABB

## Introduction
This project, in accordance to requirements, uses[Netbeans-i](https://netbeans.org) and [Glassfish-i](https://glassfish.java.net). 

The project consists of four parts: documentation, application, testing and trying.

The goal of the documentation is to provide description of ToDo service and its SOAP and REST API implementation.
Implementation result is ToDo SOAP API and REST API Service (`ToDoWebService`) and application  (`ToDoApp`), using which one can partially try SOAP API functionality.
Testing is performed using [SoapUI](https://www.soapui.org) and [Postman-i](https://www.getpostman.com).

Service use allows to create TODO and Tasks.

***





## Service's main objects
Given service main objects are `ToDo` and `Task`, 'TaskToDo' connecting both of them.
Each ToDo and Task is independent object. 
ToDo may contains several different or the same Tasks. Task presence in ToDo is not a requierement. At the same time, the Task can belong to several ToDo. 

General structure is as follows:
~~~
Service
├── ToDo
├── ToDo
│   └── TaskToDo
│		└── Task
└── Task
~~~







### ToDo
Service allows to have multiple ToDo objects. Each ToDo may contain zero or several Tasks.  ToDo defines also date of creation, due date, student name and total amount of points to be earned and adjusted. 

ToDo has following attributes:
* **id** - unique numerical id, AutoNumber assigned by system;
* **toDoDate** - date created;
* **dueDate**  - date Tasks are due;
* **studentName**  - student name;
* **punktideSumma** - total amount of points tasks earn. If no tasks related, default is zero. Type Double;
* **punktidAdjustment** - total amount of bonus points or deduction points tasks contain. If no tasks related, default is zero. Type Double.

ToDo example:
* **id** - 1;
* **toDoDate** - 2018-05-16;
* **dueDate**  - 2018-05-18;
* **studentName**  - dasoyl;
* **punktideSumma** - 0.00;
* **punktidAdjustment** - 0.00.




### Task
Service contains multiple Task objects. Task type is restricted to 'task' and 'test'. Task code defines information visible on ToDo. Each task may have information about subject and notes. 

Task has following attributes:
* **id** - unique numerical id, AutoNumber assigned by system;
* **type** - restricted to 'task' and 'test', where 'task' includes self study, in class work or home assignment, 'test' is in controlled environment, remote or in person;
* **code** - task code, may contain subject information and predefined information as week number or assignments order;
* **aine** - Optional, specific related subject for the task;
* **taskNotes** - Optional information about task.

Task example:
* **id** - 1;
* **type** - 'task';
* **code** - IDU00751;
* **aine** - '';
* **taskNotes** - ''.

***



## Service operations
Both API-s offer interface to the same service. It means, that both API Operations are similar.
Current operations' list and their documentation (what can be done).

* **Add Task**
    - create a task.
* **Add ToDo**
    - create a ToDo with no Tasks.
* **Add ToDo Task**
    - add existing task to the existing ToDo.
* **Get Task**
    - request Task by its id.
* **Get Task List**
    - request all tasks in form of list.
* **Get ToDo**
    - request ToDo by its id and with or without Task.
* **Get ToDo List**
    - request all ToDos in form of list.
* **Get ToDo Task List**
    - request all tasks in form of list from specific ToDo by its id.


### General information about service

#### token
Current project uses token authentication.
For operation to be performed correct token must be provided to system. 

**Example:**
* User sends request addTask using token 'salajane'.
* Service saves task with id 1.
* User sends request addTask using token 'x'.
* New task is not created, because token is not correct.
* User sends request addTask using token 'salajane'.
* Service saves task with id 2.

#### WSDL
API used WSDL [file link](https://github.com/dasoyl/IDU0075_Projekt/blob/master/projekt/ToDoApp/xml-resources/web-service-references/ToDoService/wsdl/desktop-47uh273_8080/ToDoWebApplication/ToDoService.wsdl), which is also available after *deploy* in NetBeans in browser, at address ending `?wsdl` or `(hostname)/ToDoWebApplication/ToDoService?wsdl`.

***



## SOAP API documentation
API is available at `(hostname)/ToDoWebApplication/ToDoService`.

### SOAP API Operations
Implemented SOAP API service provides following operations:
* [addTask SOAP](#addTask-soap)
* [addToDo SOAP](#addToDo-soap)
* [addToDoTask SOAP](#addToDoTask-soap)
* [getTask SOAP](#getTask-soap)
* [getTaskList SOAP](#getTasklist-soap)
* [getToDo SOAP](#getToDo-soap)
* [getToDoList SOAP](#getToDolist-soap)
* [getToDoTaskList SOAP](#getToDoTasklist-soap)

### SOAP API Operations' documentation
each request must include correct `token`.


***
#### addTask SOAP
Task creating operation.

##### Request data documentation
Elements and their type in SOAP request are following: 
* `Task`
	- `token` - `string`, "salajane" gives access to the operation;
    - `type` - `string`, task type;
    - `code` - `string`, task code;

###### Example of SOAP Request
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ois="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
   <soapenv:Header/>
   <soapenv:Body>
      <ois:addTaskRequest>
         <ois:token>salajane</ois:token>
         <ois:type>task</ois:type>
         <ois:code>IDU00753</ois:code>
      </ois:addTaskRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Response data documentation
Successful request response: elements and their types are following:
* `Task`
    - `id` - `integer`, system generated;
    - `code` - `string`, created task code;
    - `type` - `string`, created task type;
    
Unsuccessful request response has blank body.  

###### Example of SOAP Response
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <addTaskResponse xmlns="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
         <id>1</id>
         <code>IDU00753</code>
         <type>task</type>
      </addTaskResponse>
   </S:Body>
</S:Envelope>
~~~



***
#### addToDo SOAP
ToDo creating operation.

##### Request data documentation
Elements and their type in SOAP request are following: 
* `ToDo`
	- `token` - `string`, "salajane" gives access to the operation;
    - `toDoDate` - `date`, toDo created date;
    - `dueDate` - `date`, toDo due date;
	- `studentName` - `string`, toDo student name;

###### Example of SOAP Request
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ois="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
   <soapenv:Header/>
   <soapenv:Body>
      <ois:addToDoRequest>
         <ois:token>salajane</ois:token>
         <ois:toDoDate>2018-05-15</ois:toDoDate>
         <ois:dueDate>2018-05-18</ois:dueDate>
         <ois:studentName>dasoyl</ois:studentName>
      </ois:addToDoRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Response data documentation
Successful request response: elements and their types are following:
* `ToDo`
    - `token` - `string`, "salajane" gives access to the operation;
    - `toDoDate` - `date`, requesed toDo date;
    - `dueDate` - `date`, requested due date;
	- `studentName` - `string`, requested student name;
	- `punktideSumma` - `double`, related task list points sum;
    - `punktidAdjustment` - `double`, related task list adjustment points sum;
	- `toDoTaskList` - `toDoTaskType`, list of related tasks;
    
Unsuccessful request response has blank body.  

###### Example of SOAP Response
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <addToDoResponse xmlns="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
         <id>1</id>
         <toDoDate>2018-05-15</toDoDate>
         <dueDate>2018-05-18</dueDate>
         <studentName>dasoyl</studentName>
         <punktideSumma>0.0</punktideSumma>
         <punktidAdjustment>0.0</punktidAdjustment>
         <toDoTaskList/>
      </addToDoResponse>
   </S:Body>
</S:Envelope>
~~~

***
#### addToDoTask SOAP
Task in ToDo creating operation.

##### Request data documentation
Elements and their type in SOAP request are following: 
* `ToDoTask`
	- `token` - `string`, "salajane" gives access to the operation;
    - `toDoId` - `integer`, ToDo id, where tasks will be added;
    - `taskId` - `integer`, task id;
	- `quantity` - `double`, how many of the task to be done;
	- `punktid` - `double`, how many point each task gives;
	- `boonus` - `double`, optional - how many points each task gives as bonus or deduction;

###### Example of SOAP Request
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ois="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
   <soapenv:Header/>
   <soapenv:Body>
      <ois:addToDoTaskRequest>
         <ois:token>salajane</ois:token>
         <ois:toDoId>2</ois:toDoId>
         <ois:taskId>7</ois:taskId>
         <ois:quantity>2</ois:quantity>
         <ois:punktid>1</ois:punktid>
         <!--Optional:-->
         <ois:boonus>0.5</ois:boonus>
      </ois:addToDoTaskRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Response data documentation
Successful request response: elements and their types are following:
* `ToDoTask`
	- `quantity` - `double`, how many of the task recorded;
	- `punktid` - `double`, how many point each task gives;
	- `boonus` - `double`, optional - how many points each task gives as bonus or deduction;
    
Unsuccessful request response has blank body.  

###### Example of SOAP Response
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <addToDoTaskResponse xmlns="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
         <quantity>2.0</quantity>
         <punktid>1.0</punktid>
         <boonus>0.0</boonus>
      </addToDoTaskResponse>
   </S:Body>
</S:Envelope>
~~~


***
#### getTask SOAP
Task request operation. User can search Task by its unique identification, or `id`.

##### Request data documentation
Request has one atribute in addition to token:
*`Task`
	- `token` - `string`, "salajane" gives access to the operation; 
	- `id` - `integer`, requested Task id.

###### Example of SOAP Request
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ois="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
   <soapenv:Header/>
   <soapenv:Body>
      <ois:getTaskRequest>
         <ois:token>salajane</ois:token>
         <ois:id>1</ois:id>
      </ois:getTaskRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~


##### Response data documentation
Successful request response: elements and their types are following:
* `Task`
    - `id` - `integer`, system generated;
    - `code` - `string`, created task code;
    - `type` - `string`, created task type;
    
Unsuccessful request response has blank body.  

###### Example of SOAP Response
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <getTaskResponse xmlns="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
         <id>1</id>
         <code>IDU00753</code>
         <type>task</type>
      </getTaskResponse>
   </S:Body>
</S:Envelope>
~~~


***
#### getTaskList SOAP
All Tasks in system request operation. 

##### Request data documentation
Request has only token:
*`Task`
	- `token` - `string`, "salajane" gives access to the operation; 

###### Example  SOAP päring (request)
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ois="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
   <soapenv:Header/>
   <soapenv:Body>
      <ois:getTaskListRequest>
         <ois:token>salajane</ois:token>
      </ois:getTaskListRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~


##### Response data documentation
Successful request response: elements and their types are following:
* `Task` repeating
    - `id` - `integer`, system generated;
    - `code` - `string`, created task code;
    - `type` - `string`, created task type;
    
Unsuccessful request response has blank body.  

###### Example of SOAP Response
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <getTaskListResponse xmlns="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
         <task>
            <id>1</id>
            <code>IDU00753</code>
            <type>task</type>
         </task>
         <task>
            <id>2</id>
            <code>IDU00753</code>
            <type>task</type>
         </task>
         <task>
            <id>3</id>
            <code>IDU00753</code>
            <type>task</type>
         </task>
      </getTaskListResponse>
   </S:Body>
</S:Envelope>
~~~


***
#### getToDo SOAP
ToDo request operation. User can search ToDo by its unique identification, or `id`.

##### Request data documentation
Request has one attribute in addition to token:
* `ToDo`
	- `token` - `string`, "salajane" gives access to the operation;
	- `id` - `integer`, requested ToDo id.

###### Example of SOAP Request
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ois="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
   <soapenv:Header/>
   <soapenv:Body>
      <ois:getToDoRequest>
         <ois:token>salajane</ois:token>
         <ois:id>1</ois:id>
      </ois:getToDoRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~


##### Response data documentation
Successful request response: list of group of elements and their types are following:
* `ToDo`
    - `toDoDate` - `date`, requested toDo date;
    - `dueDate` - `date`, requested due date;
	- `studentName` - `string`, requested student name;
	- `punktideSumma` - `double`, related task list points sum;
    - `punktidAdjustment` - `double`, related task list adjustment points sum;
	- `toDoTaskList` - `toDoTaskType`, list of related tasks;
    
Unsuccessful request response has blank body.  

###### Example of SOAP Response
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <addToDoResponse xmlns="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
         <id>1</id>
         <toDoDate>2018-05-15</toDoDate>
         <dueDate>2018-05-18</dueDate>
         <studentName>dasoyl</studentName>
         <punktideSumma>0.0</punktideSumma>
         <punktidAdjustment>0.0</punktidAdjustment>
         <toDoTaskList/>
      </addToDoResponse>
   </S:Body>
</S:Envelope>
~~~



***
#### getToDoList SOAP
All ToDos request operation. Operation has optional parameter. Request is performed filtering only needed objects.

##### Request data documentation
Request attributes:
*`ToDo`
	- `token` - `string`, "salajane" gives access to the operation;
	- `hasRelatedTasks` - `string`, with restriction 'jah' | 'ei'. Jah returns ToDos that have related task object, Ei - without tasks. 
	- `startDate` - `date`, search start date
	- `endDate` - `date`, search end date

###### Example of SOAP Request
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ois="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
   <soapenv:Header/>
   <soapenv:Body>
      <ois:getToDoListRequest>
         <ois:token>salajane</ois:token>
         <ois:startDate>2018-05-14</ois:startDate>
         <ois:endDate>2018-06-05</ois:endDate>
         <!--Optional:-->
         <ois:hasRelatedTasks>ei</ois:hasRelatedTasks>
      </ois:getToDoListRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~


##### Response data documentation
Successful request response: list of group of elements and their types are following:
* `ToDo`
    - `toDoDate` - `date`, requested toDo date;
    - `dueDate` - `date`, requested due date;
	- `studentName` - `string`, requested student name;
	- `punktideSumma` - `double`, related task list points sum;
    - `punktidAdjustment` - `double`, related task list adjustment points sum;
	- `toDoTaskList` - `toDoTaskType`, list of related tasks;
    
Unsuccessful request response has blank body.  

###### Example of SOAP Response
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <getToDoListResponse xmlns="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
         <toDo>
            <id>1</id>
            <toDoDate>2018-05-15</toDoDate>
            <dueDate>2018-06-05</dueDate>
            <studentName>dasoyl</studentName>
            <punktideSumma>0.0</punktideSumma>
            <punktidAdjustment>0.0</punktidAdjustment>
            <toDoTaskList/>
         </toDo>
         <toDo>
            <id>3</id>
            <toDoDate>2018-05-15</toDoDate>
            <dueDate>2018-06-05</dueDate>
            <studentName>dasoyl</studentName>
            <punktideSumma>0.0</punktideSumma>
            <punktidAdjustment>0.0</punktidAdjustment>
            <toDoTaskList/>
         </toDo>
      </getToDoListResponse>
   </S:Body>
</S:Envelope>
~~~




***
#### getToDoTaskList SOAP
Specific ToDo all related ToDo Task list request. Response will return a list of all ToDoTask in ToDo.

##### Request data documentation
Request contains parameter and type:
* `ToDoTask1
	- `token` - `string`, "salajane" gives access to the operation;
	- `ToDoId` - `integer`, requested ToDo id.

###### Example of SOAP Request
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ois="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
   <soapenv:Header/>
   <soapenv:Body>
      <ois:getToDoTaskListRequest>
         <ois:token>salajane</ois:token>
         <ois:toDoId>2</ois:toDoId>
      </ois:getToDoTaskListRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Response data documentation
Successful request response: elements and their types are following:
* `ToDoTask`
	- `quantity` - `double`, how many of the task recorded;
	- `punktid` - `double`, how many point each task gives;
	- `boonus` - `double`, optional - how many points each task gives as bonus or deduction;
    
Unsuccessful request response has blank body.  

###### Example of SOAP Response
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <getToDoTaskListResponse xmlns="http://www.tud.ttu.ee/web/dasoyl/OisToDo">
         <toDoTask>
            <quantity>2.0</quantity>
            <punktid>1.0</punktid>
            <boonus>0.0</boonus>
         </toDoTask>
         <toDoTask>
            <quantity>2.0</quantity>
            <punktid>1.0</punktid>
            <boonus>0.0</boonus>
         </toDoTask>
         <toDoTask>
            <quantity>2.0</quantity>
            <punktid>1.0</punktid>
            <boonus>0.0</boonus>
         </toDoTask>
      </getToDoTaskListResponse>
   </S:Body>
</S:Envelope>
~~~






## REST API documentation
REST API can be reached at link `(hostname)/ToDoWebApplication`.

### REST API Operations
Implemented REST API service allows following operations:
* [addToDo REST](#addToDo-rest)
* [getToDo REST](#getToDo-rest)
* [getToDoList REST](#getToDolist-rest)
* [addTask REST](#addTask-rest)
* [getTask REST](#getTask-rest)
* [getTaskList REST](#getTasklist-rest)
* [addToDoTask REST](#addToDoTask-rest)
* [getToDoTaskList REST](#getToDoTasklist-rest)

### REST API Operations' documentation
Each request must include correct `token`. 
Token is added at URL query as parameter `?token=salajane`.

***
#### addTask REST
Task creating operation.

HTTP method: `POST`

Resource (URI): `/Tasks`

Example URL: `/ToDoWebApplication/webresources/tasks/?token=salajane`

##### Request data documentation
Elements and their type in REST request are following: 
* `Task`
    - `type` - `string`, task type;
    - `code` - `string`, task code;


###### Example of JSON Request as POST method
~~~json
{
	"code":"IDU00751",
	"type":"test"
}
~~~

##### Response data documentation
Successful request response: elements and their types are following:
* `Task`
    - `id` - `integer`, system generated;
    - `code` - `string`, created task code;
    - `type` - `string`, created task type;
    
Unsuccessful request response has blank body.

###### Example of JSON Response
~~~json
{
    "id": 4,
    "code": "IDU00751",
    "type": "test",
    "aine": null,
    "taskNotes": null
}
~~~


***
#### addToDo REST
ToDo creating operation.

HTTP method: `POST`

Resource (URI): `/todos`

Example URL: `/ToDoWebApplication/webresources/todos/?token=salajane`

###### Request data documentation
Elements and their type in REST request are following: 
* `ToDo`
    - `toDoDate` - `date`, toDo created date;
    - `dueDate` - `date`, toDo due date;
	- `studentName` - `string`, toDo student name;


###### Example of JSON Request as POST method
~~~json
{
	"toDoDate":"2018-05-16",
	"dueDate":"2018-06-20",
	"studentName":"Darja"
}
~~~

##### Response data documentation
Successful request response: elements and their types are following:
* `ToDo`
    - `token` - `string`, "salajane" gives access to the operation;
    - `toDoDate` - `date`, requesed toDo date;
    - `dueDate` - `date`, requested due date;
	- `studentName` - `string`, requested student name;
	- `punktideSumma` - `double`, related task list points sum;
    - `punktidAdjustment` - `double`, related task list adjustment points sum;
	- `toDoTaskList` - `toDoTaskType`, list of related tasks;
    
Unsuccessful request response has blank body.  

###### Example of JSON Response
~~~json
{
    "id": 7,
    "toDoDate": 1526428800000,
    "dueDate": 1529452800000,
    "studentName": "Darja",
    "punktideSumma": 0,
    "punktidAdjustment": 0,
    "toDoTaskList": {
        "toDoTask": []
    }
}
~~~


***
#### addToDoTask REST
Task in ToDo creating operation.

HTTP method: `POST`

Resource (URI): `/todos/{id}/tasks`

Example URL: `/ToDoWebApplication/webresources/todos/1/tasks?token=salajane


##### Request data documentation
Elements and their type in REST request are following: 
* `ToDoTask`
    - `toDoId` - `integer`, ToDo id, where tasks will be added;
    - `taskId` - `integer`, task id;
	- `quantity` - `double`, how many of the task to be done;
	- `punktid` - `double`, how many point each task gives;
	- `boonus` - `double`, optional - how many points each task gives as bonus or deduction;


###### Example of JSON Request as POST method
~~~json
{
	"taskId":"1",
	"quantity":"2",
	"punktid":"0.5",
	"boonus":"0"
}
~~~

##### Response data documentation
Successful request response: elements and their types are following:
* `ToDoTask`
	- `quantity` - `double`, how many of the task recorded;
	- `punktid` - `double`, how many point each task gives;
	- `boonus` - `double`, optional - how many points each task gives as bonus or deduction;
    
Unsuccessful request response has blank body. 

###### Example of JSON Response
~~~json
{
    "task": {
        "id": 1,
        "code": "IDU00753",
        "type": "task",
        "aine": null,
        "taskNotes": null
    },
    "quantity": 2,
    "punktid": 0.5,
    "boonus": 0
}
~~~


***
#### getTask REST
Task request operation. User can search Task by its unique identification, or `id`.

HTTP method: `GET`

Resource (URI): `/Tasks/{TaskId}`, where `{TaskId}` on task id.

Example  URL: `/ToDoWebApplication/webresources/tasks/1/?token=salajane`


##### Response data documentation
Successful request response: elements and their types are following:
* `Task`
    - `id` - `integer`, system generated;
    - `code` - `string`, created task code;
    - `type` - `string`, created task type;
    
Unsuccessful request response has blank body.  

###### Example  JSON vastus (response)
~~~json
{
    "id": 1,
    "code": "IDU00753",
    "type": "task",
    "aine": null,
    "taskNotes": null
}
~~~




***
#### getTaskList REST
All Tasks in system request operation. 

HTTP method: `GET`

Resource (URI): `/Tasks`

Example  URL: `/ToDoWebApplication/webresources/tasks?token=salajane`

##### Response data documentation
Successful request response: elements and their types are following:
* `Task`
    - `id` - `integer`, system generated;
    - `code` - `string`, created task code;
    - `type` - `string`, created task type;
    
Unsuccessful request response has blank body.

###### Example  JSON vastus (response)
~~~json
{
    "task": [
        {
            "id": 1,
            "code": "IDU00753",
            "type": "task",
            "aine": null,
            "taskNotes": null
        },
        {
            "id": 2,
            "code": "IDU00753",
            "type": "task",
            "aine": null,
            "taskNotes": null
        },
        {
            "id": 3,
            "code": "IDU00753",
            "type": "task",
            "aine": null,
            "taskNotes": null
        },
        {
            "id": 4,
            "code": "IDU00751",
            "type": "test",
            "aine": null,
            "taskNotes": null
        }
    ]
}
~~~






***
#### getToDo REST
ToDo request operation. User can search ToDo by its unique identification, or `id`.

HTTP method: `GET`

Resource (URI): `/ToDos/{ToDoId}`, where `{ToDoId}` is ToDo id.

Example  URL: `/ToDoWebApplication/webresources/todos/1/?token=salajane`

##### Response data documentation
Successful request response: list of group of elements and their types are following:
* `ToDo`
    - `toDoDate` - `date`, requested toDo date;
    - `dueDate` - `date`, requested due date;
	- `studentName` - `string`, requested student name;
	- `punktideSumma` - `double`, related task list points sum;
    - `punktidAdjustment` - `double`, related task list adjustment points sum;
	- `toDoTaskList` - `toDoTaskType`, list of related tasks;
    
Unsuccessful request response has blank body.  

###### Example  JSON vastus (response)
~~~json
{
    "id": 1,
    "toDoDate": 1526331600000,
    "dueDate": 1528146000000,
    "studentName": "dasoyl",
    "punktideSumma": 1,
    "punktidAdjustment": 0,
    "toDoTaskList": {
        "toDoTask": [
            {
                "task": {
                    "id": 1,
                    "code": "IDU00753",
                    "type": "task",
                    "aine": null,
                    "taskNotes": null
                },
                "quantity": 2,
                "punktid": 0.5,
                "boonus": 0
            }
        ]
    }
}
~~~




***
#### getToDoList REST
All ToDos request operation. Operation has optional parameter. Request is performed filtering only needed objects.

HTTP method: `GET`

Resource (URI): `/ToDos`

Example  URL: `/ToDoWebApplication/webresources/todos/?token=salajane&start=14-05-18&end=31-05-18`, 
- `hasRelatedTasks` - `string`, with restriction 'jah' | 'ei'. Jah returns ToDos that have related task object, Ei - without tasks. 
	- `startDate` - `date`, search start date
	- `endDate` - `date`, search end date


##### Response data documentation
Successful request response: list of group of elements and their types are following:
* `ToDo`
    - `toDoDate` - `date`, requested toDo date;
    - `dueDate` - `date`, requested due date;
	- `studentName` - `string`, requested student name;
	- `punktideSumma` - `double`, related task list points sum;
    - `punktidAdjustment` - `double`, related task list adjustment points sum;
	- `toDoTaskList` - `toDoTaskType`, list of related tasks;
    
Unsuccessful request response has blank body.  

###### Example  JSON Response
~~~json
{
    "toDo": [
        {
            "id": 1,
            "toDoDate": 1526331600000,
            "dueDate": 1528146000000,
            "studentName": "dasoyl",
            "punktideSumma": 3,
            "punktidAdjustment": 0,
            "toDoTaskList": {
                "toDoTask": [
                    {
                        "task": {
                            "id": 1,
                            "code": "IDU00753",
                            "type": "task",
                            "aine": null,
                            "taskNotes": null
                        },
                        "quantity": 2,
                        "punktid": 0.5,
                        "boonus": 0
                    },
                    {
                        "task": {
                            "id": 1,
                            "code": "IDU00753",
                            "type": "task",
                            "aine": null,
                            "taskNotes": null
                        },
                        "quantity": 2,
                        "punktid": 0.5,
                        "boonus": 0
                    },
                    {
                        "task": {
                            "id": 1,
                            "code": "IDU00753",
                            "type": "task",
                            "aine": null,
                            "taskNotes": null
                        },
                        "quantity": 2,
                        "punktid": 0.5,
                        "boonus": 0
                    }
                ]
            }
        },
        {
            "id": 2,
            "toDoDate": 1526331600000,
            "dueDate": 1528146000000,
            "studentName": "dasoyl",
            "punktideSumma": 6,
            "punktidAdjustment": 0,
            "toDoTaskList": {
                "toDoTask": [
                    {
                        "task": null,
                        "quantity": 2,
                        "punktid": 1,
                        "boonus": 0
                    },
                    {
                        "task": null,
                        "quantity": 2,
                        "punktid": 1,
                        "boonus": 0
                    },
                    {
                        "task": null,
                        "quantity": 2,
                        "punktid": 1,
                        "boonus": 0
                    }
                ]
            }
        }
    ]
}
~~~



***
#### getToDoTaskList REST
Specific ToDo all related ToDo Task list request. Response will return a list of all ToDoTask in ToDo.

HTTP method: `GET`

Resource (URI): `/ToDos/{ToDoId}/Tasks`, where `{ToDoId}` is ToDo id.

Example  URL: `/ToDoWebApplication/webresources/todos/1/tasks/?token=salajane`

##### Response data documentation
Successful request response: elements and their types are following:
* `ToDoTask`
	- `quantity` - `double`, how many of the task recorded;
	- `punktid` - `double`, how many point each task gives;
	- `boonus` - `double`, optional - how many points each task gives as bonus or deduction;
    
Unsuccessful request response has blank body.  

###### Example  JSON vastus (response)
~~~json
{
    "toDoTask": [
        {
            "task": {
                "id": 1,
                "code": "IDU00753",
                "type": "task",
                "aine": null,
                "taskNotes": null
            },
            "quantity": 2,
            "punktid": 0.5,
            "boonus": 0
        },
        {
            "task": {
                "id": 1,
                "code": "IDU00753",
                "type": "task",
                "aine": null,
                "taskNotes": null
            },
            "quantity": 2,
            "punktid": 0.5,
            "boonus": 0
        },
        {
            "task": {
                "id": 1,
                "code": "IDU00753",
                "type": "task",
                "aine": null,
                "taskNotes": null
            },
            "quantity": 2,
            "punktid": 0.5,
            "boonus": 0
        }
    ]
}
~~~





## Status code meanings

* `200` - successful request;
  - means, that ToDo is successfully created;
  - means, that Task is successfully created;
  - means, et Task is successfully added to ToDo;

* `401` - wrong `token`;

* `400` - not valid input or element missing;

* `405` - method not allowed;
  - means, that ToDo list is empty;
  - means, that Task List is empty.

* `404` - not found;
  - means, that ToDo not found;
  - means, that Task not found.

* `406` - not acceptable;
  - only  acceptable values are "jah", "ei" or "task", "test".

## References
Warehouse-web-service. Spyroks. [WWW] [https://github.com/spyroks/warehouse-web-service/blob/master/README.md] (01.06.2018)
Veebiteenused. Tarvo Treier. [WWW] [http://www.tud.ttu.ee/im/Tarvo.Treier/idu0075/2017/](http://www.tud.ttu.ee/im/Tarvo.Treier/idu0075/2017/) (01.06.2018)

