#include <iostream>
using namespace std;

int main() {
	const double shares_purchased = 600;
	const double purchase_price_per_share = 21.77;
	const double selling_price_per_share = 16.44;
	
	const double total_purchase_price = shares_purchased * purchase_price_per_share;
	cout << "The total amount paid for the stock is $" << total_purchase_price << endl;
	const double total_amount_recieved = shares_purchased * selling_price_per_share;
	cout << "The total amount recieved from selling the stock is $" << total_amount_recieved << endl;
	const double net_loss = total_purchase_price - total_amount_recieved;
	cout << "The total amount of money she lost was $" << net_loss;
}
