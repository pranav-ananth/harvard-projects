#include <iostream>
using namespace std;

class Inventory {
	private:
		int itemNumber;
		int quantity;
		double cost;
	public:
		// constructors
		Inventory(): itemNumber(0), quantity(0), cost(0) {}
		Inventory(int i, int q, double c) {
			setItemNumber(i);
			setQuantity(q);
			setCost(c);
		}
		
		// accessors
		int getItemNumber() {return itemNumber;}
		int getQuantity() {return quantity;}
		double getCost() {return cost;}
		
		// mutators
		void setItemNumber(int i) {itemNumber = i;}
		void setQuantity(int q) {quantity = q;}
		void setCost(double c) {cost = c;}
		
		// additional functions
		double getTotalCost() {return quantity * cost;}
};

int main() {
	Inventory inventory;
	int i, q;
	double c;
	
	cout << "Enter the item number: ";
	cin >> i;
	inventory.setItemNumber(i);
	cout << "Enter the quantity of the item: ";
	cin >> q;
	inventory.setQuantity(q);
	cout << "Enter the cost of the item: $";
	cin >> c;
	inventory.setCost(c);
	
	cout << endl << "Item Number: " << inventory.getItemNumber() << endl;
	cout << "Quantity: " << inventory.getQuantity() << endl;
	cout << "Cost per Item: $" << inventory.getCost() << endl;
	cout << "Total Inventory Cost: $" << inventory.getTotalCost();
	
	return 0;
}
