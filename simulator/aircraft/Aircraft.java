package simulator.aircraft;

// Only subclasses can access the protected attributes.

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = idCounter;
		idCounter += nextID();
	}

	private long nextID() {
		return 1;
	}
}
