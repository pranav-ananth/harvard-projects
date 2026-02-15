#include <iostream>
using namespace std;

int handshake(int);


int main() {
	int n;
	cout << "Enter the number of people in the room: ";
	cin >> n;
	cout << "The number of handshakes made is " << handshake(n);
	
	return 0;
} 

int handshake(int n) {
	if(n <= 1) {
		return 0;
	}
	return (n-1)+handshake(n-1);
}
