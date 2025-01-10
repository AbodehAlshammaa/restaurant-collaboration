package CrispyWay.Interfaces;

import java.io.Serializable;

public  interface FilesMemorization <T> extends Serializable {
   void initialize();
   boolean add();
   T getObject();
   void deleteObject();
   void writeObject(T object);

}
