#include <iostream>
using namespace std;
int main() {
	int num1, num2, i;
	int result = 0;
	cout << "Enter two numbers to multiply: ";
	cin >> num1 >> num2;
	
	if (num1 < 0) {
		for (i = 1; i <= -num1; i++) {
			result = result - num2;
		}
	}
	else if (num1 > 0) {
		for (i = 1; i <= num1; i++) {
			result = result + num2;
		}
	}
	
	cout << num1 << " multiplied by " << num2 << " is " << result;
}
