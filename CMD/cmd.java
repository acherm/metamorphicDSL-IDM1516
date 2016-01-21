import java.util.ArrayList;

public class JavaCmd {
	
	public final static String rename = "REN";
	public final static String cd = "CD";
	public final static String remove = "find";
	
	public static void cmdExample () {
		
		ArrayList<String> cmd1 = new ArrayList<String>();
		
		cmd1.add(rename);
		cmd1.add("file1");
		cmd1.add("newName");
		
		ArrayList<String> cmd2 = new ArrayList<String>();
		
		cmd2.add(cd);
		cmd2.add("folder");
		
		ArrayList<String> cmd3 = new ArrayList<String>();
		
		cmd3.add(remove);
		cmd3.add("filefolder");
		
		ProcessBuilder processBuilder1 = new ProcessBuilder(cmd1);
		ProcessBuilder processBuilder2 = new ProcessBuilder(cmd2);
		ProcessBuilder processBuilder3 = new ProcessBuilder(cmd3);
		try {
			processBuilder1.start();
			processBuilder2.start();
			processBuilder3.start();
		} catch (Throwable t) {
			System.err.println(t);
		}
		
	}

}
