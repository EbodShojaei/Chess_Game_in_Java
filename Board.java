public class Board {
	private final Tile[][] tiles;
	private final int width = 8;
	private final int height = 8;
	
	public Board() {
		tiles = new Tile[height][width]; // Standard 8 x 8 chess board
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				tiles[row][col] = new Tile(row, col);
			} 
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}
	
	public void setup(Player white, Player black) {
		// Add pawns
		for (int col = 0; col < width; col++) {
			tiles[1][col] = new Tile(1, col, new Pawn(black, tiles[1][col]));
			tiles[6][col] = new Tile(1, col, new Pawn(white, tiles[6][col]));
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
		for (int col = 0; col < width; col++) {
			tiles[2][col] = new Tile(2, col);
			tiles[3][col] = new Tile(3, col);
			tiles[4][col] = new Tile(4, col);
			tiles[5][col] = new Tile(5, col);
		}
	}
}
	