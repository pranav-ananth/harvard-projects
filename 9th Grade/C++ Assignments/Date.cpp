#include <iostream>
#include <string>
using namespace std;

class Date {
	private:
		int day;
		int month;
		int year;
		string getMonthName();
	public:
		Date(int d, int m, int y);
		Date();
		void printFormat1();
		void printFormat2();
		void printFormat3();
};


string Date::getMonthName() {
		switch(month) {
			case 1: return "January";
			case 2: return "February";
			case 3: return "March";
			case 4: return "April";
			case 5: return "May";
			case 6: return "June";
			case 7: return "July";
			case 8: return "August";
			case 9: return "September";
			case 10: return "October";
			case 11: return "November";
			case 12: return "December";
		}
		return "Invalid Month";
}
	
		
Date::Date(int d, int m, int y): day(d), month(m), year(y) {}

Date::Date() {
	day = 1;
	month = 1;
	year = 2001;
}

void Date::printFormat1() {
	cout << month << "/" << day << "/" << year%100 << endl;
}

void Date::printFormat2() {
	cout << getMonthName() << " " << day << ", " << year << endl; 
}

void Date::printFormat3() {
	cout << day << " " << getMonthName() << " " << year << endl;
}
		
int main() {
	Date d(11, 3, 2024);
	d.printFormat1();
	d.printFormat2();
	d.printFormat3();
}
