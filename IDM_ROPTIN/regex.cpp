#include<iostream>
#include<fstream>

using namespace std;

int main() {
	ifstream myReadFile;
	myReadFile.open("text.txt");
	String output;
	if (myReadFile.is_open()) {
		while (!myReadFile.eof()) {
			myReadFile >> output;
		}
	}
	std::cout << regex_replace(myReadFile, "[[:digit:]]", "");
	myReadFile.close();
	return 0;
}
