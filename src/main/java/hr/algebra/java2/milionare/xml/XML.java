package hr.algebra.java2.milionare.xml;

import hr.algebra.java2.milionare.model.SerializableButtonModel;
import javafx.scene.control.Alert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class XML {
    public static void saveXML
            (StringBuilder question, StringBuilder anwserA, StringBuilder anwserB, StringBuilder anwserC,
             StringBuilder anwserD, Integer pointsOne, Integer pointsTwo, boolean playerTurn, boolean callUsed,
             boolean audienceUsed, boolean fiftyUsed){

        try {
            DocumentBuilderFactory documentBuilderFactory
                    = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder
                    = documentBuilderFactory.newDocumentBuilder();
            Document xmlDocument = documentBuilder.newDocument();

            //first => parent is milionare game
            Element rootElementGame = xmlDocument.createElement("Milionare_game");
            xmlDocument.appendChild(rootElementGame);

            //adding a new element => appending it and adding to root element
            // (with append we add hidden word in the middle)

            Element question_Element = xmlDocument.createElement("Question");
            Node question_TextNode = xmlDocument.createTextNode(question.toString());
            question_Element.appendChild(question_TextNode);
            rootElementGame.appendChild(question_Element);


            Element anwser_One_Element = xmlDocument.createElement("Anwser_One");
            Node anwser_One_TextNode = xmlDocument.createTextNode(anwserA.toString());
            anwser_One_Element.appendChild(anwser_One_TextNode);
            rootElementGame.appendChild(anwser_One_Element);

            Element anwser_Two_Element = xmlDocument.createElement("Anwser_Two");
            Node anwser_Two_TextNode = xmlDocument.createTextNode(anwserB.toString());
            anwser_Two_Element.appendChild(anwser_Two_TextNode);
            rootElementGame.appendChild(anwser_Two_Element);

            Element anwser_Three_Element = xmlDocument.createElement("Anwser_Three");
            Node anwser_Three_TextNode = xmlDocument.createTextNode(anwserC.toString());
            anwser_Three_Element.appendChild(anwser_Three_TextNode);
            rootElementGame.appendChild(anwser_Three_Element);

            Element anwser_Four_Element = xmlDocument.createElement("Anwser_Four");
            Node anwser_Four_TextNode = xmlDocument.createTextNode(anwserD.toString());
            anwser_Four_Element.appendChild(anwser_Four_TextNode);
            rootElementGame.appendChild(anwser_Four_Element);


            Element player_One_Points_Element = xmlDocument.createElement("Player_One_Points");
            Node player_One_Points_TextNode = xmlDocument.createTextNode(pointsOne.toString());
            player_One_Points_Element.appendChild(player_One_Points_TextNode);
            rootElementGame.appendChild(player_One_Points_Element);

            Element player_Two_Points_Element = xmlDocument.createElement("Player_Two_Points");
            Node player_Two_Points_TextNode = xmlDocument.createTextNode(pointsTwo.toString());
            player_Two_Points_Element.appendChild(player_Two_Points_TextNode);
            rootElementGame.appendChild(player_Two_Points_Element);


            Element player_One_Turn_Element = xmlDocument.createElement("Player_One_Turn");
            Node player_One_Turn_TextNode = xmlDocument.createTextNode(Boolean.toString(playerTurn));
            player_One_Turn_Element.appendChild(player_One_Turn_TextNode);
            rootElementGame.appendChild(player_One_Turn_Element);

            Element audience_Help_Used_Element = xmlDocument.createElement("Audience_Help_Used");
            Node audience_Help_Used_TextNode = xmlDocument.createTextNode(Boolean.toString(audienceUsed));
            audience_Help_Used_Element.appendChild(audience_Help_Used_TextNode);
            rootElementGame.appendChild(audience_Help_Used_Element);

            Element call_Help_Used_Element = xmlDocument.createElement("Call_Help_Used");
            Node call_Help_Used_TextNode = xmlDocument.createTextNode(Boolean.toString(callUsed));
            call_Help_Used_Element.appendChild(call_Help_Used_TextNode);
            rootElementGame.appendChild(call_Help_Used_Element);

            Element fiffty_Help_Used_Element = xmlDocument.createElement("Fiffty_Help_Used");
            Node fiffty_Help_Used_TextNode = xmlDocument.createTextNode(Boolean.toString(fiftyUsed));
            fiffty_Help_Used_Element.appendChild(fiffty_Help_Used_TextNode);
            rootElementGame.appendChild(fiffty_Help_Used_Element);




            //Transformer => transforms element into xml dat
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            //DOMSource => DOMMaster,  takes that xml element i.e. root element
            Source xmlSource = new DOMSource(xmlDocument);
            Result xmlResult = new StreamResult(new File("Milionare.xml"));

            //Convert xml object structure to xml file
            transformer.transform(xmlSource, xmlResult);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("XML file created!");
            alert.setHeaderText("XML file was successfully created!");
            alert.setContentText("File 'Hangman.xml' was created!");

            alert.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SerializableButtonModel loadXML() {

        SerializableButtonModel serializableButtonModel = null;
        try {
            File MilionareFile = new File("Milionare.xml");
            InputStream MilionareStream = new FileInputStream(MilionareFile);

            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDocument = parser.parse(MilionareStream);

            String rootNodeName = xmlDocument.getDocumentElement().getNodeName();
            NodeList nodeList = xmlDocument.getElementsByTagName("Milionare_game");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node gameNode = nodeList.item(i);

                if (gameNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element gameElement = (Element) gameNode;

                    String question_ToString= gameElement
                            .getElementsByTagName("Question")
                            .item(0)
                            .getTextContent();
                    System.out.println("Question: " + question_ToString);

                    String anwser_One_ToString= gameElement
                            .getElementsByTagName("Anwser_One")
                            .item(0)
                            .getTextContent();
                    System.out.println("Anwser_One: " + anwser_One_ToString);

                    String anwser_Two_ToString= gameElement
                            .getElementsByTagName("Anwser_Two")
                            .item(0)
                            .getTextContent();
                    System.out.println("Anwser_Two: " + anwser_Two_ToString);

                    String anwser_Three_ToString= gameElement
                            .getElementsByTagName("Anwser_Three")
                            .item(0)
                            .getTextContent();
                    System.out.println("Anwser_Three: " + anwser_Three_ToString);

                    String anwser_Four_ToString= gameElement
                            .getElementsByTagName("Anwser_Four")
                            .item(0)
                            .getTextContent();
                    System.out.println("Anwser_Four: " + anwser_Four_ToString);



                    String player_One_Points_ToString = gameElement
                            .getElementsByTagName("Player_One_Points")
                            .item(0)
                            .getTextContent();
                    System.out.println("Player_One_Points: " + player_One_Points_ToString);

                    String player_Two_Points_ToString = gameElement
                            .getElementsByTagName("Player_Two_Points")
                            .item(0)
                            .getTextContent();
                    System.out.println("Player_Two_Points: " + player_Two_Points_ToString);

                    String player_One_Turn_ToString = gameElement
                            .getElementsByTagName("Player_One_Turn")
                            .item(0)
                            .getTextContent();
                    System.out.println("Player_One_Turn: " + player_One_Turn_ToString);


                    String audience_Help_Used_ToString = gameElement
                            .getElementsByTagName("Audience_Help_Used")
                            .item(0)
                            .getTextContent();
                    System.out.println("Audience_Help_Used: " + audience_Help_Used_ToString);

                    String call_Help_Used_ToString = gameElement
                            .getElementsByTagName("Call_Help_Used")
                            .item(0)
                            .getTextContent();
                    System.out.println("Call_Help_Used: " + call_Help_Used_ToString);

                    String fiffty_Help_Used_ToString = gameElement
                            .getElementsByTagName("Fiffty_Help_Used")
                            .item(0)
                            .getTextContent();
                    System.out.println("Fiffty_Help_Used: " + fiffty_Help_Used_ToString);

                    String is_Disabled_ToString = gameElement
                            .getElementsByTagName("Is_Disabled")
                            .item(0)
                            .getTextContent();
                    System.out.println("Is_Disabled: " + is_Disabled_ToString);


                    String number_Of_Question_ToString = gameElement
                            .getElementsByTagName("Number_Of_Question")
                            .item(0)
                            .getTextContent();
                    System.out.println("Number_Of_Question: " + number_Of_Question_ToString);



                    serializableButtonModel = new SerializableButtonModel(question_ToString, anwser_One_ToString, anwser_Two_ToString,
                            anwser_Three_ToString, anwser_Four_ToString, player_One_Points_ToString, player_Two_Points_ToString,
                            player_One_Turn_ToString, audience_Help_Used_ToString, call_Help_Used_ToString, fiffty_Help_Used_ToString, is_Disabled_ToString, number_Of_Question_ToString);
                }
            }


        } catch (Exception e) {
            System.out.println("An error occurred while reading from the file!");
        }

        return serializableButtonModel;
    }


}
