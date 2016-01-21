Le langage VHDL permet de décrire le comportement
de composants électroniques. Des simulateurs, comme
ghdl, permettent d'effectuer des tests afin de 
s'assurer que le composant décrit se comporte bien 
comme attendu.

Il est nécessaire ici d'avoir installé ghdl, disponible
dans votre gestionnaire de paquets. Il est aussi 
nécessaire d'avoir javac et g++ installés.

On a alors simulé et testé un multiplexeur à deux 
entrées en VHDL, Java et C++. Dans chacun des dossiers,
vous trouverez un fichier Makefile. En utilisant la 
commande "make", vous compilerez le projet. La commande
"make run" lancera la simulation. Enfin la commande 
"make clean" supprimera les fichiers générés pour la
simulation.
