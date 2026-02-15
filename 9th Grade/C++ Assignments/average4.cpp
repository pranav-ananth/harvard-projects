#include <iostream>
using namespace std;

int main() {
	int grade1, grade2, grade3, grade4;
	cout << "Enter 4 integer grades from 1-100, each seperated by a space: ";
	cin >> grade1 >> grade2 >> grade3 >> grade4;
	
	if (grade1 >= 0 && grade1 <= 100 && grade2 >= 0 && grade2 <= 100 && grade3 >= 0 && grade3 <= 100 && grade4 >= 0 && grade4 <= 100) {
		double average_grade = (grade1 + grade2 + grade3 + grade4) / 4.0;
		cout << "Your grades were: " << grade1 << " " << grade2 << " " << grade3 << " " << grade4 << endl;
		cout << "Your average grade is " << average_grade;
	}
	else {
		cout << "One or more of your inputs were invalid.";
	}
	
	return 0;
}
