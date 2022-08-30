package server.utils;

import java.io.File;
import java.io.IOException;

public class FileInitializer {

    public static String initListOfTasksFile() throws IOException {
        File baseDir = new File(Constants.BASE_FOLDER + File.separator + Constants.CHILD_FOLDER);
        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }


        File file = new File(baseDir, Constants.TASK_LIST_PATH);

        if (!file.exists()) {
            file.createNewFile();



        }
        return file.getPath();
    }

    public static String initTaskFile(String taskName) throws IOException {
        File baseDir = new File(Constants.BASE_FOLDER);
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }
        File file = new File(baseDir,taskName + Constants.TASK_FILENAME_SUFFIX);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file.getPath();
    }
}
