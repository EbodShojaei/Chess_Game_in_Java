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
	@Override
	public boolean checkMove(Position start, Position end) {		
		int rowDiff = end.getX() - start.getX();
		int colDiff = end.getY() - start.getY();
		int lvlDiff = end.getZ() - start.getZ();
		
		// Determine direction of movement
		int direction = super.getColor() == Color.WHITE ? -1 : 1;
		
		// Check for normal forward movement
		if (colDiff == 0) {
			if (firstMove && rowDiff == 2 * direction) { // Two tiles first move
				if (lvlDiff > 2 || lvlDiff < -2) return false;
				firstMove = false; // First move false;
				return true;
			} else if (rowDiff == direction) { // One tile forward
				if (lvlDiff > 1 || lvlDiff < -1) return false;
				if (firstMove) firstMove = false;
				return true;
			}
		}
		
		// Check for diagonal capture
		// if (Math.abs(colDiff) == 1 && rowDiff == direction) return true;
		
		return false; // None of the above. Invalid move
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
