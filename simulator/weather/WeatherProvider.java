package simulator.weather;

import java.util.Random;

import simulator.aircraft.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"FOG", "RAIN", "SNOW", "SUN"};

	// This is a constructor. This initialises the two variables above.
	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		return weatherProvider; // Returning the instance of the class in line 4.
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int num = new Random().nextInt(4);
		return weather[num];
	}
}
