package my.game.os.player;

import java.awt.event.KeyEvent;

public interface Player {
	
	public void keyPressed(KeyEvent e);

	public void keyReleased(KeyEvent e);

	public void keyTyped(KeyEvent e);
	
	public void move();

}
