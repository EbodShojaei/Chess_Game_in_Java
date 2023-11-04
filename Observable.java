import java.util.List;
import java.util.ArrayList;

public class Observable {
	private List<Observer> observers = new ArrayList<>();
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void pingObservers() {
		for (Observer o : observers) {
			o.update();
		}
	}
}