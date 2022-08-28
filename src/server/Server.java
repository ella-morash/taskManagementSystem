package server;

import controller.TaskController;
import entity.Task;
import repository.impl.TaskRepositoryFileSystemImpl;
import request.Request;
import service.impl.TaskServiceFileSystemImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static final int PORT = 4543;
    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ServerSocket ss = new ServerSocket(PORT);
        TaskController taskController = new TaskController(new TaskServiceFileSystemImpl(new TaskRepositoryFileSystemImpl()));

        var socket = ss.accept();

        pool.execute(() -> {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                //oos.writeObject(taskController.findAll());
                Request request = (Request) ois.readObject();

                switch (request.getCommandType()){

                    case FIND_ALL -> oos.writeObject(taskController.findAll());

                    case FIND_ALL_BY_PERSON -> oos.writeObject(taskController.findAllTasksByAssignedPerson(request.getPerson()));

                    case FIND_ALL_NOT_COMPLETED -> oos.writeObject(taskController.findAllNotCompletedTasks());

                    case CREATE_TASK ->  taskController.createTask((new Task(request.getTaskDTORequest().getName()
                            , request.getTaskDTORequest().isCompleted(),
                            request.getTaskDTORequest().getAssignedPerson()
                            , request.getTaskDTORequest().getCreatedDate()
                            , request.getTaskDTORequest().getCompletionDate())));

                    case DELETE_TASK_BY_NAME -> taskController.deleteTaskByName(request.getTaskName());

                    default -> oos.writeObject("Unprocessable request");
                }

                oos.flush();
                oos.close();
                ois.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        });


    }

}
















