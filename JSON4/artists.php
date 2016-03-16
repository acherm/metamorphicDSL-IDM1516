<?php 

$artists = array();
$artists['Jacques'] = array(
	'Origin' => 'France',
	'Location' => 'Parc Expo - Hall 9',
	'Date' => '2015-12-04T03:30:00Z',
	'Duration' => '75',
	'Description' => 'This young artist told his uncommon story as an Alsace-born musician who went to the capital during a TED conference.'
	);

$artists['Vandal'] = array();
$artists['Vandal']['Origin'] = 'Great Britain';
$artists['Vandal']['Location'] = 'Parc Expo - Hall 4 / Green room';
$artists['Vandal']['Date'] = '2015-12-05T01:30:00Z';
$artists['Vandal']['Duration'] = '105';
$artists['Vandal']['Description'] = 'The English sound engineer hiding behind his machines could devastate stadiums with infra-bass beats and unsteady rhythms.';


$json = json_encode($artists));


?>