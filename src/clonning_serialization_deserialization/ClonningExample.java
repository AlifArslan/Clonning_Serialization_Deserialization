package clonning_serialization_deserialization;

import java.util.ArrayList;

public class ClonningExample implements Cloneable{

    String id, name;

    public ClonningExample(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        /*
         --> Clonning means creating the exact duplicate object from the heap memory. Like if we change 
        the window of laptop, then we save our softwares back up in a USB or CD when we installed the new 
        window then we retrieves all data from the flash to in the laptop instead of buying new Laptop we 
        save back up copy. so clonning is same thing.
        
         -->Must keep in mind must our class implements the Cloneable Interface otherwise clonning is not Done.
        
         */
        ClonningExample obj = new ClonningExample("111", "aaa");
        System.out.println(obj.id + " -- " + obj.name);

        try {
            System.out.println("Clone Object 1 to Object 2");
            //Clone the Object...
            ClonningExample obj2 = (ClonningExample) obj.clone();
            System.out.println(obj2.id + " -- " + obj2.name);
 
        } catch (CloneNotSupportedException ex) {

        }
    }
}
/*
111 -- aaa
Clone Object 1 to Object 2
111 -- aaa
*/