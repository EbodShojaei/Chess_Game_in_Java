public class Game {
	private final Board board;
	private final Player player1;
	private final Player player2;
	private Player turn;
	
	public Game() {
		this.board = new Board();
		this.player1 = new Player(Color.WHITE);
		this.player2 = new Player(Color.BLACK);
	}
	
	public Board getBoard() {
		return board;
	}
}