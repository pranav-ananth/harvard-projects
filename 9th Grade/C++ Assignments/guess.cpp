#include <iostream>
#include <string>
using namespace std;

int main() {
	int mid, lower = 1, upper = 50;
	bool found = false;
	char input;
	
	cout << "Think of a number in the range of 1-50 and I'll guess it." << endl;
	while(!found) {
		mid = (upper + lower) / 2;
		cout << "Is the number " << mid << "?(y/n) ";
		cin >> input;
		
		if (input == 'Y' || input == 'y') {
			found = true;
			cout << "I have succeeded in guessing your number!";
		}
		else {
			cout << "Is the number lower than " << mid << "?(y/n) ";
			cin >> input;
			if (input == 'Y' || input == 'y') {
				upper = mid - 1;
			}
			else {
				lower = mid + 1;
			}
		}
	}
} 
