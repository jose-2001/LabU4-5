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
	
	public AutomobileElectric(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,String owner, double price,int year,double accidentCoverage, double price2,int year2,double gasLevel,char autoType, int doors, boolean tintedWindows, char chargerType, double batteryDuration) {
		super(basePrice, brand, model, cylinderCap, odometerRead, newVehicle,licensePlate,owner, price,year,accidentCoverage, price2,year2,gasLevel,autoType, doors, tintedWindows);
		this.chargerType=chargerType;
		this.batteryDuration=batteryDuration;
		batteryEfficiency=calcBatEff();
	}
	
	
	public double calcBatEff() {
		double result=0;
		if(getChargerType()=='F')
		{
			//result=(getBatteryDuration()+10)*(getCylinderCap()/100)
		}
		else
		{
			//result=(getBatteryDuration()+15)*(getCylinderCap()/100)
		}
		return result;
	}


	public char getChargerType() {
		return chargerType;
	}


	public void setChargerType(char chargerType) {
		this.chargerType = chargerType;
	}


	public double getBatteryDuration() {
		return batteryDuration;
	}


	public void setBatteryDuration(double batteryDuration) {
		this.batteryDuration = batteryDuration;
	}


	public double getBatteryEfficiency() {
		return batteryEfficiency;
	}


	public void setBatteryEfficiency(double batteryEfficiency) {
		this.batteryEfficiency = batteryEfficiency;
	}
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
