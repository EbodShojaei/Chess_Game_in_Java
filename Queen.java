import java.awt.Color;
import javax.swing.ImageIcon;

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
	@Override
	public boolean checkMove(Position start, Position end) {
		int rowDiff = Math.abs(end.getX() - start.getX());
		int colDiff = Math.abs(end.getY() - start.getY());
		
		// Check for horizontal or vertical move
		boolean rowOrCol = rowDiff == 0 || colDiff == 0;
		
		// Check for diagonal move
		boolean isDiag = rowDiff == colDiff;
		
		return rowOrCol || isDiag;
	}
	
	/** Gets the piece icon. 
	 * 
	 * @return ImageIcon is a chess piece icon.
	 */
	@Override
	public ImageIcon getIcon() {
		String fileName = this.getColor().equals(Color.WHITE) ? "qw" : "qb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}