package hr.algebra.java2.milionare.server;

import hr.algebra.java2.milionare.model.SerializableButtonModel;
import hr.algebra.java2.milionare.utils.ConsoleColor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Server server;
    private final Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientHandler(Server server, Socket socket) {
        this.clientSocket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            addSelfToClients();
            while (true) {
                Object obj = inputStream.readObject();
                SerializableButtonModel srlzbtn = (SerializableButtonModel) obj;
                System.out.println(ConsoleColor.BLUE + "Received message from client ip:port => " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + ConsoleColor.RESET);
                System.out.println(ConsoleColor.RESET + "[MESSAGE RECEIVED - CONTENT TEST]: " + srlzbtn.getPointsOne() + ConsoleColor.RESET);
                server.forwardToAllOtherClients(this, obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            removeSelfFromClients();
        }
    }

    public synchronized void sendMessage(Object obj) {
        try {
            outputStream.writeObject(obj);
            outputStream.flush();
        } catch (IOException e) {
            removeSelfFromClients();
        }
    }

    private void addSelfToClients() {
        server.addClient(this);
    }

    private void removeSelfFromClients() {
        server.removeClient(this);
        try {
            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}