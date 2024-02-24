package hr.algebra.java2.milionare.model;

import java.awt.*;

public class PlayerDetails {
    private String playerName;
    //kak mogu tu sad deklarirat gumbe na playeru kad su oni definirani
    //na game screen controleru
   private Button questionButton;
    private Button answerOneButton;
    private Button answerTwoButton;
    private String answerThreeButton;
    private String answerFourButton;
    private boolean isPlayerOne;

    public Label playerPointsLabel;

    private Integer moneyWon;

    private Integer port;

    private String ipAddress;



    public PlayerDetails() {

    }
    public PlayerDetails(String ipAddress) {

        this.ipAddress = ipAddress;
    }

    public Integer getPort() {
        return port;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getIpAddress() {
        return ipAddress;
    }


    public Integer getMoneyWon() {
        return moneyWon;
    }

    public void recordCorrectAnswers() {
        moneyWon++;}

}
