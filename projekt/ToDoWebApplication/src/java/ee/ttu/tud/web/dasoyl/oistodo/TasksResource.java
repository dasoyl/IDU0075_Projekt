package ee.ttu.tud.web.dasoyl.oistodo;

import java.math.BigInteger;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author darya
 */
@Path("tasks")
public class TasksResource {

    public TasksResource() {
    }

    
    @GET
    @Produces("application/json")
    public GetTaskListResponse getTaskList(@QueryParam("token") String token) {
        ToDoWebService ws = new ToDoWebService();
        GetTaskListRequest request = new GetTaskListRequest();
        request.setToken(token);
        return ws.getTaskList(request);
    }
    
    @GET
    @Path("{id : \\d+}") //supports digits only
    @Produces("application/json")
    public TaskType getTask(@PathParam("id") String id,
            @QueryParam("token") String token) {
        ToDoWebService ws = new ToDoWebService();
        GetTaskRequest request = new GetTaskRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getTask(request);
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public TaskType addTask(TaskType content, 
                                @QueryParam("token") String token) {
        ToDoWebService ws = new ToDoWebService();
        AddTaskRequest request = new AddTaskRequest();
        request.setCode(content.getCode());
        request.setType(content.getType());
        request.setToken(token);
        return ws.addTask(request);
    }
}