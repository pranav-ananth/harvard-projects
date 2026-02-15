#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

int main() {
	int num;
	
	for (num = 1; num <= 50; num++) {
		cout << setw(2) << num << setw(6) << pow(num, 2) << endl;
	}
}
