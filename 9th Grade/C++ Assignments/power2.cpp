#include <iostream>
#include <cmath>
using namespace std;

int main() {
	const int size = 6;
	int power[size];
	for (int i = 0; i < size; i++) {
		power[i] = pow(2, i);
		cout << power[i] << " ";
	}
}
