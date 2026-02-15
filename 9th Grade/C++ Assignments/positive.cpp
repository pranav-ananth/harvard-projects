#include <iostream>
using namespace std;

int main() {
	int num;
	char repeat = 'y';
	
	while (repeat == 'y' || repeat == 'Y') {
		cout << "Enter an integer: ";
		cin >> num;
	
		if (num >= 0) {
			cout << "The number " << num << " is positive and its absolute value is " << num << "." << endl;
		}
		else {
			int abs_num = (-1) * num;
			cout << "The number " << num << " is negative and its absolute value is " << abs_num << "." << endl;
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
	
	cout << "Adios!";
	return 0;
}
