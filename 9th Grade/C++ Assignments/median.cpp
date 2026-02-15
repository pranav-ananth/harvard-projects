#include <iostream>
using namespace std;

void printArray(int[], int);
void SSort(int[], int);
double median(int[], int);

int main() {
	int n;
	do {
		cout << "Enter the number of elements the array has(6-10): ";
		cin >> n;
	} while(n < 6 || n > 10);
	int A[n];
	for(int i = 0; i < n; i++) {
		cout << "Enter A[" << i << "]: ";
		cin >> A[i];
	}
	
	SSort(A, n);
	printArray(A, n);
	cout << "The median of the array is " << median(A, n);
	
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

double median(int A[], int n) {
	double median;
	if(n % 2 == 0) {
		median = (*(A + (n/2 - 1)) + *(A + (n/2)))/2.0;
	}
	else {
		median = *(A + (n/2));
	}
	return median;
}
