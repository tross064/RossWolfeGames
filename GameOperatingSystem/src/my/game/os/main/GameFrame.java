package my.game.os.main;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	public GameFrame(String title, int width, int height){
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
