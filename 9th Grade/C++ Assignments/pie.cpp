#include <iostream>
using namespace std;

void printArray(int[], int);
void SSort(int[], int);
int mode(int[], int);

int main() {
	const int n = 30;
	int A[n];
	for(int i = 0; i < n; i++) {
		cout << "Enter A[" << i << "]: ";
		cin >> A[i];
	}
	
	SSort(A, n);
	cout << "The array is:" << endl;
	printArray(A, n);
	cout << "The mode of the array is " << mode(A, n);
	
	return 0;
}

void printArray(int A[], int n) {
	for(int i = 0; i < n; i++) {
		cout << A[i] << "\t";
	}
	cout << endl;
}

void SSort(int A[], int n) {
	int small, temp;
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

int mode(int A[], int n) {
	int count = 0, maxCount = 0, mode;
	for(int i = 0; i < n; i++) {
		for(int j=i; j < n; j++) {
			if(*(A+i) == *(A+j)) {
				count++;
			}
		}
		if(count > maxCount) {
			mode = *(A+i);
			maxCount = count;
		}
		count = 0;
	}
	
	return mode;
}
