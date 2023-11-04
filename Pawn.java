import java.awt.Color;

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
}