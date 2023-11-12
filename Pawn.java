import java.awt.Color;
import javax.swing.ImageIcon;

/** Represents a Pawn for chess. */
public class Pawn extends Piece {
	private boolean firstMove = true;
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
	public boolean checkMove(Position start, Position end) {		
		int row = end.getX() - start.getX();
		int col = end.getY() - start.getY();

		// If first move, then we can move 1 or 2
		// If not first move, only move 1

		// if (col != 0) return false;

		// if (super.getColor() == Color.WHITE) {
			// switch (firstMove) {
				// case true:
					// if (row == -2 || row == -1) return true;
					// else return false
					// break;
				// case false:
					// if (row == -1) return true;
					// else return false;
					// break
			// }
		// } else if (super.getColor() == Color.BLACK) {
			// switch (firstMove) {
				// case true:
					// if (row == 2 || row == 1) return true;
					// else return false
					// break;
				// case false:
					// if (row == 1) return true;
					// else return false;
					// break
			// }
		// }
		// return false;
		if (col != 0) return false;
		
		// Calculate row movement based on color and if first move
		int expected = (super.getColor() == Color.WHITE) ? (firstMove ? -2 : -1) : (firstMove ? 2 : 1);
		
		// Check if move matches expected row for first move or normal move
		boolean isValid = firstMove ? Math.abs(row) <= Math.abs(expected) : row == expected;
		
		// Set first move to false on valid move
		if (isValid && firstMove) firstMove = false;
		return isValid;
	}

	
	/** Gets the piece icon. 
	 * 
	 * @return ImageIcon is a chess piece icon.
	 */
	@Override
	public ImageIcon getIcon() {
		String fileName = this.getColor().equals(Color.WHITE) ? "pw" : "pb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}