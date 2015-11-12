
<?php

$list = array (
   array('first_name', 'last_name'),
   array('John', 'Doe'),
   array('Samus', 'Aran'),
   array('Gordon', 'Freeman'),
);

$fp = fopen('file.csv', 'w');

foreach ($list as $fields) {
    fputcsv($fp, $fields);
}

fclose($fp);
?>
