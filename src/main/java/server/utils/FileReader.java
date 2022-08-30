package server.utils;

import java.io.*;

public class FileReader {
    
    public static <T extends Serializable> T readFromFile(String path) {
        T object = null;
        
        try(
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))
                ) {
            object = (T) ois.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return object;

    }
}
