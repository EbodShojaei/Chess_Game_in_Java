import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Viewer extends JFrame {
	private final Game game;
	private final Controller controller;
	
	public Viewer(Game game, Controller controller) {
		this.game = game;
		this.controller = controller;
		display();
	}
	
	private void display() {
		setTitle("Chess by Dobe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Create the BoardPanel and add to frame
		BoardPanel boardPanel = new BoardPanel(game.getBoard(), controller);
		boardPanel.init();
		add(boardPanel, BorderLayout.CENTER);
		
		// Full-screen frame
		setPreferredSize(new Dimension(600, 600));
		setResizable(true);
		
		// Set up other UI
		pack();
		setVisible(true);
		
		// Add an observer for the board
		game.addObserver(boardPanel);
	}
}