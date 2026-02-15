/* Example8_8.cpp
  	Author- Anita Rathi
  	This program demonstrates  :
  - Linear Search algorithm
  - array of strings
  - typedef
 
 */

#include<iostream>
#include<cstdio> // required for fflush()
using namespace std;

typedef string list[10]; // alias for string[10]

typedef int numbers;// alias for int is numbers

//syntax typedef datatype alias;

//synatx typedef datatype alias[size];

void Display(list, numbers); 
void Input(list, numbers & );
int LSearch(list, numbers, string);

int main()
{		int n=10;
		
		list A; //Array declaration
		Input(A,n);
		cout<<"Enter the name to be searched: ";
		string searchKey;
		cin>>searchKey;
		fflush(stdin);
		int found = LSearch(A, n, searchKey);
		if( found != -1){
			cout<< searchKey << " is present at location " << found + 1 << endl;
		}
		else{
			cout << searchKey << " not present in the array." <<endl;
		}
		cout<<"The elements in the array after the input are\n";
		Display(A,n);
		return 0;	
		
}

void Input(list B, numbers &size){

		do{ //validating the value of n is in the range of 1 -7
			cout<<" Enter the number of the elements <=10: ";
			cin>>size;
		}while(size <= 0 ||  size > 10);

			cout<<"Enter the elements "<<endl;
			fflush(stdin);
			for (int i =0; i<size;i++){
				getline(cin,B[i]);
				fflush(stdin);
			} 	
			
}

int LSearch (list A, numbers n,  string key){
	int found  = -1;
	int i = 0;
	while(found == -1 && i < n){
		if(A[i] == key) // comparing
			found = i;
		else
			i++;
	}
	return found;
}


void Display(list A, numbers size){
	for(int i=0; i<size; i++){
		cout<< A[i] << "\t";
	}
	cout<<endl;

}

