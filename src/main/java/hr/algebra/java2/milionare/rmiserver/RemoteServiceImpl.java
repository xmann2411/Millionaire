package hr.algebra.java2.milionare.rmiserver;

import java.rmi.RemoteException;

public class RemoteServiceImpl implements RemoteService {

    private String allMessages = "";

    @Override
    public void sendMessage(String newMessage, String userName) {
        //userName = HelloApplication.getPlayerName();
        allMessages += userName + " > " + newMessage + "\n";
    }

    @Override
    public String receiveAllMessages() {
        return allMessages;
    }
}