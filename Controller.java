public class Controller {
	private final Game game;
	private Tile sourceTile = null;
	
	public Controller(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void handleTileClick(int x, int y) {
		Tile clickedTile = game.getBoard().getTile(x, y);
		
		if (sourceTile == null) {
			if (clickedTile.hasPiece() && clickedTile.getPiece().getPlayer() == game.getTurn()) {
				sourceTile = clickedTile;
			}
		} else {
			game.setMove(sourceTile, clickedTile);
			sourceTile = null;
		}

		System.out.println("Clicked");
	}
}