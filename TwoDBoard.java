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
	 * Initializes a classic 8 x 8 chess board. 
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
	 * Gets board level (z-axis).
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
			System.out.printf("Piece (%s) moved to [%d, %d].\n", piece.getName().name(), end.getX(), end.getY());
			
			return true;
		} catch (Exception e) {
			System.out.printf("%s\n", e.getMessage()); // Throws to controller
			return false;
		}
	}

	/**
	 * Sets up the pieces on the board.
	 */
	@Override
	public void setup() {		
		// Add pawns
		for (int col = 0; col < width; col++) {
			pieces[1][col] = new Pawn(Color.BLACK);
			pieces[6][col] = new Pawn(Color.WHITE);
		}
		
		// Add rooks
		pieces[0][0] = new Rook(Color.BLACK);
		pieces[0][7] = new Rook(Color.BLACK);
		pieces[7][0] = new Rook(Color.WHITE);
		pieces[7][7] = new Rook(Color.WHITE);
		
		// Add knights
		pieces[0][1] = new Knight(Color.BLACK);
		pieces[0][6] = new Knight(Color.BLACK);
		pieces[7][1] = new Knight(Color.WHITE);
		pieces[7][6] = new Knight(Color.WHITE);
		
		// Add bishops
		pieces[0][2] = new Bishop(Color.BLACK);
		pieces[0][5] = new Bishop(Color.BLACK);
		pieces[7][2] = new Bishop(Color.WHITE);
		pieces[7][5] = new Bishop(Color.WHITE);
		
		// Add Queen
		pieces[0][3] = new Queen(Color.BLACK);
		pieces[7][3] = new Queen(Color.WHITE);
		
		// Add King
		pieces[0][4] = new King(Color.BLACK);
		pieces[7][4] = new King(Color.WHITE);
	}
}
