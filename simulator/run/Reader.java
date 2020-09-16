package simulator.run;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import simulator.aircraft.AircraftFactory;
import simulator.interfaces.Flyable;
import simulator.tower.WeatherTower;

public class Reader {
	public static int readFile(String fileName, WeatherTower weatherTower) throws FileNotFoundException {
		int simRun = 0;

		File scenarioFile = new File(fileName);
		Scanner scnr = new Scanner(scenarioFile);
		String line = scnr.nextLine();
		try {
			simRun = Integer.parseInt(line);
		}
		catch (Exception e) {
			return 0;
		}
		if (simRun <= 0) {
			return simRun;
		}
		while (scnr.hasNextLine()) {
			line = scnr.nextLine();
			String[] maker = line.split(" ");
			if (maker.length != 5) {
				System.out.println("Invalid input!");
				return 0;
			}
			try {
				int lonI = Integer.parseInt(maker[2]);
				int latI = Integer.parseInt(maker[3]);
				int heiG = Integer.parseInt(maker[4]);
Flyable flyableThing = AircraftFactory.newAircraft(maker[0], maker[1], lonI, latI, heiG);
			flyableThing.registerTower(weatherTower);

			}
			catch (Exception e)
			{System.out.println("Eat pant!");}
			//Flyable flyableThing = AircraftFactory.newAircraft(maker[0], maker[1], lonI, latI, heiG);
			//flyableThing.registerTower(weatherTower);
		}
	return simRun;
	}

	public static void makeFile() {
		try {
			File output = new File("simulation.txt");
			output.createNewFile();
		}
		catch (Exception e) {
			System.out.println("No file made. Wop, wop.");
		}
	}

	public static void writeFile(String input) {
		try {
			//File myFile = new File("simulation.txt");
			FileWriter output1 = new FileWriter("simulation.txt", true);
			PrintWriter output2 = new PrintWriter(output1);
			output2.write(input + "\n");
			output2.close();
		}
		catch (Exception e) {
			System.out.println("Could not write to file. Wop, wop.");
		}
	}
}
