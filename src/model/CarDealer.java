package model;
import java.util.ArrayList;
public class CarDealer {

	//constants
	
	public final static int EMPLOYEE_AMOUNT=10;
	
	//attributes
	
	private String name;
	private String nit;
	private double totalEarnings;
	private int salesAmount;
	
	//relations
	
	private ArrayList<Vehicle> fleet;
	private Employee[] employees;
	private Vehicle[][] oldParkingLot;
	
	//methods 
	public CarDealer(String name, String nit, double totalEarnings, int salesAmount) {
		this.name=name;
		this.nit=nit;
		this.totalEarnings=totalEarnings;
		this.salesAmount=salesAmount;
		fleet= new ArrayList<Vehicle>();
		employees= new Employee[EMPLOYEE_AMOUNT];
		oldParkingLot= new Vehicle[10][5];
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	public ArrayList<Vehicle> getFleet() {
		return fleet;
	}

	public void setFleet(ArrayList<Vehicle> fleet) {
		this.fleet = fleet;
	}
	public Vehicle[][] getOldParkingLot() {
		return oldParkingLot;
	}

	public void setOldParkingLot(Vehicle[][] oldParkingLot) {
		this.oldParkingLot = oldParkingLot;
	}

	public String addEmployee(String name, String lastName, String id, int sales ) {
		String message="";
		boolean alreadyExists=false;
		for(int i=0; i<EMPLOYEE_AMOUNT; i++)
		{
			if(employees[i].getId().equals(id))
				{
					alreadyExists=true;
					message="That employee is already registered";
				}
		}
		if(!alreadyExists)
		{
			int j=-1;
			for(int i=0;i<EMPLOYEE_AMOUNT; i++)
			{
				if(employees[i]==null)
				{
					j=i;
				}
			}
			if(j!=-1) {
			employees[j]= new Employee(name,lastName, id, sales);
			message="Employee added succesfully";}
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
}
