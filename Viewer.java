import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
	private final Game game;
	private final Board board;
	private final Controller controller;
	
	public Viewer(Game game, Controller controller) {
		this.game = game;
		this.board = game.getBoard();
		this.controller = controller;
		display();
	}
	
	private void display() {
		setTitle("Chess by Dobe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Create the BoardPanel and add to frame
		BoardPanel boardPanel = new BoardPanel(game, controller);
		add(boardPanel, BorderLayout.CENTER);
		
		// Full-screen frame
		setPreferredSize(new Dimension(600, 600));
		setResizable(true);
		
		// Set up other UI
		pack();
		setVisible(true);
	}
}