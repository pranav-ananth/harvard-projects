/* 
Circle4.cpp
Program to create a Circle class with 
- data memeber radius
- member function Area()
- Program demonstrates 
		- constructors
		- destructors
		- the creation of Circle objects in main() 
		- using the objects to evaluate the area and circumference of the circle
		- usage of scope resolution operator
@author: Anita Rathi
@Date: April 16, 2024


*/
#include<iostream>
#include<cmath>
using namespace std;

class Circle{
	private:
		double radius;
	public:
		Circle(){
			radius = 0;
		}
		Circle(double r):radius(r)
		{}

		//destructor definition
		~Circle(){
			cout<<"the destructor is running"<<endl;
		}
		void setRadius(double); //mutator method
		double getRadius(); //accessor method
		double area();
		double circumference();

	
};

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
	Circle circle1, circle2(5);
	cout<<"The area of Circle with radius " << circle1.getRadius() <<" = "<< circle1.area() << endl;
	cout<<"The area of Circle with radius " << circle2.getRadius() <<" = "<< circle2.area() << endl;
	circle1.setRadius(10);
	double r;
	cout<<"Enter radius: ";
	cin>>r;
	circle2.setRadius(r);
	cout<<"The area of Circle with radius 5 = "<< circle1.area() << endl;
	cout<<"The area of Circle with radius " << r << " = " << circle2.area() <<endl;

	return 0;
}


