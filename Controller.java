public class Controller {
	private final Game game;
	
	public Controller(Game game) {
		this.game = game;
	}
	
	public void handleTileClick(int x, int y) {
		game.setMove(x, y);
	}
}