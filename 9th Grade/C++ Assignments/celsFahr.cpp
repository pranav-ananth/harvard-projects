#include <iostream>
#include <iomanip>
using namespace std;

int main() {
	double fahrenhiet = 0;
	double celsius;
	cout << left << setw(13) << "Fahrenhiet" << "Celsius" << endl;
	while (fahrenhiet <= 200) {
		celsius = (5 * (fahrenhiet - 32)) / 9;
		
		cout << setw(13) << fixed << setprecision(0) << fahrenhiet;
		cout << setprecision(1) << celsius << endl;
		fahrenhiet += 20;
	}
	
}
