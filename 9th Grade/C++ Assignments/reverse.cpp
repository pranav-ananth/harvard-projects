#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int num, digits, reverse_num, reverse_digit;
	bool negative_number = false;
	
	cout << "Enter an integer: ";
	cin >> num;
	
	if (num < 0) {
		negative_number = true;
	}
	num = abs(num);
	
	digits = log10(num) + 1;
	for(int i = 1; i <= digits; i++) {
		reverse_digit = (int)(num / pow(10, digits - i)) % 10;
		reverse_num += reverse_digit * pow(10, i - 1);
	}
		
	if (negative_number) {
		reverse_num *= -1;
		num *= -1;
	}
	
	cout << num << "->" << reverse_num;
	
	return 0;
}
