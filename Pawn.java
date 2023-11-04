import java.awt.Color;
import javax.swing.ImageIcon;

/** Represents a Pawn for chess. */
public class Pawn extends Piece {
	/** 
	 * Initializes a Pawn.
	 *
	 * @param color is a chess piece color.
	 */
	public Pawn(Color color) {
		super(Name.P, color);
	}
	
	/** Checks if the piece can move to the position. 
	 * 
	 * @param position is a tile coordinate.
	 * @return true if valid move, else false.
	 */
	public boolean checkMove(Position position) {
		return true;
	}
	
	/** Gets the piece icon. 
	 * 
	 * @return ImageIcon is a chess piece icon.
	 */
	public ImageIcon getIcon() {
		String fileName = this.getColor().equals(Color.WHITE) ? "pw" : "pb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}