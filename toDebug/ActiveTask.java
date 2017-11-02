package practice;

/**
 *
 * @author John
 */
public class ActiveTask {
    private String name;
    private String description;

    public ActiveTask() {
    }

    public ActiveTask(String name, String postedby) {
        super();
        this.name = name;
        this.description = postedby;
    }


    public String getTaskName() {
        return name;
    }

    public void setTaskName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
