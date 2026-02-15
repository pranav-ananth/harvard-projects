#include <iostream>
using namespace std;

/***************************************************************************************************************
This Program demonstrates the popular game Tic Tac Toe. 

The game of Tic-Tac-Toe is played on a 3x3 grid. The computer player uses O while the human player uses X. 
The players take turns placing a stone on an empty cell. 
When a player manages to create a horizontal, vertical, or diagonal row of three stones of his color, he wins the game.

Author : Pranav Ananth
****************************************************************************************************************/

// Global Constants

// The character representing the Player
const char PLAYER = 'X';

// The character representing the Computer
const char COMPUTER = 'O';

// The character representing the empty slot
const char EMPTY = ' ';

// total number of rows
const int NUM_ROWS = 3;

// total number of columns
const int NUM_COLUMNS = 3;

//total number of possible turns
const int TOTAL_TURNS = 9;


// The score for maxmimizer in the minimax algorithm
const int MAXIMIZER_SCORE = 1;

// The score for minimizer in the minimax algorithm
const int MINIMIZER_SCORE = -1;
    
    
/********************************************************************************************************************
This Class abstracts a Move made by a player. It captures the row, column and a score in the minimax algorithm for 
the move.
********************************************************************************************************************/    
class Move {
	private:
		int row;
		int column;
		int score;
		
	public:
		// constructor
		Move() : row(-1), column(-1), score(-1000) {}
     	Move(int r, int c) : row(r), column(c), score(-1000) {}
		
		//accessors
		int getRow() { return row;}
		void setRow(int r) { row = r; }
		
		int getColumn() { return column;}
		void setColumn(int c) { column = c;}
		
		int getScore() { return score;} 
		void setScore(int s) { score = s ;}

		// method to check if the input made by the user is valid
	    bool isValid() {
			if(row < 0 || row > 2) {
        		cout << "Invalid row entered. Please try again." << endl;
        		return false;
			}
			else if(column < 0 || column > 2) {
				cout << "Invalid column entered. Please try again." << endl;
				return false;
			}
			return true;
		}
	
};

/********************************************************************************************************************
This is the main class of the TicTacToe Game. 
********************************************************************************************************************/    

class TicTacToe {
	private:
		char board[NUM_ROWS][NUM_COLUMNS];
	
		bool isMovesLeft();
		bool updateBoard(Move m, char turn);
		int  evaluateBoard();
		int  minimax(bool isMax);

    public:
    	// constructor 
    	TicTacToe() : board({ { EMPTY , EMPTY , EMPTY}, { EMPTY , EMPTY , EMPTY}, { EMPTY , EMPTY , EMPTY} }) {}
    	
		bool checkIfPlayerWon(char player);
		void getNextPlayerMove();
		void getNextComputerMove();
		void drawBoard();
	
};


/********************************************************************************************************************
Implementation of the TicTacToe Class methods
********************************************************************************************************************
Method: isMovesLeft
Description: Checks if there are any moves left
Arguments: None
Return: bool if the moves are left return true
********************************************************************************************************************/
 
bool TicTacToe::isMovesLeft() {
	for(int i = 0; i < NUM_ROWS; i++) {
		for(int j = 0; j < NUM_COLUMNS; j++) {
			if(board[i][j] == EMPTY) {
					return true;
			}
		}
	}
	return false;
}

/********************************************************************************************************************
Method: updateBoard
Description: Updates the board
Arguments: 
Move m reperesents the next move
char turn represents which player's turn is taken.
Return: bool if the board was updated returns true
********************************************************************************************************************/ 

bool TicTacToe::updateBoard(Move m, char turn) {
	// resetting the move
	if (turn == EMPTY) {
		board[m.getRow()][m.getColumn()] = turn;
		return true;	
	}
	// check if the position is already taken
    if(board[m.getRow()][m.getColumn()] != EMPTY) {
		cout << "Piece already on chosen square. Please try again." << endl;
	}
	else {
		board[m.getRow()][m.getColumn()] = turn; // update and return
		return true;	
	}
	return false;
}

/********************************************************************************************************************
Method: evaluateBoard
Description: Evaluates the score for the board based on the minimax algorithm
Arguments: None
Return: int the score of the board 
********************************************************************************************************************/ 

int TicTacToe::evaluateBoard() {
	if (checkIfPlayerWon(COMPUTER)) {
		return MAXIMIZER_SCORE;
	} else if (checkIfPlayerWon(PLAYER)) {
		return MINIMIZER_SCORE;
	}
	
	if (!isMovesLeft()) 
		return 0; // tie score
	
	return 1000;
}

/********************************************************************************************************************
Method: minimax
Description:
The minimax algorithm helps find the best move, by working backwards from the end of the game. 
At each step it assumes that player A is trying to maximize the chances of A winning, while on the next turn player B 
is trying to minimize the chances of A winning (i.e., to maximize B's own chances of winning).
Arguments: 
bool isMaxTurn represents if it is the computer's turn
Return: int score of the move
********************************************************************************************************************/ 

int TicTacToe::minimax(bool isMaxTurn) {
	// check for terminal condition of recursion
	int score = evaluateBoard();	 
	if (score <= 1) // this indicates if the game is finished
		return score;
		
		
	// initialize bestScore and turn based on the current turn
	int bestScore = (isMaxTurn) ? -1000 : 1000;
	char turn = (isMaxTurn) ? COMPUTER : PLAYER;
	// find the next possible move
	for(int i = 0; i < NUM_ROWS; i++) {
		for(int j = 0; j < NUM_COLUMNS; j++) {
			if(board[i][j] == EMPTY) {
				Move m(i,j);
				updateBoard(m, turn); // make the turn
				int score = minimax(!isMaxTurn); // find the score based on minimax
				updateBoard(m, EMPTY); // reset the board
				// update bestScore
				if (isMaxTurn) {
					 bestScore = max(score, bestScore);	
				}
				else {
					 bestScore = min(score,bestScore);
				}
				
			}
		}
	}
	return bestScore;		
 
}

/********************************************************************************************************************
Method: drawBoard
Description: Displays the board to the player
Arguments: None
Return: None
********************************************************************************************************************/ 

void TicTacToe::drawBoard() {
    cout << "______________________" << endl;
    for (int i =0; i < NUM_ROWS; i++) {
        cout << "|      |      |      |" << endl; 
    	cout << "|  "  <<  board[i][0] << "   |  " << board[i][1] << "   |  " << board[i][2] << "   |" << endl;
    	cout << "|______|______|______|" << endl; 
    }
}

/********************************************************************************************************************
Method: checkIfPlayerWon
Description: Checks if the chosen player won
Arguments: 
char player represents the player being checked
Return: bool if the player won returns true
********************************************************************************************************************/ 

bool TicTacToe::checkIfPlayerWon(char player) {
    // check rows 
    for (int i=0; i < NUM_ROWS; i++) {
        if ( (board[i][0] == player) && (board[i][1] == player) && (board[i][2] == player))
        return true;
    }
    
    // check columns 
    for (int j=0; j < NUM_COLUMNS; j++) {
        if ( (board[0][j] == player) && (board[1][j] == player) && (board[2][j] == player))
        return true;
    }
    
    // check diagonals
    if ( (board[0][0] == player) && (board[1][1] == player) && (board[2][2] == player) ) 
        return true;
        
    if ( (board[0][2] == player) && (board[1][1] == player) && (board[2][0] == player) ) 
        return true;
    
    return false;
}

/********************************************************************************************************************
Method: getNextPlayerMove
Description: Asks and validates the player's input and updates the board with players move
Arguments: None
Return: None
********************************************************************************************************************/ 

void TicTacToe::getNextPlayerMove() {
	bool validInput = false;
	int row, column = -1;
	while(!validInput) {
		cout << "Please enter your coordinates in the form of 2 numbers each ranging from 0-2(seperated by a space): ";
        cin >> row >> column;
        Move move(row, column);
        if(move.isValid()) {
        	if (updateBoard(move, PLAYER))
	        	validInput = true;
		}
	}
}

/********************************************************************************************************************
Method: getNextComputerMove
Description: Generates the next best move for the computer based on the resutls of the minimax algorithm
Arguments: None
Return: None
********************************************************************************************************************/ 

void TicTacToe::getNextComputerMove() {
    
    Move bestMove;
	for(int i = 0; i < NUM_ROWS; i++) {
		for(int j = 0; j < NUM_COLUMNS; j++) {
			if(board[i][j] == EMPTY) {
				Move m(i,j);
				updateBoard(m, COMPUTER);
				int score = minimax(false); // checks the move
				updateBoard(m , EMPTY); // reverts the move made
				if (score > bestMove.getScore()) {
					bestMove.setRow(m.getRow());
					bestMove.setColumn(m.getColumn());
					bestMove.setScore(score); 
				}
			}
		}
	}
	cout << " Computer's Move : " << bestMove.getRow() << " " << bestMove.getColumn() << endl; 
	updateBoard(bestMove, COMPUTER);
}

/********************************************************************************************************************
Method: main
Description: Plays a game of tic-tac-toe between the player and the computer
Arguments: None
Return: int returns 0 in case of success
********************************************************************************************************************/

int main() {
	TicTacToe game;	
    bool somebodyWon = false;
    
    cout << "Welcome to Tic Tac Toe: " << endl;
	game.drawBoard();
    for (int i = 0; i < TOTAL_TURNS;i++) {
		bool validInput = false;
        char turn = (i % 2 == 0) ? PLAYER : COMPUTER; // swaps between player and computer moves
        if(turn == PLAYER) {
        	game.getNextPlayerMove();
		}
		else {
			game.getNextComputerMove();
		}
		game.drawBoard();
        if (game.checkIfPlayerWon(PLAYER))  {
            cout << "Result: Player won!" << endl;
            somebodyWon = true;
            break;
        }
        else if (game.checkIfPlayerWon(COMPUTER))  {
            cout << "Result: Computer won!" << endl;
            somebodyWon = true;
            break;
        }
    }
	   
    if(!somebodyWon) {
    	cout << "Result: No Winner, Draw!";
	}
         
    return 0;
}
