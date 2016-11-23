using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace ConsoleApplication1{
    class Program{
        private XmlWriter writer;
        
        private int nbJoueur = 0;
    	private int nbEntraineur = 0;
    	private int nbStaff = 0;
        
        static void Main(string[] args){
            Program prg = new Program();
            prg.init();
        }
    	
        public void init(){
            using (writer = XmlWriter.Create("fichierXMLC.xml")){
                writer.WriteStartDocument();
                    startEquipe();
                    	addInfoEquipe("Rennes Volley 35", "Rennes", "Colette Besson");
                        startJoueurs();
                            addJoueur(1852634, "Juhkami", "Martti", 27, 195, "Attaquant/réceptionneur", 6);
        					addJoueur(1859641, "Ragondet", "Olivier", 24, 189, "Attaquant/réceptionneur", 9);
        					addJoueur(1795842, "Ah_Kong", "Rodney Ken", 28, 204, "Central", 12);
        					addJoueur(1685472, "Hardy-Dessources", "Gérald", 32, 197, "Central", 3);
        					addJoueur(1574856, "Berrios", "Gregory", 36, 182, "Libéro", 2);
        					addJoueur(1764852, "Miseikis", "Arvaydas", 28, 200, "Pointu", 5);
        					addJoueur(1436584, "Toobal", "Kert", 36, 189, "Passeur", 1);
                        endJoueurs();
                        startEntraineurs();
                        	addEntraineur("Matijasevic", "Nikola", "Entraîneur");
                        	addEntraineur("Bouvet", "Olivier", "Entraîneur Adjoint");
                        endEntraineurs();
                        startStaffs();
                       		addStaff("Mativet", "Thibault", "Co-président");
        					addStaff("Mollier", "Stéphane", "Directeur Sportif");
        					addStaff("Convenant", "Didier", "Manager");
        					addStaff("Paumier", "Karenn", "Chargée de communication");
                        endStaffs();
                    endEquipe();
                writer.WriteEndDocument();
            }
        }
        
        public void addInfoEquipe(String vNom, String vVille, String vSalle){
            writer.WriteElementString("nom", vNom);
            writer.WriteElementString("ville", vVille);
            writer.WriteElementString("salle", vSalle);
        }
        
        public void startEquipe(){
            writer.WriteStartElement("equipe");
        }
        public void endEquipe(){
            writer.WriteEndElement();
        }
        public void startJoueurs(){
            writer.WriteStartElement("joueurs");
        }
        public void endJoueurs(){
            writer.WriteEndElement();
        }
        public void startEntraineurs(){
            writer.WriteStartElement("entraineurs");
        }
        public void endEntraineurs(){
            writer.WriteEndElement();
        }
        public void startStaffs()
            writer.WriteStartElement("staffs");
        }
        public void endStaffs(){
            writer.WriteEndElement();
        }
        
        public void addJoueur(int numLicence, String nom, String prenom, int age, int taille, String poste, int numMaillot){
            writer.WriteStartElement("joueur");
            writer.WriteAttributeString("id", ""+nbJoueur);
            writer.WriteElementString("numero_licence", numLicence.ToString());            
            writer.WriteElementString("nom", name);       
            writer.WriteElementString("prenom", prenom);
            writer.WriteElementString("age", age.ToString());
            writer.WriteElementString("taille", taille.ToString());
            writer.WriteElementString("poste", poste);
            writer.WriteElementString("numMaillot", numMaillot.ToString());
            writer.WriteEndElement();
            nbJoueur++;
        }
        
        public void addEntraineur(String nom, String prenom, String poste) {
            writer.WriteStartElement("entraineur");
            writer.WriteAttributeString("id", ""+nbEntraineur);          
            writer.WriteElementString("nom", name);       
            writer.WriteElementString("prenom", prenom);
            writer.WriteElementString("poste", poste);
            writer.WriteEndElement();
            nbEntraineur++;
        }
        
        public void addStaff(String nom, String prenom, String poste) {
            writer.WriteStartElement("staff");
            writer.WriteAttributeString("id", ""+nbStaff);          
            writer.WriteElementString("nom", name);       
            writer.WriteElementString("prenom", prenom);
            writer.WriteElementString("poste", poste);
            writer.WriteEndElement();
            nbStaff++;
        }
    }
}