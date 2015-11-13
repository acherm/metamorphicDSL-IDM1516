<?php
/**
 * TP IDM
 * Maxime Lebastard
 */

	$city = new \stdClass();
	$city->name = "Rennes";
	$city->mayor = new \stdClass();
	$city->mayor->lastName = "APPERE";
	$city->mayor->firstName = "Nathalie";
	$city->postalCodes = ["35000","35200","35700"];
	$city->inhabitants = 207178;

	$jsonCity = json_encode($city);
	
