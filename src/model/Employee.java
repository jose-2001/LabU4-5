package model;

public class Employee extends Person{

	//contants
	
	public final static int MAX_CLIENTS=5;
	
	//attributes
	
	private int sales;
	
	
	//relations
	
	private Client[] assignedClients;
	
	
	//methods
	/**
	 * Employee
	 * constructor method. instances the class Employee
	 * @param name a String, not empty nor null
	 * @param lastName a String, not empty nor null
	 * @param id a String, not empty nor null
	 * @param sales an int, not negative
	 */
	public Employee(String name, String lastName, String id, int sales)
	{
		super(name, lastName, id);
		this.sales=sales;
		assignedClients=new Client[MAX_CLIENTS];
	}

	/**
	 * getSales
	 * returns the sales of the Employee
	 * @return an int
	 */
	public int getSales() {
		return sales;
	}

	/**
	 * setSales
	 * sets the sales of the Employee
	 * @param sales an int, not negative
	 */
	public void setSales(int sales) {
		this.sales = sales;
	}

	/**
	 * getAssignedClients
	 * returns the assigned clients list of the Employee 
	 * @return a Client[]
	 */
	public Client[] getAssignedClients() {
		return assignedClients;
	}

	/**
	 * setAssignedClients
	 * sets the assigned clients list of the Employee
	 * @param assignedClients a Client[], not null
	 */
	public void setAssignedClients(Client[] assignedClients) {
		this.assignedClients = assignedClients;
	}
	
	/**
	 * addAssignedClient
	 * adds a client to the assigned clients of the Employee
	 * @param toAdd a Client
	 */
	public void addAssignedClient(Client toAdd) {
		for(int i=0; i<assignedClients.length;i++) 
		{
			if(assignedClients[i]==null)
			{
				assignedClients[i]= toAdd;
			}
		}
	}
	/**
	 * addAssignedClient 
	 * adds a client to the assigned clients of the Employee
	 * @param name a String, not empty nor null
	 * @param lastName a String, not empty nor null
	 * @param id a String, not empty nor null
	 * @param phoneNumber a String, not empty nor null
	 * @param email a String, not empty nor null
	 */
	public void addAssignedClient(String name, String lastName, String id, String phoneNumber, String email) {
		Client toAdd= new Client(name, lastName, id, phoneNumber, email);
		for(int i=0; i<assignedClients.length;i++) 
		{
			if(assignedClients[i]==null)
			{
				assignedClients[i]= toAdd;
			}
		}
	}
}
