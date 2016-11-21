/**
 * The TTTGame programs implements a TicTacToe game. It allows two Engines to 
 * servers as the players.
 * 
 * @author Tyler Ross
 * @version 2.0
 * @since 2016-11-15
 */

package e2.tictactoe;

public class Game {

	static char board[][] = new char[3][3];
	static Engine player1 = new ScottsEngine();
	static Engine player2 = new RandomEngine();
	
	static Move currMove;
	
	final static char XMARK = 'x';
	final static char OMARK = 'o';
	
	public static void main(String args[]) throws InterruptedException{
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				board[i][j]=' ';
			}
		}
		
		System.out.println("GAME START");
		System.out.println("==================");
		printBoard();
		Thread.sleep(2000);
		
		while(true){
			//Player 1 Moves
			if(!checkAvalMoves()){
				printEndScreen(' ');
				break;
			}			
			currMove = player1.move(board, XMARK, OMARK);
			checkForLegalMove(currMove, XMARK);
			board[currMove.row][currMove.col] = currMove.mark;
			printBoard();
			Thread.sleep(2000);
			if(checkForWin(XMARK)){
				printEndScreen(XMARK);
				break;
			}
			
			//Player 2 Moves
			if(!checkAvalMoves()){
				printEndScreen(' ');
				break;
			}
			currMove = player2.move(board, OMARK, XMARK);
			checkForLegalMove(currMove, OMARK);
			board[currMove.row][currMove.col] = currMove.mark;
			printBoard();
			Thread.sleep(2000);
			if(checkForWin(OMARK)){
				printEndScreen(OMARK);
				break;
			}
			
		}//end while
	}//end main()
	
	/**
	 * Checks to see if engine's move is legal
	 */
	private static void checkForLegalMove(Move move, char playerMark) {
	    
	    // checks that square has not already been taken
	    if (board[move.row][move.col] != ' ') {
	        throw new IllegalArgumentException("Illegal Move!! Cheater!!");
	    }
	    
	    if (move.mark != playerMark) {
	        throw new IllegalArgumentException("Wrong mark, dummy!!");
	    }
	    
	}
	
	/**
	 * Checks to see if the player who just made a move won.
	 * 
	 * @param mark	uses either XMARK or YMARK
	 * @return true if the mark is found three time sequentially, otherwise false
	 * @exception Nothing
	 */
	public static boolean checkForWin(char mark){
		//Check rows for 3 of the same mark
		for(int i=0; i<3; i++){
			if(board[i][0]==mark && board[i][1]==mark && board[i][2]==mark){
				return true;
			}
		}//end for loop
		//Check columns for 3 of the same mark
		for(int j=0; j<3; j++){
			if(board[0][j]==mark && board[1][j]==mark && board[2][j]==mark){
				return true;
			}
		}//end for loop
		//Check diagonals for 3 of the same mark
		if(board[0][0]==mark && board[1][1]==mark && board[2][2]==mark){
			return true;
		}
		else if(board[2][0]==mark && board[1][1]==mark && board[0][2]==mark){
			return true;
		}
		else{
			return false;
		}
	}//end checkForWin()
	
	public static boolean checkAvalMoves(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j] == ' '){
					return true;
				}
			}
		}//end checkAvalMoves
		
		return false;
	}
	
	public static void printEndScreen(char winner){
		switch(winner){
		case 'o':
			System.out.println("\n\nO Wins!!!");
			break;
		case 'x':
			System.out.println("\n\nX Wins!!!");
			break;
		default:
			System.out.println("\n\nTie, you all lose!!!");
			break;
		}
	}//end printEndScreen()
	
	public static void printBoard(){
		String output = "";
		output = "\n" + board[0][0]  + "|" + board[0][1] + "|" + board[0][2];
		output += "\n-----";
		output += "\n" +board[1][0]  + "|" + board[1][1] + "|" + board[1][2];
		output += "\n-----";
		output += "\n" + board[2][0]  + "|" + board[2][1] + "|" + board[2][2];
		System.out.println(output);
	}//end printBoard()
	
}//end Game.java
