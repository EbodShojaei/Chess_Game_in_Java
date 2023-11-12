/**
 * Represents a controller for handling mouse events 
 * from selecting and moving pieces.
 */
public class Controller {
	/** Represents a chess game i.e., the model. */
	private final Game game;
	
	/** Represents currently selected tile. */
	private Position selectedTile;
	
	/** 
	 * Initializes the controller.
	 * 
	 * @param game is a chess game
	 */
	public Controller(Game game) {
		this.game = game;
	}
	
	/** 
	 * Enables selection of tiles and movement
	 * of pieces on next tile click.
	 *
	 * @param position is the tile coordinates
	 */
	public void selectTile(Position position) {
		if (selectedTile != null) {
			// If tile already selected, handle movement.
			Player currentPlayer = game.getTurn();
			
			// Get the selected piece before moving it
			Piece current = game.getBoard().getPiece(selectedTile);
			game.makeMove(selectedTile, position);
			
			// If the move was not successful, reset the selected tile.
			if (current != game.getBoard().getPiece(position)) selectedTile = null;
			if (!game.getTurn().equals(currentPlayer)) selectedTile = null;
		} else {
			// Check if tile has piece that belongs to player.
			if (game.getBoard().hasPiece(position) &&
				game.getBoard().getPiece(position).getColor().equals(game.getTurn().getColor())) {
				selectedTile = position; // If current player owns piece, select tile.
			} else {
				// Either no piece on tile or is owned by the opponent. Handle error.
				System.out.println("Error: You must select your own piece.");
			}
		}
	}
}