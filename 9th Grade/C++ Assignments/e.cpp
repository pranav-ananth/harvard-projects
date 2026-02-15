#include <iostream>
using namespace std;

int main() {

int integer1 = 19,
integer2 = 2;
double doubleVal;
doubleVal = integer1 / integer2;
cout << doubleVal << endl;
doubleVal = static_cast<double>(integer1) / integer2;
cout << doubleVal << endl;
doubleVal = static_cast<double>(integer1 / integer2);
cout << doubleVal << endl;
}
