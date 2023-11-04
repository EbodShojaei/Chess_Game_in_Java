/** Represents Cartesian coordinates. */
public class Position {
	/** Represents X-axis (abscissa). */
	private final int x;
	
	/** Represents Y-axis (ordinate). */
	private final int y;
	
	/** Represents X-axis (applicate). */
	private final int z;
	
	/** 
	 * Initializes a position.
	 *
	 * @param x is the abscissa
	 * @param y is the ordinate
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	/** 
	 * Initializes a position.
	 *
	 * @param x is the abscissa
	 * @param y is the ordinate
	 * @param z is the applicate
	 */
	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/** 
	 * Gets x.
	 *
	 * @return x as the abscissa
	 */
	public int getX() {
		return x;
	}
	
	/** 
	 * Gets y.
	 *
	 * @return y as the ordinate
	 */
	public int getY() {
		return y;
	}
	
	/** 
	 * Gets z.
	 *
	 * @return z as the applicate
	 */
	public int getZ() {
		return z;
	}
}