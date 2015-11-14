/**
 * Created by yvan on 13/11/2015.
 */

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;



public class dsl_java 
{

    private static Document creerDocumentExemple(DocumentBuilder docBuilder) 
    {
        Document doc = docBuilder.newDocument();
        Element racine = doc.createElement("root");
        racine.setAttribute("lang", "fr");
        doc.appendChild(racine);
        Element sujet = doc.createElement("Departement");
        sujet.setAttribute("Informatique", "Genie Logiciel");
        sujet.setTextContent("GL-Apprentissage");
        racine.appendChild(sujet);
        return doc;
    }
    /**
     *
     * @param doc le document à écrire
     * @param nomFichier le nom du fichier de sortie
     */
    private static void ecrireDocument(Document doc, String nomFichier) {

        Source source = new DOMSource(doc);
        Result resultat = new StreamResult(new File(nomFichier));
        Transformer transfo = null;
        try {
            transfo = TransformerFactory.newInstance().newTransformer();
        } catch(TransformerConfigurationException e) {
            System.err.println("Impossible de créer un transformateur XML.");
            System.exit(1);
        }
        transfo.setOutputProperty(OutputKeys.METHOD, "xml");
        transfo.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

        transfo.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        transfo.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            transfo.transform(source, resultat);
        } catch(TransformerException e) {
            System.err.println("La transformation a échoué : " + e);
            System.exit(1);
        }
    }
    
    public static void  main(String [] args  )
    {
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch(ParserConfigurationException e) {
            System.err.println("Impossible de créer un DocumentBuilder.");
            System.exit(1);
        }
        Document doc = creerDocumentExemple(docBuilder);
        ecrireDocument(doc, "test_dsl.xml");
        
    }

}
