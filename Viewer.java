import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Represents a view that displays the chess board. 
 */
public class Viewer extends JFrame {
	/** Represents a chess game i.e., the model. */
	private final Game game;
	
	/** Represents an event handler i.e., the controller. */
	private final Controller controller;
	
	/** 
	 * Initializes the viewer.
	 * 
	 * @param game is a chess game
	 * @param controller is an event handler
	 */
	public Viewer(Game game, Controller controller) {
		this.game = game;
		this.controller = controller;
		display();
	}
	
	/** 
	 * Displays the Swing displayer.
	 */
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