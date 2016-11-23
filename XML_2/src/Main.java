import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    private Document doc;
    private Element equipe;
    private Element nom;
    private Element ville;
    private Element salle;
    private Element joueurs;
    private Element entraineurs;
    private Element staffs;

    private int nbJoueur = 0;
    private int nbEntraineur = 0;
    private int nbStaff = 0;

    public static void main(String argv[]) {
        Main main = new Main();
        // Init of XML model
        main.init();
        
        // Add datas to XML
        main.addInfoEquipe("Rennes Volley 35", "Rennes", "Colette Besson");
        
        main.addJoueur(1852634, "Juhkami", "Martti", 27, 195, "Attaquant/réceptionneur", 6);
        main.addJoueur(1859641, "Ragondet", "Olivier", 24, 189, "Attaquant/réceptionneur", 9);
        main.addJoueur(1795842, "Ah_Kong", "Rodney Ken", 28, 204, "Central", 12);
        main.addJoueur(1685472, "Hardy-Dessources", "Gérald", 32, 197, "Central", 3);
        main.addJoueur(1574856, "Berrios", "Gregory", 36, 182, "Libéro", 2);
        main.addJoueur(1764852, "Miseikis", "Arvaydas", 28, 200, "Pointu", 5);
        main.addJoueur(1436584, "Toobal", "Kert", 36, 189, "Passeur", 1);
        
        main.addEntraineur("Matijasevic", "Nikola", "Entraîneur");
        main.addEntraineur("Bouvet", "Olivier", "Entraîneur Adjoint");
        
        main.addStaff("Mativet", "Thibault", "Co-président");
        main.addStaff("Mollier", "Stéphane", "Directeur Sportif");
        main.addStaff("Convenant", "Didier", "Manager");
        main.addStaff("Paumier", "Karenn", "Chargée de communication");
        
        try{
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(main.doc);
            StreamResult result = new StreamResult(new File("fichierXML.xml"));

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    private void init(){
        try {
	    //initialisation of document
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();

	    // parent node
            equipe = doc.createElement("equipe");
            doc.appendChild(equipe);

            // child nodes
            nom = doc.createElement("nom");
            equipe.appendChild(nom);
            ville = doc.createElement("ville");
            equipe.appendChild(ville);
            salle = doc.createElement("salle");
            equipe.appendChild(salle);
            joueurs = doc.createElement("joueurs");
            equipe.appendChild(joueurs);
            entraineurs = doc.createElement("entraineurs");
            equipe.appendChild(entraineurs);
            staffs = doc.createElement("staffs");
            equipe.appendChild(staffs);

        } catch (ParserConfigurationException pcex) {
            pcex.printStackTrace();
        }
    }

    private void addInfoEquipe(String vNom, String vVille, String vSalle){
    	nom.setTextContent(vNom);
        ville.setTextContent(vVille);
        salle.setTextContent(vSalle);
    }

    /**
     * Create childs nodes for joueurs node
     */
    private void addJoueur(int numLicence, String nom, String prenom, int age, int taille, String poste, int numMaillot) {
        Element joueur = doc.createElement("joueur");
        joueur.setAttribute("id", "" + nbJoueur);

        Element eltNumLicence = doc.createElement("numero_licence");
        eltNumLicence.appendChild(doc.createTextNode(String.valueOf(numLicence)));
        joueur.appendChild(eltNumLicence);
        Element eltNom = doc.createElement("nom");
        eltNom.appendChild(doc.createTextNode(nom));
        joueur.appendChild(eltNom);
        Element eltPrenom = doc.createElement("prenom");
        eltPrenom.appendChild(doc.createTextNode(prenom));
        joueur.appendChild(eltPrenom);
        Element eltAge = doc.createElement("age");
        eltAge.appendChild(doc.createTextNode(String.valueOf(age)));
        joueur.appendChild(eltAge);
        Element eltTaille = doc.createElement("taille");
        eltTaille.appendChild(doc.createTextNode(String.valueOf(taille)));
        joueur.appendChild(eltTaille);
        Element eltPoste = doc.createElement("poste");
        eltPoste.appendChild(doc.createTextNode(poste));
        joueur.appendChild(eltPoste);
        Element eltNumMaillot = doc.createElement("numero_maillot");
        eltNumMaillot.appendChild(doc.createTextNode(String.valueOf(numMaillot)));
        joueur.appendChild(eltNumMaillot);

        nbJoueur++;
        joueurs.appendChild(joueur);
    }

    /**
     * Create childs nodes for entraineurs node
     */
    private void addEntraineur(String nom, String prenom, String poste) {
        Element entraineur = doc.createElement("entraineur");
        entraineur.setAttribute("id", "" + nbEntraineur);

        Element eltNom = doc.createElement("nom");
        eltNom.appendChild(doc.createTextNode(nom));
        entraineur.appendChild(eltNom);
        Element eltPrenom = doc.createElement("prenom");
        eltPrenom.appendChild(doc.createTextNode(prenom));
        entraineur.appendChild(eltPrenom);
        Element eltPoste = doc.createElement("poste");
        eltPoste.appendChild(doc.createTextNode(poste));
        entraineur.appendChild(eltPoste);

        nbEntraineur++;
        entraineurs.appendChild(entraineur);
    }

    /**
     * Create childs nodes for staffs node
     */
    private void addStaff(String nom, String prenom, String poste) {
        Element staff = doc.createElement("staff");
        staff.setAttribute("id", "" + nbStaff);

        Element eltNom = doc.createElement("nom");
        eltNom.appendChild(doc.createTextNode(nom));
        staff.appendChild(eltNom);
        Element eltPrenom = doc.createElement("prenom");
        eltPrenom.appendChild(doc.createTextNode(prenom));
        staff.appendChild(eltPrenom);
        Element eltPoste = doc.createElement("poste");
        eltPoste.appendChild(doc.createTextNode(poste));
        staff.appendChild(eltPoste);

        nbStaff++;
        staffs.appendChild(staff);
    }
}