import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadText {
	
	public static void main(String[] args){
		String chaine="";
		String fichier ="exemple.txt";
	
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception err){
			System.out.println(err.toString());
		}
		
		// Use Regex on chaine
		String sNumbers = chaine.replaceAll("[^0-9]", "");
	
		System.out.println(sNumbers);
	}
}
