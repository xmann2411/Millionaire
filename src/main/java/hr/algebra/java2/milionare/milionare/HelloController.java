package hr.algebra.java2.milionare.milionare;

import hr.algebra.java2.milionare.model.PlayerDetails;
import hr.algebra.java2.milionare.model.SerializableButtonModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;


public class HelloController {

    public static final String HOST = "localhost";
    public static final int PORT = 2009;
    @FXML
    private TextField playerNameTextField;
    private static String playerName;
    private static PlayerDetails playerOneDetails;

    //jel ovo treba tu definirati?
    @FXML
    private Button questionButton;
    @FXML
    private Button answerOneButton;
    @FXML
    private  Button answerTwoButton;
    @FXML
    private  Button answerThreeButton;
    @FXML
    private  Button answerFourButton;
    private static SerializableButtonModel serializableButtonModel;

    private static int playerOnePoints = 0;
    private static int playerTwoPoints = 0;

    public static Boolean playerOneTurn = true;

    private static boolean usedAudience = false;
    private static boolean usedCall = false;
    private static boolean used5050 = false;

    private boolean isDisabled = false;
    int numberOfQuestion = 0;
    @FXML
    private CheckBox isPlayerOneBox;

    public void initialize(){
        playerName = playerNameTextField.getText();
        questionButton = new Button();
        answerOneButton = new Button();
        answerTwoButton = new Button();
        answerThreeButton = new Button();
        answerFourButton = new Button();

    }

    @Override
    public String toString() {
        return "HelloController{" +
                "playerOneNameTextField=" + playerNameTextField +
                //", playerTwoNameTextField=" + playerTwoNameTextField +
                '}';
    }

    public void startGame() throws IOException{
        playerName = playerNameTextField.getText();

        System.out.println("Welcome, " + playerName + "!");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gameScreen.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1200, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HelloApplication.getMainStage().setTitle("Hello!");
        HelloApplication.getMainStage().setScene(scene);
        HelloApplication.getMainStage().show();

        System.out.println("Sending state");
        String questionText = questionButton.getText();
        String anwserOneText = answerOneButton.getText();
        String anwserTwoText = answerTwoButton.getText();
        String anwserThreeText = answerThreeButton.getText();
        String anwserFourText = answerFourButton.getText();

        serializableButtonModel = new SerializableButtonModel(questionText, anwserOneText, anwserTwoText, anwserThreeText, anwserFourText, Integer.toString(playerOnePoints),
                Integer.toString(playerTwoPoints), Boolean.toString(playerOneTurn), Boolean.toString(usedCall), Boolean.toString(usedAudience), Boolean.toString(used5050), Boolean.toString(isDisabled), Integer.toString(numberOfQuestion));
    }

    @FXML
    void checkIsPlayerOne() {
        HelloApplication.isPlayerOne = true;
    }


    public TextField getPlayerNameTextField() {
        return playerNameTextField;
    }
    public void setPlayerName() {
        playerName = playerNameTextField.getText();
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static PlayerDetails getPlayerOneDetails() {
        return playerOneDetails;
    }

}