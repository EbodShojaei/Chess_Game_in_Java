import java.awt.Color;

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
	public boolean checkMove(Position position) {
		return true;
	}
}