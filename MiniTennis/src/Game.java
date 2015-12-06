import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class Game extends JPanel {
	
	static Ball ball = new Ball(30,30);
	static Paddle paddle = new Paddle(100,30);
	static Board board = new Board(ball,paddle);
	
	
	public static void main(String[] args) {
		
		TennisFrame frame = new TennisFrame(300,300);	
		frame.add(board);
		
		while(true){
			ball.calcDirection(board, paddle);
			ball.move();
			board.repaint();
			board.revalidate();
			//System.out.println(board.getHeight());
			if((ball.y + ball.yv) > (board.getHeight() - ball.ballH)){
				ball.yv = 0; ball.xv = 0;
				JOptionPane.showMessageDialog(null,"GAME OVER!!");
				System.exit(0);
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	
}
