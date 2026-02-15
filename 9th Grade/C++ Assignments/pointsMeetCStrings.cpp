#include <iostream>
#include <cstring>
using namespace std;

void reverseString(char*);

int main() {
	const int MAX_SIZE = 50;
	char string[MAX_SIZE];
		cout << "Enter a string: ";
		cin.getline(string, MAX_SIZE);
		reverseString(string);
		cout << "The reversed string is: " << string << endl;

}

void reverseString(char* string) {
	int size = strlen(string);
	char *front = string;
	char *rear = string+size-1;
	char temp;
	
	for(int i = 0; i < size/2; i++) {
		temp = *front;
		*front = *rear;
		*rear = temp;
		
		front++;
		rear--;
	}
}
