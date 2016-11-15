package e2.tictactoe;

public class Move {
	
	char mark;
	int row,col;
	
	public Move(char mark, int row, int col){
		this.mark = mark;
		this.row = row;
		this.col = col;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
}
