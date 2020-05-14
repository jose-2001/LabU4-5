package model;
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
	
	private double additionalDiscount;
	
	//relations
	private Client owner;
	private Document[] documents;
	
	//methods

	/**
	 * Vehicle
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
	 */
	public Vehicle(double basePrice, String brand, int model,
			double cylinderCap, double odometerRead, boolean newVehicle,
			String licensePlate,Client owner, double price,int year,
			double accidentCoverage, String code1, double price2,
			int year2,double gasLevel, String code2) {
		this.basePrice=basePrice;
		this.brand=brand;
		this.model=model;
		this.cylinderCap=cylinderCap;
		this.odometerRead=odometerRead;
		this.newVehicle=newVehicle;
		this.licensePlate=licensePlate;
		this.owner=owner;
		documents= new Document[2];
		documents[0]= new Soat(price,year,code1, accidentCoverage);
		documents[1]= new TechMech(price2,year2,code2, gasLevel);
		totalPrice=calculateTotalPrice();
	}

	/**
	 * getTotalPrice
	 * returns the total price of the vehicle 
	 * @return a double
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * setTotalPrice
	 * sets the total price of the vehicle
	 * @param totalPrice a double, not negative
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * getBasePrice
	 * returns the base price of the Vehicle
	 * @return a double
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * setBasePrice
	 * sets the base price of the Vehicle
	 * @param basePrice a double, not negative
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * getBrand
	 * returns the brand of the vehicle
	 * @return a String
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * setBrand
	 * sets the brand of the vehicle
	 * @param brand a String, not null nor empty
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * getModel
	 * returns the model of the vehicle
	 * @return an int
	 */
	public int getModel() {
		return model;
	}

	/**
	 * setModel
	 * sets the model of the vehicle
	 * @param model an int, not negative
	 */
	public void setModel(int model) {
		this.model = model;
	}

	/**
	 * getCylinderCap
	 * returns the cylinder capacity of the vehicle
	 * @return a double
	 */
	public double getCylinderCap() {
		return cylinderCap;
	}

	/**
	 * setCylinderCap
	 * sets the cylinder capacity of the vehicle
	 * @param cylinderCap a double, not negative
	 */
	public void setCylinderCap(double cylinderCap) {
		this.cylinderCap = cylinderCap;
	}

	/**
	 * getOdometerRead
	 * returns the kilometerage of the vehicle
	 * @return a double
	 */
	public double getOdometerRead() {
		return odometerRead;
	}

	/**
	 * setOdometerRead
	 * sets the kilometerage of the vehicle
	 * @param odometerRead a double, not negative
	 */
	public void setOdometerRead(double odometerRead) {
		this.odometerRead = odometerRead;
	}

	/**
	 * isNewVehicle
	 * returns true if the vehicle is new, false if it is used
	 * @return a boolean
	 */
	public boolean isNewVehicle() {
		return newVehicle;
	}

	/**
	 * setNewVehicle
	 * sets if the vehicle is used or new
	 * @param newVehicle a boolean
	 */
	public void setNewVehicle(boolean newVehicle) {
		this.newVehicle = newVehicle;
	}

	/**
	 * getLicensePlate
	 * returns the license plate of the vehicle
	 * @return a String
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * setLicensePlate
	 * sets the license plate of the vehicle
	 * @param licensePlate a String
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	/**
	 * getOwner
	 * returns the owner of the vehicle
	 * @return a Client
	 */
	public Client getOwner() {
		return owner;
	}

	/**
	 * setOwner
	 * sets the owner of the vehicle
	 * @param owner a Client
	 */
	public void setOwner(Client owner) {
		this.owner = owner;
	}

	/**
	 * getAdditionalDiscount
	 * returns the additional discount of the vehicle
	 * @return a double
	 */
	public double getAdditionalDiscount() {
		return additionalDiscount;
	}

	/**
	 * setAdditionalDiscount
	 * sets the additional discount of the vehicle
	 * @param additionalDiscount a double, not negative
	 */
	public void setAdditionalDiscount(double additionalDiscount) {
		this.additionalDiscount = additionalDiscount;
	}

	/**
	 * getDocuments
	 * returns the documents of the vehicle
	 * @return a Document[]
	 */
	public Document[] getDocuments() {
		return documents;
	}

	/**
	 * setDocuments
	 * sets the documents of the vehicle
	 * @param documents a Document[] not null
	 */
	public void setDocuments(Document[] documents) {
		this.documents = documents;
	}
	/**
	 * calculateTotalPrice
	 * calculates the total price of the vehicle (once implemented by a subclass)
	 * @return a double
	 */
	public abstract double calculateTotalPrice();
	
}
