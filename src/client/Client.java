package client;

import entity.Task;
import request.CommandType;
import request.MappingType;
import request.Request;
import request.TaskDTORequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;

public class Client {
    static final String SERVER_HOST = "localhost";
    static final int PORT = 4543;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket(SERVER_HOST,PORT);
        ObjectOutputStream socketOutput = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream socketInput = new ObjectInputStream(socket.getInputStream());


        var request = new Request(MappingType.DELETE,CommandType.DELETE_TASK_BY_NAME,"api");

        socketOutput.writeObject(request);
        var response = socketInput.readObject();
        socketOutput.flush();
        System.out.println(response);
        socketOutput.close();
        socketInput.close();





    }
}
