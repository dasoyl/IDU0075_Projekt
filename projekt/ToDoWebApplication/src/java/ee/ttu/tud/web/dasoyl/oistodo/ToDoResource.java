/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.tud.web.dasoyl.oistodo;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;


/**
 * REST Web Service
 *
 * @author darya
 */
@Path("todos")
public class ToDoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ToDoResource
     */
    public ToDoResource() {
    }
/**
     * Retrieves representation of an instance of toDo.ToDosResource
     * @param token
     * @param hasRelatedTasks
     * @param startDateString
     * @param endDateString
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public GetToDoListResponse getToDoList(@Context UriInfo info, @QueryParam("token") String token,
            @DefaultValue("jah") @QueryParam("tasks") String hasRelatedTasks,
            @QueryParam("start") String startDateString,
            @QueryParam("end") String endDateString) {
        try {
            ToDoWebService ws = new ToDoWebService();
            GetToDoListRequest request = new GetToDoListRequest();
            request.setToken(token);
            request.setHasRelatedTasks(hasRelatedTasks);
            
            DateFormat formatter; 
            formatter = new SimpleDateFormat("dd-MM-yy");
            Date date = formatter.parse(startDateString);
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(date);
            request.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory));
            date = formatter.parse(endDateString);
            gregory = new GregorianCalendar();
            gregory.setTime(date);
            request.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory));
            return ws.getToDoList(request);
        } catch (ParseException | DatatypeConfigurationException ex) {
            Logger.getLogger(ToDoResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Path("{id : \\d+}") //support digit only
    @Produces("application/json")
    public ToDoType getToDo(@PathParam("id") String id,
            @QueryParam("token") String token) {
        ToDoWebService ws = new ToDoWebService();
        GetToDoRequest request = new GetToDoRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getToDo(request);
    }
    
    /**
     *
     * @param content
     * @param token
     * @return 
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ToDoType addToDo(ToDoType content, 
                                @QueryParam("token") String token) {
        ToDoWebService ws = new ToDoWebService();
        AddToDoRequest request = new AddToDoRequest();
        request.setToken(token);
        request.setToDoDate(content.getToDoDate());
        request.setDueDate(content.getDueDate());
        request.setStudentName(content.getStudentName());
        return ws.addToDo(request);    
    }
    
    @GET
    @Path("{id : \\d+}/tasks") //support digit only
    @Produces("application/json")
    public ToDoTaskListType getToDoTaskList(@PathParam("id") String id,
            @QueryParam("token") String token) {
        ToDoWebService ws = new ToDoWebService();
        GetToDoTaskListRequest request = new GetToDoTaskListRequest();
        request.setToDoId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getToDoTaskList(request);
    }
    
    /**
     *
     * @param content
     * @param token
     * @param id
     * @return 
     */
    @POST
    @Path("{id : \\d+}/tasks") //support digit only
    @Consumes("application/json")
    @Produces("application/json")
    public ToDoTaskType addToDoTask(AddToDoTaskRequest content, 
                                @QueryParam("token") String token,
                                @PathParam("id") String id) {
        ToDoWebService ws = new ToDoWebService();
        AddToDoTaskRequest request = new AddToDoTaskRequest();
        request.setToken(token);
        request.setToDoId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setTaskId(content.getTaskId());
        request.setQuantity(content.getQuantity());
        request.setPunktid(content.getPunktid());
        request.setBoonus(content.getBoonus());
        return ws.addToDoTask(request);    
    }
}
