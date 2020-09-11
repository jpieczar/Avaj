package simulator.aircraft;

import simulator.aircraft.Coordinates;
import simulator.aircraft.Baloon;
import simulator.aircraft.Helicopter;
import simulator.aircraft.JetPlane;
import simulator.interfaces.Flyable;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		switch (type) {
			case "Baloon":
				return new Baloon(name, coordinates); // returns an object baloon.
			case "Helicopter":
				return new Helicopter(name, coordinates);
			case "JetPlane":
				return new JetPlane(name, coordinates);
		}
		return null;
	}
}
