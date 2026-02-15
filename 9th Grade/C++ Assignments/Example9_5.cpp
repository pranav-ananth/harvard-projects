/*
Example9_5.cpp
Program to demonstrate usage of 
- Constant  pointers
- Using comparison operators with pointers

@author: Anita Rathi
@Date: Feb 27, 2024
*/

#include<iostream>
using namespace std;

int main(){

	int num = 20;
	const int *ptr = &num;
	cout<<"The value of variable is " << *ptr << endl;
	int b = 90;
	ptr = &b;
	cout<<"The value of variable is " << *ptr << endl;

	const int constvar = 100;
	//int *intptr = &constvar;
	//const int *intptr = &constvar;
	//*intptr +=10;



	int array[] = { 3, 2 , 6, 8, 9};
	int *arrptr = array;

	while (arrptr < array+5){ //relational operator with pointers
		cout<< *arrptr <<"\t";
		arrptr++;
	}

}