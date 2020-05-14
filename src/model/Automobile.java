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
	
	/**
	 * Automobile
	 * constructor method. sets the attributes to the values in the parameters, does not instance class because it is Abstract  
	 * @param basePrice a double, not negative
	 * @param brand a String, not null
	 * @param model an int, not negative
	 * @param cylinderCap a double
	 * @param odometerRead a double
	 * @param newVehicle a boolean
	 * @param licensePlate a String, not null
	 * @param owner a Client
	 * @param price a double, not negative
	 * @param year an int, not negative
	 * @param accidentCoverage a double, not negative
	 * @param code1 a String
	 * @param price2 a double, not negative
	 * @param year2 an int, not negative
	 * @param gasLevel a double
	 * @param code2 a String
	 * @param autoType a char, must be either 'S' or 'C'
	 * @param doors an int
	 * @param tintedWindows a boolean
	 */
	public Automobile(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,Client owner, double price,int year,double accidentCoverage,String code1, double price2,int year2,double gasLevel,String code2, char autoType, int doors, boolean tintedWindows) {
		super(basePrice,brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner, price,year,accidentCoverage,code1, price2,year2,gasLevel,code2);
		this.autoType=autoType;
		this.doors=doors;
		this.tintedWindows=tintedWindows;
	}

	/**
	 * getAutoType
	 * returns the type of the auto
	 * @return a char
	 */
	public char getAutoType() {
		return autoType;
	}
	
	/**
	 * setAutoType
	 * sets  the type of the auto
	 * @param autoType a char, must be either 'S' or 'C'
	 */
	public void setAutoType(char autoType) {
		this.autoType = autoType;
	}

	/**
	 * getDoors
	 * returns the number of doors of the auto
	 * @return an int
	 */
	public int getDoors() {
		return doors;
	}

	/**
	 * setDoors
	 * sets the number of doors of the auto
	 * @param doors an int
	 */
	public void setDoors(int doors) {
		this.doors = doors;
	}

	/**
	 * isTintedWindows
	 * returns true if the windows are tinted, false if not
	 * @return a boolean
	 */
	public boolean isTintedWindows() {
		return tintedWindows;
	}

	/**
	 * setTintedWindows
	 * sets whether or not the windows are tinted
	 * @param tintedWindows a boolean
	 */
	public void setTintedWindows(boolean tintedWindows) {
		this.tintedWindows = tintedWindows;
	}

}
