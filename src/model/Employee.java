package model;

public class Employee extends Person{

	//contants
	
	public final static int MAX_CLIENTS=5;
	
	//attributes
	
	private int sales;
	
	
	//relations
	
	private Client[] assignedClients;
	
	
	//methods
	public Employee(String name, String lastName, String id, int sales)
	{
		super(name, lastName, id);
		this.sales=sales;
		assignedClients=new Client[MAX_CLIENTS];
	}


	public int getSales() {
		return sales;
	}


	public void setSales(int sales) {
		this.sales = sales;
	}


	public Client[] getAssignedClients() {
		return assignedClients;
	}


	public void setAssignedClients(Client[] assignedClients) {
		this.assignedClients = assignedClients;
	}
	
}
