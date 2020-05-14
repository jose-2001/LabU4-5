package model;
import java.util.ArrayList;

import model.Motorbyke;
public class CarDealer {

	//constants
	
	public final static int EMPLOYEE_AMOUNT=10;
	public final static int OPD_ROWS=10;
	public final static int OPD_COLUMNS=5;

	
	//attributes
	
	private String name;
	private String nit;
	private double totalEarnings;
	private int salesAmount;
	
	//relations
	
	private ArrayList<Vehicle> fleet;
	private ArrayList<Vehicle> sold;
	private Employee[] employees;
	private Vehicle[][] oldParkingLot;
	private ArrayList<Client> unassignedClients;
	
	//methods 
	/**
	 * CaDealer
	 * constructor method. instances the class CarDealer
	 * @param name a String, not empty nor null
	 * @param nit a String, not empty nor null
	 * @param totalEarnings a double, not negative
	 * @param salesAmount an int, not negative
	 */
	public CarDealer(String name, String nit, double totalEarnings, int salesAmount) {
		this.name=name;
		this.nit=nit;
		this.totalEarnings=totalEarnings;
		this.salesAmount=salesAmount;
		fleet= new ArrayList<Vehicle>();
		sold= new ArrayList<Vehicle>();
		employees= new Employee[EMPLOYEE_AMOUNT];
		oldParkingLot= new Vehicle[OPD_ROWS][OPD_COLUMNS];
		unassignedClients= new ArrayList<Client>();
	}
	
	/**
	 * getName
	 * returns the name of the CarDealer
	 * @return a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName
	 * sets the name of the CarDealer
	 * @param name a String, not empty nor null
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getNit
	 * returns the NIT of the CarDealer
	 * @return a String
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * setNit
	 * sets the NIT of the CarDealer
	 * @param nit a String, not empty nor null
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * getTotalEarnings
	 * returns the total earnings of the CarDealer
	 * @return a double
	 */
	public double getTotalEarnings() {
		return totalEarnings;
	}

	/**
	 * setTotalEarnings
	 * sets the total earnings of the CarDealer
	 * @param totalEarnings a double, not negative
	 */
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	/**
	 * getSaleAmount
	 * returns the number of sales of the CarDealer
	 * @return an int
	 */
	public int getSalesAmount() {
		return salesAmount;
	}

	/**
	 * setSalesAmount
	 * sets the number of sales of the CarDealer
	 * @param salesAmount an int, not negative
	 */
	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	/**
	 * getFleet
	 * returns the fleet of the CarDealer
	 * @return an ArrayList of Vehicle
	 */
	public ArrayList<Vehicle> getFleet() {
		return fleet;
	}

	/**
	 * setFleet
	 * sets the fleet of the CarDealer
	 * @param fleet an ArrayList of vehicles, not empty nor null
	 */
	public void setFleet(ArrayList<Vehicle> fleet) {
		this.fleet = fleet;
	}
	
	/**
	 * getEmployees
	 * Returns the employees of the CarDealer
	 * @return an Employee[]
	 */
	public Employee[] getEmployees() {
		return employees;
	}
	
	/**
	 * set Employees
	 * sets the employees of the CarDealer
	 * @param employees an Employee[], not null
	 */
	public void setEmployees(Employee[] employees) {
		this.employees=employees;
	}
	
	/**
	 * getOldParkingLot
	 * returns the parking lot matrix of the CarDealer 
	 * @return a Vehicle[][]
	 */
	public Vehicle[][] getOldParkingLot() {
		return oldParkingLot;
	}

	/**
	 * setOldParkingLot
	 * sets the parking lot matrix of the CarDealer
	 * @param oldParkingLot a Vehicle[][], not null
	 */
	public void setOldParkingLot(Vehicle[][] oldParkingLot) {
		this.oldParkingLot = oldParkingLot;
	}

	/**
	 * getUnassignedClients
	 * returns the unassigned clients of the CarDealer 
	 * @return an ArrayList of Client
	 */
	public ArrayList<Client> getUnassignedClients() {
		return unassignedClients;
	}

	/**
	 * setUnassignedClients
	 * sets the unassigned clients of the CarDealer
	 * @param unassignedClients an ArrayList of Client, not null
	 */
	public void setUnassignedClients(ArrayList<Client> unassignedClients) {
		this.unassignedClients = unassignedClients;
	}

	/**
	 * getSold
	 * returns the sold vehicles of the CarDealer
	 * @return an ArrayList of Vehicle
	 */
	public ArrayList<Vehicle> getSold() {
		return sold;
	}

	/**
	 * setSold
	 * sets the sold vehicles of the CarDealer
	 * @param sold an ArrayList of Vehicle, not null
	 */
	public void setSold(ArrayList<Vehicle> sold) {
		this.sold = sold;
	}

	/**
	 * addEmployee
	 * checks if an employee with the same ID already exists, if not, adds an employee to the CarDealer's Employee[]
	 *  in the next available position
	 *  <b>Pre</b>: there must be an available space in the CarDealer's Employee[]
	 * @param name a String, not empty nor null
	 * @param lastName a String, not empty nor null
	 * @param id a String, not empty nor null
	 * @param sales an int, not negative
	 * @return a String saying that the employee already existed or that it was successfully added
	 */
	public String addEmployee(String name, String lastName, String id, int sales ) {
		String message="";
		boolean alreadyExists=false;
		for(int i=0; i<EMPLOYEE_AMOUNT; i++)
		{
			if(employees [i]!=null)
				{if(employees[i].getId().equals(id))
				{
					alreadyExists=true;
					message="That employee is already registered";
				}}
		}
		if(!alreadyExists)
		{
			boolean done=false;
			for(int i=0;i<EMPLOYEE_AMOUNT & !done; i++)
			{
				if(employees[i]==null)
				{
					employees[i]= new Employee(name,lastName, id, sales);
					message="Employee added succesfully";
					done=true;
				}
			}
		}
		return message;
	}

	/**
	 * checkEmployees
	 * This method checks if the maximum amount of employees has already been reached
	 * @return boolean, true if the maximum has not been reached, false if it has
	 */
	public boolean checkEmployees(){
		boolean result=false; 
		int cont=0;
		for(int i=0; i<employees.length;i++) {
			if(employees[i]!=null)
			{
				cont++;
			}
		}
		if (cont!=10) 
		{
			result=true;
		}
		return result;
	}
	
	/**
	 * availableEmployees
	 * checks if there is at least one employee with an available spot for assigning a Client
	 * @return true if there is a spot, false if there is not
	 */
	public boolean availableEmployees() {
		boolean result=false;
		for(int i=0; i<employees.length; i++)
		{
			if(employees[i]!=null)
			{
					for(int j=0; j<employees[i].getAssignedClients().length; j++)	
						{
						if(employees[i].getAssignedClients()[j]==null)
							{
								result=true;
							}
						}
			}
		}
		return result;
	}
	
	/**
	 * assignableEmployees
	 * this method checks which employees have an available spot for assigning a Client and returns their names and last names along 
	 * with their position in the CarDealer Employee[]
	 * @return a String
	 */
	public String assignableEmployees() {
		String message="";
		boolean found=false;
		for(int i=0; i<employees.length; i++)
		{
			if(employees[i]!=null) {
				for(int j=0; j<employees[i].getAssignedClients().length & !found; j++)
					{
					if(employees[i].getAssignedClients()[j]==null)
					{
						message+=("Type " +(i+1) +" to add the client to "+employees[i].getName()+" "+employees[i].getLastName()+" assigned Client List \n");
						found=true;
					}
				}
				}
			found=false;
		}
		return message;
	}
	
	/**
	 * assignClientToEmployee
	 * assigns an existing unassigned client to an employee
	 * @param client an int, an int, must represent a position in the CarDealer's <code>unassignedClients</code> ArrayList of Client  
	 * @param employee an int, must represent a position in the CarDealer's <code>employees</code> Employee[]
	 */
	public void assignClientToEmployee(int client, int employee) {
		employees[employee].addAssignedClient(unassignedClients.get(client));
		unassignedClients.remove(client);
	}
	
	/**
	 * assignClientToEmployee
	 * cerates and assigns a Client to an Employee
	 * @param name a String, not empty nor null
	 * @param lastName a String, not empty nor null
	 * @param id a String, not empty nor null
	 * @param phoneNumber a String, not empty nor null
	 * @param email a String, not empty nor null
	 * @param employee an int, must represent a position in the CarDealer's <code>employees</code> Employee[]
	 */
	public void assignClientToEmployee(String name, String lastName, String id, String phoneNumber, String email, int employee) {
		employees[employee].addAssignedClient(name, lastName, id, phoneNumber, email);
	}

	/**
	 * addUnassignedClient
	 * checks if a client already exists in the CarDealer's <code>unassignedClients</code> ArrayList of Client or in any employee's <code>assignedClients</code> 
	 * and if it does not already exist, it adds an unassigned client to the CarDealer's <code>unassignedClients</code> ArrayList of Client
	 * @param name a String, not empty nor null
	 * @param lastName a String, not empty nor null
	 * @param id a String, not empty nor null
	 * @param phoneNumber a String, not empty nor null
	 * @param email a String, not empty nor null
	 * @return a String saying if the client already existed and where, or that it was successfully added
	 */
	public String addUnassignedClient(String name, String lastName, String id, String phoneNumber, String email) {
		String message="";
		boolean exists =false;
		Client toAdd= new Client(name, lastName, id, phoneNumber, email);	
		for (int i=0; i<getUnassignedClients().size();i++)
		{
			if(getUnassignedClients().get(i)!=null) {
			if(getUnassignedClients().get(i).equals(toAdd))
			{
				message="Error, that client already exists but is unassigned.";
				exists=true;
			}
		}}
		for(int i=0; i<getEmployees().length;i++)
		{
			if(employees[i]!=null) {
				for(int j=0; j<getEmployees()[i].getAssignedClients().length;j++)
			{
				if(getEmployees()[i].getAssignedClients()[j]!=null) {
					if(getEmployees()[i].getAssignedClients()[j].equals(toAdd))
				{
					message="Error, that client already exists and it is assigned to "+getEmployees()[i].getName()+" "+getEmployees()[i].getLastName()+ ".";
					exists=true;
				}}
			}}
		}
		if(!exists)
		{
			getUnassignedClients().add(toAdd);
			message="Client added successfully";
		}
		return message;
	}

	/**
	 * addMotorbyke
	 * adds a Motorbyke to the CarDearler's <code>fleet</code> ArrayList of Vehicle
	 * @param pbasePrice a double, not negative
	 * @param pbrand a String, not null
	 * @param pmodel an int, not negative
	 * @param pcylinderCap a double
	 * @param podometerRead a double
	 * @param pnewVehicle a boolean
	 * @param plicensePlate a String, not null
	 * @param powner a Client
	 * @param pprice a double, not negative
	 * @param pyear an int, not negative
	 * @param paccidentCoverage a double, not negative
	 * @param pcode1 a String
	 * @param pprice2 a double, not negative
	 * @param pyear2 an int, not negative
	 * @param pgasLevel a double
	 * @param pcode2 a String
	 * @param pbikeType a char, must be either 'C', 'S', 'D' or 'D'
	 * @param ptankCapacity a double, positive
	 */
	public void addMotorByke(double pbasePrice, String pbrand, int pmodel, double pcylinderCap, double podometerRead,
			boolean pnewVehicle, String plicensePlate, Client powner, double pprice, int pyear,
			double paccidentCoverage, String pcode1, double pprice2, int pyear2, double pgasLevel, String pcode2, char pbikeType,
			double ptankCapacity) {
		getFleet().add(new Motorbyke(pbasePrice,pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,plicensePlate,powner, pprice,pyear,paccidentCoverage, pcode1, pprice2,pyear2,pgasLevel, pcode2, pbikeType, ptankCapacity));
		
	}

	/**
	 * addAutomobileGas
	 * adds an AutomobileGas to the CarDearler's <code>fleet</code> ArrayList of Vehicle, 
	 * if the model is earlier than 2015 it attempts to add it to the CarDearler's <code>oldParkingLot</code> Vehicle[][]
	 * @param pbasePrice a double, not negative
	 * @param pbrand a String, not null
	 * @param pmodel an int, not negative
	 * @param pcylinderCap a double
	 * @param podometerRead a double
	 * @param pnewVehicle a boolean
	 * @param plicensePlate a String, not null
	 * @param powner a Client
	 * @param pprice a double, not negative
	 * @param pyear an int, not negative
	 * @param paccidentCoverage a double, not negative
	 * @param pcode1 a String
	 * @param pprice2 a double, not negative
	 * @param pyear2 an int, not negative
	 * @param pgasLevel a double
	 * @param pcode2 a String
	 * @param pautoType a char, must be either 'S' or 'C'
	 * @param pdoors an int
	 * @param ptintedWindows a boolean
	 * @param ptankCapacity a double, positive
	 * @param pfuelType a char, must be either 'C', 'D' or 'E'
	 * @return a String saying the Automobile was successfully registered, if it was added to the parking lot or if it could not be added to the parking lot
	 */
	public String addAutomobileGas(double pbasePrice, String pbrand, int pmodel, double pcylinderCap,
			double podometerRead, boolean pnewVehicle, String plicensePlate, Client powner, double pprice, int pyear,
			double paccidentCoverage, String pcode1, double pprice2, int pyear2, double pgasLevel, String pcode2, char pautoType,
			int pdoors, boolean ptintedWindows,  double ptankCapacity, char pfuelType) {
		String message="";
		getFleet().add(new AutomobileGas(pbasePrice,pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,plicensePlate,powner, pprice,pyear,paccidentCoverage, pcode1, pprice2,pyear2,pgasLevel, pcode2,pautoType,pdoors,ptintedWindows,ptankCapacity,pfuelType));
		if(!pnewVehicle&pmodel<2015)
		{
			message=addToParkingLot(new AutomobileGas(pbasePrice,pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,plicensePlate,powner, pprice,pyear,paccidentCoverage, pcode1, pprice2,pyear2,pgasLevel, pcode2,pautoType,pdoors,ptintedWindows,ptankCapacity,pfuelType));
		}
		return message;
	}

	/**
	 * addAutomobileElectric 
	 * adds an AutomobileElectric to the CarDearler's <code>fleet</code> ArrayList of Vehicle, 
	 * if the model is earlier than 2015 it attempts to add it to the CarDearler's <code>oldParkingLot</code> Vehicle[][]
	 * @param pbasePrice a double, not negative
	 * @param pbrand a String, not null
	 * @param pmodel an int, not negative
	 * @param pcylinderCap a double
	 * @param podometerRead a double
	 * @param pnewVehicle a boolean
	 * @param plicensePlate a String, not null
	 * @param powner a Client
	 * @param pprice a double, not negative
	 * @param pyear an int, not negative
	 * @param paccidentCoverage a double, not negative
	 * @param pcode1 a String
	 * @param pprice2 a double, not negative
	 * @param pyear2 an int, not negative
	 * @param pgasLevel a double
	 * @param pcode2 a String
	 * @param pautoType a char, must be either 'S' or 'C'
	 * @param pdoors an int
	 * @param ptintedWindows a boolean
	 * @param pchargerType a char, must be either 'F' or 'N'
	 * @param pbatteryDuration a double, positive 
	 * @return a String saying the Automobile was successfully registered, if it was added to the parking lot or if it could not be added to the parking lot
	 */
	public String addAutomobileElectric(double pbasePrice, String pbrand, int pmodel, double pcylinderCap,
			double podometerRead, boolean pnewVehicle, String plicensePlate, Client powner, double pprice, int pyear,
			double paccidentCoverage, String pcode1, double pprice2, int pyear2, double pgasLevel, String pcode2, char pautoType, int pdoors,
			boolean ptintedWindows, char pchargerType, double pbatteryDuration) {
		String message="";
		getFleet().add(new AutomobileElectric(pbasePrice,pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,plicensePlate,powner, pprice,pyear,paccidentCoverage, pcode1, pprice2,pyear2,pgasLevel, pcode2,pautoType,pdoors,ptintedWindows,pchargerType,pbatteryDuration ));
		if(!pnewVehicle&pmodel<2015)
		{
			message=addToParkingLot(new AutomobileElectric(pbasePrice,pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,plicensePlate,powner, pprice,pyear,paccidentCoverage, pcode1, pprice2,pyear2,pgasLevel, pcode2,pautoType,pdoors,ptintedWindows,pchargerType,pbatteryDuration ));
		}
		return message;
	}

	/**
	 * addAutomobileHybrid
	 * adds an AutomobileElectric to the CarDearler's <code>fleet</code> ArrayList of Vehicle, 
	 * if the model is earlier than 2015 it attempts to add it to the CarDearler's <code>oldParkingLot</code> Vehicle[][]
	 * @param pbasePrice a double, not negative
	 * @param pbrand a String, not null
	 * @param pmodel an int, not negative
	 * @param pcylinderCap a double
	 * @param podometerRead a double
	 * @param pnewVehicle a boolean
	 * @param plicensePlate a String, not null
	 * @param powner a Client
	 * @param pprice a double, not negative
	 * @param pyear an int, not negative
	 * @param paccidentCoverage a double, not negative
	 * @param pcode1 a String
	 * @param pprice2 a double, not negative
	 * @param pyear2 an int, not negative
	 * @param pgasLevel a double
	 * @param pcode2 a String
	 * @param pautoType a char, must be either 'S' or 'C'
	 * @param pdoors an int
	 * @param ptintedWindows a boolean
	 * @param ptankCapacity a double, positive
	 * @param pfuelType a char, must be either 'C', 'D' or 'E'
	 * @param pchargerType a char, must be either 'F' or 'N'
	 * @param pbatteryDuration a double, positive 
	 * @return a String saying the Automobile was successfully registered, if it was added to the parking lot or if it could not be added to the parking lot
	 */
	public String addAutomobileHybrid(double pbasePrice, String pbrand, int pmodel, double pcylinderCap,
			double podometerRead, boolean pnewVehicle, String plicensePlate, Client powner, double pprice, int pyear,
			double paccidentCoverage, String pcode1, double pprice2, int pyear2, double pgasLevel, String pcode2, char pautoType, int pdoors,
			boolean ptintedWindows, double ptankCapacity, char pfuelType, char pchargerType, double pbatteryDuration) {
		String message="";
		getFleet().add(new AutomobileHybrid(pbasePrice,pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,plicensePlate,powner, pprice,pyear,paccidentCoverage, pcode1, pprice2,pyear2,pgasLevel, pcode2,pautoType,pdoors,ptintedWindows,ptankCapacity,pfuelType,pchargerType,pbatteryDuration ));
		if(!pnewVehicle&pmodel<2015)
		{
			message=addToParkingLot(new AutomobileHybrid(pbasePrice,pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,plicensePlate,powner, pprice,pyear,paccidentCoverage, pcode1, pprice2,pyear2,pgasLevel, pcode2,pautoType,pdoors,ptintedWindows,ptankCapacity,pfuelType,pchargerType,pbatteryDuration ));
		}
		return message;
	}
	
	/**
	 * addToParkingLot
	 * this method adds an AutomobileGas to the parking lot, in a specific column depending on the model
	 * @param automo an AutomobileGas, not null
	 * @return a String saying if the automobile was added, how many spaces are left for cars of the same model, and if it could not be added it says so and that the parking lot needs more space
	 */
	private String addToParkingLot(AutomobileGas automo) {
		String message="";
		int cont=0;
		switch(automo.getModel())
		{
		case 2014:
				for(int i=0; i<(OPD_ROWS);i++)
				{
					if(getOldParkingLot()[i][0]!=null)
						{
						cont++;
						}
				}
				if(cont==OPD_COLUMNS)
				{
					message="The row for 2014-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
				}
				else {
					getOldParkingLot()[cont][0]=automo;
					message="Car added to the parking lot, remaining spots for 2014-modeled cars: "+(cont+1);
				}
			break;
		case 2013:
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][1]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2013-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][1]=automo;
				message="Car added to the parking lot, remaining spots for 2013-modeled cars: "+(cont+1);
			}
			break;
		case 2012: 
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][2]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2012-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][2]=automo;
				message="Car added to the parking lot, remaining spots for 2012-modeled cars: "+(cont+1);
			}
			break;
		case 2011:
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][3]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2011-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][3]=automo;
				message="Car added to the parking lot, remaining spots for 2011-modeled cars: "+(cont+1);
			}
			break;
		default: 
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][4]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2010 or earlier-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][4]=automo;
				message="Car added to the parking lot, remaining spots for 2010 or earlier-modeled cars: "+(cont+1);
			}
		break;
		}
		return message;
	}
	
	/**
	 * addToParkingLot
	 * this method adds an AutomobileElectric to the parking lot, in a specific column depending on the model
	 * @param automo an AutomobileElectric, not null
	 * @return a String saying if the automobile was added, how many spaces are left for cars of the same model, and if it could not be added it says so and that the parking lot needs more space
	 */
	private String addToParkingLot(AutomobileElectric automo) {
		String message="";
		int cont=0;
		switch(automo.getModel())
		{
		case 2014:
				for(int i=0; i<(OPD_ROWS);i++)
				{
					if(getOldParkingLot()[i][0]!=null)
						{
						cont++;
						}
				}
				if(cont==OPD_COLUMNS)
				{
					message="The row for 2014-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
				}
				else {
					getOldParkingLot()[cont][0]=automo;
					message="Car added to the parking lot, remaining spots for 2014-modeled cars: "+(cont+1);
				}
			break;
		case 2013:
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][1]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2013-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][1]=automo;
				message="Car added to the parking lot, remaining spots for 2013-modeled cars: "+(cont+1);
			}
			break;
		case 2012: 
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][2]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2012-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][2]=automo;
				message="Car added to the parking lot, remaining spots for 2012-modeled cars: "+(cont+1);
			}
			break;
		case 2011:
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][3]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2011-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][3]=automo;
				message="Car added to the parking lot, remaining spots for 2011-modeled cars: "+(cont+1);
			}
			break;
		default: 
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][4]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2010 or earlier-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][4]=automo;
				message="Car added to the parking lot, remaining spots for 2010 or earlier-modeled cars: "+(cont+1);
			}
		break;
		}
		return message;
	}
	
	/**
	 * addToParkingLot
	 * this method adds an AutomobileHybrid to the parking lot, in a specific column depending on the model
	 * @param automo an AutomobileHybrid, not null
	 * @return a String saying if the automobile was added, how many spaces are left for cars of the same model, and if it could not be added it says so and that the parking lot needs more space
	 */
	private String addToParkingLot(AutomobileHybrid automo) {
		String message="";
		int cont=0;
		switch(automo.getModel())
		{
		case 2014:
				for(int i=0; i<(OPD_ROWS);i++)
				{
					if(getOldParkingLot()[i][0]!=null)
						{
						cont++;
						}
				}
				if(cont==OPD_COLUMNS)
				{
					message="The row for 2014-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
				}
				else {
					getOldParkingLot()[cont][0]=automo;
					message="Car added to the parking lot, remaining spots for 2014-modeled cars: "+(cont+1);
				}
			break;
		case 2013:
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][1]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2013-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][1]=automo;
				message="Car added to the parking lot, remaining spots for 2013-modeled cars: "+(cont+1);
			}
			break;
		case 2012: 
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][2]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2012-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][2]=automo;
				message="Car added to the parking lot, remaining spots for 2012-modeled cars: "+(cont+1);
			}
			break;
		case 2011:
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][3]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2011-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][3]=automo;
				message="Car added to the parking lot, remaining spots for 2011-modeled cars: "+(cont+1);
			}
			break;
		default: 
			for(int i=0; i<OPD_ROWS;i++)
			{
				if(getOldParkingLot()[i][4]!=null)
					{
					cont++;
					}
			}
			if(cont==OPD_COLUMNS)
			{
				message="The row for 2010 or earlier-modeled cars is full, needs to be expanded. Car added to the fleet but not the Parking Lot";
			}
			else {
				getOldParkingLot()[cont][4]=automo;
				message="Car added to the parking lot, remaining spots for 2010 or earlier-modeled cars: "+(cont+1);
			}
		break;
		}
		return message;
	}
	
	/**
	 * catalog
	 * this method returns the information that was requested of it in Main
	 * @param dec1 an int, either 1 or 2
	 * @param dec2 an int, either 1, 2  or 4
	 * @param dec3 an int, either 1, 2  or 4
	 * @return a String with the information of the Vehicles that match the criteria given in Main
	 */
	public String catalog(int dec1, int dec2, int dec3) {
		String message="";
		switch(dec1)
		{
		case 1:
			for(int i=0; i<fleet.size();i++)
				{
					if(fleet.get(i) instanceof Motorbyke)
					{
						if(dec3!=2) {message+="License Plate: "+fleet.get(i).getLicensePlate()+"\n";}
						message+="Brand: "+fleet.get(i).getBrand()+"\n"
								+ "Model: "+fleet.get(i).getModel()+"\n"
										+ "Cylinder capacity: "+fleet.get(i).getCylinderCap()+"\n"
										+ "Kilometerage: "+fleet.get(i).getOdometerRead()+"\n";
						if(((Motorbyke) fleet.get(i)).getBikeType()=='C')
						{
							message+="Byke type: Cross \n";
						}
						if(((Motorbyke) fleet.get(i)).getBikeType()=='S')
						{
							message+="Byke type: Scooter \n";
						}
						if(((Motorbyke) fleet.get(i)).getBikeType()=='D')
						{
							message+="Byke type: Sports \n";
						}
						if(((Motorbyke) fleet.get(i)).getBikeType()=='E')
						{
							message+="Byke type: Estandar \n";
						}
						message+="Tank Capacity: "+((Motorbyke) fleet.get(i)).getTankCapacity()+"\n"
								+ "Fuel efficiency: "+((Motorbyke) fleet.get(i)).getFuelEfficiency()+"\n"
										+ "Registration number: "+i+"\n\n";						
					}
				}
			break;
		case 2: 
			for(int i=0; i<fleet.size();i++)
			{
				if(fleet.get(i) instanceof Automobile)
				{
					if(dec3!=2) {message+="License Plate: "+fleet.get(i).getLicensePlate()+"\n";}
					message+="Brand: "+fleet.get(i).getBrand()+"\n"
							+ "Model: "+fleet.get(i).getModel()+"\n"
									+ "Cylinder capacity: "+fleet.get(i).getCylinderCap()+"\n"
									+ "Kilometerage: "+fleet.get(i).getOdometerRead()+"\n";
					if(((Automobile) fleet.get(i)).getAutoType()=='S')
					{
						message+="Auto type: Sedan \n";
					}
					if(((Automobile) fleet.get(i)).getAutoType()=='C')
					{
						message+="Auto type: Truck \n";
					}
					if(((Automobile) fleet.get(i)).isTintedWindows())
						{message+= "Has tinted windows \n";}
					else {message+= "Does not have tinted windows \n";}
					message+= "Number of doors" + ((Automobile) fleet.get(i)).getDoors()+"\n";
					switch (dec2)
					{
					case 1:
						if(((AutomobileGas) fleet.get(i)).getFuelType()=='C')
						{
							message+="Fuel type: Common \n";
						}
						if(((AutomobileGas) fleet.get(i)).getFuelType()=='E')
						{
							message+="Fuel type: Extra \n";
						}
						if(((AutomobileGas) fleet.get(i)).getFuelType()=='D')
						{
							message+="Fuel type: Diesel \n";
						}
						message+="Tank Capacity: "+((AutomobileGas) fleet.get(i)).getTankCapacity()+"\n"
								+ "Fuel efficiency: "+((AutomobileGas) fleet.get(i)).getFuelEfficiency()+"\n"
										+ "Registration number: "+i+"\n\n";
						break;
					case 2: 
						if(((AutomobileElectric) fleet.get(i)).getChargerType()=='F')
						{
							message+="Charger type: Fast \n";
						}
						if(((AutomobileElectric) fleet.get(i)).getChargerType()=='N')
						{
							message+="Charger type: Normal \n";
						}
						message+= "Battery Duration: "+((AutomobileElectric) fleet.get(i)).getBatteryDuration()+"\n"
								+ "Battery Efficiency: "+((AutomobileElectric) fleet.get(i)).getBatteryEfficiency()+"\n"
								+ "Registration number: "+i+"\n\n";
						break;
					case 3:
						if(((AutomobileHybrid) fleet.get(i)).getFuelType()=='C')
						{
							message+="Fuel type: Common \n";
						}
						if(((AutomobileHybrid) fleet.get(i)).getFuelType()=='E')
						{
							message+="Fuel type: Extra \n";
						}
						if(((AutomobileHybrid) fleet.get(i)).getFuelType()=='D')
						{
							message+="Fuel type: Diesel \n";
						}
						message+="Tank Capacity: "+((AutomobileHybrid) fleet.get(i)).getTankCapacity()+"\n"
								+ "Fuel efficiency: "+((AutomobileHybrid) fleet.get(i)).getFuelEfficiency()+"\n";
						if(((AutomobileHybrid) fleet.get(i)).getChargerType()=='F')
						{
							message+="Charger type: Fast \n";
						}
						if(((AutomobileHybrid) fleet.get(i)).getChargerType()=='N')
						{
							message+="Charger type: Normal \n";
						}
						message+= "Battery Duration: "+((AutomobileHybrid) fleet.get(i)).getBatteryDuration()+"\n"
								+ "Battery Efficiency: "+((AutomobileHybrid) fleet.get(i)).getBatteryEfficiency()+"\n"
								+ "Registration number: "+i+"\n\n";
								
					}
				}
			}
			
			break;
	}
		if(message.equals(""))
			message="There are no vehicles registered that match this criteria \n";
		message+="Press enter to continue \n";
		return message;
	}

	/**
	 * addVehicleOfInterest
	 * adds a specific vehicle to an assigned client's <code>interestedIn</code> ArrayList of Vehicle
	 * @param veh an int, must represent the position (index) of a vehicle in the CarDealer's <code>fleet</code> ArrayList of Vehicle
	 * @param employee an int, must represent the position (index) of an employee in the CarDealer's <code>employees</code> Employee[]
	 * @param client an int, must represent the position (index) of a Client in an employee's <code>assignedClients</code> Client[]
	 */
	public void addVehicleOfInterest(int veh,int employee, int client) {
		
		employees[employee].getAssignedClients()[client].getInterestedIn().add(fleet.get(veh));
		
	}

	/**
	 * printInterestedList
	 * returns a Strung with the information of the vehicles in an assigned client's <code>interestedIn</code> ArrayList of Vehicle
	 * @param employee an int, must represent the position (index) of an employee in the CarDealer's <code>employees</code> Employee[]
	 * @param client an int, must represent the position (index) of a Client in an employee's <code>assignedClients</code> Client[]
	 * @return a String
	 */
	public String printInterestedList(int employee, int client) {
		String message="";
	for (int i=0;i<employees[employee].getAssignedClients()[client].getInterestedIn().size();i++)
		{
			Vehicle getBaseInfo= employees[employee].getAssignedClients()[client].getInterestedIn().get(i);
			if(!getBaseInfo.isNewVehicle())
			{
				message+="Vehicle is used"+ "\n"+ "License Plate: "+getBaseInfo.getLicensePlate()+"\n"
						+ "Documents: \n"
						+ "Soat: \n"
						+ "Price: "+getBaseInfo.getDocuments()[0].getPrice()+"\n"
						+ "Expiration year: "+getBaseInfo.getDocuments()[0].getYear()+"\n"
						+ "Coverage Amount: "+((Soat)getBaseInfo.getDocuments()[0]).getAccidentCoverage()+"\n"
						+ "Code: "+getBaseInfo.getDocuments()[0].getCode()+"\n"
						
						+ "Technical-Mechanical revision: \n"
						+ "Price: "+getBaseInfo.getDocuments()[1].getPrice()+"\n"
						+ "Expiration year: "+getBaseInfo.getDocuments()[1].getYear()+"\n"
						+ "Gas Level: "+((TechMech)getBaseInfo.getDocuments()[1]).getGasLevel()+"\n"
						+ "Code: "+getBaseInfo.getDocuments()[0].getCode()+"\n";
			}
			else {message+="Vehicle is not used \n";}
			message+="Brand: "+getBaseInfo.getBrand()+"\n"
			+ "Model: "+getBaseInfo.getModel()+"\n"
					+ "Kilometerage: "+getBaseInfo.getOdometerRead()+"\n"
							+ "Cylinder Capacity: "+getBaseInfo.getCylinderCap()+"\n";
			if(employees[employee].getAssignedClients()[client].getInterestedIn().get(i) instanceof Motorbyke)
			{
				Motorbyke getInfo= ((Motorbyke)employees[employee].getAssignedClients()[client].getInterestedIn().get(i));
				
				if(getInfo.getBikeType()=='C')
				{
					message+="Byke type: Cross \n";
				}
				if(getInfo.getBikeType()=='S')
				{
					message+="Byke type: Scooter \n";
				}
				if(getInfo.getBikeType()=='D')
				{
					message+="Byke type: Sports \n";
				}
				if(getInfo.getBikeType()=='E')
				{
					message+="Byke type: Estandar \n";
				}
				message+="Tank Capacity: "+getInfo.getTankCapacity()+"\n"
						+ "Fuel efficiency: "+getInfo.getFuelEfficiency()+"\n";
				message+= "Total Price: "+getInfo.getTotalPrice()+"\n\n\n";
													
			}
			
			
			if(employees[employee].getAssignedClients()[client].getInterestedIn().get(i) instanceof AutomobileElectric)
			{
				AutomobileElectric getInfo= ((AutomobileElectric)employees[employee].getAssignedClients()[client].getInterestedIn().get(i));
				message+= "Auto Type: "+getInfo.getAutoType()+"\n"
						+ "Number of Doors: "+getInfo.getDoors()+"\n";
				if(getInfo.isTintedWindows())
				{
					message+="Tinted windows: No \n";
				}
				else {
					message+="Tinted windows: Yes \n";
				}
				if(getInfo.getChargerType()=='F')
				{
					message+="Charger type: Fast \n";
				}
				if(getInfo.getChargerType()=='N')
				{
					message+="Charger type: Normal \n";
				}
				message+= "Battery Duration: "+getInfo.getBatteryDuration()+"\n"
						+ "Battery Efficiency: "+getInfo.getBatteryEfficiency()+"\n";
				message+= "Total Price: "+getInfo.getTotalPrice()+"\n\n\n";
			}
			if(employees[employee].getAssignedClients()[client].getInterestedIn().get(i) instanceof AutomobileGas)
			{
				AutomobileGas getInfo= ((AutomobileGas)employees[employee].getAssignedClients()[client].getInterestedIn().get(i));
				message+= "Auto Type: "+getInfo.getAutoType()+"\n"
						+ "Number of Doors: "+getInfo.getDoors()+"\n";
				if(getInfo.isTintedWindows())
				{
					message+="Tinted windows: No \n";
				}
				else {
					message+="Tinted windows: Yes \n";
				}
				if(getInfo.getFuelType()=='C')
				{
					message+="Fuel type: Common \n";
				}
				if(getInfo.getFuelType()=='E')
				{
					message+="Fuel type: Extra \n";
				}
				if(getInfo.getFuelType()=='D')
				{
					message+="Fuel type: Diesel \n";
				}
				message+="Tank Capacity: "+getInfo.getTankCapacity()+"\n"
						+ "Fuel efficiency: "+getInfo.getFuelEfficiency()+"\n";
				message+= "Total Price: "+getInfo.getTotalPrice()+"\n\n\n";
			}
			if(employees[employee].getAssignedClients()[client].getInterestedIn().get(i) instanceof AutomobileHybrid)
			{
				AutomobileHybrid getInfo= ((AutomobileHybrid)employees[employee].getAssignedClients()[client].getInterestedIn().get(i));
				message+= "Auto Type: "+getInfo.getAutoType()+"\n"
						+ "Number of Doors: "+getInfo.getDoors()+"\n";
				if(getInfo.isTintedWindows())
				{
					message+="Tinted windows: No \n";
				}
				else {
					message+="Tinted windows: Yes \n";
				}
				if(getInfo.getFuelType()=='C')
				{
					message+="Fuel type: Common \n";
				}
				if(getInfo.getFuelType()=='E')
				{
					message+="Fuel type: Extra \n";
				}
				if(getInfo.getFuelType()=='D')
				{
					message+="Fuel type: Diesel \n";
				}
				message+="Tank Capacity: "+getInfo.getTankCapacity()+"\n"
						+ "Fuel efficiency: "+getInfo.getFuelEfficiency()+"\n";
				if(getInfo.getChargerType()=='F')
				{
					message+="Charger type: Fast \n";
				}
				if(getInfo.getChargerType()=='N')
				{
					message+="Charger type: Normal \n";
				}
				message+= "Battery Duration: "+getInfo.getBatteryDuration()+"\n"
						+ "Battery Efficiency: "+getInfo.getBatteryEfficiency()+"\n";
				message+= "Total Price: "+getInfo.getTotalPrice()+"\n\n\n";
			}
			message+="Vehicle of interest number"+ (i);
		}
	if(message=="")
		{message="No vehicles of interest added yet";}
		return message;
	}
	//used vehicles with unexpired documents
	/**
	 * sellVehicle
	 * sells a vehicle whose documents are up to date, applies the discount given. 
	 * <b>Post</b>: the company's <code>totalEarnings</code> and <code>salesAmount</code> increase, the specific vehicle's <code>owner</code>
	 * 	is updated and that vehicle is removed from: all clients' <code>interestedIn</code> ArrayList of Vehicle, 
	 *  the company's <code>fleet</code> ArrayList of Vehicle (and <code>oldParkingLot</code> vehicle[][] if it was there).
	 *  the vehicle is added to the company's <code>sold</code> ArrayList of Vehicle, the employee's <code>sales</code> increase, 
	 *  and the client is removed from the employee's <code>assignedClients</code> Client[].
	 * @param employee an int, must represent the position (index) of an employee in the CarDealer's <code>employees</code> Employee[]
	 * @param client an int, must represent the position (index) of a Client in an employee's <code>assignedClients</code> Client[]
	 * @param vehicle an int, must represent the position (index) of a Vehicle in the Client's <code>interestedIn</code> ArrayList of Vehicle
	 * @param paddDisc a double, not negative
	 * @return a String saying the vehicle was sold successfully, at which price, who the new owner is and the updated sales and earnings of the CarDealer
	 */
	public String sellVechicle(int employee, int client, int vehicle, double paddDisc) {
		String message="";
		for(int i=0; i<fleet.size();i++)
			{
				if(fleet.get(i).equals(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle)))
				{
					fleet.remove(i);
				}
			}
		for(int i=0; i<unassignedClients.size();i++)
		{
			unassignedClients.get(i).getInterestedIn().remove(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
		}
		if(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getModel()<2015)
		{
		removeFromParkingLot(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
		}
		employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setAdditionalDiscount(paddDisc);
		employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setTotalPrice(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice()*(1-paddDisc));
		double sellingPrice=employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice();
		employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setOwner(employees[employee].getAssignedClients()[client]);
		String newOwner=employees[employee].getAssignedClients()[client].getName()+" "+employees[employee].getAssignedClients()[client].getLastName();
		setSalesAmount(getSalesAmount()+1);
		int updatedSales=getSalesAmount();
		setTotalEarnings(getTotalEarnings()+employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice());
		double updatedEarnings= getTotalEarnings();
		employees[employee].setSales(employees[employee].getSales()+1);
		int updatedEmployeeSales=employees[employee].getSales();
		sold.add(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
		for(int i=0; i<employees.length;i++) 
		{
			for(int j=0;j<employees[i].getAssignedClients().length;j++)
			{
				employees[i].getAssignedClients()[j].getInterestedIn().remove(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
			}
		}
		
		unassignedClients.add(employees[employee].getAssignedClients()[client]);
		Client[] newAssignedClients = new Client[employees[employee].getAssignedClients().length];
		for(int i=0;i<employees[employee].getAssignedClients().length;i++)
		{
			if(!(employees[employee].getAssignedClients()[i].equals(employees[employee].getAssignedClients()[client])))
			{
				newAssignedClients[i]=employees[employee].getAssignedClients()[i];
			}
		}
		employees[employee].setAssignedClients(newAssignedClients);
		message= "Vehicle Sold succesfully! \n"
				+ "Selling Price: "+sellingPrice+"\n"
				+ "New Owner: "+ newOwner+"\n"
				+ "Company Sales Amount: " +updatedSales+"\n"
				+ "Company Earnings: "+updatedEarnings+"\n"
				+ employees[employee].getName()+ " "+employees[employee].getLastName()+"'s total sales: "+updatedEmployeeSales+"\n";
								
		return message;
	}
	//used vehicles with both expired documents/new vehicles
	
	/**
	 * sellVehicle
	 * sells a vehicle whose documents are both expired or have to be generated, applies the discount given. 
	 * <b>Post</b>: The vehicle's documents are renewed and assigned and that cost is added to the vehicle's <code>totalPrice</code>,
	 * 	the company's <code>totalEarnings</code> and <code>salesAmount</code> increase, the specific vehicle's <code>owner</code>
	 * 	is updated and that vehicle is removed from: all clients' <code>interestedIn</code> ArrayList of Vehicle, 
	 *  the company's <code>fleet</code> ArrayList of Vehicle (and <code>oldParkingLot</code> vehicle[][] if it was there).
	 *  the vehicle is added to the company's <code>sold</code> ArrayList of Vehicle, the employee's <code>sales</code> increase, 
	 *  and the client is removed from the employee's <code>assignedClients</code> Client[].
	 * @param employee an int, must represent the position (index) of an employee in the CarDealer's <code>employees</code> Employee[]
	 * @param client an int, must represent the position (index) of a Client in an employee's <code>assignedClients</code> Client[]
	 * @param vehicle an int, must represent the position (index) of a Vehicle in the Client's <code>interestedIn</code> ArrayList of Vehicle
	 * @param paddDisc a double, not negative
	 * @param price1 a double, not negative
	 * @param year1 an int, not negative
	 * @param paccidentCoverage a double, not negative
	 * @param price2 a double, not negative
	 * @param year2 an int, not negative
	 * @param pgasLevel a double, not negative
	 * @return a String saying the vehicle was sold successfully, at which price, who the new owner is and the updated sales and earnings of the CarDealer
	 */
	public String sellVechicle(int employee, int client, int vehicle, double paddDisc, double price1, int year1,
			double paccidentCoverage, double price2, int year2, double pgasLevel) 
	{
		String message="";
		for(int i=0; i<fleet.size();i++)
		{
			if(fleet.get(i).equals(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle)))
			{
				fleet.remove(i);
			}
		}
		for(int i=0; i<unassignedClients.size();i++)
		{
			unassignedClients.get(i).getInterestedIn().remove(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
		}
			Document[] newDocs= new Document[2];
			newDocs[0]= new Soat(price1, year1,paccidentCoverage);
			newDocs[1]= new TechMech (price1, year1,pgasLevel);
			employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setDocuments(newDocs);
			if(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getModel()<2015)
			{
			removeFromParkingLot(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
			}
			employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setAdditionalDiscount(paddDisc);
			if(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).isNewVehicle()) 
			{
				employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setTotalPrice((price1+price2+employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice())*(1-paddDisc));
			}
			else {
				employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setTotalPrice((price1+price2+1000000+employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice())*(1-paddDisc));
			}
			double sellingPrice=employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice();
			employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setOwner(employees[employee].getAssignedClients()[client]);
			String newOwner=employees[employee].getAssignedClients()[client].getName()+" "+employees[employee].getAssignedClients()[client].getLastName();
			setSalesAmount(getSalesAmount()+1);
			int updatedSales=getSalesAmount();
			setTotalEarnings(getTotalEarnings()+employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice());
			double updatedEarnings= getTotalEarnings();
			employees[employee].setSales(employees[employee].getSales()+1);
		int updatedEmployeeSales = employees[employee].getSales();
		sold.add(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));

		for (int i = 0; i < employees.length; i++) 
			{
				for(int j=0;j<employees[i].getAssignedClients().length;j++)
				{
					employees[i].getAssignedClients()[j].getInterestedIn().remove(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
				}
			}
			unassignedClients.add(employees[employee].getAssignedClients()[client]);
			Client[] newAssignedClients = new Client[employees[employee].getAssignedClients().length];
			for(int i=0;i<employees[employee].getAssignedClients().length;i++)
			{
				if(!(employees[employee].getAssignedClients()[i].equals(employees[employee].getAssignedClients()[client])))
				{
					newAssignedClients[i]=employees[employee].getAssignedClients()[i];
				}
			}
			employees[employee].setAssignedClients(newAssignedClients);
			message= "Vehicle Sold succesfully! \n"
					+ "Selling Price: "+sellingPrice+"\n"
					+ "New Owner: "+ newOwner+"\n"
					+ "Company Sales Amount: " +updatedSales+"\n"
					+ "Company Earnings: "+updatedEarnings+"\n"
					+ employees[employee].getName()+ " "+employees[employee].getLastName()+"'s total sales: "+updatedEmployeeSales+"\n";
			return message;
	}
	//used vehicles with only one expired document
	/**
	 * sellVehicle
	 * sells a vehicle with one expired document, applies the discount given. 
	 * <b>Post</b>: The vehicle's expired document is renewed and assigned and that cost is added to the vehicle's <code>totalPrice</code>,
	 * 	the company's <code>totalEarnings</code> and <code>salesAmount</code> increase, the specific vehicle's <code>owner</code>
	 * 	is updated and that vehicle is removed from: all clients' <code>interestedIn</code> ArrayList of Vehicle, 
	 *  the company's <code>fleet</code> ArrayList of Vehicle (and <code>oldParkingLot</code> vehicle[][] if it was there).
	 *  the vehicle is added to the company's <code>sold</code> ArrayList of Vehicle, the employee's <code>sales</code> increase, 
	 *  and the client is removed from the employee's <code>assignedClients</code> Client[].
	 * @param employee an int, must represent the position (index) of an employee in the CarDealer's <code>employees</code> Employee[]
	 * @param client an int, must represent the position (index) of a Client in an employee's <code>assignedClients</code> Client[]
	 * @param vehicle an int, must represent the position (index) of a Vehicle in the Client's <code>interestedIn</code> ArrayList of Vehicle
	 * @param paddDisc a double, not negative
	 * @param pprice1 a double, not negative
	 * @param pyear1 an int, not negative
	 * @param paccidentCoverage a double, not negative
	 * @param ident an int, either 1 or 2
	 * @return a String saying the vehicle was sold successfully, at which price, who the new owner is and the updated sales and earnings of the CarDealer
	 */
	public String sellVechicle(int employee, int client, int vehicle, double paddDisc, double pprice1, int pyear1,
			double paccidentCoverage, int ident) 
		{
		String message="";	
		for(int i=0; i<fleet.size();i++)
			{
				if(fleet.get(i).equals(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle)))
				{
					fleet.remove(i);
				}
			}
		for(int i=0; i<unassignedClients.size();i++)
		{
			unassignedClients.get(i).getInterestedIn().remove(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
		}
			if(ident==1)
			{
				Soat newSoat=new Soat(pprice1, pyear1,paccidentCoverage);
				employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getDocuments()[0]= newSoat;
			}
			if(ident==2)
			{
				TechMech newTM= new TechMech(pprice1, pyear1,paccidentCoverage);
				employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getDocuments()[1]= newTM;
			}
			if(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getModel()<2015)
			{
			removeFromParkingLot(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
			}
			employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setAdditionalDiscount(paddDisc);
			employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setTotalPrice((500000+pprice1+employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice())*(1-paddDisc));
			double sellingPrice=employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice();
			employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).setOwner(employees[employee].getAssignedClients()[client]);
			String newOwner=employees[employee].getAssignedClients()[client].getName()+" "+employees[employee].getAssignedClients()[client].getLastName();
			setSalesAmount(getSalesAmount()+1);
			int updatedSales=getSalesAmount();
			setTotalEarnings(getTotalEarnings()+employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle).getTotalPrice());
			double updatedEarnings= getTotalEarnings();
			employees[employee].setSales(employees[employee].getSales()+1);
			int updatedEmployeeSales=getSalesAmount();
			sold.add(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
			for(int i=0; i<employees.length;i++) 
			{
				for(int j=0;j<employees[i].getAssignedClients().length;j++)
				{
					employees[i].getAssignedClients()[j].getInterestedIn().remove(employees[employee].getAssignedClients()[client].getInterestedIn().get(vehicle));
				}
			}
			unassignedClients.add(employees[employee].getAssignedClients()[client]);
			Client[] newAssignedClients = new Client[employees[employee].getAssignedClients().length];
			for(int i=0;i<employees[employee].getAssignedClients().length;i++)
			{
				if(!(employees[employee].getAssignedClients()[i].equals(employees[employee].getAssignedClients()[client])))
				{
					newAssignedClients[i]=employees[employee].getAssignedClients()[i];
				}
			}
			employees[employee].setAssignedClients(newAssignedClients);
			message= "Vehicle Sold succesfully! \n"
					+ "Selling Price: "+sellingPrice+"\n"
					+ "New Owner: "+ newOwner+"\n"
					+ "Company Sales Amount: " +updatedSales+"\n"
					+ "Company Earnings: "+updatedEarnings+"\n"
					+ employees[employee].getName()+ " "+employees[employee].getLastName()+"'s total sales: "+updatedEmployeeSales+"\n";
			return message;
	}

	/**
	 * removeFromParkingLot
	 * this method removes from the ParkingLot one vehicle that is the same as the one given in the parameters
	 * @param vehicle a vehicle, not null
	 */
	private void removeFromParkingLot(Vehicle vehicle) {
		int column=-vehicle.getModel()+2014;
		boolean found=false;
		if(column>3)
			column=4;
		for(int i=0; i<OPD_ROWS&!found;i++)
		{
			if(getOldParkingLot()[i][column].equals(vehicle))
			{
				getOldParkingLot()[i][column]=null;
				found=true;
			}
		}
		
	}

	/**
	 * showColumnOP
	 * shows the information of the vehicles in a specific column of the parking lot
	 * @param dec an int, between 0 and 4
	 * @return a String
	 */
	public String showColumnOP(int dec) {
		String message=""; int cont=0;
		for(int i=0; i<OPD_ROWS;i++)
		{
			if(getOldParkingLot()[i][dec]!=null)
			{
				if(!getOldParkingLot()[i][dec].isNewVehicle()){message+="License Plate: "+getOldParkingLot()[i][dec].getLicensePlate()+"\n";}
				message+="Brand: "+getOldParkingLot()[i][dec].getBrand()+"\n"
						+ "Model: "+getOldParkingLot()[i][dec].getModel()+"\n"
								+ "Kilometerage: "+getOldParkingLot()[i][dec].getOdometerRead()+"\n";
				if(((Automobile) getOldParkingLot()[i][dec]).getAutoType()=='S')
				{
					message+="Auto type: Sedan \n";
				}
				if(((Automobile) getOldParkingLot()[i][dec]).getAutoType()=='C')
				{
					message+="Auto type: Truck \n";
				}
				if(((Automobile) getOldParkingLot()[i][dec]).isTintedWindows())
					{message+= "Has tinted windows \n";}
				else {message+= "Does not have tinted windows \n";}
				message+= "Number of doors" + ((Automobile) getOldParkingLot()[i][dec]).getDoors()+"\n";
				if(getOldParkingLot()[i][dec] instanceof AutomobileGas)
				{
				if(((AutomobileGas) getOldParkingLot()[i][dec]).getFuelType()=='C')
				{
					message+="Fuel type: Common \n";
				}
				if(((AutomobileGas) getOldParkingLot()[i][dec]).getFuelType()=='E')
				{
					message+="Fuel type: Extra \n";
				}
				if(((AutomobileGas) getOldParkingLot()[i][dec]).getFuelType()=='D')
				{
					message+="Fuel type: Diesel \n";
				}
				message+="Tank Capacity: "+((AutomobileGas) getOldParkingLot()[i][dec]).getTankCapacity()+"\n"
						+ "Fuel efficiency: "+((AutomobileGas) getOldParkingLot()[i][dec]).getFuelEfficiency()+"\n\n";
				}
				if(getOldParkingLot()[i][dec] instanceof AutomobileElectric)
				{
					if(((AutomobileElectric) getOldParkingLot()[i][dec]).getChargerType()=='F')
					{
						message+="Charger type: Fast \n";
					}
					if(((AutomobileElectric) getOldParkingLot()[i][dec]).getChargerType()=='N')
					{
						message+="Charger type: Normal \n";
					}
					message+= "Battery Duration: "+((AutomobileElectric) getOldParkingLot()[i][dec]).getBatteryDuration()+"\n"
							+ "Battery Efficiency: "+((AutomobileElectric) getOldParkingLot()[i][dec]).getBatteryEfficiency()+"\n\n";
				}
				if(getOldParkingLot()[i][dec] instanceof AutomobileHybrid)
				{
					if(((AutomobileHybrid) getOldParkingLot()[i][dec]).getFuelType()=='C')
					{
						message+="Fuel type: Common \n";
					}
					if(((AutomobileHybrid) getOldParkingLot()[i][dec]).getFuelType()=='E')
					{
						message+="Fuel type: Extra \n";
					}
					if(((AutomobileHybrid) getOldParkingLot()[i][dec]).getFuelType()=='D')
					{
						message+="Fuel type: Diesel \n";
					}
					message+="Tank Capacity: "+((AutomobileHybrid) getOldParkingLot()[i][dec]).getTankCapacity()+"\n"
							+ "Fuel efficiency: "+((AutomobileHybrid) getOldParkingLot()[i][dec]).getFuelEfficiency()+"\n";
					if(((AutomobileHybrid) getOldParkingLot()[i][dec]).getChargerType()=='F')
					{
						message+="Charger type: Fast \n";
					}
					if(((AutomobileHybrid) getOldParkingLot()[i][dec]).getChargerType()=='N')
					{
						message+="Charger type: Normal \n";
					}
					message+= "Battery Duration: "+((AutomobileHybrid) getOldParkingLot()[i][dec]).getBatteryDuration()+"\n"
							+ "Battery Efficiency: "+((AutomobileHybrid) getOldParkingLot()[i][dec]).getBatteryEfficiency()+"\n\n";
				}
			cont++;
			}
		}
		message+="Number of vehicles in column "+(dec+1)+": "+cont+"\n";
		if(cont==OPD_ROWS)
		{
			message+="This column needs more space if more vehicles are to be added \n";
		}
		return message;
	}

	/**
	 * showPLGeneralInfo
	 * shows how many spaces are left in each column of the parking lot
	 * @return a String
	 */
	public String showPLGeneralInfo() {
		String message="";
		int cont=0;
		for(int j=0;j<OPD_COLUMNS;j++)
			{
				for(int i=0; i<OPD_ROWS;i++)
				{
					if(getOldParkingLot()[i][j]!=null)
					{
						cont++;
					}
				}
				message+="Number of vehicles in column "+(j+1)+": "+cont+"\n";
				if(cont==OPD_ROWS)
				{
					message+="This column needs more space if more vehicles are to be added \n";
				}
			}
		
		return message;
	}
}
