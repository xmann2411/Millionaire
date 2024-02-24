package hr.algebra.java2.milionare.model;

public class Answer {
    private final String answerText;
    private final boolean isCorrect;

    public Answer(String answerText, boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public String toString() {
        return answerText; // Display the answer text in the ListView
    }
}

