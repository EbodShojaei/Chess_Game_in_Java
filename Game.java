import java.util.List;
import java.util.ArrayList;

public class Game {
	private final Board board;
	private final List<Observer> observers;
	
	public Game() {
		this.board = new Board();
		this.observers = new ArrayList<>();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setMove(int x, int y) {
		for (Observer observer : observers) {
			observer.onUpdate();
		}
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	private void callObserver() {
		for (Observer observer : observers) {
			observer.onUpdate();
		}
	}
}