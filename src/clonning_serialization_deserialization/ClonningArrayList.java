
package clonning_serialization_deserialization;

import java.util.ArrayList;

public class ClonningArrayList {
    public static void main(String[] args) {
         ArrayList al = new ArrayList();
            al.add("10");
            al.add(1001);
            al.add("bbb");
            
            ArrayList al2 = new ArrayList();
            al2 = (ArrayList) al.clone();
            
            System.out.println(al2);
            
            /* output :
                        [10, 1001, bbb]
            */
    }
 
}
