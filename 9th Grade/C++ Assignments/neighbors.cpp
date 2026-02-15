#include <iostream>
using namespace std;

bool checkNeighbors(int x, int y, int array[][5]);

int main() {
	const int size = 3;
	int  array[size+2][size+2];
	bool greaterThanNeighbors;
	
	for(int i = 0; i <= size+1; i++) { // creating the array
		for(int j = 0; j <= size+1; j++) {
						array[i][j] = -1;
						
		}
	}
	
					
	for(int i = 1; i <= size; i++) { // creating the array
		for(int j = 1; j <= size; j++) {
				cout << "Enter the value of (" << i-1 << ", " << j-1 << "): ";
				cin >> array[i][j];
		}
	}
	
	cout << "The array is:" << endl; // display the array
	for(int i = 1; i <= size; i++) {
		for(int j = 1; j <= size; j++) {
			cout << array[i][j] << "\t";
		}
		cout << endl;
	}
	
	cout << "The elements that are greater than all their neighbors are: " << endl;
	for(int i = 1; i <= size; i++) {
		for(int j = 1; j <= size; j++) {
			greaterThanNeighbors = checkNeighbors(i, j, array);
			if (greaterThanNeighbors) {
				cout << array[i][j] << " in location (" << i-1 << ", " << j-1 << ")" << endl;
			}
		}
	}
	
	return 0;
}



bool checkNeighbors(int x, int y, int array[][5]) {
	int currentNumber = array[x][y];
	for(int i = x-1; i <= x+1; i++) {
		for(int j = y-1; j <= y+1; j++) {
			if(x == i && y == j) {
			}
			else {
				if (array[i][j] >= currentNumber) {
					return false;
				}
			}
		}
	}
	
	return true;
}
