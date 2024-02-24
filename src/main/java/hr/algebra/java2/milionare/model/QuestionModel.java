package hr.algebra.java2.milionare.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

import java.util.List;

public class QuestionModel {

    private final StringProperty id = new SimpleStringProperty();
    public StringProperty questionText = new SimpleStringProperty();

    private ListProperty<Answer> answers = new SimpleListProperty<>();

    public QuestionModel(String id, String questionText, List<Answer> answers) {
        setId(id);
        this.questionText.set(questionText);
        this.answers = new SimpleListProperty<>(FXCollections.observableArrayList(answers));
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty questionTextProperty() {
        return questionText;
    }

    public String getQuestionText() {
        return questionText.get();
    }

    public ListProperty<Answer> answersProperty() {
        return answers;
    }

    public List<Answer> getAnswers() {
        return answers.get();
    }

    public QuestionModel toData() {
        return new QuestionModel(
                getId(),
                getQuestionText(),
                getAnswers()
        );
    }
}




