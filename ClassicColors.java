public enum ClassicColors implements Color {
	WHITE,
	BLACK;
	
	/**
	 * What is the name of the piece?
	 */
	public String getName() {
		return this.name();
	}
}

// Now we can create new enums aka 'packs' of colors nested under type 'Colors'
// e.g., public enum DragonWizardPieces implements Pieces