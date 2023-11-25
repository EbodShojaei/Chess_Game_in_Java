import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Represents a Swing displayer for a chess board. 
 * Implements Observer for visually updating the
 * board when game state changes.
 */
public class BoardPanel extends JPanel implements Observer {
	/** Represents a chess board. */
	private final Board board;
	
	/** Represents event handler. */
	private final Controller controller;
	
	/** Represents board index. */
	private final int index;
	
	/** 
	 * Initializes a Swing displayer for a chess board.
	 *
	 * @param board is a chess board.
	 * @param controller is a handler for click events.
	 */
	public BoardPanel(Board board, Controller controller) {
		this.board = board;
		this.controller = controller;
		this.index = 0; // First board is index 0
	}
	
	/** 
	 * Initializes a Swing displayer for a chess board.
	 *
	 * @param board is a chess board.
	 * @param controller is a handler for click events.
	 */
	public BoardPanel(Board board, Controller controller, int index) {
		this.board = board;
		this.controller = controller;
		this.index = index;
	}
	
	/**
	 * Initializer to set up the Swing displayer.
	 */
	public void init() {
		setLayout(new GridLayout(board.getHeight(), board.getWidth()));
		update();
	}
	
	/**
	 * Implements abstract method to repaint the board
	 * when game state changes.
	 */
	@Override
	public void update() {
		// Clear the board
		removeAll();
		
		// Repaint the board
		for (int tile = 0; tile < board.getSize(); tile++) {
			Position position = board.getTile(tile);
			if (position.getZ() != index) continue; // Essential for proper display. Try unchecking it.
			
			TilePanel tilePanel = new TilePanel(position, controller);
			
			Piece piece = board.getPiece(position); // Check for piece at tile
			if (piece != null) {
				tilePanel.setPieceLabel(piece); // Label tile with piece name
			} else {
				tilePanel.removePieceLabel(); // Unoccupied tile is blank.
			}
			
			tilePanel.setPreferredSize(new Dimension(60, 60));
			add(tilePanel);
		}
		
		// Refresh state
		revalidate();
		repaint();
	}
	
	/**
	 * Inner class represents each tile of the board.
	 * A tile cannot exist without the board.
	 */
	public class TilePanel extends JPanel {
		/** Represents tile coordinates. */
		private final Position position;
		
		/** Represents event handler. */
		private final Controller controller;
		
		/** Represents tile color. */
		private Color color;
	
		/** Represents piece name. */
		private JLabel label;
		
		/** 
		 * Constructor for a TilePanel to handle click events. 
		 *
		 * @param board is a chess board.
		 * @param controller is a handler for click events.
		 */
		public TilePanel(Position position, Controller controller) {
			this.position = position;
			this.controller = controller;
			
			int x = position.getX();
			int y = position.getY();
			color = ((x + y) % 2 == 0) ? Color.WHITE : Color.BLACK;
			setBackground(color);
			
			// Attach an event listener for tile click events.
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (board.hasPiece(position)) {
						System.out.println("Piece selected.");
						// setBackground(Color.YELLOW);
					}
					else {
						System.out.println("Tile selected.");
					}
		
					controller.selectTile(position); // Update the controller
				}
			});
			setOpaque(true);
		}
		
		/** 
		 * Assigns an occupied tile with the piece name. 
		 *
		 * @param piece represents a chess piece.
		 */
		public void setPieceLabel(Piece piece) {
			// Center the label. Use Comic Sans.
			if (label == null) {
				label = new JLabel();
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setVerticalAlignment(JLabel.CENTER);
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
				label.setPreferredSize(new Dimension(60, 60));
				this.add(label);	
			} 
			
			if (piece != null) {
				// If image does not load, fall back to alt-text.
				try {
					ImageIcon icon = piece.getIcon();
					Image original = icon.getImage();
					Image scaled = original.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					label.setIcon(new ImageIcon(scaled));
				} catch (Exception e) {
					label.setText(piece.getName().name()); // Update label of occupied tile
					label.setForeground((piece.getColor() == Color.BLACK) ? Color.BLUE : Color.RED); // Update font color
				}
			} else {
				// If image does not load, fall back to alt-text.
				try {
					label.setIcon(null);
				} catch (Exception e) {
					label.setText(""); // Unoccupied tile
				}
			}
			
			this.revalidate();
			this.repaint();
		}
		
		/** 
		 * Removes label from a tile.
		 */
		public void removePieceLabel() {
			if (label != null) {
				this.remove(label);
				label = null;
				this.revalidate();
				this.repaint();
			}
		}
	}
}