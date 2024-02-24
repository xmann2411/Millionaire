package hr.algebra.java2.milionare.model;

import java.io.Serializable;

public class SerializableButtonModel implements Serializable {

    private final StringBuilder question;
    private final StringBuilder anwserA;
    private final StringBuilder anwserB;
    private final StringBuilder anwserC;
    private final StringBuilder anwserD;

    private final Integer pointsOne;
    private final Integer pointsTwo;
    private final Integer numberOfQuestions;

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }

    private final boolean playerTurn;
    private final boolean callUsed;
    private final boolean audienceUsed;
    private final boolean fiftyUsed;
    private final boolean isDisabled;

    public SerializableButtonModel(String question, String anwserA, String anwserB, String anwserC, String anwserD, String pointsOne, String pointsTwo, String playerTurn, String callUsed, String audienceUsed, String fiftyUsed, String isDisabled, String numberOfQuestions) {
        this.question = new StringBuilder(question);
        this.anwserA = new StringBuilder(anwserA);
        this.anwserB = new StringBuilder(anwserB);
        this.anwserC = new StringBuilder(anwserC);
        this.anwserD = new StringBuilder(anwserD);
        this.pointsOne = Integer.valueOf(pointsOne);
        this.pointsTwo = Integer.valueOf(pointsTwo);
        this.playerTurn = Boolean.parseBoolean(playerTurn);
        this.callUsed = Boolean.parseBoolean(callUsed);
        this.audienceUsed = Boolean.parseBoolean(audienceUsed);
        this.fiftyUsed = Boolean.parseBoolean(fiftyUsed);
        this.isDisabled = Boolean.parseBoolean(isDisabled);
        this.numberOfQuestions = Integer.valueOf(numberOfQuestions);
    }
    public StringBuilder getQuestion() {
        return this.question;
    }
    public StringBuilder getAnwserA() {
        return this.anwserA;
    }
    public StringBuilder getAnwserB() {
        return this.anwserB;
    }
    public StringBuilder getAnwserC() {
        return this.anwserC;
    }
    public StringBuilder getAnwserD() {
        return this.anwserD;
    }
    public Integer getPointsOne() {
        return pointsOne;
    }
    public Integer getPointsTwo() {
        return pointsTwo;
    }
    public boolean isPlayerTurn() {
        return playerTurn;
    }
    public boolean isCallUsed() {
        return this.callUsed;
    }
    public boolean isAudienceUsed() {
        return this.audienceUsed;
    }
    public boolean isFiftyUsed() {
        return this.fiftyUsed;
    }

    public boolean isDisabled() {
        return this.isDisabled;
    }
}
