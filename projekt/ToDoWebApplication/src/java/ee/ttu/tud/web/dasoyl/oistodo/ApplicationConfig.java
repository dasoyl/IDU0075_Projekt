package ee.ttu.tud.web.dasoyl.oistodo;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author darya
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        try{
           Class jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
           resources.add(jsonProvider);
           } catch(ClassNotFoundException e){
           java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ee.ttu.tud.web.dasoyl.oistodo.TasksResource.class);
        resources.add(ee.ttu.tud.web.dasoyl.oistodo.ToDoResource.class);
    }
    
}
