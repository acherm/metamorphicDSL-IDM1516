public class GPL {
		
    public static void main(String[] args) {
    if (!Rengine.versionCheck()) {
        System.err.println("** Version mismatch - Java files don't match library version.");
        System.exit(1);
    }
    
        System.out.println("Creating Rengine");
        Rengine re = null;
        try{
	        re=new Rengine(args, false, new TextConsole());
	        System.out.println("salut !!!");
        }catch(Exception e){
        	System.out.println("toto" + e.getMessage());
        }
        System.out.println("Rengine created");
        
        if (!re.waitForR()) {
            System.out.println("Cannot load R");
            return;
        }
    	
        // --------- Appel du DSL ----------
       re.eval("source('DSL.R')");
       // ---------- Fin d'appel -----------
     
    }
}