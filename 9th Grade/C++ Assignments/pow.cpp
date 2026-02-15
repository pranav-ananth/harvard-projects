#include <iostream>
using namespace std;

float pow(float, int);
int main() {
	float p;
	int b;
	cout << "Enter the base(any float): ";
	cin >> p;
	cout << "Enter the exponent(any nonnegative int): ";
	cin >> b;
	cout << p << " to the power of " << b << " is " << pow(p, b);
	
	return 0;
}

float pow(float b, int p) {
	if(p == 0) {
		return 1;
	}
	else {
		return b * pow(b, p-1);
	}
}
