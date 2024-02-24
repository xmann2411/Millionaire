package hr.algebra.java2.milionare.model;

import hr.algebra.java2.milionare.utils.ConsoleColor;

import java.io.Serializable;

public class NumberOfQuestionWrapper implements Serializable {
    private int numberOfQuestion;

    public NumberOfQuestionWrapper(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        System.out.println(ConsoleColor.YELLOW + String.valueOf(this.numberOfQuestion) + " => " + ConsoleColor.RED + String.valueOf(numberOfQuestion) + ConsoleColor.RESET);
        this.numberOfQuestion = numberOfQuestion;
    }

    public void incrementNumberOfQuestion(){
        System.out.println(ConsoleColor.YELLOW + String.valueOf(this.numberOfQuestion) + " => " + ConsoleColor.RED + String.valueOf((this.numberOfQuestion + 1)) + ConsoleColor.RESET);
        this.numberOfQuestion = this.numberOfQuestion + 1;
    }
}
