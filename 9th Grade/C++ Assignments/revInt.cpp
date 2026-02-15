#include <iostream>
#include <cmath>
using namespace std;

int rev(int);

int main() {
	int num;
	cout << "Enter a nonnegative number: ";
	cin >> num;
	cout << "That number reversed is " << rev(num) << ".";
	
	return 0;
}

int rev(int num) {

	if (num < 10){
		return num;
    }
    else { 	
		int lastdigit = num % 10;
		int remainingNum = num/10;
    	int power = log10(num);
		return lastdigit * pow(10, power) + rev(remainingNum);    	
   }
}
