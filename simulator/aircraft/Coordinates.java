package simulator.aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude; 
        this.latitude = latitude;

        if (height > 100){ // This is the uppermost height limit.
            height = 100;
        }
        else if (height < 0){// This is the lowermost height limit.
            height = 0;
        }
        this.height = height;
    }

    public int getLongitude() {
        return this.longitude;
    }
    public int getLatitude() {
        return this.latitude;
    }
    public int getHeight() {
        return this.height;
    }
}
