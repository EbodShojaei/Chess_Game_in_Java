import java.awt.Color;
import javax.swing.ImageIcon;

/** Represents a King for chess. */
public class King extends Piece {
	/** 
	 * Initializes a King.
	 *
	 * @param color is a chess piece color.
	 */
	public King(Color color) {
		super(Name.K, color);
	}
	
	/** Checks if the piece can move to the position. 
	 * 
	 * @param position is a tile coordinate.
	 * @return true if valid move, else false.
	 */
	public boolean checkMove(Position start, Position end) {
		return true;
	}
	
	/** Gets the piece icon. 
	 * 
	 * @return ImageIcon is a chess piece icon.
	 */
	public ImageIcon getIcon() {
		String fileName = this.getColor().equals(Color.WHITE) ? "kw" : "kb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}