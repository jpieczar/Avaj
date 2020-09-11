package simulator.run;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Random;
import simulator.weather.WeatherProvider;

import simulator.aircraft.Coordinates;
import simulator.aircraft.Baloon;
import simulator.interfaces.Flyable;
import simulator.aircraft.AircraftFactory;
import simulator.tower.WeatherTower;
import simulator.tower.Tower;
import simulator.run.Reader;

public class Main {

	public static String sky;

	public static void main(String[] args) {

		int rand = new Random().nextInt(150);
		int dran = new Random().nextInt(150);
		int ndra = new Random().nextInt(150);
		Coordinates cv1 = new Coordinates(rand, dran, ndra);
		WeatherTower weatherTower = new WeatherTower(); //>*>*>*>*
		int simRun = 0; // >*>*>*>*

		if (args.length == 1) {
			Reader redFile = new Reader();
			try {
				simRun = redFile.readFile(args[0], weatherTower);
			}
			catch (FileNotFoundException e) {
				System.out.println("File does not exist!!!");
			}
		}
		else {
			System.out.println("Provide scenario file for the simulation.");
		}
		if (simRun > 0) {
			while (simRun > 0) {
				sky = weatherTower.getWeather(cv1);
				weatherTower.changeWeather();
				simRun--;
			}
			Reader.makeFile();
			return;
		}
		else {
			System.out.println("The scenario needs a valid number of runs.");
			return;
		} // >*>*>*>*
	}
}
