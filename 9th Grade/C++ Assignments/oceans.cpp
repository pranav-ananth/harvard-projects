#include <iostream>
using namespace std;

int main() {
	const double ocean_level_rise_per_year_in_mm = 3.1;
	const double number_of_years = 20;
	const double net_ocean_level_rise_mm = ocean_level_rise_per_year_in_mm * number_of_years;
	
	const double mm_to_cm = 10;
	const double net_ocean_level_rise_cm = net_ocean_level_rise_mm / mm_to_cm;
	const double cm_to_inches = 2.54;
	const double net_ocean_level_rise_inches = net_ocean_level_rise_cm / cm_to_inches;
	
	cout << "The ocean will rise " << net_ocean_level_rise_cm << " centimeters in the next 20 years." << endl;
	cout << "The ocean will rise " << net_ocean_level_rise_inches << " inches in the next 20 years.";
}
