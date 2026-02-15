#include <iostream>
#include <cmath>
using namespace std;

int main () {
	int a, b, c;
	cout << "a=";
	cin >> a;
	cout << "b=";
	cin >> b;
	cout << "c=";
	cin >> c;
	
	const double discriminant = pow(b, 2.0) - (4*a*c);
	
	double root1, root2;
	root1 = (-b + pow(discriminant, 0.5))/(2*a);
	root2 = (-b - pow(discriminant, 0.5))/(2*a);
	
	if (discriminant > 0) {
		cout << "The equation has two solutions, " << root1 << " and " << root2 << "." << endl;
	}
	else if (discriminant == 0) {
		cout << "The equation has one solution, " << root1 << "." << endl;
	}
	else {
		cout << "There are no solutions." << endl;
	}
	
	return 0;
}
