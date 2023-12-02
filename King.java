import java.awt.Color;
import javax.swing.ImageIcon;

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
	@Override
	public boolean checkMove(Position start, Position end) {
		int rowDiff = Math.abs(end.getX() - start.getX());
		int colDiff = Math.abs(end.getY() - start.getY());
		int lvlDiff = Math.abs(end.getZ() - start.getZ());
		
		// Check that both X and Y moves 1 tile
		return rowDiff <= 1 && colDiff <= 1 && lvlDiff <= 1;
	}
	
	/** Gets the piece icon. 
	 * 
	 * @return ImageIcon is a chess piece icon.
	 */
	@Override
	public ImageIcon getIcon() {
		String fileName = this.getColor().equals(Color.WHITE) ? "kw" : "kb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}
