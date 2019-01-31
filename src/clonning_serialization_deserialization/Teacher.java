
package clonning_serialization_deserialization;

import java.io.Serializable;

public class Teacher implements Serializable{
    private int tid;
    private String tname;
    
    /* for custom class object serialization with out inheritance that class must implement the Serializable interface */
    private Address address; 

    public Teacher(int tid, String tname, Address address) {
        this.tid = tid;
        this.tname = tname;
        this.address = address;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
       
}
