import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TilePanel extends JPanel {
	private final Controller controller;
	private final int x;
	private final int y;
	private final java.awt.Color c;
	
	public TilePanel(int x, int y, Controller controller) {
		this.controller = controller;
		this.x = x;
		this.y = y;
		this.c = ((x + y) % 2 == 0) ? java.awt.Color.WHITE : java.awt.Color.BLACK;
		setBackground(c);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(java.awt.Color.RED);
				controller.handleTileClick(x, y);
			}
		});
		
		setOpaque(true);
	}
}