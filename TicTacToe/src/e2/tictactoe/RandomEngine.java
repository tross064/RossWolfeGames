package e2.tictactoe;

public class RandomEngine implements Engine{

	@Override
	public Move move(char[][] board, char playerMark, char oppMark) {
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j] == ' '){
					return new Move(playerMark,i,j);
				}
			}
		}
		return null;
	}
	
}
