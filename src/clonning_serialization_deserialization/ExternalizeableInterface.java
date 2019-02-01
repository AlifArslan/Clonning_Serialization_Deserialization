
package clonning_serialization_deserialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Parent
{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

class Child extends Parent implements Externalizable
{

    private int salary;
    private String employeeType;

    public Child() {
        /*We Must Required Zero arg Constructor when we implement Externalizable for doing the serialization. Other wise
       Serialization cannot Done. 
       */
    }
    
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    
    
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        
        //write parent object
         out.writeInt(getId());
         out.writeObject(getName());
         
         //write child class object
         out.writeObject(employeeType);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        
        //Read Parent Object
        super.setId(in.readInt()); //super optional
        setName((String) in.readObject());
        
        //read Child Object
        setEmployeeType((String) in.readObject());
    }
    
}   

public class ExternalizeableInterface {
    
    public static void main(String[] args) {
        
        String fileName = "abc.my";
        
        Child c1 = new Child();
        c1.setId(1111);
        c1.setName("Arslan Shakar");
        c1.setEmployeeType("Hourly Employee");
        c1.setSalary(500000);  //we dont serialized this object bcz of Externalizable gives custom serialization behaviour
        
        /* we dont serialized salary object check writeObject(..) method..because of custom serialization
            behaviour we get by implementing the Externalizable interface.
        even we print when  deserialize it print the default variable value... Serialization performing by
        implementing the serializable interface thats gives us the default serialization behaviour it serialize all
        objects of child class but when we implements the externalizable it gives us customserialization means only
        those object serialize which we want to serialize. we must override two methods writeExternal and 
        readExternal methods for customization of serialization of objects.
        */
        
        
        try
        {
            //Serialzation
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(c1);
            oos.close();
            System.out.println("Serialization Done!!!!");
            
            
            
            //De-Serialization
            System.out.println("\nDeSerialization");
            ObjectInputStream ios = new ObjectInputStream(new FileInputStream(fileName));
            Child c = (Child) ios.readObject();
            ios.close();
            System.out.println(c.getId() +" -- "+c.getName()+" -- "+c.getEmployeeType()+" -- "+c.getSalary());
        }catch(Exception e)
        {
            
        }
    }  
}

/*
Output :- 
        Serialization Done!!!!

        DeSerialization
        1111 -- Arslan Shakar -- Hourly Employee -- 0

*/
