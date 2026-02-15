#include <iostream>
using namespace std;

void SSort(int[], int);
void printArray(int[], int);
int removeDup(int[], int, int[]);

int main() {
	const int inpSize = 10;
	int inpA[] = {50, 60, 70, 72, 70, 85, 90, 100, 80, 85}, outA[inpSize];
	
	SSort(inpA, inpSize);
	cout << "Input Array:" << endl;
	printArray(inpA, inpSize);
	const int outSize = removeDup(inpA, inpSize, outA);
	cout << "Array with Duplicates Removed:" << endl;
	printArray(outA, outSize);
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

void printArray(int A[], int n) {
	for(int i = 0; i < n; i++) {
		cout << A[i] << "\t";
	}
	cout << endl;
}

int removeDup(int inpA[], int inpSize, int outA[]) {
	for(int i=0; i < inpSize; i++) { // initializing outA[]
		outA[i] = inpA[i];
	}
	
	int outSize = inpSize;
	for(int i=0; i < inpSize-1; i++) {
		if(inpA[i] == inpA[i+1]) {
			for(int j=i; j < outSize-1; j++) {
				outA[j] = outA[j+1];
			}
			outSize--;
		}
	}
	
	return outSize;
}
