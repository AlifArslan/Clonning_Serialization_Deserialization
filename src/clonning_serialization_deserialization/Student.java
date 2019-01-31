
package clonning_serialization_deserialization;

import java.io.Serializable;

public class Student implements Serializable {
    /* this class must implement the Serializable interface else get Exception if we perform Serialization */
    
    String id , name;
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
}
