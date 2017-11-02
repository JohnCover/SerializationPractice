package practice;

/**
 *
 * @author John
 */

public class Task {
    private String name;
    private String description;
    
    public Task() {
    }
    
    Task(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription() {
        return description;
    }
}
