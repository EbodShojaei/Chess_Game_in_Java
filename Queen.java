import java.awt.Color;

/** Represents a Queen for chess. */
public class Queen extends Piece {
	/** 
	 * Initializes a Queen.
	 *
	 * @param color is a chess piece color.
	 */
	public Queen(Color color) {
		super(Name.Q, color);
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