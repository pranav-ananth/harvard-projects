#include <iostream>
using namespace std;

int factorial(int num);
int C(int n, int k); // combination function

int main() {
	for(int i = 0; i <= 6; i++) {
		for(int k = 6 - i; k > 0; k--) {
			cout << " "; // used to create the spaces for the pyramid
		}
		for(int j = 0; j <= i; j++) {
			cout << C(i,j) << " ";
		}
		cout << endl;
	}
}

int factorial(int num) {
	int factorial = 1;
	for(int i = num; i > 1; i--) {
		factorial *= i;
	}
	return factorial;
}
int C(int n, int k) {
	if (k == 0 || k == n) {
		return 1;
	}
	else {
		int combination = factorial(n) / (factorial(k) * factorial(n-k));
		return combination;	
	}
}
