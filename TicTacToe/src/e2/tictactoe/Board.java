package e2.tictactoe;

public class Board {

	private String[][] boardState = new String[3][3];
	
	public Board(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				boardState[i][j]=" ";
			}
		}
	}
	
	public void placeMark(String mark, int row, int col){
		boardState[row][col] = mark;
	}
	
	public String[][] getBoardState(){
		return boardState;
	}
	
	public String printBoard(){
		String output = "";
		output = "\n" +boardState[0][0].toString()  + "|" + boardState[0][1].toString() + "|" + boardState[0][2].toString();
		output += "\n-----";
		output += "\n" +boardState[1][0].toString()  + "|" + boardState[1][1].toString() + "|" + boardState[1][2].toString();
		output += "\n-----";
		output += "\n" + boardState[2][0].toString()  + "|" + boardState[2][1].toString() + "|" + boardState[2][2].toString();
		return output;
	}
}


