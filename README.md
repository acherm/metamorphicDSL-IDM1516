# DM IDM DSL
Thibaut Rousseau

DSL utilisé : le langage DOT (utilisé au sein de la suite d'outils GraphViz).
Il s'agit d'un langage de description de graphes.

Plus d'informations :
* [DOT (langage)](https://fr.wikipedia.org/wiki/DOT_%28langage%29)
* [Graphviz](https://fr.wikipedia.org/wiki/Graphviz)

## Installation de GraphViz
Sous Linux, il faudra installer le paquet `graphviz` (`sudo apt-get install graphviz`).

## Programme
Les usages en tant que DSL internes et externe suivants viseront à reproduire
ce graphe de flot de contrôle d'un programme calculant le PGCD de deux nombres :

![Graphe de flot de contrôle d'un programme de calcul de PGCD](https://i.imgur.com/jvzw1GA.gif)

(Image trouvée via Google Images)

## Utilisation comme DSL externe
Dans le dossier `sh/`, lancer la commande `./dot.sh` pour convertir le graphe
décrit en langage DOT dans le fichier `gcd.gv` en image PNG (`gcd-dot.png`).

## Utilisation comme DSL interne

### Python
Le programme utilise Python 3 et la bibliothèque graphviz pour Python. Il
faudra donc installer :

* Python 3 (`sudo apt-get install python3`)
* Le gestionnaire de dépendances pip pour Python 3 (il devrait normalement
s'installer en même temps que Python 3, s'il n'est pas présent il faudra
l'installer manuellement à l'aide de la commande `sudo easy_install3 pip` ou
`sudo easy_install pip`
* La bibliothèque graphviz pour Python (`pip install graphiz`)

Dans le dossier `py/`, il sera ainsi possible de lancer la commande `./gcd.py`.
Une image PNG `gcd-py.png` sera créée.

### NodeJS
Le programme utilise NodeJS et la bibliothèque graphviz. Il faudra installer :

* NodeJS (`sudo apt-get install nodejs`)
* NPM (normalement packagé avec NodeJS, sinon `sudo apt-get install npm`)
* La dépendence graphviz peut s'installer en lançant la commande
`npm install` dans le dossier `js/`

Il faudra ensuite lancer la commande `node index.js` ou `nodejs index.js` selon
l'installation pour générer l'image `gcd-js.png`.
