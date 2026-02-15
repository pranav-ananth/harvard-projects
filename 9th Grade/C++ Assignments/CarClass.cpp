#include <iostream>
#include <string>
using namespace std;

class Car {
	private:
		int year;
		string make;
		int speed;
	
	public:
		Car(int y, string m) : year(y), make(m), speed(0) {}
		
		int getYear() {
			return year;
		}
		string getMake() {
			return make;
		}
		int getSpeed() {
			return speed;
		}
		
		void accelerate() {
			speed += 5;
		}
		void brake() {
			speed -= 5;
		}
};

int main() {
	int y;
	string m;
	cout << "Enter the year of the car: ";
	cin >> y;
	cin.ignore();
	cout << "Enter the make of the car: ";
	getline(cin, m);
	
	Car car(y, m);
	cout << "Year of car: " << car.getYear() << endl;
	cout << "Make of car: " << car.getMake() << endl;
	cout << "Speed of car: " << car.getSpeed() << endl;
	
	car.accelerate();
	cout << "Speed of car after acceleration: " << car.getSpeed() << endl;
	car.brake();
	cout << "Speed of car after braking: " << car.getSpeed() << endl;
	
	return 0;
}
