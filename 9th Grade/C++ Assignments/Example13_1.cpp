/*
Example13_1.cpp
Program to demonstrate reading and writing a file through fstream object

@author: Anita Rathi
@Date: March 7, 2024
*/

#include<iostream>
#include<fstream>
#include<string>

using namespace std;

int main(){
	fstream file; //object of fstream, it can be used for both input and output

	string word;

	//Open the file for both input and output
	file.open("file1.txt");
	//file.open("file1.txt", ios::openmode = ios::in | ios::out)

	if(file.fail()){//unable to open the file
		cout<<"Unable to open the file";
		return 1; //to show that the an error has occured
	}

	while(file>>word){ // while end of file is not reached
		cout<<word;
	}

	file.clear();// clearing end of file flag to allow further operations on the file
	int repeat = 1;

	file<<" It is a rainy day. ";


	while(repeat){
		cout<<" Enter a word:";
		cin>>word;
		file<<word;
		cout<<"Do you want to add more words to file(1/0):";
		cin>>repeat;
	}
	
	file.close(); //closing the file
	return 0; 

}