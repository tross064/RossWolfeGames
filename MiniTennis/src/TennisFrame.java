import javax.swing.JFrame;


public class TennisFrame extends JFrame {
	
	//Constructor
	public TennisFrame(int HEIGHT, int WIDTH) {
		
		this.setSize(HEIGHT,WIDTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tennis Frame");
		this.setVisible(true);

	}
}
