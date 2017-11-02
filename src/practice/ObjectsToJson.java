
package practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author John
 */
public class ObjectsToJson {
    
    public static void main(String[] args) throws IOException {
        ObjectsToJson tester = new ObjectsToJson();
        tester.writeJson();
        tester.readJson();
    }
    
    public void writeJson() throws IOException {
        ActiveTask ans1 = new ActiveTask("Prime Directive", "allocate resources to maintain John's coolness");
        ActiveTask ans2 = new ActiveTask("Secondary Task", "Look amazing");

        ArrayList<ActiveTask> list = new ArrayList<ActiveTask>();
        list.add(ans1);
        list.add(ans2);

        Employee test = new Employee(123, "John Cover", 65000, list);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("john.json"), test);
    }
    
    public void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Employee john = mapper.readValue(new File("john.json"), Employee.class);
        System.out.println("Employee name: " + john.getName());
        for(ActiveTask t : john.getTask()) 
            System.out.println("Task: " + t.getTaskName()+"\tDescription: "+t.getDescription());
    }
}
