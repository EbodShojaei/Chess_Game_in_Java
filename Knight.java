import java.awt.Color;
import javax.swing.ImageIcon;

/** Represents a Knight for chess. */
public class Knight extends Piece {
	/** 
	 * Initializes a Knight.
	 *
	 * @param color is a chess piece color.
	 */
	public Knight(Color color) {
		super(Name.X, color);
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
		String fileName = this.getColor().equals(Color.WHITE) ? "nw" : "nb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}