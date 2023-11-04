import java.util.List;
import java.util.ArrayList;

/**
 * Represents an Observer for to communicate state changes 
 * from the model to viewer components.
 */
public class Observable {
	/** Represents observers tracking state changes of components. */
	private List<Observer> observers = new ArrayList<>();
	
	/** Adds an observer. */
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	/** Removes an observer. */
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	/** 
	 * Notifies observers of state changes. 
	 * 
	 * e.g., Player moves piece. Game pings observers. Viewer updates board.
	 */
	public void pingObservers() {
		for (Observer o : observers) {
			o.update();
		}
	}
}