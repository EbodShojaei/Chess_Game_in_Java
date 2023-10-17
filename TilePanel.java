import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TilePanel extends JPanel {
	private final int x;
	private final int y;
	private final Controller controller;
	
	public TilePanel(int x, int y, Controller controller) {
		this.x = x;
		this.y = y;
		this.controller = controller;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.handleTileClick(x, y);
			}
		});
		
		setOpaque(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Board board = controller.getGame().getBoard();
		Tile tile = board.getTile(x, y);
		
		if (tile.hasPiece()) {
			Piece piece = tile.getPiece();
			String pieceName = piece.getName().name();
			
			if (piece.getPlayer().getColor() == Color.BLACK) {
				g.setColor(java.awt.Color.BLUE);
			} else {
				g.setColor(java.awt.Color.RED);
			}
			
			g.drawString(pieceName, getWidth()/2, getHeight()/2);
		}
	}
}