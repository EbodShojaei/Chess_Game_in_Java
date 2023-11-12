import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents possible movements of a chess piece.
 */
public enum Movement {
	VERTICAL(Arrays.asList(new Position(0, 1), new Position(0, -1))),
	HORIZONTAL(Arrays.asList(new Position(1, 0), new Position(-1, 0))),
	DIAGONAL(Arrays.asList(new Position(1, 1), new Position(-1, -1), new Position(-1, 1), new Position(1, -1))),
	L_SHAPE(Arrays.asList(new Position(1, 2), new Position(1, -2), new Position(-1, 2), new Position(-1, -2),
						  new Position(2, 1), new Position(2, -1), new Position(-2, 1), new Position(-2, -1)));
	
	/** 
	 * Initializes a Movement with possible directions.
	 *
	 * @param directions is the possible moves
	 */
	private List<Position> directions;
	
	Movement(List<Position> directions) {
		this.directions = directions;
	}
	
	/** Gets the possible directions for a Movement. */
	public List<Position> getDirections() {
		return directions;
	}
}
