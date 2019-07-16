package br.com.tlmacedo.cafeperfeito.nfe;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: thiagomacedo
 * Date: 2019-06-19
 * Time: 13:55
 */

public class ServiceDocumentFactory {

    public static Document documentFactory(String xml) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document document = null;
        try {
            document = factory.newDocumentBuilder().parse(
                    new ByteArrayInputStream(xml.getBytes()));
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            ex.printStackTrace();
        }
        return document;
    }
}
