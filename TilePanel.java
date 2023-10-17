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
}