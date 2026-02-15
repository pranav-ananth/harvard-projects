#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

void printArray(string [], int);
void initialize(string [], int);
void quickSort(string [], int, int);
int partition(string [], int, int);

int main() {
	int n = 7;
	cout << "Enter the length of the array(nonegative int): ";
	cin >> n;
	cin.ignore(); // to stop initialization from reading this line
	string A[n];
	
	initialize(A, n);
	cout << endl << "Array Before Sorting: ";
	printArray(A, n);
	quickSort(A, 0, n-1);
	cout << "Array After Sorting:  ";
	printArray(A, n);
	
	return 0;
}

void printArray(string arr[], int n) {
	for(int i = 0; i < n; i++) {
		cout << arr[i] << "\t";
	}
	cout << endl;
}

void initialize(string arr[], int n) {
	for(int i = 0; i < n; i++) {
		cout << "Enter element #" << i+1 << ": ";
		getline(cin, arr[i]);
	}
}

void quickSort(string arr[], int start, int end) {
	if(start < end) {
		int p = partition(arr, start, end);
		quickSort(arr, start, p-1);
		quickSort(arr, p+1, end);
	}
}

int partition(string arr[], int start, int end) {
	string pivotValue = arr[start];
	int pivotPosition = start;
	for(int pos = start+1; pos <= end; pos++) {
		if(arr[pos] < pivotValue) {
			swap(arr[pivotPosition+1], arr[pos]);
			swap(arr[pivotPosition], arr[pivotPosition+1]);
			pivotPosition++;
		}
	}
	
	return pivotPosition;
}
