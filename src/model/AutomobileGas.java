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
	
	public AutomobileGas(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,String owner, double price,int year,double accidentCoverage, double price2,int year2,double gasLevel,char autoType, int doors, boolean tintedWindows, double tankCapacity, char fuelType) {
		super(basePrice, brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner, price,year,accidentCoverage, price2,year2,gasLevel,autoType, doors, tintedWindows);
		this.tankCapacity=tankCapacity;
		this.fuelType=fuelType;
		fuelEfficiency=calcFuelEff();
	}
	
	public double getTankCapacity() {
		return tankCapacity;
	}
	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity=tankCapacity;
	}
	public char getFuelType() {
		return fuelType;
	}

	public void setFuelType(char fuelType) {
		this.fuelType = fuelType;
	}

	public double getFuelEfficiency() {
		return fuelEfficiency;
	}

	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}

	public double calcFuelEff() {
		double result=0;
		result=getTankCapacity()*getCylinderCap()/100;
		return result;
	}
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
