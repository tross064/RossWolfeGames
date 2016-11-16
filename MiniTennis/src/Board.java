import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Board extends JPanel {
	Ball ball;
	Paddle paddle;
	
	public Board(Ball ball, Paddle paddle) {
		
		this.ball = ball;
		this.paddle = paddle;
		this.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("keyTyped="+KeyEvent.getKeyText(e.getKeyCode()));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 39){
					paddle.moveRight();
				}
				else if(e.getKeyCode() == 37){
					paddle.moveLeft();
				}
			}
			
		});
		setFocusable(true);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		ball.draw(g2d);
		paddle.draw(g2d);
	}

}
