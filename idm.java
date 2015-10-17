import org.json.simple.JSONObject;

public class idm {

	public static void main(String[] args) {
		   JSONObject voiture = new JSONObject();
		   voiture.put("Annee", "2010");
		   voiture.put("Marque", "Volvo");
		   voiture.put("Puissance", "190cv");
		   voiture.put("Modele", "xc90");
		   System.out.print(voiture);
	}
}
