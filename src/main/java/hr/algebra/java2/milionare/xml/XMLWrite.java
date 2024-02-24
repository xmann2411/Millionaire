package hr.algebra.java2.milionare.xml;

import hr.algebra.java2.milionare.model.OnePlayerMove;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLWrite {
    private XMLWrite() {}

    public static void writeXML(List<OnePlayerMove> playerMoves, final String fileName) {
        try {
            Document document = createDocument("playerMoves");
            for (OnePlayerMove playerMove : playerMoves) {
                Element move = document.createElement("playerMove");
                document.getDocumentElement().appendChild(move);

                move.appendChild(createElement(document, "question", String.valueOf(playerMove.getQuestion())));
                move.appendChild(createElement(document, "givenAnwserLetter", String.valueOf(playerMove.isGivenAnwserCorrect())));
                move.appendChild(createElement(document, "isAudienceUsed", String.valueOf(playerMove.isAudienceUsed())));
                move.appendChild(createElement(document, "isCallUsed", String.valueOf(playerMove.isCallUsed())));
                move.appendChild(createElement(document, "isFiftyUsed", String.valueOf(playerMove.isFiftyUsed())));
                // Add more fields if needed
            }
            saveDocument(document, fileName);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static Document createDocument(String element) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation domImplementation = builder.getDOMImplementation();
        DocumentType documentType = domImplementation.createDocumentType("DOCTYPE", null, "playerMove.dtd");
        return domImplementation.createDocument(null, element, documentType);
    }

    private static Node createElement(Document document, String tagName, String data) {
        Element element = document.createElement(tagName);
        Text text = document.createTextNode(data);
        element.appendChild(text);
        return element;
    }

    private static void saveDocument(Document document, String fileName) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        String filePath = fileName;
        transformer.transform(new DOMSource(document), new StreamResult(new File(filePath)));
    }
}
