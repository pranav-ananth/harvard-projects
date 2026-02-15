#include<iostream>
#include<fstream>
#include<string>

using namespace std;

int main() {
	fstream wordFile; //object of fstream, it can be used for both input and output

	string wordLine;

	//Open the file for both input and output
	wordFile.open("wordFile.txt");
	//file.open("file1.txt", ios::openmode = ios::in | ios::out)

	if(wordFile.fail()){//unable to open the file
		cout<<"Unable to open the file";
		return 1; //to show that the an error has occured
	}
	
	int i = 1;
	cout << "The first 10 lines of the file are:" << endl;
	getline(wordFile, wordLine);//read first line
	while(wordFile && i <= 10) {
		cout << wordLine << endl;
		getline(wordFile, wordLine);//read the next lines
		i++; //count
	}
	if(i < 10) {
		cout << "There are no more lines in the file." << endl; //shows that there were less than 10 lines read
	}

	
	wordFile.close(); //closing the file
	return 0; 

}
