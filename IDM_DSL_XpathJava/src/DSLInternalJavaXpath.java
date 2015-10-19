import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

public class DSLInternalJavaXpath {

	public static void main(String[] args) throws JDOMException {
		File entryFile = new File("./resources/etudiants.xml");
		DSLInternalJavaXpath example = new DSLInternalJavaXpath();
		example.xpathParse(entryFile);
	}

	public DSLInternalJavaXpath(){
		
	}
	
	public void xpathParse(File _FilePath) {
		org.jdom.Document document = null;
		try {
			SAXBuilder sxb = new SAXBuilder();
			document = sxb.build(_FilePath);
		} catch (IOException | JDOMException e) {
			e.printStackTrace();
		}

		try {
			Element racine = document.getRootElement();
			//Nom de l'étudiant avec l'ID 4
			System.out.println("Nom de l'étudiant avec l'id 4");
			XPath xpa = XPath.newInstance("//etudiant");
			
			List results = xpa.selectNodes(racine);
			Iterator iter = results.iterator();
			
			Element noeudCourant = null;
			String etudiantId = null;
			while (iter.hasNext()) {
				noeudCourant = (Element) iter.next();
				xpa = XPath.newInstance("./@id");
				etudiantId = xpa.valueOf(noeudCourant);

				if(etudiantId.equals("4")){
					xpa = XPath.newInstance("//etudiant[@id='" + etudiantId + "']");
					noeudCourant = (Element) xpa.selectSingleNode(noeudCourant);

					xpa = XPath.newInstance("./nom");
					System.out.println("Nom : " + xpa.valueOf(noeudCourant));
				}
			}
			System.out.println("============================================================");
			//Les prénoms de tous les étudiants
			System.out.println("Prénoms de tous les étudiants");
			xpa = XPath.newInstance("//etudiant");
			
			results = xpa.selectNodes(racine);
			iter = results.iterator();
			
			noeudCourant = null;
			etudiantId = null;
			while (iter.hasNext()) {
				noeudCourant = (Element) iter.next();
				xpa = XPath.newInstance("./@id");
				etudiantId = xpa.valueOf(noeudCourant);

				xpa = XPath.newInstance("//etudiant[@id='" + etudiantId + "']");
				noeudCourant = (Element) xpa.selectSingleNode(noeudCourant);

				xpa = XPath.newInstance("./nom");
				System.out.println("Nom : " + xpa.valueOf(noeudCourant));
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}
}
