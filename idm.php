<?php
	$voiture = array();
	$voiture["Annee"] = "2010";
	$voiture["Marque"]  = "Volvo";
	$voiture["Puissance"] = "190cv";
	$voiture["Modele"]  = "xc90";
	echo json_encode( $voiture );
?>