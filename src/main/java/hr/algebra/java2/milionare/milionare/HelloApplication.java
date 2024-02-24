package hr.algebra.java2.milionare.milionare;

import hr.algebra.java2.milionare.Client.Client;
import hr.algebra.java2.milionare.server.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class HelloApplication extends Application {

    public static final String HOST = "localhost";
    public static final int PORT = 2009;
    private static Stage mainStage;
    private static String playerName;
    public static boolean isPlayerOne = false;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        String tempPlayerName = "";

        Integer tokenNumber = 1;

        for (String param : args){
            System.out.println("Next param: " + param);
            if (args.length > tokenNumber){
                tempPlayerName += param + " ";
            }
            else {
                tempPlayerName += param;
            }
            tokenNumber++;
        }

        playerName = tempPlayerName;

        launch();
        //ARadovan -> u mainu acceptaRequest ako je Server
        // a sendRequest ako je client
        // obje metode ima u HelloApplication
    }

    public static Stage getMainStage(){
        return mainStage;
    }

    public static String getPlayerName(){
        return HelloController.getPlayerName();
    }
}