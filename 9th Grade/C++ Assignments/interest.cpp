#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

int main() {
	double Final_Balance, Initial_Balance, Interest_Rate, Times_Compounded;
	
	cout << "Enter Initial Balance: $";
	cin >> Initial_Balance;
	cout << "Enter Interest Rate: ";
	cin >> Interest_Rate;
	cin.ignore();
	cout << "Enter Times Compounded Anually: ";
	cin >> Times_Compounded;
	cout << endl;
	
	cout << "Initial Balance: $" << Initial_Balance << endl;
	cout << "Interest Rate: " << Interest_Rate << "%" << endl;
	cout << "Times Compounded Anually: " << Times_Compounded << endl;
	
	const double Interest_In_A_Year = (1 + (Interest_Rate / 100) / Times_Compounded);
	const double Total_Interest = pow(Interest_In_A_Year, Times_Compounded);
	Final_Balance = Initial_Balance * Total_Interest;
	
	cout << "Final Balance: $" << Final_Balance;
	
	return 0;
}
