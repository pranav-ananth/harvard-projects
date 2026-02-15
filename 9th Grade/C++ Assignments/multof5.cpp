#include <iostream>
using namespace std;

void Sort(int [], int);

/*int main() {
	const int n = 9; 
	int A[n] = {2, 5, 3, 6, 2, 20, 10, 7, 9};
	Sort(A, n);
	for(int i = 0; i<n; i++) {
		cout << A[i] << "\t";
 	}
}*/
/*int findOdd(int A[], int n) {
	int counter;
	for(int i = 0; i < n; i++) {
		counter = 0;
		for(int j = 0; j < n; j++) {
			if(A[i] == A[j])
				counter++;
		}
		if(counter % 2 == 1) {
			return A[i];
		}
	}
	
}*/

//{1, 1, 2, 2, 2}

/*void reverseString(char* string, int n) {
	char temp;
	
	for(int i = 0; i < n/2; i++) {
		temp = string[i];
		string[i] = string[n-i];
		string[n-1] = temp;
	}
}*/

void Sort(int A[], int n) {
	int temp;
	for(int i = 0; i < n-1; i++) {
		for(int j = i+1; j < n; j++) {
			if(A[j] % 5 == 0) {
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
	}
}

void swap2(int A[], int n) {
	int temp;
	for(int i = 0; i < n-1; i += 2) {
		temp = A[i+1];
		A[i+1] = A[i];
		A[i] = temp;
	}
}

/*int main() {
	int n;
	do {
		cout << "Enter the length of the array: ";
		cin >> n;
	}while(n<=0);
	
	int powof2 = 2;
	int *A = new int[n];
	for(int i=0; i<n; i++) {
		A[i] = powof2;
		powof2*= 2;
	}
	
	for(int i=0; i<n; i++) {
		cout << A[i] << "\t";
	}
	cout << endl;
	
	delete [] A;
	A = NULL;
}*/

/*void matrixSwap(int A[][], int n, int m) {
	for(int i=0; i<m; i++) {
		swap(A[0][i], A[n-1][i])
	}
}*/

int main() {
	cout << 5/2;
}
