import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Subclass represents a classic 8 x 8 chess board.
 */
public class TwoDBoard implements Board {
	private final List<Position> board;
	private final Piece[][][] pieces; // Why hello there. New dimensions
	private final int width = 8;
	private final int height = 8;
	private final int level;
	
	/**
	 * Initializes a classic 8 x 8 chess board. 
	 */
	public TwoDBoard() {
		// Standard 8 x 8 chess board
		this.level = 1;
		pieces = new Piece[height][width][level];
		board = new ArrayList<Position>(height * width);
		
		// Set up board layout
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				board.add(new Position(row, col));
			}
		}
	}
	
	/**
	 * Overriden constructor. Allows variable number chess boards.
	 * Initializes a 3D 8 x 8 x N chess board. N is levels.
	 */
	public TwoDBoard(int levels) {
		// Standard 8 x 8 x N chess board
		this.level = levels;
		pieces = new Piece[height][width][level];
		board = new ArrayList<Position>(height * width * level);
		
		// Set up board layout
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				for (int lvl = 0; lvl < this.level; lvl++) {
					board.add(new Position(row, col, lvl));
				}
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
		return level;
	} 
	
	/**
	 * Gets board size.
	 */
	@Override
	public int getSize() {
		return width * height * level; // Asking if third-dimensional
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
		if (this.hasPiece(pos)) return pieces[pos.getX()][pos.getY()][pos.getZ()]; // Default Z was always 0. Just being explicit now that it's variable
		return null;
	}
	
	/**
	 * Checks for a piece.
	 */
	@Override
	public boolean hasPiece(Position pos) {
		if (pieces[pos.getX()][pos.getY()][pos.getZ()] != null) return true;
		return false;
	}
	
	/**
	 * Checks if path is empty.
	 */
	@Override
	public boolean checkPath(Position start, Position end) {
		int dx = Integer.signum(end.getX() - start.getX());
		int dy = Integer.signum(end.getY() - start.getY());
		int dz = Integer.signum(end.getZ() - start.getZ()); // Default was always 0. Just being explicit with Z now that it's variable
		int x = start.getX() + dx;
		int y = start.getY() + dy;
		int z = start.getZ() + dz; // This method finally came in handy.
		System.out.println("end: " + end.getZ());
		System.out.println("start " + start.getZ());
		System.out.println("dz " + dz);
		while (x != end.getX() || y != end.getY() || z != end.getZ()) { 
			if (this.hasPiece(new Position(x, y, z))) return false;		
			x += dx;
			y += dy;
			if (z < end.getZ()) z += dz; // Yup. Level up (Default 0).
			System.out.println(z);
		}
		return true;
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
			if (!piece.checkMove(start, end)) throw new Exception("Error: Invalid move."); // Piece checking
			if (!(piece instanceof Knight) && !checkPath(start, end)) throw new Exception("Error: Path is not clear."); // Path checking
			if (this.hasPiece(end)) throw new Exception("Error: Cannot capture piece."); // TEMP: IF ANOTHER PIECE AT TARGET THEN DO NOT MOVE THE PIECE
			
			// Player cannot attack their own pieces.
			if (this.hasPiece(end))
				if (piece.getColor().equals(this.getPiece(end).getColor())) 
					throw new Exception("Error: Cannot capture own piece.");
			
			// Move to new tile. Clear previous tile.
			pieces[start.getX()][start.getY()][start.getZ()] = null;
			pieces[end.getX()][end.getY()][end.getZ()] = piece;
			if (level > 1) { // Asking if third-dimensional
				System.out.printf("Piece (%s) moved to [%d, %d, %d].\n", 
					piece.getName().name(), end.getX(), end.getY(), end.getZ());
			} else {
				System.out.printf("Piece (%s) moved to [%d, %d].\n", 
					piece.getName().name(), end.getX(), end.getY());
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
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
			pieces[1][col][0] = new Pawn(Color.BLACK);
			pieces[6][col][0] = new Pawn(Color.WHITE);
		}
		
		// Add rooks
		pieces[0][0][0] = new Rook(Color.BLACK);
		pieces[0][7][0] = new Rook(Color.BLACK);
		pieces[7][0][0] = new Rook(Color.WHITE);
		pieces[7][7][0] = new Rook(Color.WHITE);
		
		// Add knights
		pieces[0][1][0] = new Knight(Color.BLACK);
		pieces[0][6][0] = new Knight(Color.BLACK);
		pieces[7][1][0] = new Knight(Color.WHITE);
		pieces[7][6][0] = new Knight(Color.WHITE);
		
		// Add bishops
		pieces[0][2][0] = new Bishop(Color.BLACK);
		pieces[0][5][0] = new Bishop(Color.BLACK);
		pieces[7][2][0] = new Bishop(Color.WHITE);
		pieces[7][5][0] = new Bishop(Color.WHITE);
		
		// Add Queen
		pieces[0][3][0] = new Queen(Color.BLACK);
		pieces[7][3][0] = new Queen(Color.WHITE);
		
		// Add King
		pieces[0][4][0] = new King(Color.BLACK);
		pieces[7][4][0] = new King(Color.WHITE);
	}
}
