#include <iostream>
#include <string>
using namespace std;

void printArray(string *A, int n);
void SSort(string *A, int n);
string* addEntry(string *dynamicArray, int &size, string newEntry);
string* deleteEntry(string *dynamicArray, int &size, string entryToDelete);

int main() {
	int size = 5;
	string *A = new string[size];
	for(int i = 0; i < 5; i++) {
		cout << "Enter string for A[" << i << "]: ";
		getline(cin, A[i]);
	}
	
	printArray(A, size);
	
	string entry;
	cout << "Enter the string you would like to add: ";
	cin >> entry;
	cout << "The new array is now: " << endl;
	A = addEntry(A, size, entry);
	printArray(A, size);
	
	cout << "Enter the string you would like to delete: ";
	cin >> entry;
	cout << "The new array is now: " << endl;
	A = deleteEntry(A, size, entry);
	printArray(A, size);
}

void printArray(string *A, int n) {
	SSort(A, n);
	
	for(int i = 0; i < n; i++) {
		cout << A[i] << "\t";
	}
	cout << endl;
}

void SSort(string *A, int n) {
	int small;
	string temp;
	for(int i=0; i < n-1; i++) {
		small = i;
		for(int j=i+1; j < n; j++) {
			if(A[j] < A[small]) {
				small = j;
			}
		}
		if(small != i) {
			temp = A[i];
			A[i] = A[small];
			A[small] = temp;
		}
	}
}

string* addEntry(string *dynamicArray, int &size, string newEntry) {
	string *newArray = new string[size+1];
	
	for(int i = 0; i < size; i++) {
		newArray[i] = dynamicArray[i];
	}
	newArray[size] = newEntry;
	size++;
	delete [] dynamicArray;
	
	return newArray;
}

string* deleteEntry(string *dynamicArray, int &size, string entryToDelete) {
	bool isFound = false;
	for(int i = 0; i < size; i++) {
		if(dynamicArray[i] == entryToDelete) {
			isFound = true;
		}
	}
	
	if(isFound) {
		string *newArray = new string[size-1];
		
		for(int i = 0, j = 0; i < size; i++) {
			if(dynamicArray[i] != entryToDelete) {
				newArray[j] = dynamicArray[i];
				j++;
			}
		}
		size--;
		delete [] dynamicArray;
		return newArray;
	}
	else {
		return dynamicArray;
	}
}
