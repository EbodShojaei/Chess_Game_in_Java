/**
 * Subclass represents a classic 8 x 8 chess board.
 */
public class TwoDBoard implements Board {
	private final Piece[][] board;
	private final int width = 8;
	private final int height = 8;
	
	/**
	 * Constructor.
	 */
	public TwoDBoard() {
		board = new Piece[height][width]; // Standard 8 x 8 chess board
	}
	
	/**
	 * Gets board width.
	 */
	@Override
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gets board height.
	 */
	@Override
	public int getHeight() {
		return height;
	}
	
	/**
	 * Gets board level.
	 */
	@Override
	public int getLevel() {
		return 0;
	} 

	/**
	 * Checks for a piece.
	 */
	@Override
	public boolean hasPiece(Position pos) {
		if (board[pos.getX()][pos.getY()] != null) return true;
		return false;
	}
	
	/**
	 * Gets a piece.
	 */
	@Override
	public Piece getPiece(Position pos) {
		if (this.hasPiece(pos)) return board[pos.getX()][pos.getY()];
		return null;
	}
	
	/**
	 * Moves a piece.
	 */
	@Override
	public void movePiece(Position start, Position end) {
		// Check for a piece and if the move is valid. 
		Piece piece = this.getPiece(start);
		if (piece == null) return;
		if (!piece.checkMove(end)) return;
		if (piece.getColor() == this.getPiece(end).getColor()) return;
		
		// Move to new tile. Clear previous tile.
		board[start.getX()][start.getY()] = null;
		board[end.getX()][end.getY()] = piece;
	}

	public void setup(Player white, Player black) {
		// Add pawns
		// for (int col = 0; col < width; col++) {
			// tiles[1][col] = new Tile(1, col, new Pawn(black, tiles[1][col]));
			// tiles[6][col] = new Tile(1, col, new Pawn(white, tiles[6][col]));
		// }
		
		// Add rooks
		// tiles[0][0] = new Tile(0, 0, new Rook(black));
		// tiles[0][7] = new Tile(0, 7, new Rook(black));
		// tiles[7][0] = new Tile(7, 0, new Rook(white));
		// tiles[7][7] = new Tile(7, 7, new Rook(white));
		
		// Add knights
		// tiles[0][1] = new Tile(0, 1, new Knight(black));
		// tiles[0][6] = new Tile(0, 6, new Knight(black));
		// tiles[7][1] = new Tile(7, 1, new Knight(white));
		// tiles[7][6] = new Tile(7, 6, new Knight(white));
		
		// Add bishops
		// tiles[0][2] = new Tile(0, 2, new Bishop(black));
		// tiles[0][5] = new Tile(0, 5, new Bishop(black));
		// tiles[7][2] = new Tile(7, 2, new Bishop(white));
		// tiles[7][5] = new Tile(7, 5, new Bishop(white));
		
		// Add Queen
		// tiles[0][3] = new Tile(0, 3, new Queen(black));
		// tiles[7][3] = new Tile(7, 3, new Queen(white));
		
		// Add King
		// tiles[0][4] = new Tile(0, 4, new King(black));
		// tiles[7][4] = new Tile(7, 4, new King(white));
		
		// Empty remaining tiles
		// for (int col = 0; col < width; col++) {
			// tiles[2][col] = new Tile(2, col);
			// tiles[3][col] = new Tile(3, col);
			// tiles[4][col] = new Tile(4, col);
			// tiles[5][col] = new Tile(5, col);
		// }
	}
}
