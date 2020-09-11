#!/bin/sh

find -name *.java > sources.txt
javac -sourcepath . -d runMe @sources.txt

#javac -sourcepath . -d runMe run/Main.java aircraft/Aircraft.java aircraft/Helicopter.java aircraft/JetPlane.java aircraft/Baloon.java  aircraft/Coordinates.java aircraft/AircraftFactory.java interfaces/Flyable.java weather/WeatherProvider.java tower/WeatherTower.java tower/Tower.java run/Reader.java;
#java -cp runMe/ simulator.run.Main scenario.txt
