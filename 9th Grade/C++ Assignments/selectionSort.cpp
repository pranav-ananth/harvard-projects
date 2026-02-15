#include <iostream>
using namespace std;

const int n = 7;

void Initialize(int a[]);
void SelectionSort(int a[]);
int FindMax(int a[], int end);
void Swap(int a[], int p1, int p2);
void Display(int a[]);

int main() {
	int a[n];
	Initialize(a);
	SelectionSort(a);
	Display(a);
	
	return 0;
}

void Initialize(int a[]) {
	int i;
	cout << "Enter the elements of the arrray." << endl;
	cout << "(The array has " << n << " elements)." << endl;
	for(i = 0; i < n; i++) {
		cout << "a[" << i << "]=";
		cin >> a[i];
	}
}	

void SelectionSort(int a[]) {
	int i, index;
	int cycle = 1;
	for(i = 0; i < n - 1; i++, cycle++) {
		index = FindMax(a, n - i);
		Swap(a, n - i - 1,  index);
	}
}

void Display(int a[]) {
	int i;
	cout << "The array: " << endl;
	
	for(i = 0; i < n; i++) {
		cout << "a[" << i << "]=" << a[i] << endl;
	}
}

int FindMax(int a[], int end) {
	int max = 0;
	for(int i =0; i < end; i++) {
		if(a[i] > a[max])
		max = i;
	}
	return max;
}

void Swap(int a[], int p1, int p2) {
	int temp = a[p1];
	a[p1] = a[p2];
	a[p2] = temp;
}

