package ui;
import java.util.Scanner;

import model.CarDealer;
public class Main {

	
	public static Scanner scanner;
	private static CarDealer company;
	
	public static void main(String args[]) {
		scanner= new Scanner (System.in);
		System.out.println("Welcome");
		scanner.nextLine();
		System.out.println("Please type in the Company's name");
		String companyName= scanner.nextLine();
		System.out.println("Please type in the company's NIT");
		String companyNit= scanner.nextLine();
		double companyEarnings=0;
		do{System.out.println("Please type in the company's current total earnings (could be 0 but not negative)");
		companyEarnings= scanner.nextDouble();}
		while(companyEarnings>=0);
		int companySales= 0;
		do{System.out.println("Please type in the company's amount of sales done (could be 0 but not negative)");
		companySales= scanner.nextInt();}
		while(companySales>=0);
		scanner.nextLine();
		company= new CarDealer(companyName, companyNit, companyEarnings, companySales);
		
		int dec=0;
		boolean menu=true;
		do {
			System.out.println("Welcome to the main menu");
			System.out.println("Type  to add an employees' basic information"); //usar método checkEmployees
			System.out.println("Type  to add a clients' information");
			System.out.println("Type  to add a vehicle to the fleet");
			System.out.println("Type  to show a catalog of the vehicles in the fleet");
			System.out.println("Type  to list a vehicle in the ''interested in'' List of a client");
			System.out.println("Type  to show the information of the vehicles in the ''interested in'' list of a Client");
			System.out.println("Type  to sell a  vehicle");
			System.out.println("Type  to print out the information of the vehicles in the ''interested in'' List of a client");
			System.out.println("Type  to terminate the program");
			dec=scanner.nextInt();
			scanner.nextLine();
			switch(dec) {
			case 1:
				if(company.checkEmployees()==false)
				{
					System.out.println("The maximum amount of employees has been reached. Returning to menu");
				}
				else {
					//String name, String lastName, String id, int sales 
					System.out.println("Type in the employee's first name");
					String EmployeeName= scanner.nextLine();
					System.out.println("Type in the employee's Last name");
					String EmployeeLastName= scanner.nextLine();
					System.out.println("Type in the employee's id");
					String EmployeeId= scanner.nextLine();
					System.out.println("Type in the employee's amount of sales done");
					int EmployeeSales= scanner.nextInt(); scanner.nextLine();
					System.out.println(company.addEmployee(EmployeeName, EmployeeLastName, EmployeeId, EmployeeSales));
				}
				break;
			case 2:
				
				
			}
		}
		while(menu);
	}
}
