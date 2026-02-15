#include <iostream>
#include <iomanip>
using namespace std;

int main () {
	double USD;
	const double USD_to_won = 0.00087;
	const double USD_to_yuan = 0.15;
	
	cout << "Enter an amount of U.S. dollars: $";
	cin >> USD;
	
	double won = USD / USD_to_won;
	double yuan = USD / USD_to_yuan;
	
	cout << "Your amount of U.S. dollars: $" << fixed << setprecision(2) << USD << " converts to " << won << " South Korean Won." << endl;
	cout << "Your amount of U.S. dollars: $" << USD << " converts to " << yuan << " Chinese Yuan." << endl;
}
