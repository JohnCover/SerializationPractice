/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author John
 */
public class SerializationPractice {

    public static void main(String[] args) throws Exception {

        ActiveTask ans1 = new ActiveTask("java is a programming language", "ravi");
        ActiveTask ans2 = new ActiveTask("java is a platform", "john");

        ArrayList<ActiveTask> list = new ArrayList<ActiveTask>();
        list.add(ans1);
        list.add(ans2);

        Employee test = new Employee(123, "John Cover", 65000, list);
        objectToXml(test, "Employee_JohnCover9.xml");

        //unmarshal: XML to Object
        //getting a null pointer on unmarshal, no idea why.
        try {
            File file = new File("Employee_JohnCover9.xml");
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            
            Unmarshaller toObj = context.createUnmarshaller();
            Employee john = (Employee) toObj.unmarshal(file);
            
            System.out.println(john.getName() + " " + john.getSalary() + " " + john.getId());
            List<ActiveTask> unmarshaledTasks = john.getTask();
            for(ActiveTask t : unmarshaledTasks)
                System.out.println("Task Name:\t"+t.getTaskName()+"\tTask Description:\t"+t.getDescription());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void objectToXml(Employee e, String name) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller toXML = context.createMarshaller();
        toXML.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        toXML.marshal(e, new FileOutputStream(name));
    }

}
