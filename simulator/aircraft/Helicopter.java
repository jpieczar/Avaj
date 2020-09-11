package simulator.aircraft;

import simulator.run.Main;
import simulator.run.Reader;
import simulator.interfaces.Flyable;
import simulator.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		int newLong = this.coordinates.getLongitude();
		int newLat = this.coordinates.getLatitude();
		int newHeight = this.coordinates.getHeight();

		switch (Main.sky) {
			case ("FOG"):
				this.coordinates = new Coordinates(newLong + 1, newLat, newHeight);
				Reader.writeFile("Helicopter#" + this.name + "(" + this.id + ") Its Foggy.");
				break;
			case ("RAIN"):
				this.coordinates = new Coordinates(newLong + 5, newLat, newHeight);
				Reader.writeFile("Helicopter#" + this.name + "(" + this.id + ") Rain, rain, go away ...");
				break;
			case ("SNOW"):
				if ((newHeight - 12) <= 0) {
					Reader.writeFile("Helicopter#" + this.name + "(" + this.id + ") I've landed, and I can't get up.");
					this.weatherTower.unregister(this);
					Reader.writeFile("Tower says: Helicopter#" + (this.name) + "(" + (this.id) + ") unregistered from weather tower.");
					return;
				}
				this.coordinates = new Coordinates(newLong, newLat, newHeight - 12);
				Reader.writeFile("Helicopter#" + this.name + "(" + this.id + ") Snowy.");
				break;
			case ("SUN"):
				if ((newHeight + 2) > 100) {
					newHeight = 98;
				}
				this.coordinates = new Coordinates(newLong + 10, newLat, newHeight + 2);
				Reader.writeFile("Helicopter#" + this.name + "(" + this.id + ") I'm gonna touch the sun.");
				break;
		}
		return;
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Reader.writeFile("Tower says: Helicopter#" + (this.name) + "(" + (this.id) + ") registered to weather tower.");
		return;
	}
}
