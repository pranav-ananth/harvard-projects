/*
Example9_3.cpp
Program to demonstrate usage of 
- Pointers as parameters to functions
- Functions with return type as a pointer
- Constant Pointers
- Dangling Pointers - nullptr

@author: Anita Rathi
@Date: Feb 27, 2024
*/

#include<iostream>
using namespace std;


int sumElementsArray(int *);
void display(const int *);


int main(){
	int a;
	
	int array[] = { 4, 3, 8, 9,7};

	int sum= sumElementsArray(array);
	cout<<"The sum of the elements in the array are:" << sum<<endl;
	
	display(array);
	
	return 0;
	
}


int sumElementsArray(int *temp){ //the parameter is a pointer
	
	int sum = 0;
	
	for(int i= 0; i<5; i++){
		sum = sum + *temp;
		temp++;
	}
	return sum;
}


void display(const int *temp){ //the parameter is a pointer
	
	for(int i= 0; i<5; i++){
		cout<< *temp++ <<endl;
	}
}

