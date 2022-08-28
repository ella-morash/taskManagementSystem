import controller.TaskController;
import repository.impl.TaskRepositoryFileSystemImpl;
import service.impl.TaskServiceFileSystemImpl;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController(new TaskServiceFileSystemImpl(new TaskRepositoryFileSystemImpl()));


        //System.out.println(taskController.findAllTasksByAssignedPerson("Lisa"));
        System.out.println("______");
        System.out.println(taskController.findAllTasksToBeCompletedThisWeek());
        //taskController.deleteTaskByName("socket");
        //System.out.println(taskController.findAll());

    }
}
