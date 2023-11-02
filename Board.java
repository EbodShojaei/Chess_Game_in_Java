public interface Board {
	boolean hasPiece(Position pos);
	Piece getPiece(Position pos);
	void movePiece(Position start, Position end);
	int getWidth();
	int getHeight();
	int getLevel();
}
