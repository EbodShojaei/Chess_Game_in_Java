public class Controller {
	private final Game game;
	private Position selectedTile;
	
	public Controller(Game game) {
		this.game = game;
	}
	
	public void selectTile(Position position) {
		if (selectedTile != null) {
			// If tile already selected, handle movement.
			Player currentPlayer = game.getTurn();
			game.makeMove(selectedTile, position);
			if (!game.getTurn().equals(currentPlayer)) selectedTile = null;
		} else {
			if (game.getBoard().hasPiece(position) &&
				game.getBoard().getPiece(position).getColor().equals(game.getTurn().getColor())) {
				// If current player owns piece, select tile.
				selectedTile = position;
			} else {
				// Either no piece on tile or is owned by the opponent. Handle error.
				System.out.println("Error: You must select your own piece.");
			}
		}
	}
}