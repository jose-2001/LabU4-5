package model;

public abstract class Automobile extends Vehicle{

	//constants
	
	public static final char SEDAN ='S';
	public static final char CAMIONETA ='C';
	
	//attributes
	
	private char autoType;
	private int doors;
	private boolean tintedWindows;
	
	//methods
	
	public Automobile(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,String owner, double price,int year,double accidentCoverage, double price2,int year2,double gasLevel,char autoType, int doors, boolean tintedWindows) {
		super(basePrice,brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner, price,year,accidentCoverage, price2,year2,gasLevel);
		this.autoType=autoType;
		this.doors=doors;
		this.tintedWindows=tintedWindows;
	}

	public char getAutoType() {
		return autoType;
	}

	public void setAutoType(char autoType) {
		this.autoType = autoType;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public boolean isTintedWindows() {
		return tintedWindows;
	}

	public void setTintedWindows(boolean tintedWindows) {
		this.tintedWindows = tintedWindows;
	}
}
