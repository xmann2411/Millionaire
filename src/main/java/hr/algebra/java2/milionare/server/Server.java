package hr.algebra.java2.milionare.server;

import hr.algebra.java2.milionare.milionare.HelloApplication;
import hr.algebra.java2.milionare.utils.ConsoleColor;

import java.net.ServerSocket;
import java.net.Socket;


import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Server {
    private final int port;
    private final Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>());

    public Server(int port) {
        this.port = port;
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(ConsoleColor.YELLOW + "Server starting on port => " + port + ConsoleColor.RESET);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(this, clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClient(ClientHandler client) {
        synchronized (clients) {
            clients.add(client);
            System.out.println(ConsoleColor.GREEN + "Client connected from ip:port => " + client.getClientSocket().getInetAddress() + ":" + client.getClientSocket().getPort() + ConsoleColor.RESET);
        }
    }

    public void removeClient(ClientHandler client) {
        synchronized (clients) {
            clients.remove(client);
            System.out.println(ConsoleColor.RED + "Client disconnected from ip:port => " + client.getClientSocket().getInetAddress() + ":" + client.getClientSocket().getPort() + ConsoleColor.RESET);
        }
    }

    public void forwardToAllOtherClients(ClientHandler sender, Object obj) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(obj);
                }
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(HelloApplication.PORT);
        server.startServer();
    }
}