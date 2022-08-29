package client;


import request.CommandType;
import request.MappingType;
import request.Request;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client {
    static final String SERVER_HOST = "localhost";
    static final int PORT = 4543;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket(SERVER_HOST,PORT);
        ObjectOutputStream socketOutput = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream socketInput = new ObjectInputStream(socket.getInputStream());

        Request request = Request.builder()
                .mappingType(MappingType.GET)
                .commandType(CommandType.FIND_ALL)
                .build();




        socketOutput.writeObject(request);
        socketOutput.flush();

        while (socketInput.available() > 0) {
            var response = socketInput.readObject();
            System.out.println(response);
        }

        socketOutput.close();
        socketInput.close();





    }
}
