package client;

import entity.Task;

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
        ObjectInputStream socketInput = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream socketOutput = new ObjectOutputStream(socket.getOutputStream());
        socketOutput.writeObject(new Task("payment"
                , true
                ,"John"
                , LocalDate.now()
                ,LocalDate.of(2022,9,22)));
        System.out.println(socketInput.readObject());

    }
}
