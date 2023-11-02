public abstract class Piece {
	private Name name;
	private Color color;
	
	public Piece(Name name, Color color) {
		this.name = name;
		this.color = color;
	}
	
	public abstract boolean checkMove(Position pos);
	
	public Name getName() {
		return this.name;
	}
	
	public Color getColor() {
		return this.color;
	}
}
	