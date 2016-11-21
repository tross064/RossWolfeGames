package e2.tictactoe;

import java.util.Scanner;

/**
 * Allows a human to play the tic-tac-toe game
 * @author Scott
 *
 */
public class HumanEngine implements Engine {

    @Override
    public Move move(char[][] board, char playerMark, char oppMark) {
        

        // Infinite loop while legal move has not been entered correctly
        while (true) {
            
            // User enters move
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter a legal move: ");
            String s = keyboard.nextLine();
            System.out.println("You entered " + s);
            
            // Create new move object and return
            Move move = null;
            try {
                move = new Move(playerMark,
                        Character.getNumericValue(s.charAt(0)),
                        Character.getNumericValue(s.charAt(1)) );
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            return move;
        }
    }

}
