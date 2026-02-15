#include <iostream>
using namespace std;

void equation(double num1, double num2, char operation);

int main() {
	double num1, num2;
	char operation;
	char repeat;
	
	do {
		cout << "Enter the operation you want to do: Addition(+), Subtraction(-), Multiplication(*), or Division(/): ";
		cin >> operation;
		cout << "Enter the first number: ";
		cin >> num1;
		cout << "Enter the second number: ";
		cin >> num2;
	
		equation(num1, num2, operation);
		
		cout << "Again? (y/n): ";
		cin >> repeat;
	} while(repeat == 'Y' || repeat == 'y');

	return 0;
}

void equation(double num1, double num2, char operation) {
	if (operation == '+' ) {
		cout << num1 << " + " << num2 << " = " << num1 + num2 << endl;
	}
	else if (operation == '-' ) {
		cout << num1 << " - " << num2 << " = " << num1 - num2 << endl;
	}
	else if (operation == '*' ) {
		cout << num1 << " * " << num2 << " = " << num1 * num2 << endl;
	}
	else if (operation == '/' ) {
		if (num2 == 0) {
			cout << "Error: Cannot divide by zero." << endl;
			return;
		}
		else {
			cout << num1 << " / " << num2 << " = " << num1 / num2 << endl;
		}
	}
	else {
		cout << "Error: Invalid operation." << endl;
		return;
	}
}
