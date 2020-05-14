package model;
import java.time.LocalDate;
public class AutomobileElectric extends Automobile implements ElectricConsumable{
	
	//Constants
	
	public static final char FAST='F';
	public static final char NORMAL='N';
	
	//Attributes
	
	private char chargerType;
	private double batteryDuration;
	private double batteryEfficiency;
	
	//methods
	
	/**
	 * AutomobileElectric
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
	 * @param chargerType a char, must be either 'F' or 'N'
	 * @param batteryDuration a double, positive 
	 */
	public AutomobileElectric(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,Client owner, double price,int year,double accidentCoverage, String code1, double price2,int year2,double gasLevel,String code2, char autoType, int doors, boolean tintedWindows, char chargerType, double batteryDuration) {
		super(basePrice, brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner, price,year,accidentCoverage,code1, price2,year2,gasLevel,code2, autoType, doors, tintedWindows);
		this.chargerType=chargerType;
		this.batteryDuration=batteryDuration;
		batteryEfficiency=calcBatEff();
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
			result=(getBatteryDuration()+10)*(getCylinderCap()/100);
		}
		else
		{
			result=(getBatteryDuration()+15)*(getCylinderCap()/100);
		}
		return result;
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
	 * calculateTotalPrice
	 * calculates the total price of the auto
	 * @return a double
	 */
	public double calculateTotalPrice() {
		double result=getBasePrice()*1.2;
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
