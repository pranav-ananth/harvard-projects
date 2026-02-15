#include <iostream>
using namespace std;

void printArray(int[], int);
void SSort(int[], int);
bool BSearch(int[], int, int);
bool LSearch(int[], int, int);

int main() {
	int key, A[] = {1, 7, 6, 4, 12, 3, 19, 20, 42, 93, 124, 65, 83, 56, 33, 95, 35, 16, 815};
	const int n = 20;
	
	SSort(A, n);
	cout << "Array:" << endl;
	printArray(A, n);
	
	cout << "Enter the value that you would like to search for: ";
	cin >> key;
	
	if (BSearch(A, n, key)) {
		cout << "The element was found." << endl;
	}
	else {
		cout << "The element was not found." << endl;
	}
	
	if (LSearch(A, n, key)) {
		cout << "The element was found." << endl;
	}
	else {
		cout << "The element was not found." << endl;
	}
	
	return 0;
}

void printArray(int A[], int n) {
	for(int i = 0; i < n; i++) {
		cout << A[i] << "\t";
	}
	cout << endl;
}

void SSort(int A[], int n) {
	int small;
	int temp;
	for(int i = 0; i < n-1; i++) {
		small = i;
		for(int j = i+1; j < n; j++) {
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

bool BSearch(int A[], int n, int key) {
	int mid, comparisons = 0, lbound = 0, ubound= n-1;
	bool found = false;
	
 	while (!found && lbound <= ubound) { 
		mid = (lbound + ubound)/2; // find the middlemost subscript 

		if(key < A[mid])//key is in the first half 
  			ubound = mid =1; 
 		else if (key > A[mid]) 
  			lbound = mid +1; 
  		else  
  			found = true;
  			
  		comparisons++;
 	} 
 	
 	cout << "The number of comparisons the Binary Search algorithm made was " << comparisons << "." << endl;
	if(found) 
		return true; 
	else  
		return false;
}

bool LSearch(int A[], int n, int key) {
	bool found = false;
	int comparisons = 0;
	
	for(int i=0; i < n; i++) {
		comparisons++;
		if(A[i] == key) {
			found = true;
			break;
		}
	}
	
	cout << "The number of comparisons the Linear Search algorithm made was " << comparisons << "." << endl;
	if(found) 
		return true; 
	else  
		return false;
}
