class Foo {
	public static void main(String[] args) {
		Board board = new TwoDBoard();
		System.out.printf("%d\n", board.getWidth());
		System.out.printf("%d\n", board.getHeight());
		System.out.printf("%d\n", board.getLevel());
	
		Game game = new Game();
		Position start = new Position(1, 2);
		Position end = new Position(3, 4);
		
		System.out.printf("%s\n", game.getTurn().getColor()); // WHITE
		game.makeMove(start, end);
		System.out.printf("%s\n", game.getTurn().getColor()); // BLACK
		game.makeMove(start, end);
		System.out.printf("%s\n", game.getTurn().getColor()); // WHITE
	}
}