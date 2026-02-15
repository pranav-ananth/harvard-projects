#include <iostream>
#include <string>
using namespace std;

void SSort(string A[], int n);
void printArray(string A[], int n);
int BSearch(string A[], int n, string key);

int main() {
	int n = 6;
	string A[] = {"Hello", "Great", "Large", "Antidisestablishmentarianism", "Bubble", "Selection"};
	string searchString;
	cout << "Array: ";
	printArray(A, n);
	SSort(A, n);
	cout << "Sorted Array: ";
	printArray(A, n);
	
	cout << endl;
	cout << "Enter a string you want to search: ";
		getline(cin, searchString);
	if (BSearch(A, n, searchString) == -1) {
		cout << "String not found." << endl;		
	}
	else {
		cout << "Your string was found." << endl;
	}
	
	return 0;
} 

void SSort(string A[], int n) {
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

void printArray(string A[], int n) {
	for(int i = 0; i < n; i++) {
		cout << A[i] << "\t";
	}
	cout << endl;
}

int BSearch(string A[], int n, string key) {
	int mid, lbound = 0, ubound = n-1;
	bool found = false;
	
	while(!found && lbound <= ubound) {
		mid = (lbound+ubound)/2;
		
		if (key < A[mid]) {
			ubound = mid - 1;
		}
		else if (key > A[mid]) {
			lbound = mid + 1;
		}
		else {
			found = true;
		}
	}
	
	if(found) {
		return mid;
	}
	else
		return -1;
}
