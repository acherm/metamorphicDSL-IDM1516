import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.FileWriter;

/**
*
* @author julie
*/
public class ShellAvecJava {

	/**
	* @param args the command line arguments
	*/
	public static void main (String[] args) {
		/* Pour C : system("/etc/init.d/samba reload"); */
		try{
			Process proc=Runtime.getRuntime().exec("ls");
			InputStream in = proc.getInputStream();
			BufferedWriter out=new BufferedWriter(new FileWriter("result_ls.dat"));

			int c;
			while ((c = in.read()) != -1) {
				out.write((char)c);
			}

			in.close();
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
