package simulator.tower;

import java.util.ArrayList; // This is used because standard arrays are not resizable.
import java.util.List;

import simulator.interfaces.Flyable;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) {
		this.observers.add(flyable);
		return;
	}

	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
		return;
	}

	protected void conditionsChanged() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
		return;
	}
}
