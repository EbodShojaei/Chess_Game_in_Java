import java.awt.Color;

/** Represents a Bishop for chess. */
public class Bishop extends Piece {
	/** 
	 * Initializes a Bishop.
	 *
	 * @param color is a chess piece color.
	 */
	public Bishop(Color color) {
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
}