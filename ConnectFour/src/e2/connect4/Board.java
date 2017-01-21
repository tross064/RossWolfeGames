package e2.connect4;

public class Board {

    public final int ROW = 6;
    public final int COL = 7;
    
    private String[][] boardState = new String[ROW][COL];
  
    
    public Board(){
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
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
    
    public void printBoard() {
        String output = "";
        
        output += "\n-----------------------------";
        for (int i = 0; i < ROW; i++) {
            output += "\n|";
            for (int j = 0; j < COL; j++) {
                output += " " + boardState[i][j] + " |";
            }
            output += "\n-----------------------------";
        }
        output += "\n";
                
        System.out.println(output);
    }
    
}
