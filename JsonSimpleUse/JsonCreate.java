import org.json.JSONException;
import org.json.JSONObject;

public class JsonCreate {
	public static void main(String[] args) throws JSONException{
	      JSONObject obj = new JSONObject();
	      JSONObject def = new JSONObject();
	      def.put("size", 70);
	      def.put("name", "pinguin");
	      def.put("type", "oiseau");
	      def.put("isCool", new Boolean(true));
	      obj.put("animal", def);
	      System.out.print(obj);
	   }
}