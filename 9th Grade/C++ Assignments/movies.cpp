#include <iostream>
using namespace std;

void printArray(int[], int);
void SSort(int[], int);
double mean(int[], int);
double median(int[], int);
int mode(int[], int);

int main() {
	int size;
	do {
		cout << "Enter the size of the array: ";
		cin >> size;
	} while(size <= 0);
	
	int *A = new int(size);
	
	for(int i = 0; i < size; i++) {
		cout << "Enter the amount of movies for A[" << i << "]: ";
		cin >> A[i];
	}
	
	SSort(A, size);
	cout << "The array of movie statistics is:" << endl;
	printArray(A, size);
	
	cout << "The mean of the array is " << mean(A, size) << endl;
	cout << "The median of the array is " << median(A, size) << endl;
	cout << "The mode of the array is " << mode(A, size) << endl;
	
	delete [] A;
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

double mean(int A[], int n) {
	double mean = 0;
	
	for(int i = 0; i < n; i++) {
		mean += A[i];
	}
	mean /= n;
	
	return mean;
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

int mode(int A[], int n) {
	int count = 0, maxCount = 0, mode;
	for(int i = 0; i < n; i++) {
		for(int j=i; j < n; j++) {
			if(A[i] == A[j]) {
				count++;
			}
		}
		if(count > maxCount) {
			mode = A[i];
			maxCount = count;
		}
		count = 0;
	}
	
	return mode;
}
