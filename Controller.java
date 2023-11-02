public class Controller {
	private final Game game;
	
	public Controller(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void handleTileClick(int x, int y) {
		System.out.println("Clicked");
	}
}