
IDM : HomeWork DSL
=
JavaFx
-


JavaFX est un ensemble de classes permettant de créer des interfaces graphiques en java.
Il est possible de les utiliser de différentes façons :
- Depuis un fichier FXML externe
- Directement en Java comme on utiliserait une classe traditionnelle
- Via l'API ScalaFX permettant d'utiliser JavaFx tout en conservant la syntaxe Scala

----------
Pour lancer une des versions du programme :
 1. Se placer dans le repertoire du project à lancer
 2. Pour exécuter la version :
 	* Java : 
 	```
    java -cp out/production/javafx-java sample.JavaFXFont
    ```
    * FXML :
    ```shell
    java -cp out/production/javafx-fxml sample.FxmlFont
    ```
    * ScalaFX
    ```shell
    sbt run
    ```
 3. ????
 4.  Profit !!!

Réalisé par Thomas Huchedé

---

> **Note:**
> - Les versions Java et FXML nécessitent Java 8
> - La version Scala nécessite SBT

### Liens

 * [JavaFx](http://docs.oracle.com/javase/8/javase-clienttechnologies.htm) : documentation générale sur JavaFx
 * [Tuto FXML](http://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm) : pour bien démarrer 
 * [ScalaFx](http://www.scalafx.org/) : pour la partie Scala