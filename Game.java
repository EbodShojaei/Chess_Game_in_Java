import java.util.List;
import java.util.ArrayList;

public class Game {
	private final Board board;
	private final Player player1;
	private final Player player2;
	private Player turn;
	private List<Observer> observers = new ArrayList<>();
	
	public Game() {
		this.board = new Board();
		this.player1 = new Player(Color.WHITE);
		this.player2 = new Player(Color.BLACK);
		this.turn = player1;
		board.setup(player1, player2);
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Player getTurn() {
		return turn;
	}
	
	private void switchPlayer() {
		if (turn == player1) {
			turn = player2;
		} else {
			turn = player1;
		}
	}
	
	public void setMove(Tile source, Tile target) {
		Piece piece = source.getPiece();
		
		if (piece != null && piece.getPlayer() == turn) {
			if (piece.checkMove(board, target)) {
				piece.move(board, target);
				switchPlayer();
				updateObservers();
			} else {
				System.out.println("Invalid Move!");
			}
		} else {
			System.out.println("Not your piece!");
		}
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void updateObservers() {
		for (Observer o : observers) {
			o.onUpdate();
		}
	}
}