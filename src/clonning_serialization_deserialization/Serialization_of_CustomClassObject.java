
package clonning_serialization_deserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization_of_CustomClassObject {
    public static void main(String[] args) {
        Address address = new Address("Bhimber", "10050");
        Address address2 = new Address("Rawalpindi", "7777");
        Address address3 = new Address("Lahore", "5454");
        Teacher tObj = new Teacher(01, "Alif Arslan", address);
        Teacher tObj2 = new Teacher(02, "Hamza Waqar", address2);
        Teacher tObj3 = new Teacher(03, "Noor Arif", address3);
        
        //make file with any extension
        String fileName = "MyFile.ser"; 
        //Serialization
        
        /**
        *   passing object like try(objectOutputStream) {..} then we don't need to close that file or even database 
        *   connection because that object scope is only with try block after when try block execution its destroys.
        */
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            objectOutputStream.writeObject(tObj); //only first object is writes to object output stream
            objectOutputStream.writeObject(tObj2); //not write
            objectOutputStream.writeObject(tObj3); //not write 
            /* Please use ArrayList or any other Collection class for writing one class Multiple objects */
            System.out.println("Serialization DONE!!");
            
        }catch(Exception e)
        {
        }

        //Deserialization
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            System.out.println("\nDeserialization");
     
            Teacher e = (Teacher) ois.readObject();
            
            System.out.println(e.getTid() + " -- "+e.getTname()+" -- "+e.getAddress());

            /* for address it print the Address class Hash Code so we must need to do something thats very basic thing */
            Address readAddress = e.getAddress();
            System.out.println("Address : "+readAddress.getCityName() + " -- "+readAddress.getZipCode());  
        }catch(Exception e)
        {
        }  
    }
}
