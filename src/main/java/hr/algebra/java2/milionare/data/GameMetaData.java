package hr.algebra.java2.milionare.data;

import hr.algebra.java2.milionare.milionare.GameScreenController;

import java.io.Serializable;

public class GameMetaData implements Serializable {

    int numQuestion = 0;
    static int playerOnePoints = 0;
    static int playerTwoPoints = 0;
    static String winner;

    public static String getWinner(String playerOneName) {
        return winner;
    }
    public void setWinner(String winner) {
        GameMetaData.winner = winner;
    }

    static String playerOneName;
    static String playerTwoName;
    boolean playerOneTurn = true;
    boolean usedAudienceHelp = false;
    boolean usedCallHelp = false;
    boolean usedFiftyFiftyHelp = false;



    public static String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        GameMetaData.playerOneName = playerOneName;
    }

    public static String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        GameMetaData.playerTwoName = playerTwoName;
    }

    public int getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

    public boolean isPlayerOneTurn() {
        return playerOneTurn;
    }

    public void setPlayerOneTurn(boolean playerOneTurn) {
        this.playerOneTurn = playerOneTurn;
    }

    public static int getPlayerOnePoints() {
        return playerOnePoints;
    }

    public void setPlayerOnePoints(int playerOnePoints) {
        GameMetaData.playerOnePoints = playerOnePoints;
    }

    public static int getPlayerTwoPoints() {
        return playerTwoPoints;
    }

    public void setPlayerTwoPoints(int playerTwoPoints) {
        GameMetaData.playerTwoPoints = playerTwoPoints;
    }


    public boolean isUsedAudienceHelp() {
        return usedAudienceHelp;
    }

    public void setUsedAudienceHelp(boolean usedAudienceHelp) {
        this.usedAudienceHelp = usedAudienceHelp;
    }

    public boolean isUsedCallHelp() {
        return usedCallHelp;
    }

    public void setUsedCallHelp(boolean usedCallHelp) {
        this.usedCallHelp = usedCallHelp;
    }

    public boolean isUsedFiftyFiftyHelp() {
        return usedFiftyFiftyHelp;
    }

    public void setUsedFiftyFiftyHelp(boolean usedFiftyFiftyHelp) {
        this.usedFiftyFiftyHelp = usedFiftyFiftyHelp;
    }

}
