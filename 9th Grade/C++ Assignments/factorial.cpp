#include <iostream>
using namespace std;

int main() {
	int n, i;
	int factorial = 1;
	
	cout << "Enter an integer n: ";
	cin >> n;
	
	if (n < 0) {
		cout << "Invalid input." << endl;
	}
	else if (n == 0) {
		cout << "0! = 1" << endl; 
	}
	
	for(i = 1; i <= n; i++) {
		factorial = factorial * i;
		cout << i << "! = " << factorial << endl;
	}
	
	return 0;
}
