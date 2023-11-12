import java.awt.Color;
import javax.swing.ImageIcon;

/** Represents a chess piece. */
public abstract class Piece {
	/** Represents name of the chess piece. */
	private Name name;
	
	/** Represents the assigned color (e.g., WHITE or BLACK). */
	private Color color;
	
	/** 
	 * Initializes a chess piece.
	 *
	 * @param name is a chess piece name
	 * @param color is a chess piece color
	 * @param icon is a chess piece icon
	 */
	public Piece(Name name, Color color) {
		this.name = name;
		this.color = color;
	}
	
	/** 
	 * Gets the piece name. 
	 *
	 * @return name of piece
	 */
	public Name getName() {
		return this.name;
	}
	
	/** 
	 * Gets the piece color. 
	 *
	 * @return color of piece
	 */
	public Color getColor() {
		return this.color;
	}
	
	/** 
	 * Gets the piece icon. 
	 *
	 * @return icon of piece
	 */
	abstract ImageIcon getIcon();
	
	/** Checks if the piece can move to the position. 
	 * 
	 * @param position is a tile coordinate.
	 * @return true if valid move, else false.
	 */
	public abstract boolean checkMove(Position start, Position end);
}
	