/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */

@XmlRootElement
public class Employee {

    private int id;
    private String name;
    private float salary;
    private List<ActiveTask> activeTask;

    public Employee() {

    }

    public Employee(int id, String name, float salary, List<ActiveTask> task) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.activeTask = task;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public float getSalary() {
        return salary;
    }
    
    @XmlElement
    public List<ActiveTask> getTask() {
        return activeTask;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    public void printTasks() {
        for(ActiveTask t : activeTask)
            System.out.println("Task Name:\t"+t.getTaskName()+"\tTask Description:\t"+t.getDescription());
    }
}
