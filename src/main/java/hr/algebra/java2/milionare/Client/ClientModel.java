package hr.algebra.java2.milionare.Client;

import java.io.Serializable;

public class ClientModel implements Serializable {

    private final Integer port;
    private final String ipAddress;


    public ClientModel(Integer port, String ipAddress){
        this.port = port;
        this.ipAddress = ipAddress;
    }

    public Integer getPort() { return port; }

}
