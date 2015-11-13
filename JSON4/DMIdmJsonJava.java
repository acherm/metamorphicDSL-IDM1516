import org.json.simple.JSONObject;
import java.lang.System;

public class DMIdmJsonJava {

	public static void main(String[] args) {
        String string = '{ "DCComics" : [{"Batman" : { "nom" : "Bruce Wayne" }}, {"Superman" : { "nom" : "Clark Kent"}}],'+
                ' "Marvel" : [{"Ironman" : { "nom" : "Tony Stark" }}, {"Captain America" : { "nom" : "Steve Rogers" }}]}'
        JSONObject heros = new JSONObject(string);
        System.out.println(heros);
	}
}
