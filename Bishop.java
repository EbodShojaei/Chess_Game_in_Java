import java.awt.Color;
import javax.swing.ImageIcon;

/** Represents a Bishop for chess. */
public class Bishop extends Piece {
	/** 
	 * Initializes a Bishop.
	 *
	 * @param color is a chess piece color.
	 */
	public Bishop(Color color) {
		super(Name.B, color);
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
		
		// Check for diagonal move > 0
		return rowDiff == colDiff && rowDiff != 0;
	}
	
	/** Gets the piece icon. 
	 * 
	 * @return ImageIcon is a chess piece icon.
	 */
	@Override
	public ImageIcon getIcon() {
		String fileName = this.getColor().equals(Color.WHITE) ? "bw" : "bb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}