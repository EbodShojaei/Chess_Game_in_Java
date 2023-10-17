public class Tile {
	private final int x;
	private final int y;
	private Piece piece;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.piece = null;
	}
	
	public Tile(int x, int y, Piece piece) {
		this.x = x;
		this.y = y;
		this.piece = piece;
	}
	
	public boolean hasPiece() {
		return piece != null;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}