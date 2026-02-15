/* 
Example14_5.cpp
Program to 
- search for a number in  a sorted array using Binary Search method.  
- use a value returning recursive function

@author: Anita Rathi
@Date: March 21, 2024


*/
#include<iostream>

using namespace std;

int binarySearch(int *, int, int , int, int);

void create(int *, int);

void display(int *, int);

void sort(int *, int);

int main(){

	int num, key;
	cout<<"Enter the number of elements:";
	cin>> num;
	int *A = new int[num]; //dynamic integer array is created
	cout<<"Enter "<<num <<" numbers "<<endl;
	create(A,num); //function call for the input of the elements
	cout<<"The elements in the array are:"<<endl;
	display(A, num); //function call to display the original array
	sort(A, num); // sorting the array in ascending order
	cout<<"The sorted elements in the array are:"<<endl;
	display(A, num); // displaying the sorted elements in the array

	cout<<"Enter the number to be searched:";
	cin>>key;
	int result = binarySearch(A, num, 0, num-1, key);
	if( result != -1)
		cout<< key << " present at location "<< result+1 << endl;
	else
		cout<< key << " not present. " << endl;
	return 1;
	
}

void create(int *A, int n){
	for(int i = 0; i<n; i++){
		cin>>A[i];
	}
}

void display(int *A, int n){
	for(int i = 0; i<n; i++){
		cout<<A[i]<<" ";
	}
	cout<<endl;
}

void sort(int *A, int n){ //Selection Sort
	int small, i, j, temp;

	for(i =0;i<n-1; i++){
		small = i;

		for(j = i+1; j<n; j++){
			if(A[j]<A[small]){
				small = j;
			}
		}
			if(small != i){
				temp = A[i];
				A[i] = A[small];
				A[small] = temp;
			}
	}
}

/*
@param A - array
@param n - size of the array
@param low - first index in the search array
@param high - last index of the search array
@param key - number to be searched
*/

int binarySearch(int *A, int n, int low, int high, int key){
	if(low > high) //base case
		return -1;	
	int mid = (low + high)/2;
	if(key < A[mid]){ // recursive case
		return binarySearch(A, n, low, mid-1, key);	
	}
	else if(key > A[mid]){ //recursive case
		return binarySearch(A, n, mid+1, high, key);	
	}
	else{ //base case
		return mid;	
	}
	
	
}

