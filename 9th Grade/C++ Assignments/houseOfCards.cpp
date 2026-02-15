#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;


/*******************************************************************************************
Description : This Program, House of Cards simulates a simplified dice version of the card game Blackjack.

Author : Pranav Ananth

Requirements: 
A roll randomly selects from the values 2-10 or Jack, Queen, King, or Ace. An Ace always has the 
value of 11. Jack, Queen, and King all have the value of 10. In other words, with equal 
probability (chance), a roll selects one of 2,3,4,5,6,7,8,9,10,10,10,10,11.
2. The human player enters a wager. The wager must be positive and most not exceed the amount 
of money possessed the player.
3. The player is given two rolls. The house, played by the computer, is given one roll. The player is 
shown the value of the house’s roll.
4. If the total of rolls is 22 or greater than the player “busts”, loses the wager and the round is 
over.
5. If the total of rolls is 21 or less then the player has the option to “hit”, or “stand”. If the player 
opts to “hit” then the player is given another roll. Return to step 4. If the player opts to “stand” 
then continue to step 6.
6. It is now the house’s turn. The house is given an additional roll and the values are summed. If 
the total is less than 17 then the house must “hit”. If the house has a total of 22 or greater than 
the house “busts”, the player wins the wager, and the round is over. The house must continue 
to hit until it either “busts” or has a value between 17 and 21.
7. If the house did not “bust” then its value is compared to the player’s total. If the totals are the 
same then it is a “push” and the player does not win or lose anything. If the house’s total is 
greater than the player’s, then the player loses the wager.
If the player’s total is greater than the house’s, then the player wins the wager

********************************************************************************************/

// These are function declarations that support the logic of the game
int rollDice(); // returns the value of a random roll
int getWager(int money); // returns a wager that is entered by the player
void playerTurn(int money, int &wager, bool &bust, int &total, int &houseRoll); // all of the player's turns
void houseTurn(int houseRoll, bool &bust, int &total); // all of the house's turns(minus the first roll at the start)


/******************************************************************
Function : main

Arguments: none

Description:  main function that calls other helper functions and drives the logic of the game.
******************************************************************/
int main() {
	srand(time(0)); // to generate a different seed for each execution
	int money = 101;
	int wager, playerTotal, houseTotal, houseRoll;
	bool playerBust, houseBust;
	bool quit = false;
	char quitChar;
	do {
		cout << "You have $" << money << "." << endl;
		playerTurn(money, wager, playerBust, playerTotal, houseRoll);
		if (playerBust) { // if player busts during their rolls
			cout << "You lost your wager of $" << wager << "." << endl;
			money -= wager;
		}
		else {
			houseTurn(houseRoll, houseBust, houseTotal);
			if (houseBust) { // if house busts during their rolls
				cout << "You won your wager of $" << wager << "." << endl;
				money += wager;
			}
			else {
				if (playerTotal > houseTotal) { // to check who wins if neither player busts
					cout << "Your roll was greater than the house's roll, so you won your wager of $" << wager << "." << endl;
					money += wager;
				}
				else if (playerTotal == houseTotal) {
					cout << "Your roll and the house's roll were the same, so you keep the same amount of money." << endl;
				}
				else {
					cout << "Your roll was lower than the house's roll, so you lost your wager of $" << wager << "." << endl;
					money -= wager;
				}
			}
		}
		
		if (money > 0) { // option to keep playing or not
			cout << "Do you want to stop playing? If so, type 'y' or 'Y': ";
			cin >> quitChar;
			if (quitChar == 'y' || quitChar == 'Y') {
			quit = true;
			cout << "Bye!";
			}	
		}
		else { // forcefully quits the program if you run out of money
			cout << "You have no more money to gamble. Better luck next time!";
		}
	} while(quit == false && money > 0);
	
	return 0;
}

/******************************************************************
Function : rollDice

Arguments: none

Description: Rolls a 2-10, Jack, Queen, King, or Ace and returns the value.
******************************************************************/
int rollDice() {
	int roll = (rand() % 13) + 1; // to generate a random number between 1 and 13
	if(roll == 11 || roll == 12 || roll == 13) {
		roll = 10; // value of the face cards
	}
	else if(roll == 1) {
		roll = 11; // value of the ace
	}
	
	cout << "The dice rolled " << roll << "." << endl;
	return roll;
}

/***************************************************************************
Function : getWager

Arguments: money

Description: The parameter money is the amount of money possessed by the player.
The function inputs a wager from the keyboard and returns the amount. 
The function  ensures that the amount entered is valid (positive and <= money). 
If the amount is invalid, the user is  prompted to enter another value.
****************************************************************************/
int getWager(int money) {
	int wager;
	bool invalid;
	do {
		invalid = false;
		cout << "Enter a wager: $";
		cin >> wager;
		
		if (wager <= 0 || wager > money) {
			invalid = true;
			cout << "Invalid input. Please try again." << endl;
		}
	} while(invalid);
	
	return wager;
}

/***************************************************************************
Function : playerTurn

Arguments: money , wager, bust, total, houseRoll

Description: Implements the game logic for one round for the human player . The parameter 
money is the amount of money possessed by the player. wager returns the amount of money 
wagered by the player. bust returns true if the player busted, false otherwise. total returns the 
sum of the rolls by the player. houseRoll returns the single roll made by the house . 
The logic to test whether the round is over and to update the player’s money total is handled in the 
code that calls playerTurn, not inside playerTurn
****************************************************************************/

void playerTurn(int money, int &wager, bool &bust, int &total, int &houseRoll) {
	wager = getWager(money);
	total = 0;
	bust = false;
	
	cout << "The house will roll now." << endl;
	houseRoll = rollDice();
	
	cout << "You will roll now." << endl;
	total += rollDice(); // the first of the 2 starting rolls, the second is in the do-while function
	
	char action;
	bool invalid;
	do {
		total += rollDice();
		cout << "Your total of all rolls is " << total << "." << endl;
		if (total > 21) { // bust check
			bust = true;
			cout << "You rolled over 21. Busted!" << endl;
			return;
		}
		
		do {
			invalid = false;
			cout << "Type 'h' or 'H' to hit and 's' or 'S' to stand: ";
			cin >> action;
			
			if (action != 'h' && action != 'H' && action != 's' && action != 'S') { // allows lower and upper case for more freedom
				invalid = true;
				cout << "Invalid result. Please try again." << endl;
			}
		} while (invalid);
	} while(action == 'h' || action == 'H');
}

/***************************************************************************
Function : houseTurn

Arguments: houseRoll , bust, total

Description: Implement the logic for one round for the house or computer player (step 6 above). houseRoll is 
the value of the first roll made by the house that was made visible to the player. burst returns true
if the house busted, false otherwise. total returns the sum of the rolls by the house.
The logic to test the winner of the round (step 7 above) is handled in the code that calls 
houseTurn, not inside houseTurn.
****************************************************************************/

void houseTurn(int houseRoll, bool &bust, int &total) {
	bust = false;
	total = houseRoll;
	cout << "The house will roll now." << endl;
	
	do {
		total += rollDice();
		cout << "The total of all the house's rolls is " << total << "." << endl;
		if (total > 21) { // bust check
			bust = true;
			cout << "The house rolled over 21. Busted!" << endl;
			return;
		}
	} while (total < 17); // the house keeps rolling until they reach 17 or higher(or bust)
}
