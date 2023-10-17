import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardPanel extends JPanel implements Observer {
	private final Game game;
	private final Board board;
	private final Controller controller;
	
	public BoardPanel(Game game, Controller controller) {
		this.game = game;
		this.board = game.getBoard();
		this.controller = controller;
		init();
	}
	
	private void init() {
		int rows = board.getHeight();
		int cols = board.getWidth();
		
		setLayout(new GridLayout(rows, cols));
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				TilePanel tilePanel = new TilePanel(row, col, controller);
				tilePanel.setPreferredSize(new Dimension(60,  60));
				
				if ((row + col) % 2 == 0) {
					tilePanel.setBackground(java.awt.Color.WHITE);
				} else {
					tilePanel.setBackground(java.awt.Color.BLACK);
				}
				
				add(tilePanel);
			}
		}
	}
	
	public void onUpdate() {
		repaint();
	}
}