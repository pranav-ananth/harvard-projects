#include <iostream>
#include <cmath>
using namespace std;

int main() {
	bool prime;
	
	cout << "The prime numbers between 25 and 101 are: " << endl;
	for(int n = 25; n <= 101; n++) {
		prime = true;
		
		for(int i = 2; i <= pow(n, 0.5); i++) {
			if(n % i == 0) {
				prime = false;
			}
		}
		
		if (prime) {
			cout << n << endl;
		}
	}
	
	return 0;
}
