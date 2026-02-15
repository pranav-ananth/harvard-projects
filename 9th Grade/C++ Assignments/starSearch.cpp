#include <iostream>
using namespace std;

void getJudgeData(double &score);
double calcScore(double s1, double s2, double s3, double s4, double s5);
double findLowest(double s1, double s2, double s3, double s4, double s5);
double findHighest(double s1, double s2, double s3, double s4, double s5);

int main() {
	double score1, score2, score3, score4, score5;
	getJudgeData(score1);
	getJudgeData(score2);
	getJudgeData(score3);
	getJudgeData(score4);
	getJudgeData(score5);
	cout << "The contestant's score is " << calcScore(score1, score2, score3, score4, score5) << "." << endl;
	
	return 0;
}

void getJudgeData(double &score) {
	bool valid;
	do {
		cout << "Enter a score between 0 and 10: ";
		cin >> score;
		
		if (score >= 0 && score <= 10) {
			valid = true;
		}
		else {
			valid = false;
			cout << "Invalid result. Please try again." << endl;
		}
	} while(valid == false);
}

double calcScore(double s1, double s2, double s3, double s4, double s5) {
	double average = (s1 + s2 + s3 + s4 + s5 - findLowest(s1, s2, s3, s4, s5) - findHighest(s1, s2, s3, s4, s5)) / 3;
	return average;
}

double findLowest(double s1, double s2, double s3, double s4, double s5) {
	double min = s1;
	if (s2 < min) {
		min = s2;
	}
	if (s3 < min) {
		min = s3;
	}
	if (s4 < min) {
		min = s4;
	}
	if (s5 < min) {
		min = s5;
	}
	return min;
}

double findHighest(double s1, double s2, double s3, double s4, double s5) {
	double max = s1;
	if (s2 > max) {
		max = s2;
	}
	if (s3 > max) {
		max = s3;
	}
	if (s4 > max) {
		max = s4;
	}
	if (s5 > max) {
		max = s5;
	}
	return max;
}
