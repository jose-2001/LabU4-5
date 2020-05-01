package model;
import java.time.LocalDate;
public abstract class Vehicle {

	//attributes
	
	private double totalPrice;
	private double basePrice;
	private String brand;
	private int model;
	private double cylinderCap;
	private double odometerRead;
	private boolean newVehicle;
	private String licensePlate;
	private String owner;
	private double additionalDiscount;
	
	//relations
	
	private Document[] documents;
	
	//methods
	//double price,int year,double accidentCoverage para el Soat, double price,int year,double gasLevel para la techmech
	public Vehicle(double basePrice, String brand, int model, double cylinderCap, double odometerRead, boolean newVehicle,String licensePlate,String owner, double price,int year,double accidentCoverage, double price2,int year2,double gasLevel) {
		this.basePrice=basePrice;
		this.brand=brand;
		this.model=model;
		this.cylinderCap=cylinderCap;
		this.odometerRead=odometerRead;
		this.newVehicle=newVehicle;
		this.licensePlate=licensePlate;
		this.owner=owner;
		documents= new Document[2];
		documents[0]= new Soat(price,year,accidentCoverage);
		documents[1]= new TechMech(price2,year2,gasLevel);
		totalPrice=calculateTotalPrice();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public double getCylinderCap() {
		return cylinderCap;
	}

	public void setCilinderCap(double cylinderCap) {
		this.cylinderCap = cylinderCap;
	}

	public double getOdometerRead() {
		return odometerRead;
	}

	public void setOdometerRead(double odometerRead) {
		this.odometerRead = odometerRead;
	}

	public boolean isNewVehicle() {
		return newVehicle;
	}

	public void setNewVehicle(boolean newVehicle) {
		this.newVehicle = newVehicle;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getAdditionalDiscount() {
		return additionalDiscount;
	}

	public void setAdditionalDiscount(double additionalDiscount) {
		this.additionalDiscount = additionalDiscount;
	}

	public Document[] getDocuments() {
		return documents;
	}

	public void setDocuments(Document[] documents) {
		this.documents = documents;
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
		return result;
	}
}
