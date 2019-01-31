
package clonning_serialization_deserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person //implements Serializable
{
    private int id;
    private String Name;

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}

class Emp extends Person implements Serializable
{
    /* When we have parent and child relationship then for performs serialization just child class implements 
    *  Serializable Interface. Parent class dont need to implements the Serializable Interface for performing 
       Serialization of Child class. In Child class we have parent class fields Accessible Except private fields
       and methods so make parent class fields public or encapsulate parent class fields by creating getter 
       and setter methods in parent class then we will be able to access the getter and setter in the child class
       because getter and setter methods always public in this way we get encapsulation of parent class fields and 
        as well as we use parent class properties in the child class.
    */
    private int salary;

    public Emp(int salary) {
        
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    /* 
    --> When Parent class does not implements the Serializable interface then we must write these two methods mainly 
	the purpose is to overriding the default Serailization Mechanism & Overriding default Deserailization Mechanism.
	If we dont overrides then default Serailization and DeSerialization Mechanism performing Serailization and De-Serialization
	then  the default values of variables are written to the file. when read values then we gets default values for parent 
       class variables means objects of parent class. every variable is object type Wrapper Concept..
    
    --> These two methods calls by JVM at Run time While Perforing Serialization and Deserialization.
    */
     private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject(); // //must call this method for overriding the default behaviour of writing the object
        oos.writeInt(super.getId()); /* super is optional if variables same then use super for represent parent class var.. */
        oos.writeObject(getName());
    }
    
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException
    {
		
        ois.defaultReadObject(); //must call this methodfor overriding the default behaviour of reading the object
        
		/*  Must Retrieve the objects in the same order in which the objects are write. */
		
        setId(ois.readInt());
        setName((String) ois.readObject());
    }
    
}

public class Serialization_of_Parent_Child_Class_Fields {
    private void serializationOfData(String fileName)
    {
        Emp emp = new Emp(2554454);
        emp.setId(001);
        emp.setName("Alif Arslan");
        
         try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
         {
             oos.writeObject(emp);
             /* here we dont need to close the ObjectOutputStream by using oos.close(); because of oos pass as try(parameter) */
             
             System.out.println("Serialization DONE !!");
         }catch(Exception e){}
    }
    
    private void deserializationOfData(String fileName)
    {
        try
        {
            System.out.println("\nDe-Serialization Of Data :- ");
            //Now here we must need to close to ObjectInputStream
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            Emp e = (Emp) ois.readObject();
            System.out.println(e.getId() + " - - "+e.getName()+" -- "+e.getSalary());
            
            
            //must close the Object Input Stream
            ois.close();
            
        }catch(Exception e) {}
    }
    public static void main(String[] args) {
        Serialization_of_Parent_Child_Class_Fields obj = new Serialization_of_Parent_Child_Class_Fields();
        //file name with any extension 
        String fileName = "info.login";
        obj.serializationOfData(fileName);
        
        obj.deserializationOfData(fileName);
    }
}
/*
Output :- 
        Serialization DONE !!

        De-Serialization Of Data :- 
        1 - - Alif Arslan -- 2554454

*/