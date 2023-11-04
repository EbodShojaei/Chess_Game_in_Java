import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class BoardPanel extends JPanel implements Observer {
	private final Board board;
	private final Controller controller;
	
	public BoardPanel(Board board, Controller controller) {
		this.board = board;
		this.controller = controller;
	}
	
	public void init() {
		setLayout(new GridLayout(board.getHeight(), board.getWidth()));
		update();
	}
	
	@Override
	public void update() {
		// Clear the board
		removeAll();

		for (int tile = 0; tile < board.getSize(); tile++) {
			Position position = board.getTile(tile);
			TilePanel tilePanel = new TilePanel(position, controller);
			
			Piece piece = board.getPiece(position);
			if (piece != null) {
				tilePanel.setPieceLabel(piece);
			} else {
				tilePanel.removePieceLabel();
			}
			
			tilePanel.setPreferredSize(new Dimension(60, 60));
			add(tilePanel);
		}
		
		// Refresh state
		revalidate();
		repaint();
	}
	
	public class TilePanel extends JPanel {
		private final Position position;
		private final Controller controller;
		private Color color;
		private JLabel label;
		
		public TilePanel(Position position, Controller controller) {
			this.position = position;
			this.controller = controller;
			
			int x = position.getX();
			int y = position.getY();
			color = ((x + y) % 2 == 0) ? Color.WHITE : Color.BLACK;
			setBackground(color);
			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (board.hasPiece(position)) System.out.println("Piece selected.");
					else System.out.println("Tile selected.");
					
					controller.selectTile(position);
				}
			});
			setOpaque(true);
		}
		
		public void setPieceLabel(Piece piece) {
			if (label == null) {
				label = new JLabel();
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setVerticalAlignment(JLabel.CENTER);
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
				this.add(label);	
			} 
			
			if (piece != null) {
				label.setText(piece.getName().name());
				label.setForeground((piece.getColor() == Color.BLACK) ? Color.BLUE : Color.RED);
			} else {
				label.setText("");
			}
			
			this.revalidate();
			this.repaint();
		}
		
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