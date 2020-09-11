package simulator.aircraft;

import simulator.run.Main;
import simulator.run.Reader;
import simulator.interfaces.Flyable;
import simulator.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		int newLong = this.coordinates.getLongitude();
		int newLat = this.coordinates.getLatitude();
		int newHeight = this.coordinates.getHeight();

		switch (Main.sky) {
			case ("FOG"):
				this.coordinates = new Coordinates(newLong, newLat + 1, newHeight);
				Reader.writeFile("JetPlane#" + this.name + "(" + this.id + "): Ahhhh! I can't see!");
				break;
			case ("RAIN"):
				this.coordinates = new Coordinates(newLong, newLat + 5, newHeight);
				Reader.writeFile("JetPlane#" + this.name + "(" + this.id + "): Call Gene Kelly.");
				break;
			case ("SNOW"):
				if ((newHeight - 7) <= 0) {
					Reader.writeFile("JetPlane#" + this.name + "(" + this.id + ") I've landed, and I can't get up.");
					this.weatherTower.unregister(this);
					Reader.writeFile("Tower says: JetPlane#" + (this.name) + "(" + (this.id) + ") unregistered from weather tower.");
					return;
				}
				this.coordinates = new Coordinates(newLong, newLat, newHeight - 7);
				Reader.writeFile("JetPlane#" + this.name + "(" + this.id + "): Informer - Snow.");
				break;
			case ("SUN"):
				if ((newHeight + 2) > 100) {
					newHeight = 98;
				}
				this.coordinates = new Coordinates(newLong, newLat + 10, newHeight + 2);
				Reader.writeFile("JetPlane#" + this.name + "(" + this.id + "): Here comes the sun, do, dun, do, do");
				break;
		}
		return;
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Reader.writeFile("Tower says: JetPlane#" + (this.name) + "(" + (this.id) + ") registered to weather tower.");
		return;
	}
}
