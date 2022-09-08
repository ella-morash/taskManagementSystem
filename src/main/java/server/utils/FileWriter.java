package server.utils;





import java.io.*;


public class FileWriter {

    public static <T extends Serializable> void writeToFile(String path, T object) {
        try(
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))
                ) {
            oos.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
