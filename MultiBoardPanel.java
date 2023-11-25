import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class MultiBoardPanel extends JPanel implements Observer {
	BoardPanel boards[];
	
	public MultiBoardPanel(Board board, Controller controller, int levels) {
		setLayout(new GridLayout(1, levels));
		boards = new BoardPanel[levels];
		for (int i = 0; i < levels; i++) {
			boards[i] = new BoardPanel(board, controller, i);
			boards[i].init();
			add(boards[i]);
			Border border;
			switch (i % 3) {
				case 0: border = BorderFactory.createLineBorder(Color.RED, 2); break;
				case 1: border = BorderFactory.createLineBorder(Color.GREEN, 2); break;
				case 2: border = BorderFactory.createLineBorder(Color.BLUE, 2); break;
				default: border = BorderFactory.createLineBorder(Color.BLACK, 2); break;
			}
			
			boards[i].setBorder(border);
		}
	}
	
	public void update() {
		for (BoardPanel board : boards) board.update();
	}
}