/*
Example9-4.cpp
Program to demonstrate usage of 
- Mathematical operations on pointers

@author: Anita Rathi
@Date: Feb 27, 2024
*/
#include<iostream>

using namespace std;

int main(){
	int *ptr;
	int a =10;
	ptr = &a;
	float s = 45.8;
	//ptr = &s;

	void *ptr3;
	ptr3= &s;
	cout<< "val1 = " << ptr << endl;
	cout<< "Increment operation on pointer = " << ptr++ <<endl;
	cout<<" value of pointer = "<< ptr << endl;
	cout<< "Decrement operation on pointer = " << --ptr <<endl;

	/*
	ptr3 = &a;
	cout<< "Increment operation on pointer = " << ++ptr <<endl;
	cout << "val2 =" << ptr3 <<endl;

	*/

	int b,c, *ptr2=&b;
	a = b = c = 10;	
	cout<<" value of pointer = "<< ptr << endl;
	cout<< "Increment operation on pointer = " << ptr++ <<endl;
	cout<<" value opf pointer = "<< ptr << endl;
	cout<< "Decrement operation on pointer = " << --ptr <<endl;
	cout<< "Division operation on pointer" <<ptr/2 <<endl;
	ptr *= 4;
	cout<< "Multiplication operation on pointer = " <<ptr <<endl;
	int x = 2;
	ptr +=x;
	cout<< "Addition operation on pointer = " <<ptr  <<endl; */
}