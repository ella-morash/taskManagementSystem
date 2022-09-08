package client;


import common.CommandType;
import common.MappingType;
import common.Request;
import common.TaskDTORequest;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;


public class Client {
    static final String SERVER_HOST = "localhost";
    static final int PORT = 4543;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket(SERVER_HOST, PORT);
        ObjectInputStream socketInput = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream socketOutput = new ObjectOutputStream(socket.getOutputStream());

//        Request request = Request.builder()
//                .mappingType(MappingType.GET)
//                .commandType(CommandType.CREATE_TASK)
//                .taskDTORequest(new TaskDTORequest(
//                        "task-1",
//                        false,
//                        "peter",
//                        LocalDate.now(),
//                        LocalDate.now().plusDays(3)
//                ))
//                .build();

        Request request = Request.builder()
                .mappingType(MappingType.GET)
                .commandType(CommandType.FIND_ALL)
                .build();


        socketOutput.writeObject(request);
        socketOutput.flush();

        var response = socketInput.readObject();
        System.out.println(response);

        socketOutput.close();
        socketInput.close();


    }
}
