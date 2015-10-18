<!-- I use Spyc,it is a YAML loader/dumper written in pure PHP.link :https://github.com/mustangostang/spyc/ -->

<?php

require_once "Spyc.php";


class Employe
{

    public function setup()
    {
        $this->yamlParser = new YamlParser();
    }

    public function createYAML()
    {
	// Fonction de l'api permetant de mettre un tableau sous YML.
        $ymlFormat = Spyc::YAMLDump(array(
            "nom" => "Noumi",
            "prenom" => "Paola",
            "nationalite" => "francaise",
            "age" => 22,
            "lieudetravail" => "ISTIC",
            "activite" => "Danser",
             4, 60);

	print_r($ymlFormat);
    }
}
?>
