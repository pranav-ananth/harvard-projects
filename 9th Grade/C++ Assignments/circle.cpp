#include <iostream>
using namespace std;

int main() {
	float radius;
	
	cout << "Enter radius: ";
	cin >> radius;
	
	float area = 3.14 * radius * radius;
	float circumference = 2 * 3.14 * radius;
	
	cout << "The area of your circle is: " << area << endl;
	cout << "The perimeter of your circle is: " << circumference;
}
