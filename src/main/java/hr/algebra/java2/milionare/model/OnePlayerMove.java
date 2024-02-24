package hr.algebra.java2.milionare.model;

import java.io.Serializable;

public class OnePlayerMove implements Serializable {

    public int question;
    public char givenAnwserLetter;

    public boolean isAudienceUsed;
    public boolean isCallUsed;
    public boolean isFiftyUsed;

    public OnePlayerMove(){
    }

    public OnePlayerMove(int question, char givenAnwserLetter){
        this.question = question;
        this.givenAnwserLetter = givenAnwserLetter;
    }

    public OnePlayerMove(int question, char givenAnwserLetter, boolean isAudienceUsed, boolean isCallUsed, boolean isFiftyUsed) {
        this.question = question;
        this.givenAnwserLetter = givenAnwserLetter;
        this.isAudienceUsed = isAudienceUsed;
        this.isCallUsed = isCallUsed;
        this.isFiftyUsed = isFiftyUsed;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public char isGivenAnwserCorrect() {
        return givenAnwserLetter;
    }

    public void setGivenAnwserLetter(char givenAnwserLetter) {
        this.givenAnwserLetter = givenAnwserLetter;
    }

    public boolean isAudienceUsed() {
        return isAudienceUsed;
    }

    public void setAudienceUsed(boolean audienceUsed) {
        isAudienceUsed = audienceUsed;
    }

    public boolean isCallUsed() {
        return isCallUsed;
    }

    public void setCallUsed(boolean callUsed) {
        isCallUsed = callUsed;
    }

    public boolean isFiftyUsed() {
        return isFiftyUsed;
    }

    public void setFiftyUsed(boolean fiftyUsed) {
        isFiftyUsed = fiftyUsed;
    }

    @Override
    public String toString() {
        return "Question " + question + ", Answer " + givenAnwserLetter;
    }

}
