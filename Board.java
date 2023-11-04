/** 
 * Represents a chess board. 
 */
interface Board {
	/** Abstract gets width (X-axis). */
	int getWidth();
	
	/** Abstract gets height (Y-axis). */
	int getHeight();
	
	/** Abstract gets level (Z-axis). */
	int getLevel();
	
	/** Abstract gets number of tiles. */
	int getSize();
	
	/** Abstract gets tile position. */
	Position getTile(int index);
	
	/** Abstract gets piece. */
	Piece getPiece(Position pos);
	
	/** Abstract checks for piece. */
	boolean hasPiece(Position pos);
	
	/** Abstract moves piece. */
	boolean movePiece(Position start, Position end);
	
	/** Abstract sets up board. */
	void setup();
}

