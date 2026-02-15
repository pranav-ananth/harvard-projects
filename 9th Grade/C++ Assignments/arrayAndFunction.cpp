#include <iostream>
#include <string>

using namespace std;

string lookupName(string targetName, string names[], string phoneNumbers[], int nameAmount);

int main() {
	string names[4] = {"Michael Myers", "Ash William", "Jack Torrance", "Freddy Kruege"};
	string phoneNumbers[4] = {"333-8000", "333-2323", "333-6150", "333-7970"};
	string targetName, targetPhone;
	char c;
	
	do {
		cout << "Enter a name to find the corresponding phone number: ";
		getline(cin, targetName);
		targetPhone = lookupName(targetName, names, phoneNumbers, 4);	
	
		if  (targetPhone.length() > 0) {
			cout << "The number is: " << targetPhone << endl;
		}	
		else {
			cout << "Name not found." << endl;
		}
		
		cout << "Look up another game?(Y/N): ";
		cin >> c;
		cin.ignore();
	} while(c == 'Y');
	
	return 0;
}

string lookupName(string targetName, string names[], string phoneNumbers[], int nameAmount) {
	string targetPhoneNumber;
	for(int i = 0; i < nameAmount; i++) {
		if (names[i] == targetName) {
			targetPhoneNumber = phoneNumbers[i];
		}
	}
	return targetPhoneNumber;
}

