import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Subclass represents a classic 8 x 8 chess board.
 */
public class TwoDBoard implements Board {
	private final List<Position> board;
	private final Piece[][] pieces;
	private final int width = 8;
	private final int height = 8;
	
	/**
	 * Constructor.
	 */
	public TwoDBoard() {
		// Standard 8 x 8 chess board
		pieces = new Piece[height][width];
		board = new ArrayList<Position>(height * width);
		
		// Set up board layout
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				board.add(new Position(row, col));
			}
		}
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
	 * Gets board size.
	 */
	@Override
	public int getSize() {
		return width * height;
	}
	
	/**
	 * Gets tile position.
	 */
	@Override
	public Position getTile(int index) {
		return board.get(index);
	}
	
	/**
	 * Gets a piece.
	 */
	@Override
	public Piece getPiece(Position pos) {
		if (this.hasPiece(pos)) return pieces[pos.getX()][pos.getY()];
		return null;
	}
	
	/**
	 * Checks for a piece.
	 */
	@Override
	public boolean hasPiece(Position pos) {
		if (pieces[pos.getX()][pos.getY()] != null) return true;
		return false;
	}
	
	/**
	 * Moves a piece.
	 */
	@Override
	public boolean movePiece(Position start, Position end) {
		// Check for a piece and if the move is valid.
		Piece piece = this.getPiece(start);
		try {
			if (piece == null) throw new Exception("Error: No piece to move.");
			if (!piece.checkMove(end)) throw new Exception("Error: Invalid move.");
			
			// Player cannot attack their own pieces.
			if (this.hasPiece(end))
				if (piece.getColor().equals(this.getPiece(end).getColor())) 
					throw new Exception("Error: Cannot capture own piece.");
			
			// Move to new tile. Clear previous tile.
			pieces[start.getX()][start.getY()] = null;
			pieces[end.getX()][end.getY()] = piece;
			return true;
		} catch (Exception e) {
			System.out.printf("%s\n", e.getMessage()); // Throws to controller
			return false;
		} finally {
			System.out.printf("Piece (%s) moved to [%d, %d].\n", piece.getName().name(), end.getX(), end.getY());
		}
	}

	@Override
	public void setup() {		
		// Add pawns
		for (int col = 0; col < width; col++) {
			pieces[1][col] = new Pawn(Color.BLACK);
			pieces[6][col] = new Pawn(Color.WHITE);
		}
		
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
