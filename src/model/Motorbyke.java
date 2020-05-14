package model;

public class Motorbyke extends Vehicle implements GasConsumable{

	//constants
	
	public static final char STANDARD ='E';
	public static final char SPORT ='D';
	public static final char SCOOTER ='S';
	public static final char CROSS ='C';
	//Attributes
	
	private char bikeType;
	private double tankCapacity;
	private double fuelEfficiency;
	
	
	//methods 
	
	/**
	 * Motorbyke
	 * constructor method. instances the class Motorbyke 
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
	 * @param bikeType a char, must be either 'C', 'S', 'D' or 'D'
	 * @param tankCapacity a double, positive
	 */
	public Motorbyke(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,Client owner, double price,int year,double accidentCoverage, String code1, double price2,int year2,double gasLevel, String code2,char bikeType,double tankCapacity) {
		super(basePrice,brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner, price,year,accidentCoverage, code1, price2,year2,gasLevel, code2);
		this.bikeType=bikeType;
		this.tankCapacity=tankCapacity;
		fuelEfficiency=calcFuelEff();
	}
	
	/**
	 * getBykeType
	 * returns the type of the byke
	 * @return a char
	 */
	public char getBikeType() {
		return bikeType;
	}


	/**
	 * setBykeType
	 * sets the type of the byke
	 * @param bikeType a char, must be either 'C', 'S', 'D' or 'D'
	 */
	public void setBikeType(char bikeType) {
		this.bikeType = bikeType;
	}

	/**
	 * getTankCapacity
	 * returns the capacity of the tank of the byke
	 * @return a double
	 */
	public double getTankCapacity() {
		return tankCapacity;
	}

	/**
	 * setTankCapacity
	 * sets the capacity of the tank of the byke
	 * @param tankCapacity  a double, positive
	 */
	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	/**
	 * getFuelEfficiency
	 * returns the fuel efficiency of the byke
	 * @return a double
	 */
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}

	/**
	 * setFuelEfficiency
	 * sets the fuel efficiency of the byke
	 * @param fuelEfficiency a double, positive
	 */
	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}

	/**
	 * calcFuelEff
	 * calculates the fuel efficiency of the byke
	 */
	public double calcFuelEff() {
		double result=0;
		result=getTankCapacity()*getCylinderCap()/90;
		return result;
	}
	
	/**
	 * calculateTotalPrice
	 * calculates the total price of the Byke 
	 * @return a double
	 */
	public double calculateTotalPrice() {
		double result=getBasePrice();
		result*=1.04;
		if(!isNewVehicle())
		{
			result*=0.98;
		}
		return result;
	}

}
