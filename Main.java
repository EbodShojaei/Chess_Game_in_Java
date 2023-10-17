import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		Controller controller = new Controller(game);
		Viewer viewer = new Viewer(game, controller);
	}
}