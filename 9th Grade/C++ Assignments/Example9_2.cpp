/*
Example9_2.cpp
Program to demonstrate usage of 
- Pointers as parameters to functions
- Constant Pointers
- Dangling Pointers - nullptr

@author: Anita Rathi
@Date: Feb 27, 2024
*/

#include<iostream>
using namespace std;

void swap(int *, int *);

int main(){
	int a, b;
	cout<<"enter two numbers:";
	cin>>a>>b;
	cout<<"The value of the variables before swapping are:\n";
	cout<<"First variable = "<< a << " Second variable = "<<b<<endl;
	//using address of variable as actual parameters
	
	swap(&a,&b); //pass the address of the variables as arguments
	
	cout<<"The value of the variables after swapping are:\n";
	cout<<"First variable = "<< a << " Second variable = "<<b<<endl;


	int *xptr, *yptr;
	cout<<"enter two numbers:";
	
	cin>> *xptr>> *yptr;
	cout<<"The value stored in pointers before swapping are:\n";
	cout<<"First variable = "<< *xptr << " Second variable = "<< *yptr <<endl;
	//Using pointers as actual parameter
	swap( xptr, yptr); // notice the pointers are passed without indirection operator
	cout<<"The value of the variables after swapping are:\n";
	cout<<"First variable = "<< *xptr << " Second variable = "<< *yptr <<endl;

	xptr = nullptr; 
	yptr = nullptr;

	return 0;
	
}

void swap(int *x, int *y){

	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
}





