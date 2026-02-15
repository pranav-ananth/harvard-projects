#include <iostream>
#include <cstdlib>
#include <ctime>
#include <cmath>
using namespace std;

int main() {
	srand(time(0));
	int totalRoll, targetRoll = 300, averageOfTests, iterations = 10000;
	double cc = 11.3*100, critMult = 415.95/100, time = 0, currentRoll;
	
	for(int i = 0; i < iterations; i++) {
		currentRoll = 0;
		totalRoll = 0;
		while(totalRoll < targetRoll) {
			currentRoll = (rand() % 6)+1;
			if((rand() % 10000)+1 <= cc) {
				currentRoll *= critMult;
				currentRoll = round(currentRoll);
			}
			if(currentRoll == 6) {
				currentRoll = 0;
				totalRoll = 0;
				time += 60;
			}
			else {
				totalRoll += currentRoll;
				time++;	
			}
		}
	}
	
	cout << time/(iterations*3600);
}
