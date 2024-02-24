package hr.algebra.java2.milionare.milionare;

import hr.algebra.java2.milionare.Client.Client;
import hr.algebra.java2.milionare.Client.ClientEventListener;
import hr.algebra.java2.milionare.model.*;
import hr.algebra.java2.milionare.rmiserver.RemoteService;
import hr.algebra.java2.milionare.thread.GetLastMoveThread;
import hr.algebra.java2.milionare.thread.SaveNewGameMoveThread;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameScreenController implements ClientEventListener {
    // PITANJA kreirana modelom QuestionModel
    Answer answerA = new Answer("Dubrovnik", false);
    Answer answerB = new Answer("Paris", true);
    Answer answerC = new Answer("Vienna", false);
    Answer answerD = new Answer("Madrid", false);
    List<Answer> answers1 = Arrays.asList(answerA, answerB, answerC, answerD);
    List<Answer> mutableAnswers1 = new ArrayList<>(answers1);

    // 2 pitanje
    Answer answerA2 = new Answer("William Wordsworth", false);
    Answer answerB2 = new Answer("William Shakespeare", true);
    Answer answerC2 = new Answer("Jane Austen", false);
    Answer answerD2 = new Answer("Mark Twain", false);
    List<Answer> answers2 = Arrays.asList(answerA2, answerB2, answerC2, answerD2);
    List<Answer> mutableAnswers2 = new ArrayList<>(answers2);

    // 3 pitanje
    Answer answerA3 = new Answer("Si", false);
    Answer answerB3 = new Answer("Go", false);
    Answer answerC3 = new Answer("Au", true);
    Answer answerD3 = new Answer("Ag", false);
    List<Answer> answers3 = Arrays.asList(answerA3, answerB3, answerC3, answerD3);
    List<Answer> mutableAnswers3 = new ArrayList<>(answers3);

    // 4 pitanje
    Answer answerA4 = new Answer("Venus", false);
    Answer answerB4 = new Answer("Saturn", false);
    Answer answerC4 = new Answer("Jupiter", false);
    Answer answerD4 = new Answer("Mars", true);
    List<Answer> answers4 = Arrays.asList(answerA4, answerB4, answerC4, answerD4);
    List<Answer> mutableAnswers4 = new ArrayList<>(answers4);

    // 5 pitanje
    Answer answerA5 = new Answer("Blue whale", true);
    Answer answerB5 = new Answer("African Elephant", false);
    Answer answerC5 = new Answer("Polar Bear", false);
    Answer answerD5 = new Answer("Giraffe", false);
    List<Answer> answers5 = Arrays.asList(answerA5, answerB5, answerC5, answerD5);
    List<Answer> mutableAnswers5 = new ArrayList<>(answers5);

    // 6 pitanje
    Answer answerA6 = new Answer("1912", true);
    Answer answerB6 = new Answer("1905", false);
    Answer answerC6 = new Answer("1920", false);
    Answer answerD6 = new Answer("1931", false);
    List<Answer> answers6 = Arrays.asList(answerA6, answerB6, answerC6, answerD6);
    List<Answer> mutableAnswers6 = new ArrayList<>(answers6);

    // 7 pitanje
    Answer answerA7 = new Answer("Mount Kilimanjaro", false);
    Answer answerB7 = new Answer("Mount Everest", true);
    Answer answerC7 = new Answer("Mount McKinley", false);
    Answer answerD7 = new Answer("Mount Fuji", false);
    List<Answer> answers7 = Arrays.asList(answerA7, answerB7, answerC7, answerD7);
    List<Answer> mutableAnswers7 = new ArrayList<>(answers7);

    // 8 pitanje
    Answer answerA8 = new Answer("Isaac Newton", false);
    Answer answerB8 = new Answer("Albert Einstein", true);
    Answer answerC8 = new Answer("Galileo Galilei", false);
    Answer answerD8 = new Answer("Marie Curie", false);
    List<Answer> answers8 = Arrays.asList(answerA8, answerB8, answerC8, answerD8);
    List<Answer> mutableAnswers8 = new ArrayList<>(answers8);

    // 9 pitanje
    Answer answerA9 = new Answer("Venus", false);
    Answer answerB9 = new Answer("Mars", false);
    Answer answerC9 = new Answer("Jupiter", true);
    Answer answerD9 = new Answer("Saturn", false);
    List<Answer> answers9 = Arrays.asList(answerA9, answerB9, answerC9, answerD9);
    List<Answer> mutableAnswers9 = new ArrayList<>(answers9);

    // 10 pitanje
    Answer answerA10 = new Answer("Yen", true);
    Answer answerB10 = new Answer("Rupee", false);
    Answer answerC10 = new Answer("Euro", false);
    Answer answerD10 = new Answer("Baht", false);
    List<Answer> answers10 = Arrays.asList(answerA10, answerB10, answerC10, answerD10);
    List<Answer> mutableAnswers10 = new ArrayList<>(answers10);

    // 11 pitanje
    Answer answerA11 = new Answer("Vincent van Gogh", false);
    Answer answerB11 = new Answer("Leonardo da Vinci", true);
    Answer answerC11 = new Answer("Pablo Picasso", false);
    Answer answerD11 = new Answer("Michelangelo", false);
    List<Answer> answers11 = Arrays.asList(answerA11, answerB11, answerC11, answerD11);
    List<Answer> mutableAnswers11 = new ArrayList<>(answers11);

    // 12 pitanje
    Answer answerA12 = new Answer("Oxygen", false);
    Answer answerB12 = new Answer("Carbon Dioxide", true);
    Answer answerC12 = new Answer("Nitrogen", false);
    Answer answerD12 = new Answer("Hydrogen", false);
    List<Answer> answers12 = Arrays.asList(answerA12, answerB12, answerC12, answerD12);
    List<Answer> mutableAnswers12 = new ArrayList<>(answers12);

    // 13 pitanje
    Answer answerA13 = new Answer("Wt", false);
    Answer answerB13 = new Answer("O2", false);
    Answer answerC13 = new Answer("CO2", false);
    Answer answerD13 = new Answer("H2O", true);
    List<Answer> answers13 = Arrays.asList(answerA13, answerB13, answerC13, answerD13);
    List<Answer> mutableAnswers13 = new ArrayList<>(answers13);

    // 14 pitanje
    Answer answerA14 = new Answer("Charles Dickens", false);
    Answer answerB14 = new Answer("Jane Austen", false);
    Answer answerC14 = new Answer("George Orwell", false);
    Answer answerD14 = new Answer("William Shakespeare", true);
    List<Answer> answers14 = Arrays.asList(answerA14, answerB14, answerC14, answerD14);
    List<Answer> mutableAnswers14 = new ArrayList<>(answers14);

    // 15 pitanje
    Answer answerA15 = new Answer("1776", false);
    Answer answerB15 = new Answer("1607", false);
    Answer answerC15 = new Answer("1492", true);
    Answer answerD15 = new Answer("1498", false);
    List<Answer> answers15 = Arrays.asList(answerA15, answerB15, answerC15, answerD15);
    List<Answer> mutableAnswers15 = new ArrayList<>(answers15);

    // 16 pitanje
    Answer answerA16 = new Answer("Amelia Earhart", true);
    Answer answerB16 = new Answer("Marie Curie", false);
    Answer answerC16 = new Answer("Rosa Parks", false);
    Answer answerD16 = new Answer("Queen Elizabeth II", false);
    List<Answer> answers16 = Arrays.asList(answerA16, answerB16, answerC16, answerD16);
    List<Answer> mutableAnswers16 = new ArrayList<>(answers16);

    // 17 pitanje
    Answer answerA17 = new Answer("Venus", false);
    Answer answerB17 = new Answer("Mars", false);
    Answer answerC17 = new Answer("Jupiter", true);
    Answer answerD17 = new Answer("Saturn", false);
    List<Answer> answers17 = Arrays.asList(answerA17, answerB17, answerC17, answerD17);
    List<Answer> mutableAnswers17 = new ArrayList<>(answers17);

    // 18 pitanje
    Answer answerA18 = new Answer("George Orwell", true);
    Answer answerB18 = new Answer("F. Scott Fitzgerald", false);
    Answer answerC18 = new Answer("J.K. Rowling", false);
    Answer answerD18 = new Answer("Charles Dickens", false);
    List<Answer> answers18 = Arrays.asList(answerA18, answerB18, answerC18, answerD18);
    List<Answer> mutableAnswers18 = new ArrayList<>(answers18);

    // 19 pitanje
    Answer answerA19 = new Answer("China", false);
    Answer answerB19 = new Answer("South Korea", false);
    Answer answerC19 = new Answer("Japan", true);
    Answer answerD19 = new Answer("Thailand", false);
    List<Answer> answers19 = Arrays.asList(answerA19, answerB19, answerC19, answerD19);
    List<Answer> mutableAnswers19 = new ArrayList<>(answers19);

    // 20 pitanje
    Answer answerA20 = new Answer("Skin", true);
    Answer answerB20 = new Answer("Brain", false);
    Answer answerC20 = new Answer("Heart", false);
    Answer answerD20 = new Answer("Liver", false);
    List<Answer> answers20 = Arrays.asList(answerA20, answerB20, answerC20, answerD20);
    List<Answer> mutableAnswers20 = new ArrayList<>(answers20);

    // pokušaj optimizacije
    //Answers answers8 = new Answers("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Marie Curie" );
    //Answers answers9 = new Answers("Venus", "Mars", "Jupiter", "Saturn" );
    /*List<Answer> finalListOfAnwsers = new ArrayList<>();
    List<List<Answer>> mutableAnswersLists = Arrays.asList(
            mutableAnswers1,
            mutableAnswers2,
            mutableAnswers3,
            mutableAnswers4,
            mutableAnswers5,
            mutableAnswers6,
            mutableAnswers7
    );

    for (List<Answer> mutableAnswers : mutableAnswersLists) {
        finalListOfAnwsers.addAll(mutableAnswers);
    }*/


    // Create a question with the answers
    QuestionModel question1 = new QuestionModel("1", "(1) What is the capital of France?", mutableAnswers1);
    QuestionModel question2 = new QuestionModel("2", "(2) Who wrote the play Romeo and Juliet?", mutableAnswers2);
    QuestionModel question3 = new QuestionModel("3", "(3) What is the chemical symbol for gold?", mutableAnswers3);
    QuestionModel question4 = new QuestionModel("4", "(4) Which planet is known as the \"Red Planet\"", mutableAnswers4);
    QuestionModel question5 = new QuestionModel("5", "(5) What is the largest mammal on Earth?", mutableAnswers5);
    QuestionModel question6 = new QuestionModel("6", "(6) In which year did the Titanic sink?", mutableAnswers6);
    QuestionModel question7 = new QuestionModel("7", "(7) What is the tallest mountain in the world?", mutableAnswers7);
    QuestionModel question8 = new QuestionModel("8", "(8) Which famous scientist developed the theory of general relativity?", mutableAnswers8);
    QuestionModel question9 = new QuestionModel("9", "(9) What is the largest planet in our solar system?", mutableAnswers9);
    QuestionModel question10 = new QuestionModel("10", "(10) What is the currency used in Japan?", mutableAnswers10);
    QuestionModel question11 = new QuestionModel("11", "(11) Who painted the Mona Lisa?", mutableAnswers11);
    QuestionModel question12 = new QuestionModel("12", "(12) Which gas do plants absorb from the atmosphere during photosynthesis?", mutableAnswers12);
    QuestionModel question13 = new QuestionModel("13", "(13) What is the chemical symbol for water?", mutableAnswers13);
    QuestionModel question14 = new QuestionModel("14", "(14) Who wrote the play \"Hamlet\"?", mutableAnswers14);
    QuestionModel question15 = new QuestionModel("15", "(15) In which year did Christopher Columbus first reach the Americas?", mutableAnswers15);
    QuestionModel question16 = new QuestionModel("16", "(16) Who was the first woman to fly solo across the Atlantic Ocean?", mutableAnswers16);
    QuestionModel question17 = new QuestionModel("17", "(17) What is the largest planet in our solar system?", mutableAnswers17);
    QuestionModel question18 = new QuestionModel("18", "(18) Who wrote the novel \"1984\"?", mutableAnswers18);
    QuestionModel question19 = new QuestionModel("19", "(19) Which country is known as the Land of the Rising Sun?", mutableAnswers19);
    QuestionModel question20 = new QuestionModel("20", "(20) What is the largest organ in the human body?", mutableAnswers20);

    List<QuestionModel> questions = Arrays.asList(question1, question2, question3, question4, question5,
            question6, question7, question8, question9, question10,
            question11, question12, question13, question14, question15,
            question16, question17, question18, question19, question20 );
    List<QuestionModel> mutableQuestions = new ArrayList<>(questions);


    ////////////
    @FXML
    private  Button questionButton;
    @FXML
    private  Button getNextQuestionButton;
    @FXML
    private Button answerOneButton;
    @FXML
    private  Button answerTwoButton;
    @FXML
    private  Button answerThreeButton;
    @FXML
    private  Button answerFourButton;
    private static SerializableButtonModel serializableButtonModel;
    @FXML
    private ImageView audienceImageView;
     @FXML
    private ImageView phoneImageView;
     @FXML
    private ImageView fiftyFiftyImageView;
     @FXML
     private ImageView prizesTableImageView;
     @FXML
     private Label lblWhosTurn;
    @FXML
    private Label lastGameMoveLabel;
     @FXML
     private TextArea chatHistoryTextArea;
    @FXML
    private TextField chatMessageTextField;
    @FXML
    private AnchorPane panelDisable;

    private static int playerOnePoints = 0;
    private static int playerTwoPoints = 0;



    public static Boolean playerOneTurn = true;
    public static Boolean audienceCalled = false;
    public static Boolean phoneCalled = false;
    public static Boolean fiftyCalled = false;

    private AllPlayerMoves allPlayerMoves = new AllPlayerMoves();
    private RemoteService stub = null;

    public Client client = new Client(HelloApplication.HOST, HelloApplication.PORT, this);

    public void getAudienceHelpImageChanged(){
        audienceCalled = true;

        try {
            if (!audienceCalled){
                audienceImageView.setImage(new Image(String.valueOf("src/main/images/audience.PNG")));
            } else {
                //audienceImageView.setImage(new Image(String.valueOf("src/main/images/audienceCalled.PNG")));
                audienceImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\audienceCalled.PNG")));
                audienceImageView.setDisable(true);
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            // Handle the exception
            System.err.println("Error loading image: " + e.getMessage());
            // You can log the exception or perform other error handling tasks
        }
    }
    public void getCallHelpImageChanged(){
        phoneCalled = true;

        try {
            if (!phoneCalled){
                phoneImageView.setImage(new Image(String.valueOf("src/main/images/phone.PNG")));
            } else {
                phoneImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\phoneCalled.PNG")));
                phoneImageView.setDisable(true);
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }
    public void getHalfHalfHelpImageChanged(){
        fiftyCalled = true;

        try {
            if (!fiftyCalled){
                fiftyFiftyImageView.setImage(new Image(String.valueOf("src/main/images/fiftyFifty.PNG")));
            } else {
                fiftyFiftyImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\fiftyFiftyCalled.PNG")));
                fiftyFiftyImageView.setDisable(true);
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    //int numberOfQuestion = -1;
    NumberOfQuestionWrapper numberOfQuestion = new NumberOfQuestionWrapper(-1);

    private static GameScreenController instance;

    //@Override
    public void initialize()  {
        prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\resources\\images\\fullMoneyTree.PNG")));
        //kontroler prilikom init metode, starta server i salje sebe kao referencu
        instance = this;

        try {
            startGame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("localhost", 2010);
            stub = (RemoteService) registry.lookup(RemoteService.REMOTE_OBJECT_NAME);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }

        initializeMessageReceiver();
        setEnableControls();

        GetLastMoveThread getLastGameMoveThread = new GetLastMoveThread(lastGameMoveLabel);
        Thread starterThread = new Thread(getLastGameMoveThread);
        starterThread.start();
    }

    public static String getPlayerName() {
        return HelloController.getPlayerName();
    }

    public void sendMessage() throws RemoteException {
        String newMessage = chatMessageTextField.getText();
        stub.sendMessage(newMessage, getPlayerName());
        chatHistoryTextArea.setText(stub.receiveAllMessages());
    }


    public void getNextQuestion() throws IOException {
        System.out.println("Player ONE points: " + playerOnePoints);
        System.out.println("Player TWO points: " + playerTwoPoints);
        System.out.println("Broj pitanja: " + numberOfQuestion.getNumberOfQuestion());

        if(playerOneTurn){
            System.out.println(HelloController.getPlayerName() + "'s turn!" );
        } else{
            System.out.println(HelloController.getPlayerName() + "'s turn!");
        }

        updateMoneyScoreImage();
        updateWhosTurnLabel();

        answerOneButton.setStyle("");
        answerOneButton.setText("");
        answerTwoButton.setStyle("");
        answerThreeButton.setStyle("");
        answerFourButton.setStyle("");

        //svaki klik se inkrementa
        //number of question je index
        //numberOfQuestion = numberOfQuestion + 1;
        numberOfQuestion.incrementNumberOfQuestion();

        if (numberOfQuestion.getNumberOfQuestion() == 0){
            //lbwhosTurn.setText("Welcome players! ");
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\resources\\images\\fullMoneyTree.PNG")));
            questionButton.setText("Who wants to be a Milionaire");
            answerOneButton.setText("  ");
            answerTwoButton.setText("  ");
            answerThreeButton.setText("  ");
            answerFourButton.setText("  ");
        }
        else if (numberOfQuestion.getNumberOfQuestion() == 1) {
            //titleovi
            questionButton.setText(question1.getQuestionText());
            answerOneButton.setText(answerA.getAnswerText());
            answerTwoButton.setText(answerB.getAnswerText());
            answerThreeButton.setText(answerC.getAnswerText());
            answerFourButton.setText(answerD.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 2) {
            questionButton.setText(question2.getQuestionText());
            answerOneButton.setText(answerA2.getAnswerText());
            answerTwoButton.setText(answerB2.getAnswerText());
            answerThreeButton.setText(answerC2.getAnswerText());
            answerFourButton.setText(answerD2.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 3) {
            questionButton.setText(question3.getQuestionText());
            answerOneButton.setText(answerA3.getAnswerText());
            answerTwoButton.setText(answerB3.getAnswerText());
            answerThreeButton.setText(answerC3.getAnswerText());
            answerFourButton.setText(answerD3.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 4) {
            questionButton.setText(question4.getQuestionText());
            answerOneButton.setText(answerA4.getAnswerText());
            answerTwoButton.setText(answerB4.getAnswerText());
            answerThreeButton.setText(answerC4.getAnswerText());
            answerFourButton.setText(answerD4.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 5) {
            questionButton.setText(question5.getQuestionText());
            answerOneButton.setText(answerA5.getAnswerText());
            answerTwoButton.setText(answerB5.getAnswerText());
            answerThreeButton.setText(answerC5.getAnswerText());
            answerFourButton.setText(answerD5.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 6) {
            questionButton.setText(question6.getQuestionText());
            answerOneButton.setText(answerA6.getAnswerText());
            answerTwoButton.setText(answerB6.getAnswerText());
            answerThreeButton.setText(answerC6.getAnswerText());
            answerFourButton.setText(answerD6.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 7) {
            questionButton.setText(question7.getQuestionText());
            answerOneButton.setText(answerA7.getAnswerText());
            answerTwoButton.setText(answerB7.getAnswerText());
            answerThreeButton.setText(answerC7.getAnswerText());
            answerFourButton.setText(answerD7.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 8) {
            questionButton.setText(question8.getQuestionText());
            answerOneButton.setText(answerA8.getAnswerText());
            answerTwoButton.setText(answerB8.getAnswerText());
            answerThreeButton.setText(answerC8.getAnswerText());
            answerFourButton.setText(answerD8.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 9) {
            questionButton.setText(question9.getQuestionText());
            answerOneButton.setText(answerA9.getAnswerText());
            answerTwoButton.setText(answerB9.getAnswerText());
            answerThreeButton.setText(answerC9.getAnswerText());
            answerFourButton.setText(answerD9.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 10) {
            questionButton.setText(question10.getQuestionText());
            answerOneButton.setText(answerA10.getAnswerText());
            answerTwoButton.setText(answerB10.getAnswerText());
            answerThreeButton.setText(answerC10.getAnswerText());
            answerFourButton.setText(answerD10.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 11) {
            questionButton.setText(question11.getQuestionText());
            answerOneButton.setText(answerA11.getAnswerText());
            answerTwoButton.setText(answerB11.getAnswerText());
            answerThreeButton.setText(answerC11.getAnswerText());
            answerFourButton.setText(answerD11.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 12) {
            questionButton.setText(question12.getQuestionText());
            answerOneButton.setText(answerA12.getAnswerText());
            answerTwoButton.setText(answerB12.getAnswerText());
            answerThreeButton.setText(answerC12.getAnswerText());
            answerFourButton.setText(answerD12.getAnswerText());
        }else if (numberOfQuestion.getNumberOfQuestion() == 13) {
            questionButton.setText(question13.getQuestionText());
            answerOneButton.setText(answerA13.getAnswerText());
            answerTwoButton.setText(answerB13.getAnswerText());
            answerThreeButton.setText(answerC13.getAnswerText());
            answerFourButton.setText(answerD13.getAnswerText());
        }else if (numberOfQuestion.getNumberOfQuestion() == 14) {
            questionButton.setText(question14.getQuestionText());
            answerOneButton.setText(answerA14.getAnswerText());
            answerTwoButton.setText(answerB14.getAnswerText());
            answerThreeButton.setText(answerC14.getAnswerText());
            answerFourButton.setText(answerD14.getAnswerText());
        }else if (numberOfQuestion.getNumberOfQuestion() == 15) {
            questionButton.setText(question15.getQuestionText());
            answerOneButton.setText(answerA15.getAnswerText());
            answerTwoButton.setText(answerB15.getAnswerText());
            answerThreeButton.setText(answerC15.getAnswerText());
            answerFourButton.setText(answerD15.getAnswerText());
        }else if (numberOfQuestion.getNumberOfQuestion() == 16) {
            questionButton.setText(question16.getQuestionText());
            answerOneButton.setText(answerA16.getAnswerText());
            answerTwoButton.setText(answerB16.getAnswerText());
            answerThreeButton.setText(answerC16.getAnswerText());
            answerFourButton.setText(answerD16.getAnswerText());
        }else if (numberOfQuestion.getNumberOfQuestion() == 17) {
            questionButton.setText(question17.getQuestionText());
            answerOneButton.setText(answerA17.getAnswerText());
            answerTwoButton.setText(answerB17.getAnswerText());
            answerThreeButton.setText(answerC17.getAnswerText());
            answerFourButton.setText(answerD17.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 18) {
            questionButton.setText(question18.getQuestionText());
            answerOneButton.setText(answerA18.getAnswerText());
            answerTwoButton.setText(answerB18.getAnswerText());
            answerThreeButton.setText(answerC18.getAnswerText());
            answerFourButton.setText(answerD18.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 19) {
            questionButton.setText(question19.getQuestionText());
            answerOneButton.setText(answerA19.getAnswerText());
            answerTwoButton.setText(answerB19.getAnswerText());
            answerThreeButton.setText(answerC19.getAnswerText());
            answerFourButton.setText(answerD19.getAnswerText());
        } else if (numberOfQuestion.getNumberOfQuestion() == 20) {
            questionButton.setText(question20.getQuestionText());
            answerOneButton.setText(answerA20.getAnswerText());
            answerTwoButton.setText(answerB20.getAnswerText());
            answerThreeButton.setText(answerC20.getAnswerText());
            answerFourButton.setText(answerD20.getAnswerText());
        }
    }

    public static String findQuestionId(List<QuestionModel> questions, String searchText) {
        return questions.stream().filter(question -> question.getQuestionText().equalsIgnoreCase(searchText)).map(QuestionModel::getId).findFirst().orElse(null);
    }

    private char givenAnwser = '0';

    AllPlayerMoves allMoves = new AllPlayerMoves();

    //public OnePlayerMove onePlayerMove;
    public void handleAnswer(boolean isCorrect) throws IOException {
        String currentQuestion = questionButton.getText();
        //numberOfQuestion.setNumberOfQuestion(Integer.parseInt(findQuestionId(questions, currentQuestion)));

        System.out.println("Given anwser: " + givenAnwser);
        OnePlayerMove playerMove = new OnePlayerMove(numberOfQuestion.getNumberOfQuestion(), givenAnwser);

        allMoves.addPlayerMove(playerMove);
        System.out.println(allMoves.toString());

        System.out.println("Last player move: " + playerMove.toString());

        setMainStage(mainStage);

        if (HelloApplication.isPlayerOne && isCorrect){
            playerOneTurn = true;
            playerOnePoints++;
            //prvi igrac + 1
            getNextQuestion();
        } else if(HelloApplication.isPlayerOne && !isCorrect){
            playerOneTurn = false;
            //playerTwoPoints = numberOfQuestion.getNumberOfQuestion() - 1;
            playerTwoPoints = playerOnePoints;
        } else if(!HelloApplication.isPlayerOne && isCorrect){
            playerOneTurn = false;
            playerTwoPoints ++;
            // drugi igrac +1
            getNextQuestion();
        } else if(!HelloApplication.isPlayerOne && !isCorrect){
            playerOneTurn = true;
            //playerOnePoints = numberOfQuestion.getNumberOfQuestion() - 1;
            playerOnePoints = playerOnePoints;
            //playerOnePoints++;
        }

        //gui update na temelju podataka primljenih od servera

        //System.out.println("Broj pitanja prije sendState-a: " + numberOfQuestion);
        sendState();
        //getNextQuestion();

        //OnePlayerMove onePlayerMove = new OnePlayerMove()

        SaveNewGameMoveThread saveNewGameMoveThread = new SaveNewGameMoveThread(playerMove);
        Thread starterThread = new Thread(saveNewGameMoveThread);
        starterThread.start();

        if (highestPoint == 15){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("movesRecapScreen.fxml"));
            Parent root = fxmlLoader.load();
            ResultsScreenController resultsController = fxmlLoader.getController();
            resultsController.setAllPlayerMoves(allMoves);

            Scene scene = new Scene(root, 600, 700);
            HelloApplication.getMainStage().setTitle("Hello!");
            HelloApplication.getMainStage().setScene(scene);
            HelloApplication.getMainStage().show();
            System.out.println("Sending results to new screen..");

        }

    }

    // metode na gumbima
    public void clickedOnAnswerA() throws IOException {
        givenAnwser = 'A';
            handleAnswer(numberOfQuestion.getNumberOfQuestion() == 5 || numberOfQuestion.getNumberOfQuestion() == 6 ||
                    numberOfQuestion.getNumberOfQuestion() == 10 || numberOfQuestion.getNumberOfQuestion() == 16 || numberOfQuestion.getNumberOfQuestion() == 18
            || numberOfQuestion.getNumberOfQuestion() == 20);

        /*
        if (numberOfQuestion == 5 || numberOfQuestion == 6 || numberOfQuestion == 10) {
            // Check if the answer is correct for question 5
            boolean isCorrect = true; // Change this based on your logic
            handleAnswer(isCorrect);
        } else {
            // If it's not the final question, switch turns
            playerOneTurn = !playerOneTurn;
            getNextQuestion();
        }*/
    }
    public void clickedOnAnswerB() throws IOException {
        givenAnwser = 'B';
        handleAnswer(numberOfQuestion.getNumberOfQuestion() == 1 || numberOfQuestion.getNumberOfQuestion() == 2 ||
                numberOfQuestion.getNumberOfQuestion() == 7 || numberOfQuestion.getNumberOfQuestion() == 8 || numberOfQuestion.getNumberOfQuestion() == 11
                || numberOfQuestion.getNumberOfQuestion() == 12 );
    }
    public void clickedOnAnswerC() throws IOException {
        givenAnwser = 'C';
        handleAnswer(numberOfQuestion.getNumberOfQuestion() == 3 || numberOfQuestion.getNumberOfQuestion() == 9
        || numberOfQuestion.getNumberOfQuestion() == 15 || numberOfQuestion.getNumberOfQuestion() == 17 || numberOfQuestion.getNumberOfQuestion() == 19);
    }
    public void clickedOnAnswerD() throws IOException {
        givenAnwser = 'D';
        handleAnswer(numberOfQuestion.getNumberOfQuestion() == 4 || numberOfQuestion.getNumberOfQuestion() == 13 ||
                numberOfQuestion.getNumberOfQuestion() == 14);
    }

    public int highestPoint;
    public String winner = "definirani pobjednik";

    public void updateMoneyScoreImage() throws IOException {

        if (playerOnePoints > playerTwoPoints){
            highestPoint = playerOnePoints;
        } else {
            highestPoint = playerTwoPoints;
        }

        //highestPoint = playerOnePoints + playerTwoPoints;
        if (highestPoint == 1) {
            //prizesTableImageView.setImage(new Image(String.valueOf("src/main/images/MoneyTree-1.PNG")));
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-1.png")));
        } else if (highestPoint == 2) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-2.png")));
        } else if (highestPoint == 3) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-3.png")));
        } else if (highestPoint == 4) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-4.png")));
        } else if (highestPoint == 5) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-5.png")));
        } else if (highestPoint == 6) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-6.png")));
        } else if (highestPoint == 7) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-7.png")));
        } else if (highestPoint == 8) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-8.png")));
        } else if (highestPoint == 9) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-9.png")));
        } else if (highestPoint == 10) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-10.png")));
        } else if (highestPoint == 11) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-11.png")));
        } else if (highestPoint == 12) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-12.png")));
        } else if (highestPoint == 13) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-13.png")));
        } else if (highestPoint == 14) {
            prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\MoneyTree-14.png")));
        } else if (highestPoint == 15) {
            if (HelloApplication.isPlayerOne){
                lblWhosTurn.setText("Parabens! YOU WON");
            } else {
                lblWhosTurn.setText("YOU LOST!");
            }
        }
    }

    public void updateWhosTurnLabel(){
        if(playerOneTurn){
            lblWhosTurn.setText("Player one turn!");
        } else {
            lblWhosTurn.setText("Player two turn!");
        }
       // if (numberOfQuestion.getNumberOfQuestion() == 20){
        if (playerOnePoints  == 15 || playerTwoPoints == 15){
            if (HelloApplication.isPlayerOne && playerOneTurn){
                lblWhosTurn.setText("Parabens! YOU WON!!");
            } else if (!HelloApplication.isPlayerOne && playerOneTurn){
                lblWhosTurn.setText("You LOOST!");
            } else if (HelloApplication.isPlayerOne && !playerOneTurn){
                lblWhosTurn.setText("You LOOST!");
            } else if (!HelloApplication.isPlayerOne && !playerOneTurn){
                lblWhosTurn.setText("Parabens! YOU WON!!");
            }
        }

    }

    private static boolean usedAudience;
    private static boolean usedCall;
    private static boolean used5050;
    private boolean isDisabled = false;

    public void getAskingAudience() {
        getAudienceHelpImageChanged();
        // klik na getAskingAudience
        usedAudience = true;

        if (usedAudience && (numberOfQuestion.getNumberOfQuestion() == 1 || numberOfQuestion.getNumberOfQuestion() == 2 || numberOfQuestion.getNumberOfQuestion() == 7 || numberOfQuestion.getNumberOfQuestion() == 8 || numberOfQuestion.getNumberOfQuestion() == 12 || numberOfQuestion.getNumberOfQuestion() == 13)) {
            answerTwoButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else if(usedAudience && (numberOfQuestion.getNumberOfQuestion() == 3 || numberOfQuestion.getNumberOfQuestion() == 4 || numberOfQuestion.getNumberOfQuestion() == 9 || numberOfQuestion.getNumberOfQuestion() == 11 || numberOfQuestion.getNumberOfQuestion() == 14 || numberOfQuestion.getNumberOfQuestion() == 15 || numberOfQuestion.getNumberOfQuestion() == 17 || numberOfQuestion.getNumberOfQuestion() == 19)){
            answerThreeButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else if(usedAudience && (numberOfQuestion.getNumberOfQuestion() == 5 || numberOfQuestion.getNumberOfQuestion() == 6 || numberOfQuestion.getNumberOfQuestion() == 10 || numberOfQuestion.getNumberOfQuestion() == 16 || numberOfQuestion.getNumberOfQuestion() == 18 || numberOfQuestion.getNumberOfQuestion() == 20)){
            answerOneButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else {
            return;
        }

    }
    public void getCallHelp() {

        getCallHelpImageChanged();
        usedCall = true;

        if (usedCall && (numberOfQuestion.getNumberOfQuestion() == 1 || numberOfQuestion.getNumberOfQuestion() == 2 || numberOfQuestion.getNumberOfQuestion() == 7 || numberOfQuestion.getNumberOfQuestion() == 8 || numberOfQuestion.getNumberOfQuestion() == 12 || numberOfQuestion.getNumberOfQuestion() == 13)) {
            answerTwoButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else if(usedCall && (numberOfQuestion.getNumberOfQuestion() == 3 || numberOfQuestion.getNumberOfQuestion() == 4 || numberOfQuestion.getNumberOfQuestion() == 9 || numberOfQuestion.getNumberOfQuestion() == 11 || numberOfQuestion.getNumberOfQuestion() == 14 || numberOfQuestion.getNumberOfQuestion() == 15 || numberOfQuestion.getNumberOfQuestion() == 17 || numberOfQuestion.getNumberOfQuestion() == 19)){
            answerThreeButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else if(usedCall && (numberOfQuestion.getNumberOfQuestion() == 5 || numberOfQuestion.getNumberOfQuestion() == 6 || numberOfQuestion.getNumberOfQuestion() == 10 || numberOfQuestion.getNumberOfQuestion() == 16 || numberOfQuestion.getNumberOfQuestion() == 18 || numberOfQuestion.getNumberOfQuestion() == 20)){
            answerOneButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else {
            return;
        }

    }
    public void getHalfAndHalf(){
        getHalfHalfHelpImageChanged();

        used5050 = true;

        if (used5050 && (numberOfQuestion.getNumberOfQuestion() == 1 || numberOfQuestion.getNumberOfQuestion() == 2 || numberOfQuestion.getNumberOfQuestion() == 7 || numberOfQuestion.getNumberOfQuestion() == 8 || numberOfQuestion.getNumberOfQuestion() == 12 || numberOfQuestion.getNumberOfQuestion() == 13)) {
            answerTwoButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
            answerFourButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else if(used5050 && (numberOfQuestion.getNumberOfQuestion() == 5 || numberOfQuestion.getNumberOfQuestion() == 6 || numberOfQuestion.getNumberOfQuestion() == 10 || numberOfQuestion.getNumberOfQuestion() == 16 || numberOfQuestion.getNumberOfQuestion() == 18 || numberOfQuestion.getNumberOfQuestion() == 20)){
            answerOneButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
            answerTwoButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else if(used5050 && (numberOfQuestion.getNumberOfQuestion() == 3 || numberOfQuestion.getNumberOfQuestion() == 4 || numberOfQuestion.getNumberOfQuestion() == 9 || numberOfQuestion.getNumberOfQuestion() == 11 || numberOfQuestion.getNumberOfQuestion() == 14 || numberOfQuestion.getNumberOfQuestion() == 15 || numberOfQuestion.getNumberOfQuestion() == 17 || numberOfQuestion.getNumberOfQuestion() == 19)){
            answerOneButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
            answerThreeButton.setStyle("-fx-background-color: #FFFD5C; -fx-border-color: black;");
        }
        else {
            return;
        }
    }

    public static Boolean isGameSaved = false;
    public void startGame() throws IOException, ClassNotFoundException {
        numberOfQuestion.setNumberOfQuestion(0);
        playerOnePoints = 0;
        playerTwoPoints = 0;
        audienceCalled = false;
        audienceImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\audience.PNG")));
        phoneCalled = false;
        phoneImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\phone.PNG")));
        fiftyCalled = false;
        fiftyFiftyImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\fiftyFifty.PNG")));
        prizesTableImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\resources\\images\\fullMoneyTree.PNG")));
        updateMoneyScoreImage();
        getNextQuestion();
    }

    //saveState
    public static ObjectOutputStream serializer;
    public void saveGame() throws IOException {
        isGameSaved = true;

        String questionText = questionButton.getText();
        String anwserOneText = answerOneButton.getText();
        String anwserTwoText = answerTwoButton.getText();
        String anwserThreeText = answerThreeButton.getText();
        String anwserFourText = answerFourButton.getText();

        serializableButtonModel = new SerializableButtonModel(questionText, anwserOneText, anwserTwoText, anwserThreeText, anwserFourText, Integer.toString(playerOnePoints),
                Integer.toString(playerTwoPoints), Boolean.toString(playerOneTurn), Boolean.toString(usedCall), Boolean.toString(usedAudience), Boolean.toString(used5050), Boolean.toString(isDisabled), Integer.toString(numberOfQuestion.getNumberOfQuestion()));
        serializer = new ObjectOutputStream(new FileOutputStream("savedGame.ser"));

        try {
            serializer.writeObject(serializableButtonModel);
            System.out.println("Game is saved.");
        } catch (Throwable var5) {
            try {
                serializer.close();
            } catch (Throwable var4) {
                var5.addSuppressed(var4);
            }
            throw var5;
        }
        serializer.close();
    }

    private static final String CLASS_EXTENSION = ".class";

    public void generateDocumentation() {

        //Generating in this folder
        File documentationFile = new File("documentation.html");

        try {
            FileWriter writer = new FileWriter(documentationFile);

            writer.write("<!DOCTYPE html>");
            writer.write("<html>");
            writer.write("<head>");
            writer.write("<title>Project documentation for Hangman</title>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<h1>Project documentation</h1>");
            writer.write("<p><u><b>Class list:</b></u></p>");

            //fitler the data and print them
            List<Path> paths = Files.walk(Paths.get("."))
                    .filter(path -> path.getFileName().toString().endsWith(CLASS_EXTENSION))
                    .collect(Collectors.toList());

            //split with /
            for (Path path : paths) {
                String[] tokens = path.toString().split(Pattern.quote(System.getProperty("file.separator")));

                Boolean startBuildingPath = false;

                StringBuilder sb = new StringBuilder();

                for (String token : tokens) {
                    if ("classes".equals(token)) {
                        startBuildingPath = true;
                        continue;
                    }

                    if (startBuildingPath) {

                        if (token.endsWith(CLASS_EXTENSION)) {
                            sb.append(token, 0, token.indexOf("."));
                        } else {
                            sb.append(token);
                            sb.append(".");
                        }
                    } else {
                        continue;
                    }
                }

                if ("module-info".equals(sb.toString())) {
                    continue;
                }

                System.out.println("Fully qualified name: " + sb);

                try {
                    Class<?> clazz = Class.forName(sb.toString());

                    writer.write("<h2>" + Modifier.toString(clazz.getModifiers()) + " " + clazz.getName() + "</h2>");

                    StringBuilder classFieldString = new StringBuilder();

                    //anotations & class fields
                    for (Field classField : clazz.getDeclaredFields()) {
                        Annotation[] annotations = classField.getAnnotations();
                        for (Annotation a : annotations) {
                            classFieldString.append(a.toString());
                            classFieldString.append("<br />");
                        }
                        classFieldString.append(Modifier.toString(classField.getModifiers()));
                        classFieldString.append(" ");
                        classFieldString.append(classField.getType().getSimpleName());
                        classFieldString.append(" ");
                        classFieldString.append(classField.getName());
                        classFieldString.append(" ");
                        classFieldString.append("<br /><br />");
                    }

                    writer.write("<h3><u>Fields</u></h3>");

                    writer.write("<h4>" + classFieldString + "</h4>");

                    //constructors

                    Constructor[] constructors = clazz.getConstructors();

                    writer.write("<h3><u>Constructors:</u></h3>");

                    for (Constructor c : constructors) {
                        String constructorParams = generateDocumentation(c);
                        writer.write("<h4>Constructor:" + Modifier.toString(c.getModifiers()) + " " + c.getName()
                                + "(" + constructorParams + ")" + "</h4>");
                    }


                    //methods
                    Method[] methods = clazz.getMethods();
                    writer.write("<h3><u>Methods:</u></h3>");
                    for (Method m : methods) {
                        String methodsParams = generateDocumentation(m);
                        StringBuilder exceptionsBuilder = new StringBuilder();

                        //exceptions
                        for (int i = 0; i < m.getExceptionTypes().length; i++) {
                            if (exceptionsBuilder.isEmpty()) {
                                exceptionsBuilder.append(" throws ");
                            }

                            Class exceptionClass = m.getExceptionTypes()[i];
                            exceptionsBuilder.append(exceptionClass.getSimpleName());

                            if (i < m.getExceptionTypes().length - 1) {
                                exceptionsBuilder.append(", ");
                            }
                        }

                        writer.write("<h4>Method:" + Modifier.toString(m.getModifiers())
                                + " " + m.getReturnType().getSimpleName()
                                + " " + m.getName() + "(" + methodsParams + ")"
                                + " " + exceptionsBuilder
                                + "</h4>");
                    }

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            writer.write("</body>");
            writer.write("</html>");
            writer.close();

        } catch (IOException e) {
            //errors
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while generating documentation!");
            alert.setHeaderText("Can't find the files");
            alert.setContentText("The class files cannot be accessed.");

            alert.showAndWait();
        }
    }

    //method that can only accept methods and constructors => for Parameters
    private <T extends Executable> String generateDocumentation(T executable) {
        Parameter[] params = executable.getParameters();

        StringBuilder methodsParams = new StringBuilder();

        for (int i = 0; i < params.length; i++) {
            String modifierString = Modifier.toString(params[i].getModifiers());

            if (!modifierString.isEmpty()) {
                methodsParams.append(modifierString);
                methodsParams.append(" ");
            }
            methodsParams.append(params[i].getType().getSimpleName());
            methodsParams.append(" ");
            methodsParams.append(params[i].getName());

            if (i < (params.length - 1)) {
                methodsParams.append(", ");
            }
        }

        return methodsParams.toString();
    }


    private static Stage mainStage;
    public static void setMainStage(Stage mainStage) {
        mainStage = mainStage;
    }
    public ObjectInputStream deserializer;
    public void loadGame() throws IOException, ClassNotFoundException {
        deserializer = new ObjectInputStream(new FileInputStream("savedGame.ser"));

        try {
            serializableButtonModel = (SerializableButtonModel) deserializer.readObject();
            questionButton.setText(serializableButtonModel.getQuestion().toString());
            answerOneButton.setText(serializableButtonModel.getAnwserA().toString());
            answerTwoButton.setText(serializableButtonModel.getAnwserB().toString());
            answerThreeButton.setText(serializableButtonModel.getAnwserC().toString());
            answerFourButton.setText(serializableButtonModel.getAnwserD().toString());
            playerOnePoints = serializableButtonModel.getPointsOne();
            playerTwoPoints = serializableButtonModel.getPointsTwo();
            playerOneTurn = serializableButtonModel.isPlayerTurn();
            usedAudience = serializableButtonModel.isAudienceUsed();
            usedCall = serializableButtonModel.isCallUsed();
            used5050 = serializableButtonModel.isFiftyUsed();
            numberOfQuestion.setNumberOfQuestion(serializableButtonModel.getNumberOfQuestions());
        } catch (Throwable var5) {
            try {
                deserializer.close();
            } catch (Throwable var4) {
                var5.addSuppressed(var4);
            }
            throw var5;
        }

        if (usedAudience){ audienceImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\audienceCalled.PNG")));}
        if (usedCall){ phoneImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\phoneCalled.PNG")));}
        if (used5050){ fiftyFiftyImageView.setImage(new Image(String.valueOf("C:\\Users\\Karla\\IdeaProjects\\Milionare\\src\\main\\images\\fiftyFiftyCalled.PNG")));}

        System.out.println("Ucitano pitanje: " + questionButton.getText() + ", " + answerOneButton.getText());
        System.out.println("Ucitani bodovi: " + playerOnePoints + ", " + playerTwoPoints);
        System.out.println("BROJ PITANJA: " + numberOfQuestion);

        deserializer.close();
    }

    //ovo se nigdje ne senda -> trebalo bi se poslati sa svakim klikom
    //public void sendState(Integer numberOfQuestion) {
    public void sendState() {
        System.out.println("Sending state");

        String currentQuestion = questionButton.getText();
        //numberOfQuestion.setNumberOfQuestion(Integer.parseInt(findQuestionId(questions, currentQuestion)));

        Integer numOfQ = numberOfQuestion.getNumberOfQuestion();
        String questionText = questionButton.getText();
        String anwserOneText = answerOneButton.getText();
        String anwserTwoText = answerTwoButton.getText();
        String anwserThreeText = answerThreeButton.getText();
        String anwserFourText = answerFourButton.getText();

        if(HelloApplication.isPlayerOne){
            playerTwoPoints = playerOnePoints;
        } else {
            playerOnePoints = playerTwoPoints;
        }


        serializableButtonModel = new SerializableButtonModel(questionText, anwserOneText, anwserTwoText, anwserThreeText, anwserFourText, Integer.toString(playerOnePoints),
                Integer.toString(playerTwoPoints), Boolean.toString(playerOneTurn), Boolean.toString(usedCall), Boolean.toString(usedAudience), Boolean.toString(used5050), Boolean.toString(isDisabled), numOfQ.toString());

        client.sendMessage(serializableButtonModel);

        setEnableControls();
    }


    @Override
    public void onMessageReceived(SerializableButtonModel serializableButtonModel) {
        Platform.runLater(() -> {
            // logika za updateanje GUIa tu
            this.serializableButtonModel = serializableButtonModel;

            questionButton.setText(serializableButtonModel.getQuestion().toString());
            answerOneButton.setText(serializableButtonModel.getAnwserA().toString());
            answerTwoButton.setText(serializableButtonModel.getAnwserB().toString());
            answerThreeButton.setText(serializableButtonModel.getAnwserC().toString());
            answerFourButton.setText(serializableButtonModel.getAnwserD().toString());
            playerOnePoints = serializableButtonModel.getPointsOne();
            playerTwoPoints = serializableButtonModel.getPointsTwo();
            playerOneTurn = serializableButtonModel.isPlayerTurn();
            usedAudience = serializableButtonModel.isAudienceUsed();
            usedCall = serializableButtonModel.isCallUsed();
            used5050 = serializableButtonModel.isFiftyUsed();

            numberOfQuestion.setNumberOfQuestion(serializableButtonModel.getNumberOfQuestions());

            setEnableControls();
        });
    }

    private void setEnableControls(){
        // Set buttons disable kills logic if button is used or not used already
        if (HelloApplication.isPlayerOne && playerOneTurn){
            //panelDisable.setDisable(false);
            answerOneButton.setDisable(false);
            answerTwoButton.setDisable(false);
            answerThreeButton.setDisable(false);
            answerFourButton.setDisable(false);
            phoneImageView.setDisable(false);
            audienceImageView.setDisable(false);
            fiftyFiftyImageView.setDisable(false);
            prizesTableImageView.setDisable(false);
            getNextQuestionButton.setDisable(false);
        } else if(HelloApplication.isPlayerOne && !playerOneTurn){
            //panelDisable.setDisable(true);
            answerOneButton.setDisable(true);
            answerTwoButton.setDisable(true);
            answerThreeButton.setDisable(true);
            answerFourButton.setDisable(true);
            phoneImageView.setDisable(true);
            audienceImageView.setDisable(true);
            fiftyFiftyImageView.setDisable(true);
            prizesTableImageView.setDisable(true);
            getNextQuestionButton.setDisable(true);
        } else if(!HelloApplication.isPlayerOne && playerOneTurn){
            //panelDisable.setDisable(true);
            answerOneButton.setDisable(true);
            answerTwoButton.setDisable(true);
            answerThreeButton.setDisable(true);
            answerFourButton.setDisable(true);
            phoneImageView.setDisable(true);
            audienceImageView.setDisable(true);
            fiftyFiftyImageView.setDisable(true);
            prizesTableImageView.setDisable(true);
            getNextQuestionButton.setDisable(true);
        } else if(!HelloApplication.isPlayerOne && !playerOneTurn){
            //panelDisable.setDisable(false);
            answerOneButton.setDisable(false);
            answerTwoButton.setDisable(false);
            answerThreeButton.setDisable(false);
            answerFourButton.setDisable(false);
            phoneImageView.setDisable(false);
            audienceImageView.setDisable(false);
            fiftyFiftyImageView.setDisable(false);
            prizesTableImageView.setDisable(false);
            getNextQuestionButton.setDisable(false);
        }
    }

    // boolean kad je na ovom screenu
    // kad je false onda ugasi metodu
    // atomic boolean? - automatski sinc boolean NE SINC OBICAN BOOLEAN

    private void initializeMessageReceiver() {
        Task messageReceiver = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                //while (!Java2Application.getClientServerCommunicationComplete()) {
                while (playerOneTurn) {
                    String chatHistory = stub.receiveAllMessages();
                    //gdje se sprema chat to je gameMainModel
                    Platform.runLater(() -> chatHistoryTextArea.setText(chatHistory));
                    Thread.sleep(1000);
                }
                return null;
            }
        };
        Thread messageReceiverThread = new Thread(messageReceiver);
        messageReceiverThread.setDaemon(true);
        messageReceiverThread.start();
    }

}
