// Buy the DLC to get the Dragon Piece Extension Pack
//
public enum ClassicPieces implements Name {
	KING,
	QUEEN,
	ROOK,
	BISHOP,
	KNIGHT,
	PAWN;
	
	/**
	 * What is the name of the piece?
	 */
	public String getName() {
		return this.name();
	}
}

// Now we can create new enums aka 'packs' of pieces nested under type 'Name'
// e.g., public enum DragonWizardPieces implements Pieces