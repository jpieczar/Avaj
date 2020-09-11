package simulator.aircraft;

import simulator.run.Main;
import simulator.run.Reader;
import simulator.interfaces.Flyable;
import simulator.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		int newLong = this.coordinates.getLongitude();
		int newLat = this.coordinates.getLatitude();
		int newHeight = this.coordinates.getHeight();

		switch (Main.sky){
			case ("FOG"):
				if ((newHeight - 3) <= 0) {
					Reader.writeFile("baloon#" + this.name + "(" + this.id + ") I've landed, and I can't get up.");
					this.weatherTower.unregister(this);
					Reader.writeFile("Tower says: Baloon#" + (this.name) + "(" + (this.id) + ") unregistered from weather tower.");
					return;
				}
				this.coordinates = new Coordinates(newLong, newLat, newHeight - 3);
				Reader.writeFile("Baloon#" + this.name + "(" + this.id + ") Brain fog sucks.");
				break;
			case ("RAIN"):
				if ((newHeight - 5) <= 0) {
					Reader.writeFile("baloon#" + this.name + "(" + this.id + ") I've landed, and I can't get up.");
					this.weatherTower.unregister(this);
					Reader.writeFile("Tower says: Baloon#" + (this.name) + "(" + (this.id) + ") unregistered from weather tower.");
					return;
				}
				this.coordinates = new Coordinates(newLong, newLat, newHeight - 5);
				Reader.writeFile("baloon#" + this.name + "(" + this.id + ") it's raining, it's pouring.");
				break;
			case ("SNOW"):
				if ((newHeight - 15) <= 0) {
					Reader.writeFile("baloon#" + this.name + "(" + this.id + ") I've landed, and I can't get up.");
					this.weatherTower.unregister(this);
					Reader.writeFile("Tower says: Baloon#" + (this.name) + "(" + (this.id) + ") unregistered from weather tower.");
					return;
				}
				this.coordinates = new Coordinates(newLong, newLat, newHeight - 15);
				Reader.writeFile("Baloon#" + this.name + "(" + this.id + ") Am I in a snowglobe?");
				//System.out.println("Baloon#" + this.name + "(" + this.id + ") Am I in a snowglobe?");
				break;
			case ("SUN"):
				if ((newHeight + 4) > 100) {
					newHeight = 96;
				}
				this.coordinates = new Coordinates(newLong + 2, newLat, newHeight + 4);
				Reader.writeFile("Baloon#" + this.name + "(" + this.id + ") It's too bright out here ...");
				//System.out.println("Baloon#" + this.name + "(" + this.id + ") It's too bright out here ...");
				break;
		}
		return;
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Reader.writeFile("Tower says: Baloon#" + (this.name) + "(" + (this.id) + ") registered to weather tower.");
		return;
	}
}
