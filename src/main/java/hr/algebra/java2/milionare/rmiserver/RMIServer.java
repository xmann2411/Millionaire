package hr.algebra.java2.milionare.rmiserver;

import hr.algebra.java2.milionare.jndi.JNDIConfigurationKey;
import hr.algebra.java2.milionare.jndi.JNDIHelper;

//import com.sun.jndi.fscontext.RefFSContext;
//import com.sun.jndi.fscontext.RefFSContextFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.util.Properties;

import static hr.algebra.java2.milionare.jndi.JNDIHelper.context;


public class RMIServer {
    public static final int RANDOM_PORT_HINT = 0;
    //public static final int RMI_PORT = 2020;
    private static final String RMI_PORT_KEY = "rmi.port";

    private RMIServer() {}

    public static void startServer() {
        try {
            //Registry registry = LocateRegistry.createRegistry(RMI_PORT);

            // ------------- KRAĆI ---------------
            int rmiPort = Integer.parseInt(JNDIHelper.getConfigurationParameter(RMI_PORT_KEY));
            Registry registry = LocateRegistry.createRegistry(rmiPort);
            RemoteService remoteService = new RemoteServiceImpl();
            RemoteService skeleton = (RemoteService) UnicastRemoteObject.exportObject(remoteService, RANDOM_PORT_HINT);
            registry.rebind(RemoteService.REMOTE_OBJECT_NAME, skeleton);
            System.err.println("Object registered in RMI registry");

            // ---------- PROF ---------------
            /*String rmiPortString = JNDIHelper.getConfigurationParameter(RMI_PORT_KEY);
            Registry registry = LocateRegistry.createRegistry(Integer.parseInt(rmiPortString));

            //Registry registry = LocateRegistry.createRegistry(RMI_PORT);
            //int rmiPort = Integer.parseInt(JNDIHelper.getConfigurationParameter(RMI_PORT_KEY));
            //Registry registry = LocateRegistry.createRegistry(rmiPort);
            RemoteService remoteService = new RemoteServiceImpl();
            RemoteService skeleton = (RemoteService) UnicastRemoteObject.exportObject(remoteService, RANDOM_PORT_HINT);
            registry.rebind(RemoteService.REMOTE_OBJECT_NAME, skeleton);
            System.err.println("Object registered in RMI registry");*/

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        RMIServer.startServer();
    }
}
