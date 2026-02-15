#include<iostream>
#include "Car.h" //contains Car
using namespace std;

/* Program demonstrates Composition
*/

class Student{
	private:
	string name, id, programName;
	Car car;

	public:
	Student(){
		name = id = programName = "";
	}

	Student(Car c, string n, string i, string pn){
		car.setLicensePlate(c.getLicensePlate());
		car.setColor(c.getColor());
		car.setModel(c.getModel());
		car.setMake(c.getMake());

		name = n;
		id = i;
		programName = pn;
	}

	Car getCar(){
		return car;
	}

	string getName(){
		return name;
	}

	string getId(){
		return id;
	}

	string getProgramName(){
		return programName;
	}

	void setCar(Car c){
		car = c;
	}

	void setName(string n){
		name = n;
	}

	void setId(string i){
		id = i;
	}

	void setProgramName(string nm){
		programName = nm;
	}


};

void display(Student s){
		cout<<"Student name = "<< s.getName()<< " ID = "<< s.getId();
		cout<<" Program Name = "<< s.getProgramName()<<endl;
		cout<<"Student Car Details:\n";
		cout<<"Make = "<< s.getCar().getMake() << " Model = " << s.getCar().getModel();
		cout<<" Licese Plate = "<< s.getCar().getLicensePlate() <<" Color = " << 
		s.getCar().getColor() <<endl;

}

int main(){
	Car c1("Toyota", "Rav4", "CA RJ56", "Black");
	Student s1(c1,"Jason Torch","S4561", "BSCS");
	display(s1);
}

