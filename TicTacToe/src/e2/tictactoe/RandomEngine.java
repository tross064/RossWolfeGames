package e2.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEngine implements Engine{

	@Override
	public Move move(char[][] board, char playerMark, char oppMark) {
		
	    List<Move> list = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == ' '){
                    list.add(new Move(playerMark, i, j));
                }
            }
        }
        
        Random rand = new Random(System.currentTimeMillis());
	    
        if (list.size() == 0) {
            return null;
        } else {
            int num = rand.nextInt(list.size());
            Move move = list.get(num);
            return move;
        }

	}
	
}
