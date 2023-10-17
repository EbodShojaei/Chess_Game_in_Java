public abstract class Piece {
	private Name name;
	private Player player;
	private Tile tile;
	
	public Piece(Name name, Player player, Tile tile) {
		this.player = player;
		this.name = name;
		this.tile = tile;
	}
	
	public abstract boolean checkMove(Board board, Tile target);
	
	public void move(Board board, Tile target) {
		if (checkMove(board, target)) {
			target.setPiece(this); // Make target reference piece
			this.tile.setPiece(null); // Make previous tile empty
			this.tile = target; // Piece references target 
		}
	}
	
	public Name getName() {
		return this.name;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Tile getTile() {
		return this.tile;
	}
}
	