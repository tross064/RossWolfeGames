package my.game.os.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyListener implements KeyListener{

	Player player;
	
	public PlayerKeyListener(Player p){
		player = p;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		player.keyTyped(e);
		
	}
	
}
