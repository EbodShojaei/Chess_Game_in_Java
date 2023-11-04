import java.awt.Color;

public class Game extends Observable {
	private final Board board = new TwoDBoard();
	private final Player player1 = new Player(Color.WHITE);
	private final Player player2 = new Player(Color.BLACK);
	private Player turn = player1;
	
	public Game() {
		board.setup();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Player getTurn() {
		return turn;
	}
	
	private void switchTurn() {
		if (turn.equals(player1)) turn = player2;
		else turn = player1;
	}
	
	public void makeMove(Position start, Position end) {
		// Check player moving own piece
		try {
			if (board.hasPiece(start) && !board.getPiece(start).getColor().equals(this.getTurn().getColor())) 
				throw new Exception("Error: Cannot move opponent piece.");
			
			if (board.movePiece(start, end)) switchTurn(); // Switch turns
			this.pingObservers(); // Notify viewer
		} catch (Exception e) {
			System.out.printf("%s\n", e.getMessage()); // Throws to controller
		} finally {
			System.out.printf("Current turn: %s\n", (turn == player1) ? "WHITE" : "BLACK");
		}
	}
}