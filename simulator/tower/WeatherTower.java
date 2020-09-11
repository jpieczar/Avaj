package simulator.tower;

import simulator.tower.Tower;

import simulator.aircraft.Coordinates;
import simulator.weather.WeatherProvider;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	public void changeWeather() {
		this.conditionsChanged();
		return; // Jeans the beans.
	}
}
