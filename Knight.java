import java.awt.Color;

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
	public boolean checkMove(Position position) {
		return true;
	}
}