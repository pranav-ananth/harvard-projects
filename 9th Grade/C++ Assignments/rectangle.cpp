#include <iostream>
using namespace std;

int main() {
	float length, breadth;
	cout << "Enter Length: ";
	cin >> length;
	cout << "Enter Breadth: ";
	cin >> breadth;
	
	float area, perimeter;
	area = length * breadth;
	perimeter = 2 * (length + breadth);
	
	cout << "Area of rectangle: " << area << endl;
	cout << "Perimeter of rectangle: " << perimeter;
}
