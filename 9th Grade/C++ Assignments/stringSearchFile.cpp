#include<iostream>
#include<fstream>
#include<string>

using namespace std;

int main() {
	fstream wordFile; //object of fstream, it can be used for both input and output
	string searchedStr, wordLine;
	size_t found;
	int amtFound = 0;

	//Open the file for both input and output
	wordFile.open("wordFile.txt");
	//file.open("file1.txt", ios::openmode = ios::in | ios::out)

	if(wordFile.fail()){//unable to open the file
		cout<<"Unable to open the file";
		return 1; //to show that the an error has occured
	}
	
	cout << "Enter a string: ";
	getline(cin, searchedStr);
	
	getline(wordFile, wordLine);
	while(wordFile) {
		found = wordLine.find(searchedStr);
		if(found != string::npos) {
			amtFound++;
		}
		getline(wordFile, wordLine);
	}
	cout << "There were " << amtFound << " times your string was in the file."<< endl;
	
	wordFile.close(); //closing the file
	return 0; 

}
