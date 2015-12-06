import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Paddle {

	//Position
	int x = 100;
	int y = 200;
	
	//Size
	int paddleW;
	int paddleH;
	
	//JPanel
	JPanel panel;
	
	//Constructor
	public Paddle(int paddleW, int paddleH) {
		this.paddleW = paddleW;
		this.paddleH = paddleH;
	}
	
	public void addPanel(JPanel panel){
		this.panel = panel;
	}
	
	//Methods
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.BLUE);
		g2d.fillRect(x,y,paddleW,paddleH);
	}
	
	public int getWidth(){
		return paddleW;
	}
	
	public int getHeight(){
		return paddleH;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void moveRight(){
		if((x + paddleW + 10) <= 290){
			x += 10;
			
		}
	}
	
	public void moveLeft(){
		if((x - 10) >= 0 ){
			x -= 10;
		}
		
		
	}
}
