package hr.algebra.java2.milionare.Client;

import hr.algebra.java2.milionare.milionare.GameScreenController;
import hr.algebra.java2.milionare.model.SerializableButtonModel;
import hr.algebra.java2.milionare.utils.ConsoleColor;

import java.net.Socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//public class Client implements Runnable {
public class Client {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ClientEventListener gameScreenController;



    public Client(String host, int port, GameScreenController gameScreenController) {
        try {
            System.out.println(ConsoleColor.YELLOW + "Client connecting to server on port => " + port + ConsoleColor.RESET);
            socket = new Socket(host, port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            this.gameScreenController = gameScreenController;
            new Thread(this::listenForMessages).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(SerializableButtonModel srlzbtn) {
        try {
            outputStream.writeObject(srlzbtn);
            outputStream.flush();
            System.out.println(ConsoleColor.BLUE + "Client sent message to server on port => " + socket.getPort() + ConsoleColor.RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listenForMessages() {
        while (true) {
            try {
                Object obj = inputStream.readObject();
                SerializableButtonModel srlzbtn = (SerializableButtonModel) obj;
                System.out.println(ConsoleColor.BLUE + "Client received message from server on port => " + socket.getPort() + ConsoleColor.RESET);
                System.out.println(ConsoleColor.RESET + "[MESSAGE RECEIVED - CONTENT TEST]: " + srlzbtn.getPointsOne() + ConsoleColor.RESET);
                // mora se updateat GameScreenController :)
                gameScreenController.onMessageReceived(srlzbtn);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

}