import java.awt.Color;
import javax.swing.ImageIcon;

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
	@Override
	public boolean checkMove(Position start, Position end) {
		int rowDiff = Math.abs(end.getX() - start.getX());
		int colDiff = Math.abs(end.getY() - start.getY());
		int lvlDiff = Math.abs(end.getZ() - start.getZ());
		
		// Check for L-shaped move
		return (rowDiff == 2 && colDiff == 1 && lvlDiff <= 3) || (rowDiff == 1 && colDiff == 2 && lvlDiff <= 3);
	}
	
	/** Gets the piece icon. 
	 * 
	 * @return ImageIcon is a chess piece icon.
	 */
	@Override
	public ImageIcon getIcon() {
		String fileName = this.getColor().equals(Color.WHITE) ? "nw" : "nb";
		return new ImageIcon(getClass().getResource("/resources/images/" + fileName + ".png"));
	}
}
