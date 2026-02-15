#include <iostream>
using namespace std;

int main() {
	int num1, num2, num3;
	cout << "Enter 3 integers: ";
	cin >> num1 >> num2 >> num3;
	
	if (num1 > num2 && num1 > num3) {
		cout << "The minimum number between " << num1 << ", " << num2 << " and " << num3 << " is " << num1 <<"." << endl;
	}
	else if (num2 > num1 && num2 > num3) {
		cout << "The minimum number between " << num1 << ", " << num2 << " and " << num3 << " is " << num2 <<"." << endl;
	}
	else if (num3 > num1 && num3 > num2) {
		cout << "The minimum number between " << num1 << ", " << num2 << " and " << num3 << " is " << num3 <<"." << endl;
	}
	else {
		cout << "One or more of the numbers are equal for the lowest value." << endl;
	}
	
	return 0;
}
