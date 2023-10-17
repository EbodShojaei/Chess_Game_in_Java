public abstract class Tile {
	private final int x;
	private final int y;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract boolean hasPiece();
	
	public abstract Piece getPiece();
	
	// Introduce immutability and type safety
	public static final class EmptyTile extends Tile {
		public EmptyTile(int x, int y) {
			super(x, y);
		}
		
		@Override
		public boolean hasPiece() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
	}
	
	public static final class OccupiedTile extends Tile {
		private final Piece piece;
		
		public OccupiedTile(int x, int y, Piece piece) {
			super(x, y);
			this.piece = piece;
		}
		
		@Override
		public boolean hasPiece() {
			return true;
		}
		
		@Override
		public Piece getPiece() {
			return this.piece;
		}
	}
}