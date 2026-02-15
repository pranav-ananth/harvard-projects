#include <iostream>
using namespace std;

double getSales(double &div);
void findHighest(double div1, double div2, double div3, double div4);

int main() {
	double ne_div, se_div, nw_div, sw_div;
	
	getSales(ne_div);
	getSales(se_div);
	getSales(nw_div);
	getSales(sw_div);
	
	findHighest(ne_div, se_div, nw_div, sw_div);
	
	return 0;
}

double getSales(double &div) {
	bool invalid;
	do {
		invalid = false;
		cout << "Enter the sales figure of the chosen division: $";
		cin >> div;
		
		if (div < 0) {
			cout << "Error: Sales figure below zero. Enter another input." << endl;
			invalid = true;
		}
	} while(invalid);
}

void findHighest(double div1, double div2, double div3, double div4) {
	if (div1 >= div2 && div1 >= div3 && div1 >= div4) {
		cout << "The Northeast division grossed the highest with $" << div1 << "." << endl;
	}
	else if (div2 >= div3 && div2 >= div4) {
		cout << "The Southeast division grossed the highest with $" << div2 << "." << endl;
	}
	else if (div3 >= div4) {
		cout << "The Northwest division grossed the highest with $" << div3 << "." << endl;
	}
	else {
		cout << "The Southwest division grossed the highest with $" << div4 << "." << endl;
	}
}
