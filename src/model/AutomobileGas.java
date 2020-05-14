package model;

import java.time.LocalDate;

public class AutomobileGas extends Automobile implements GasConsumable{
	
	// constants
	
	public static final char EXTRA='E';
	public static final char COMMON ='C';
	public static final char DIESEL='D';
	
	//attributes
	
	private double tankCapacity;
	private char fuelType;
	private double fuelEfficiency;
	
	//methods 
	
	
	/**
	 * AutomobileGas
	 * constructor method. instances the class
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
	 * @param tankCapacity a double, positive
	 * @param fuelType a char, must be either 'C', 'D' or 'E'
	 */
	public AutomobileGas(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,Client owner, double price,int year,double accidentCoverage, String code1, double price2,int year2,double gasLevel, String code2, char autoType, int doors, boolean tintedWindows, double tankCapacity, char fuelType) {
		super(basePrice, brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner, price,year,accidentCoverage, code1, price2,year2,gasLevel, code2, autoType, doors, tintedWindows);
		this.tankCapacity=tankCapacity;
		this.fuelType=fuelType;
		fuelEfficiency=calcFuelEff();
	}
	
	/**
	 * getTankCapacity
	 * returns the capacity of the tank of the auto
	 * @return a double
	 */
	public double getTankCapacity() {
		return tankCapacity;
	}
	
	/**
	 * setTankCapacity
	 * sets the capacity of the tank of the auto
	 * @param tankCapacity a double, positive
	 */
	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity=tankCapacity;
	}
	
	/**
	 * getFuelType
	 * returns the type of fuel of the auto
	 * @return a char
	 */
	public char getFuelType() {
		return fuelType;
	}

	/**
	 * setFuelType
	 * sets the type of fuel of the auto
	 * @param fuelType a char, must be either 'C', 'D' or 'E'
	 */
	public void setFuelType(char fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * getFuelEfficiency
	 * returns the fuel efficiency of the auto
	 * @return a double
	 */
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}

	/**
	 * setFuelEfficiency
	 * sets the fuel efficiency of the auto
	 * @param fuelEfficiency a double, positive
	 */
	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}

	/**
	 * calcFuelEff
	 * calculates the fuel efficiency of the auto
	 * @return a double
	 */
	public double calcFuelEff() {
		double result=0;
		result=getTankCapacity()*getCylinderCap()/100;
		return result;
	}
	
	/**
	 * calculateTotalPrice
	 * calculates the total price of the auto
	 * @return a double
	 */
	public double calculateTotalPrice() {
		double result=getBasePrice();
		int currentYear=LocalDate.now().getYear();
		for(int i=0; i<2; i++) {
			if(getDocuments()[i].getYear()<currentYear)
			{
				result+=500000;
			}
		}
		if(!isNewVehicle())
		{
			result*=0.9;
		}
		return result;
	}

}
