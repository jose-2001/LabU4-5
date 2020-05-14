package model;
import java.time.LocalDate;
public class AutomobileHybrid extends Automobile implements ElectricConsumable, GasConsumable {

	// constants
	
	public static final char EXTRA='E';
	public static final char COMMON ='C';
	public static final char DIESEL='D';
	public static final char FAST='F';
	public static final char NORMAL='N';
		
	//attributes
		
	private double tankCapacity;
	private char fuelType;
	private double fuelEfficiency;
	private char chargerType;
	private double batteryDuration;
	private double batteryEfficiency;
		
	//methods
		
	/**
	 * AutomobileHybrid
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
	 * @param chargerType a char, must be either 'F' or 'N'
	 * @param batteryDuration a double, positive
	 */
	public AutomobileHybrid(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,Client owner, double price,int year,double accidentCoverage, String code1, double price2,int year2,double gasLevel,String code2,char autoType, int doors, boolean tintedWindows, double tankCapacity, char fuelType, char chargerType, double batteryDuration) {
		super(basePrice, brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner , price,year,accidentCoverage, code1, price2, year2,gasLevel, code2, autoType, doors, tintedWindows);
		this.tankCapacity=tankCapacity;
		this.fuelType=fuelType;
		fuelEfficiency=calcFuelEff();
		this.chargerType=chargerType;
		this.batteryDuration=batteryDuration;
		batteryEfficiency=calcBatEff();
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
		this.tankCapacity = tankCapacity;
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
	 * getChargerType
	 * returns the type of charger of the auto
	 * @return a char
	 */
	public char getChargerType() {
		return chargerType;
	}

	/**
	 * setChargerType
	 * sets the type of charger of the auto
	 * @param chargerType a char, must be either 'F' or 'N'
	 */
	public void setChargerType(char chargerType) {
		this.chargerType = chargerType;
	}

	/**
	 * getBatteryDuration
	 * returns the battery Duration of the Auto
	 * @return a double
	 */
	public double getBatteryDuration() {
		return batteryDuration;
	}

	/**
	 * setBatteryDuration
	 * sets the battery Duration of the Auto
	 * @param batteryDuration a double, positive
	 */
	public void setBatteryDuration(double batteryDuration) {
		this.batteryDuration = batteryDuration;
	}

	/**
	 * getBatteryEfficiency
	 * returns the batter efficiency of the auto
	 * @return a double
	 */
	public double getBatteryEfficiency() {
		return batteryEfficiency;
	}

	/**
	 * setBatteryEfficiency
	 * sets the batter efficiency of the auto
	 * @param batteryEfficiency a double, positive
	 */
	public void setBatteryEfficiency(double batteryEfficiency) {
		this.batteryEfficiency = batteryEfficiency;
	}
	
	/**
	 * calcFuelEff
	 * calculates the fuel efficiency of the auto
	 * @return a double
	 */
	public double calcFuelEff() {
		double result=0;
		result=getTankCapacity()*getCylinderCap()/110;
		return result;
	}

	/**
	 * calcBatEff
	 * calculates the battery efficiency of the auto
	 * @return a double 
	 */
	public double calcBatEff() {
		double result=0;
		if(getChargerType()=='F')
		{
			result=(getBatteryDuration())*(getCylinderCap()/100);
		}
		else
		{
			result=(getBatteryDuration()+5)*(getCylinderCap()/100);
		}
		return result;
	}
		
	
	/**
	 * calculateTotalPrice
	 * calculates the total price of the auto
	 * @return a double
	 */
	public double calculateTotalPrice() {
		double result=getBasePrice()*1.15;
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
