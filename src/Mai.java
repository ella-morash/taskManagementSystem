import controller.TaskController;
import entity.Task;
import repository.impl.TaskRepositoryFileSystemImpl;
import service.impl.TaskServiceFileSystemImpl;

import java.time.LocalDate;

public class Mai {
    public static void main(String[] args) {
        TaskController taskController = new TaskController(new TaskServiceFileSystemImpl(new TaskRepositoryFileSystemImpl()));


        //System.out.println(taskController.findAllTasksByAssignedPerson("Lisa"));
        System.out.println("______");
        System.out.println(taskController.findAllTasksToBeCompletedThisWeek());
        //taskController.deleteTaskByName("socket");
        //System.out.println(taskController.findAll());

    }
}
