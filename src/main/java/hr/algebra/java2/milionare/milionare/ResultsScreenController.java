package hr.algebra.java2.milionare.milionare;

import hr.algebra.java2.milionare.model.AllPlayerMoves;
import hr.algebra.java2.milionare.model.OnePlayerMove;
import hr.algebra.java2.milionare.xml.XMLWrite;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class ResultsScreenController implements Initializable {

    private AllPlayerMoves allMoves;
    private Stage stage;
    @FXML
    public Label endMessage;

    @FXML
    private Button readXml;
    @FXML
    private Button writeXml;
    @FXML
    private Button endGame;
    @FXML
    private AnchorPane ResultsPane;
    @FXML
    private TextArea xmlTextArea;

    public void setAllPlayerMoves(AllPlayerMoves allMoves) {
        this.allMoves = allMoves;
    }

    public ResultsScreenController() {
        //this.resultsGameModel = resultsGameModel;
        //this.allMoves = new AllPlayerMoves();
        AllPlayerMoves allMoves = new AllPlayerMoves();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Displaying results..");
        xmlTextArea.setText("Initial text for xmlTextArea");

        displayResults();
    }

    public void displayResults() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    endMessage.setText("Congratulations to the winner!");
                });
            }
        }, 5000); // 5000 milliseconds = 5 seconds

    }

    @FXML
    private void writeToXml() {
        String fileName = "PlayerMoves.xml";

        XMLWrite.writeXML(allMoves.getPlayerMoves(), fileName);
        System.out.println("XML file written successfully: " + fileName);
    }


    @FXML
    private void readFromXml() {
        String fileName = "PlayerMoves.xml";

        try {
            System.out.println("XML file read successfully: " + fileName);
            String xmlContent = convertPlayerMovesToXml(allMoves.getPlayerMoves());

            // Set the XML content to the TextArea
            xmlTextArea.setText(xmlContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertPlayerMovesToXml(List<OnePlayerMove> playerMoves) {
        StringBuilder xmlContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<playerMoves>");

        for (OnePlayerMove playerMove : playerMoves) {
            xmlContent.append("\n  <playerMove>");
            xmlContent.append("\n    <question>").append(playerMove.getQuestion()).append("</question>");
            xmlContent.append("\n    <givenAnwserLetter>").append(playerMove.isGivenAnwserCorrect()).append("</givenAnwserLetter>");
           // xmlContent.append("\n    <isAudienceUsed>").append(playerMove.isAudienceUsed()).append("</isAudienceUsed>");
            //xmlContent.append("\n    <isCallUsed>").append(playerMove.isCallUsed()).append("</isCallUsed>");
            //xmlContent.append("\n    <isFiftyUsed>").append(playerMove.isFiftyUsed()).append("</isFiftyUsed>");
            xmlContent.append("\n  </playerMove>");
        }

        xmlContent.append("\n</playerMoves>");
        return xmlContent.toString();
    }

    @FXML
    public void Exit() {
        if (ResultsPane != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exiting game");
            alert.setHeaderText("You are going to exit the game! Are you sure you want to exit?");

            // if a person clicks OK => exit, if they click CANCEL => stay
            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                stage = (Stage) ResultsPane.getScene().getWindow();
                System.out.println("You have exited the game!");
                stage.close();
            }
        }
    }
}
