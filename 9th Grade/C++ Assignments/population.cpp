#include <iostream>
using namespace std;

void population(int starting_organisms, double daily_increase, int days);

int main() {
	bool correct_inputs;
	int starting_organisms, days;
	double daily_increase;
	
	do {
		cout << "Enter the starting amount of organisms: ";
		cin >> starting_organisms;
		cout << "Enter the daily increase in a %: ";
		cin >> daily_increase;
		cin.ignore(); // makes cin ignore the %
		cout << "Enter the amount of days tested: ";
		cin >> days;
	
		if (starting_organisms < 0) {
			cout << "Error: Invalid amount of starting organisms. Please try again." << endl << endl;
			correct_inputs = false;
		}
		if (days < 0) {
			cout << "Error: Invalid amount of starting organisms. Please try again." << endl << endl;
			correct_inputs = false;
		}
	} while (correct_inputs);
	
	for (int i = 1; i <= days; i++) {
		population(starting_organisms, daily_increase, i);
	}
		
	
	return 0;
}

void population(int starting_organisms, double daily_increase, int days) {
	double final_organisms = starting_organisms;
	
	for (int i = 2; i <= days; i++) {
		final_organisms *= (1 + daily_increase/100);
	}
	
	final_organisms = static_cast<int>(final_organisms); //the amount of organisms needs to be an integer
	
	cout << "Day " << days << ": " << final_organisms << endl;
}
