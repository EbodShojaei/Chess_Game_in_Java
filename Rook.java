import java.awt.Color;
import javax.swing.ImageIcon;

/** Represents a Rook for chess. */
public class Rook extends Piece {
	/** 
	 * Initializes a Rook.
	 *
	 * @param color is a chess piece color.
	 */
	public Rook(Color color) {
		super(Name.R, color);
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
		int maxDiff = Math.max(rowDiff, colDiff);
		
		// Check for horizontal or vertical move
		return (rowDiff == 0 || colDiff == 0) && lvlDiff <= maxDiff;
	}
	
	/** Gets the piece icon. 
	 * 
	 * @return ImageIcon is a chess piece icon.
	 */
	@Override
	public ImageIcon getIcon() {
		String fileName = this.getColor().equals(Color.WHITE) ? "rw" : "rb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}
