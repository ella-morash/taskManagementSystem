package server;

import controller.TaskController;
import entity.Task;
import repository.impl.TaskRepositoryFileSystemImpl;
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

        while(true) {
            var socket = ss.accept();


               try {
                   ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                   ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                   taskController.createTask((Task) ois.readObject());
               } catch (IOException | ClassNotFoundException e) {
                   e.printStackTrace();
               }



        }

    }
}
