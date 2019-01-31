
package clonning_serialization_deserialization;

import java.io.Serializable;


public class EmpModel implements Serializable{
    /* this class must implement the Serializable interface else get Exception if we perform Serialization */
    public int id;
    public String name;
    public transient String password;

    public EmpModel(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    
}
