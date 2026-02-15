#include <iostream>
using namespace std;

int main() {
	int month;
	cout << "Enter a month: ";
	cin >> month;
	
	switch(month) {
		case 1:
			cout << "Not summer" << endl;
			break;
		case 2:
			cout << "Not summer" << endl;
			break;
		case 3:
			cout << "Not summer" << endl;
			break;
		case 4:
			cout << "Not summer" << endl;
			break;
		case 5:
			cout << "Not summer" << endl;
			break;
		case 6:
			cout << "June" << endl;
			break;
		case 7:
			cout << "July" << endl;
			break;
		case 8:
			cout << "August" << endl;
			break;
		case 9:
			cout << "Not summer" << endl;
			break;
		case 10:
			cout << "Not summer" << endl;
			break;
		case 11:
			cout << "Not summer" << endl;
			break;
		case 12:
			cout << "Not summer" << endl;
			break;
		default:
			cout << "Your input is out of range" << endl;
	}
	
	return 0;
}
