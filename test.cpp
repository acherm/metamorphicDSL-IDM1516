#include <stdlib.h>
#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
	cout << "Affichage détaillé des fichiers" << endl;
	system("ls -l");
	
	cout << "Affichage du contenu du README" << endl;
	system("cat README.md");
	
	return 0;
}