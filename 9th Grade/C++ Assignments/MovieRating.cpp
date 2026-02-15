#include <iostream>
#include <string>
using namespace std;

class Movie {
	private:
		string name;
		string MPAA;
		int rate1;
		int rate2;
		int rate3;
		int rate4;
		int rate5;
	
	public:
		Movie(string n, string m): name(n), MPAA(m), rate1(0), rate2(0), rate3(0), rate4(0), rate5(0) {}
		
		string getName() {
			return name;
		}
		string getMPAA() {
			return MPAA;
		}
		
		void setName(string n) {
			name = n;
		}
		void setMPAA(string m) {
			MPAA = m;
		} 
		
		void addRating(int r) {
			switch(r) {
				case 1: rate1++;
						break;
				case 2: rate2++;
						break;
				case 3: rate3++;
						break;
				case 4: rate4++;
						break;
				case 5: rate5++;
						break;
				default: cout << "Your rating is not from 1-5." << endl;
			}
		}
		double getAverage() {
			return (rate1 + 2*rate2 + 3*rate3 + 4*rate4 + 5.0*rate5)/(rate1 + rate2 + rate3 + rate4 + rate5);
		}
};

int main() {
	string name, rating;
	int r;
	
	for(int i = 0; i < 2; i++) {
		cout << "Enter a movie name: ";
		getline(cin, name);
		cout << "Enter the MPAA rating of the movie: ";
		getline(cin, rating);
		Movie movie1(name, rating);
		for(int j = 0; j < 5; j++) {
			cout << "Enter the rating you want to give this movie: ";
			cin >> r;
			movie1.addRating(r);
		}
		cout << "Movie Name: " << movie1.getName() << endl;
		cout << "MPAA Rating: " << movie1.getMPAA() << endl;
		cout << "Average Rating: " << movie1.getAverage() << endl;
		
		cout << endl;
		cin.ignore();
	}
	
	return 0;
}
