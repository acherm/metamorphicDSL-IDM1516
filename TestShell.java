import java.io.*;

public class TestShell {

	public static void main (String[] args) {
		try {
			TestShell t = new TestShell();
			
			System.out.println("Affichage détaillé des fichiers");
			Process p = Runtime.getRuntime().exec("ls -l");
			t.ShowProcessInput(p);
        
			System.out.println("Affichage du contenu du README");
			p = Runtime.getRuntime().exec("cat README.md");
			t.ShowProcessInput(p);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public void ShowProcessInput(Process p) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = reader.readLine();
			while(line != null)
			{
				System.out.println(line);
				line = reader.readLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if (reader != null) {
				try {
					reader.close();
				}
				catch (IOException ex) {
				}
			}
        }
	}
}