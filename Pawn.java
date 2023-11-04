import java.awt.Color;

public class Pawn extends Piece {
	public Pawn(Color color) {
		super(Name.P, color);
	}
	
	public boolean checkMove(Position position) {
		return true;
	}
}