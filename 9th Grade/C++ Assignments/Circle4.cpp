/* 
Circle4.cpp
Program to create a Circle class with 
- data memeber radius
- member function area(), circumference()
- Program demonstrates 
		- default constructor
		- constructor overloading
		- the creation of Circle objects in main() using constructors
		- using the to objects to evaluate the area of circle
		- usage of scope resolution operator
@author: Anita Rathi
@Date: April 18, 2024


*/
#include<iostream>
#include<cmath>
using namespace std;

class Circle{
	private:
		double radius;
	public:
		// Default constructor
		Circle(){
			radius = 0;
		}
		//constructor overloading
		Circle(double);
		void setRadius(double); //mutator method
		double getRadius(); //accessor method
		double area();
		double circumference();

	
};
//definition of overloaded constructor
Circle:: Circle(double r){
	radius = r;
}
void Circle::setRadius(double r){
		radius=r;
	}

double Circle::area(){
	return M_PI * pow(radius,2);
	}

double Circle::getRadius(){
	return radius;
}

double Circle::circumference(){
	return 2 * M_PI * radius;
}

int main(){
	Circle circle1; //calls the default constructor
	Circle circle2(5); //calls the constructor with one double parameter
	cout<<"The area of Circle with radius " << circle1.getRadius() <<" = "<< circle1.area() << endl;
	cout<<"The area of Circle with radius " << circle2.getRadius() <<" = "<< circle2.area() << endl;
	circle1.setRadius(10);
	double r;
	cout<<"Enter radius: ";
	cin>>r;
	circle2.setRadius(r);
	cout<<"The area of Circle with radius "<< circle1.getRadius()<< " = " << circle1.area() << endl;
	cout<<"The area of Circle with radius " << r << " = " << circle2.area() <<endl;

	return 0;
}

