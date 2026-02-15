#include <iostream>
using namespace std;

int main() {
	int num1, num2;
	char repeat = 'y';
	
	while (repeat == 'y' || repeat == 'Y') {
		cout << "Enter two integers: ";
		cin >> num1 >> num2;
	
		if (num1 == num2) {
			cout << "The two numbers " << num1 << " and " << num2 << " are equal." << endl;
		}
		else {
			cout << "The maximum number between " << num1 << " and " << num2 << " is ";
		
			if (num1 > num2) {
				cout << num1 << "." << endl;
			}
			else {
				cout << num2 << "." << endl;
			}
		}
		
		repeat = 'a';
		
		while (repeat != 'n' && repeat != 'N' && repeat != 'y' && repeat != 'Y') {
			cout << "Again(y/n)? ";
			cin >> repeat;
		
			if (repeat != 'n' && repeat != 'N' && repeat != 'y' && repeat != 'Y') {
				cout << "Invalid result. Please try again." << endl;
			}
		}
	}
	
	cout << "Good bye!";
	return 0;
}
