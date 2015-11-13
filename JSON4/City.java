/**
 * TP IDM
 * Maxime Lebastard
 */
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class City {
	
	public static void main(String[] args) {
		JSONObject city = new JSONObject();
		city.put("name", "Rennes");

		JSONObject mayor = new JSONObject();
		mayor.put("lastName", "APPERE");
		mayor.put("firstName", "Nathalie");
		
		city.put("mayor", mayor);
		
		List<String> postalCodes = new ArrayList<String>();
		postalCodes.add("35000");
		postalCodes.add("35200");
		postalCodes.add("35700");
		city.put("postalCodes", postalCodes);
		
		city.put("inhabitants", 207178);
		
		System.out.print(city);
	}
}
