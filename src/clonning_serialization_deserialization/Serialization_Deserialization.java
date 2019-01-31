
package clonning_serialization_deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Let
 */
public class Serialization_Deserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        ArrayList<EmpModel> arrayListEmp = new ArrayList<>();
        arrayListEmp.add(new EmpModel(111, "Kamran Khan", "56887"));
        arrayListEmp.add(new EmpModel(222, "Noor Khan", "565468"));
        arrayListEmp.add(new EmpModel(333, "Afzal Khan", "87864"));
        
        ArrayList<Student> studentArrayList = new ArrayList();
        studentArrayList.add(new Student("001", "Arslan Arslan"));
        studentArrayList.add(new Student("002", "Noor Noor"));
        studentArrayList.add(new Student("003", "Ali Ali"));
        
        //Serialization
        FileOutputStream fileOutputStream = new FileOutputStream("abc.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        
        objectOutputStream.writeObject(arrayListEmp);
        objectOutputStream.writeObject(studentArrayList);
        
        objectOutputStream.close(); //close for avoid leaking memory
        
        //DeSerialization
        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        /* 
        In which order write the objects same order retrieve those objects else get exception.
        like here first employee arraylist object write then student object write, so while deserialization
        must must retrieve the employee object then retrieve the student object. See Below demo uncomment the next code
        */
        //ArrayList<Student> stdAL  = (ArrayList<Student>) ois.readObject(); //get Exception...
        ArrayList<EmpModel> al = (ArrayList<EmpModel>) ois.readObject();
        ArrayList<Student> stdAL  = (ArrayList<Student>) ois.readObject();
        
        ois.close();//close for avoid any leaking resources
        
        System.out.println("Deserialize Employees Data :- ");
        for(EmpModel emp : al)
        {
            System.out.println(emp.id + " -- "+emp.name+" -- "+emp.password);
        }
        
        
        System.out.println("\nDeserialize Students Data :- ");
        for(Student std : stdAL)
        {
            System.out.println(std.id + " : "+std.name);
        }      
    } 
}

/*
Output :- 
            Deserialize Employees Data :- 
            111 -- Kamran Khan -- null
            222 -- Noor Khan -- null
            333 -- Afzal Khan -- null

            Deserialize Students Data :- 
            001 : Arslan Arslan
            002 : Noor Noor
            003 : Ali Ali
*/
