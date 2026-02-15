#include <iostream>
#include <limits>
#include <string>
#include <utility>
#include<cstdlib>

using namespace std;



string encipher(string str, int n);
string decipher(string str);

char rotate(unsigned char ch, int n);
double letterScore(char ch);
double stringScore(string str);
void pressEnterToContinue(string msg);
  

int testFunctions();



int main() {
	
    string entered_choice = "";
	string str = "";
	int chars_to_shift = 1;
	char enter_to_see_message = '\0';
	string input = "";
	
	testFunctions();
	
	do {
		

		cout <<  "Welcome. Please choose from the following options" << endl;
		cout <<  "1. Encrypt a message" << endl;
		cout <<  "2. Decode a message"  << endl;
		cout <<  "3. End Program"  << endl;
		
		cout << "Your choice: ";
		
		getline(cin,entered_choice);
		
		if (entered_choice[0] == '1')  {
			cout << "Enter a message to encrypt: " << endl;
			getline(cin, str);
			
			bool invalid;
				
			do {
				invalid = false;
				cout << "Enter a caesar shift between 1 and 25: ";
				getline(cin, input);
				chars_to_shift = atoi(input.c_str());
			
				if ( (chars_to_shift < 1) || (chars_to_shift > 25) ) {

				   cout << "Invalid characters to shift" << endl;
				   invalid = true;
				}	
			} while (invalid);
			
			cout << "I will now encrypt that message..." << endl;
			
			pressEnterToContinue("Enter return to see the encrypted message");
			cout << endl;
			cout << encipher(str, chars_to_shift) << endl;
							
		}
		
		if (entered_choice[0] == '2')  {
			cout << "Enter the message you want to decode:" << endl;
			getline(cin, str);
			
			cout << "Aha! I have figured out the message." << endl;
			pressEnterToContinue("Enter return to see the decoded message");
			
			cout << endl;
			cout << decipher(str) << endl;
		}
		
		if (entered_choice[0] == '3')  {
			cout << "Goodbye!";
		}
		
	}  while (entered_choice[0] != '3'); 
	
	return 0;
	
}

char rotate(unsigned char ch, int n) 
{
	
	unsigned char rotatedChar = ch;
	
	// Check if the character is a upper case character
	if ( (ch >= 'A') && (ch <= 'Z')) {
		rotatedChar = ch + n;
		if (rotatedChar > 'Z') {
			rotatedChar = rotatedChar - 26;
		}
	}	
	
	// Check if the character is a lower case character
	if ( (ch >= 'a') && (ch <= 'z')) {
		rotatedChar = ch + n;
		if (rotatedChar > 'z') {
			rotatedChar = rotatedChar - 26;
		}
	}	


    return (char) rotatedChar;
}


double letterScore(char ch)
{
	if (ch == 'A' || ch == 'a') return .0684;
	if (ch == 'B' || ch == 'b') return .0139;
	if (ch == 'C' || ch == 'c') return .0146;
	if (ch == 'D' || ch == 'd') return .0456;
	if (ch == 'E' || ch == 'e') return .1267;
	if (ch == 'F' || ch == 'f') return .0234;
	if (ch == 'G' || ch == 'g') return .0180;
	if (ch == 'H' || ch == 'h') return .0701;
	if (ch == 'I' || ch == 'i') return .0640;
	if (ch == 'J' || ch == 'j') return .0033;
	if (ch == 'K' || ch == 'k') return .0093;
	if (ch == 'L' || ch == 'l') return .0450;
	if (ch == 'M' || ch == 'm') return .0305;
	if (ch == 'N' || ch == 'n') return .0631;
	if (ch == 'O' || ch == 'o') return .0852;
	if (ch == 'P' || ch == 'p') return .0136;
	if (ch == 'Q' || ch == 'q') return .0004;
	if (ch == 'R' || ch == 'r') return .0534;
	if (ch == 'S' || ch == 's') return .0659;
	if (ch == 'T' || ch == 't') return .0850;
	if (ch == 'U' || ch == 'u') return .0325;
	if (ch == 'V' || ch == 'v') return .0084;
	if (ch == 'W' || ch == 'w') return .0271;
	if (ch == 'X' || ch == 'x') return .0007;
	if (ch == 'Y' || ch == 'y') return .0315;
	if (ch == 'Z' || ch == 'z') return .0004;
	return 0.0; 
}

double stringScore(string str) 
{
   
   double score = 0.0;
   int nonWhiteSpaceCharacters = 0;
   // score each letter and sum it
   for (int i = 0; i < str.length(); i++)	{
   	   double letter_score = letterScore(str[i]);
   	   score = score + letter_score;
   	   if (letter_score > 0.0) {
   	  		nonWhiteSpaceCharacters++;		
	   }
   	  
   }
   
   // return the average of the score
   return score / nonWhiteSpaceCharacters;
	
}

string encipher(string str, int n) 
{
	
	string encryptedStr = "";
	for ( int i = 0; i < str.length(); i++) {
		encryptedStr = encryptedStr + rotate(str[i], n);
	}
	
	return encryptedStr;
	
}

string decipher(string str) {
	
	string rotatedStr[25];
	double scores[25];

    // encipher the string 25 times by incrementing each shift	
	for (int i = 0; i < 25; i++ ) {
		rotatedStr[i] = encipher(str, i+1);
		scores[i] = stringScore(rotatedStr[i]);
	}
	 	
    // find the enciphered string with the maximum score
	double maxScore = scores[0];
	int indexOfMaxScore = 0;
	
	for (int j = 1; j < 25; j++) {
		if (scores[j] > maxScore ) {
			maxScore = scores[j];
		    indexOfMaxScore = j;	
		}
	}
	
	return rotatedStr[indexOfMaxScore];
}

void pressEnterToContinue(string msg)
{
  cout << msg << flush;
  cin.ignore(numeric_limits <streamsize> ::max(), '\n' );
}

int testFunctions() 
{
	
	cout << "rotate('A', 3) --> '" <<  rotate('A', 3) << "'" << endl;
	cout << "rotate('f', 5) --> '" <<  rotate('f', 5) << "'" << endl;
	cout << "rotate('z', 2) --> '" <<  rotate('z', 2) << "'" << endl;
	cout << "rotate('!', 5) --> '" <<  rotate('!', 5) << "'" << endl;

	cout << "encipher(\"I love cheese pizza!\", 5) --> \"" <<  encipher("I love cheese pizza!", 5) << "\"" << endl;
	cout << "encipher(\"Code is like humor. When you have to explain it, it's bad\", 13) --> \"" << encipher("Code is like humor. When you have to explain it, it's bad.", 13) << "\"" << endl;
	
	
	cout << " decipher(\"N qnpj yt jfy uneef.\") --> " << decipher("N qnpj yt jfy uneef.") << endl;
 
	return 0;
} 

