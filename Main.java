/** Driver program for a chess game. */
public class Main {
	public static void main(String[] args) {
		// Initialize the Model View Controller
		Game game = new Game();
		Controller controller = new Controller(game);
		Viewer viewer = new Viewer(game, controller);
	}
}