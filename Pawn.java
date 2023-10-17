public class Pawn extends Piece {
	public Pawn(Player player, Tile tile) {
		super(Name.P, player, tile);
	}
	
	public boolean checkMove(Board board, Tile target) {
		return true;
	}
}