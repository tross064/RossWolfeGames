import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ball {
	
	//position
	int x=10;
	int y=50;
	
	//Velocity
	final int xvelo = 3;
	final int yvelo = 0;
			
	//direction
	int xv = xvelo;
	int yv = yvelo;
	
	//size
	int ballW;
	int ballH;
	
	public Ball(int ballW, int ballH){
		this.ballW = ballW;
		this.ballH = ballH;
	}
	
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.RED);
		g2d.fillOval(x,y,ballW,ballH);
	}
	
	public void move(){
		x = x + xv;
		y = y + yv;
	}
	
	public void calcDirection(JPanel board, Paddle paddle){
		
		//Checking if Ball contacts Walls
		if(x + xv < 0){
			xv = xvelo; System.out.println("hit left wall");
		}
		else if((x + xv) > (board.getWidth() - ballW)){
			xv = -xvelo; System.out.println("hit right wall");
		}
		if(y + yv < 0){
			yv = yvelo; System.out.println("hit top wall");
		}
		
		
		
		//If Ball contacts Paddle
		  
		//Top of Paddle
		if((y+yv)>=(paddle.getY() - ballH)){  //If ball reaches ballH of paddle		
				
			if((x+xv >= paddle.getX() - (ballW/2)) && (x+xv <= paddle.getX() + paddle.getWidth() - (ballW/2))){  //If ball is in same x position as paddle
			
			yv = -yvelo;
			}
		}
		
				 
		
		//Left Side of Paddle
		if((x+xv)>=(paddle.getX() - ballW) && ((x + ballW) < (paddle.getX() + paddle.getWidth()/2))){ 	//If ball reaches left side of paddle
			
			  if((y+yv >= paddle.getY() - (ballH/2) && (y+yv <= paddle.getY() + paddle.getHeight() - (ballH/2)) ) ){  //If ball is in same x position as paddle
				xv = -xvelo;
			  }	
		}
		
		
		//Right Side of Paddle
		else if((x+xv)<=(paddle.getX() + paddle.getWidth())  && ((x) > (paddle.getX() + paddle.getWidth()/2))){ 	//If ball reaches left side of paddle
			
			  if((y+yv >= paddle.getY() - (ballH/2) && (y+yv <= paddle.getY() + paddle.getHeight() - (ballH/2)) ) ){  //If ball is in same x position as paddle
				xv = xvelo;
			  }	
		}
		 
		
	}
}
