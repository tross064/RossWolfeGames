/**
 * The TTTGame programs implements a TicTacToe game. It allows two Engines to 
 * servers as the players.
 * 
 * @author Tyler Ross, Scott Wolfe
 * @version 2.0
 * @since 2016-11-15
 */

package e2.tictactoe;

public class Game {

	static char board[][] = new char[3][3];
	static Engine player1 = new RandomEngine();
	static Engine player2 = new RandomEngine();
	
	static Move currMove;
	
	final static char XMARK = 'x';
	final static char OMARK = 'o';
	
	final static int PRINT_ON = 1;
	final static int PRINT_OFF = 0;
	
	public static void main(String args[])  {
	    runGame(PRINT_ON);
	}
	
	public static char runGame(int printStatus) {
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				board[i][j]=' ';
			}
		}
		
		if (printStatus == PRINT_ON) {
    		System.out.println("GAME START");
    		System.out.println("==================");
    		printBoard();
    		try {
    		    Thread.sleep(2000);
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
		}
		
		while(true){
			//Player 1 Moves
			if(!checkAvalMoves()){
			    
			    if (printStatus == PRINT_ON) {
			        printEndScreen(' ');
			    }
				return ' ';
			}			
			currMove = player1.move(copyBoard(board), XMARK, OMARK);
			checkForLegalMove(currMove, XMARK);
			board[currMove.row][currMove.col] = currMove.mark;
			
			if (printStatus == PRINT_ON) {
    			printBoard();
    			try {
    	            Thread.sleep(2000);
    	        } catch (InterruptedException e) {
    	            e.printStackTrace();
    	        }
			}
			if(checkForWin(XMARK)){
			    if (printStatus == PRINT_ON) {
			        printEndScreen(XMARK);
			    }
				return XMARK;
			}
			
			//Player 2 Moves
			if(!checkAvalMoves()){
			    if (printStatus == PRINT_ON) {
			        printEndScreen(' ');
			    }
				break;
			}
			currMove = player2.move(copyBoard(board), OMARK, XMARK);
			checkForLegalMove(currMove, OMARK);
			board[currMove.row][currMove.col] = currMove.mark;
			
			if (printStatus == PRINT_ON) {
    			printBoard();
    			try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
			if(checkForWin(OMARK)){
			    if (printStatus == PRINT_ON) {
			        printEndScreen(OMARK);
			    }
				return OMARK;
			}
			
		}//end while
		return ' ';
	}//end runGame()
	
	/**
	 * Checks to see if engine's move is legal
	 */
	private static void checkForLegalMove(Move move, char playerMark) {
	    
	    // checks that move row and columns are in bounds
	    if (move.row < 0 || move.row > 2 || move.col < 0 || move.col > 2) {
	        throw new IllegalArgumentException("row or col out of bounds!"
	                + " Can't you count??");
	    }
	    
	    // checks that square has not already been taken
	    if (board[move.row][move.col] != ' ') {
	        throw new IllegalArgumentException("Illegal Move!! Cheater!!");
	    }
	    
	    // checks that correct mark was used
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
	
	/**
	 * creates a copy of a board
	 * 
	 * @param board
	 * @return
	 */
	private static char[][] copyBoard(char[][] board) {
	    
	    char[][] newBoard = new char[3][3];
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            newBoard[i][j] = board[i][j];
	        }
	    }
	    return newBoard;
	}
	
}//end Game.java
