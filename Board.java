public class Board {
	private final Tile[][] tiles;
	private final int width = 8;
	private final int height = 8;
	
	public Board() {
		tiles = new Tile[height][width]; // Standard 8 x 8 chess board
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				tiles[row][col] = new Tile.EmptyTile(row, col);
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
	
	// Set up board with pieces
	// public void setup() {}
}
	