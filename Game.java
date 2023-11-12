import java.awt.Color;

/**
 * Represents a model for managing the state 
 * of the chess board and viewer.
 */
public class Game extends Observable {
	/** Represents the chess board. */
	private final Board board = new TwoDBoard();
	
	/** Represents a player. */
	private final Player player1 = new Player(Color.WHITE);
	
	/** Represents another player. */
	private final Player player2 = new Player(Color.BLACK);
	
	/** Represents the current turn. */
	private Player turn = player1;
	
	/** Initializes the game. */
	public Game() {
		board.setup();
	}
	
	/** 
	 * Gets the chess board.
	 * 
	 * @return board currently in use
	 */
	public Board getBoard() {
		return board;
	}
	
	/** 
	 * Initializes the controller.
	 * 
	 * @return turn of current player
	 */
	public Player getTurn() {
		return turn;
	}
	
	/** 
	 * Changes turns to the next player.
	 */
	private void switchTurn() {
		if (turn.equals(player1)) turn = player2;
		else turn = player1;
	}
	
	/** 
	 * Handles piece movement.
	 */
	public void makeMove(Position start, Position end) {
		// Check player moving own piece
		if (board.movePiece(start, end)) {
			switchTurn(); // Switch turns
			this.pingObservers(); // Notify viewer
		}
		System.out.printf("Current turn: %s\n", (turn == player1) ? "WHITE" : "BLACK");
	}
}