package model;

public class Motorbyke extends Vehicle implements GasConsumable{

	//constants
	
	public static final char ESTANDAR ='E';
	public static final char DEPORTIVA ='D';
	public static final char SCOOTER ='S';
	public static final char CROSS ='C';
	//Attributes
	
	private char bikeType;
	private double tankCapacity;
	private double fuelEfficiency;
	
	
	//methods 
	public Motorbyke(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,String owner, double price,int year,double accidentCoverage, double price2,int year2,double gasLevel,char bikeType,double tankCapacity) {
		super(basePrice,brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner, price,year,accidentCoverage, price2,year2,gasLevel);
		this.bikeType=bikeType;
		this.tankCapacity=tankCapacity;
		fuelEfficiency=calcFuelEff();
	}
	
	
	public char getBikeType() {
		return bikeType;
	}


	public void setBikeType(char bikeType) {
		this.bikeType = bikeType;
	}


	public double getTankCapacity() {
		return tankCapacity;
	}


	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}


	public double getFuelEfficiency() {
		return fuelEfficiency;
	}


	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}


	public double calcFuelEff() {
		double result=0;
		result=getTankCapacity()*getCylinderCap()/90;
		return result;
	}
	public double calculateTotalPrice() {
		double result=super.calculateTotalPrice();
		result*=1.04;
		if(!isNewVehicle())
		{
			result*=0.98;
		}
		return result;
	}
}
