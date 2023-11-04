import java.awt.Color;

/** Represents a chess player. */
public class Player {
	/** Represents the assigned color (e.g., WHITE or BLACK). */
	private final Color color;
	
	/** Initializes a chess player. */
	public Player(Color color) {
		this.color = color;
	}
	
	/** 
	 * Gets the player color. 
	 *
	 * @return color of player
	 */
	public Color getColor() {
		return color;
	}
}