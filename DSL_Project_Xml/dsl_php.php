<?php

$document=new DOMDocument('1.0',"UTF-8");
$root=$document->createElement('root');
$root->setAttribute('lang', 'fr');
$root=$document->appendChild($root);
$departement=$document->createElement('Departement','GLA');
$departement->setAttribute('Informatique', 'Genie Logiciel');
$departement=$root->appendChild($departement);
$document->save('test_dsl.xml');

