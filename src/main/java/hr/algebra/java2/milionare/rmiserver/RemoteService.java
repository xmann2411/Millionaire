package hr.algebra.java2.milionare.rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteService extends Remote {
    String REMOTE_OBJECT_NAME = "hr.algebra.rmi.service.chat";

    void sendMessage(String newMessage, String userName) throws RemoteException;

    String receiveAllMessages() throws RemoteException;
}
