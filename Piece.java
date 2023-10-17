public abstract class Piece {
	private Name name;
	private Player player;
	private Tile tile;
	
	public Piece(Player player, Tile tile) {
		this.player = player;
		this.tile = tile;
	}
	
	public Piece(Player player) {
		this.player = player;
	}
	
	public Piece() {};
	
	public abstract boolean checkMove(Board board, Tile current, Tile target);
	
	public void move(Board board, Tile target) {
		if (checkMove(board, this.tile, target)) {
			this.tile = target; // Board is made of tiles. Each tile knows if occupied or not
		}
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
	public Name getName() {
		return this.name;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public Tile getTile() {
		return this.tile;
	}
}
	