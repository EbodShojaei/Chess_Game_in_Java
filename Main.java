/** Driver program for a chess game. */
public class Main {
	public static void main(String[] args) {
		int numberOfBoards = 3;
		if (args.length == 1) {
			try {
				numberOfBoards = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid number entered.");
			}
		} else if (args.length != 0) {
			System.out.println("Error: Usage <numberOfBoards>");
			System.exit(1);
		}
		// Initialize the Model View Controller
		Game game = new Game(numberOfBoards); // Default is single board. Else specify number boards.
		Controller controller = new Controller(game);
		Viewer viewer = new Viewer(game, controller);
	}
}