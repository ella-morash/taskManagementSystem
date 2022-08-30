package server.utils;

import java.io.File;

public class FileEraser {

    public static void  deleteFile(String path) {
        new File(path).delete();
    }
}
