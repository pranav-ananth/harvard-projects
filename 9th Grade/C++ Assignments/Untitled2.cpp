#include <iostream>
using namespace std;

int main() {
	int a[5] = {0, 10, 20, 30, 40}; 
	int k = 3; 
	int *p = a + 1;
	
	cout << a[*a] << endl;
	cout << a[*a + 2]<<endl;
	cout << *p<<endl;
	cout << p[0]<<endl;
	cout << p[1]<<endl;
}
