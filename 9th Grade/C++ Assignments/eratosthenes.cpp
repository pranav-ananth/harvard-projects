#include <iostream>
using namespace std;

int main() {
	const int arrayLength = 99;
	int arrayOfPrimes[arrayLength];
	
	// create the array
	for(int i = 1; i <= arrayLength; i++) {
		arrayOfPrimes[i] = i + 1;
	}
	
	for(int i = 1; i <= arrayLength; i++) {
		if (arrayOfPrimes[i] != 0) {
			for(int j = i + arrayOfPrimes[i]; j <= 100; j+= arrayOfPrimes[i]) {
				arrayOfPrimes[j] = 0;
			}
		}
	}
	
	cout << "The prime numbers from 2 to 100 are:" << endl;
	for(int i = 1; i <= arrayLength; i++) {
		if (arrayOfPrimes[i] != 0) {
			cout << arrayOfPrimes[i] << endl;
		}
	}
	
	return 0;
}
