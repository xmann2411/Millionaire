package hr.algebra.java2.milionare.Client;

import hr.algebra.java2.milionare.model.SerializableButtonModel;

public interface ClientEventListener {

    public void onMessageReceived(SerializableButtonModel serializableButtonModel);

}
