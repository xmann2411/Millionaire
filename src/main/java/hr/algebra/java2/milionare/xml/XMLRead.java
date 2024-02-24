package hr.algebra.java2.milionare.xml;

import hr.algebra.java2.milionare.model.OnePlayerMove;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class XMLRead {
    private XMLRead() {}

    public static List<OnePlayerMove> readXML(final String fileName) throws Exception {
        List<OnePlayerMove> playerMoves = new LinkedList<>();

        String projectDir = System.getProperty("user.dir");
        File playerMovesFile = new File(projectDir + "\\" + fileName);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document xmlDocument = builder.parse(playerMovesFile);

        NodeList nodeList = xmlDocument.getElementsByTagName("playerMove");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node moveNode = nodeList.item(i);

            if (moveNode.getNodeType() == Node.ELEMENT_NODE) {
                Element moveElement = (Element) moveNode;

                int question = Integer.parseInt(moveElement.getElementsByTagName("question").item(0).getTextContent());
                //char givenAnwserLetter = Char.(moveElement.getElementsByTagName("givenAnwserLetter").item(0).getTextContent());
                char givenAnwserLetter = moveElement.getElementsByTagName("givenAnwserLetter").item(0).getTextContent().charAt(0);
                boolean isAudienceUsed = Boolean.parseBoolean(moveElement.getElementsByTagName("isAudienceUsed").item(0).getTextContent());
                boolean isCallUsed = Boolean.parseBoolean(moveElement.getElementsByTagName("isCallUsed").item(0).getTextContent());
                boolean isFiftyUsed = Boolean.parseBoolean(moveElement.getElementsByTagName("isFiftyUsed").item(0).getTextContent());

                OnePlayerMove playerMove = new OnePlayerMove(question, givenAnwserLetter, isAudienceUsed, isCallUsed, isFiftyUsed);
                playerMoves.add(playerMove);
            }
        }

        return playerMoves;
    }
}
