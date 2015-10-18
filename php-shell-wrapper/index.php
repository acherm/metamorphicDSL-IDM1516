<?php
require 'vendor/autoload.php';
use AdamBrett\ShellWrapper\Command;
use AdamBrett\ShellWrapper\Command\Param;
use AdamBrett\ShellWrapper\Runners\Exec;


$shell = new Exec();

$command   = new Command('echo');
$command->addParam(new Param('Bonjour'));
$shell->run($command);


$shell2 = new Exec();
$command2   = new Command('echo');
$command2->addParam(new Param('Saviez-vous que les fourmis sont parfois paresseuses ?'));
$shell2->run($command2);


/*
$command3 = new Command('ls');
$shell->run($command3);
print_r($shell->getOutput()); 
*/
