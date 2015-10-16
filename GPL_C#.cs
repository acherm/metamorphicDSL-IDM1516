namespace ApplicationScriptR
{
	private void lancementScriptR()
	{
	    // Lancement du script R
	    System.Diagnostics.Process proc = new System.Diagnostics.Process();
	    proc.StartInfo.FileName = "C:/Program Files/R/R-3.3.2/bin/Rscript.exe";
	    proc.StartInfo.WorkingDirectory = "C:/Program Files/R/R-3.3.2/bin/";
	    proc.StartInfo.Arguments = "source('DSL.R')";
	    proc.StartInfo.UseShellExecute = true;
	    proc.StartInfo.RedirectStandardOutput = false;
	    proc.Start();           
	}
}