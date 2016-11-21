package e2.tictactoe;

import java.util.Random;

public class RandomEngine implements Engine{

	@Override
	public Move move(char[][] board, char playerMark, char oppMark) {
		
	    int count = 0;
	    int[] arr = new int[9];
	    Random rand = new Random(System.currentTimeMillis());
	    
	    Move move = new Move(playerMark, -1, -1);
	    
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j] == ' '){
					arr[count] = i*3 + j;
					count++;
				}
			}
		}
		
		if (count == 0) {
		    return null;
		} else {
		    int num = rand.nextInt(count);
		    move.row = arr[num] / 3;
		    move.col = arr[num] % 3;
		    return move;
		}
	}
	
}
