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
import java.net.Socket;
import java.net.SocketException;
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

                Request request = (Request) ois.readObject();

                ServerRequestParser.parseRequest(request,taskController,oos);

                oos.flush();
                oos.close();
                ois.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        });


    }

}
















