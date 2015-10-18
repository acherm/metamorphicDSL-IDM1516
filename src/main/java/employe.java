/*I use YamlBeans to serialize and deserialize the object Employe to and from YAML: https://github.com/EsotericSoftware/yamlbeans */

import java.io.FileWriter;

class Employe {

    public static void main (String[] args){

        Employe employe = new Employe();
        employe.nom = "Noumi";
        employe.prenom = "Paola";
        employe.nationalite = "francaise";
        employe.age = 22;
        employe.lieudetravail = "ISTIC";
    	employe.activite = "Danser";

        YamlWriter writer = new YamlWriter(new FileWriter("employe.yml"));
        writer.write(employe);
        writer.close();
    }
}
