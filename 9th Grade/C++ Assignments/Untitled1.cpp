#include <iostream>
using namespace std;

int main() {
	double y = 900;
	for(int i = 0; i < 4; i++) {
		y = y + 0.0625*0.03*y;
	}
	cout << y;
}
