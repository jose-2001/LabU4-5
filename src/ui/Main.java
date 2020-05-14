package ui;

import java.util.Scanner;
import java.time.LocalDate;

import model.CarDealer;

public class Main {

	public static Scanner scanner;
	private static CarDealer company;

	public static void main(String args[]) {
		scanner = new Scanner(System.in);
		System.out.println("Welcome");
		System.out.println("Please type in the Company's name");
		String companyName = scanner.nextLine();
		System.out.println("Please type in the company's NIT");
		String companyNit = scanner.nextLine();
		double companyEarnings = 0;
		do {
			System.out.println("Please type in the company's current total earnings (could be 0 but not negative)");
			companyEarnings = scanner.nextDouble();
		} while (companyEarnings < 0);
		int companySales = 0;
		do {
			System.out.println("Please type in the company's amount of sales done (could be 0 but not negative)");
			companySales = scanner.nextInt();
		} while (companySales < 0);
		scanner.nextLine();
		company = new CarDealer(companyName, companyNit, companyEarnings, companySales);

		int dec;
		boolean menu = true;
		boolean showAll1 = false;
		boolean showAll2 = false;
		boolean showAll3 = false;
		do {
			System.out.println("Welcome to the main menu");
			System.out.println("Type 1 to add an employees' basic information"); // usar método checkEmployees
			System.out.println("Type 2 to add a client's information (without assigning to an employee)");
			System.out.println("Type 3 to assign a client to an employee");
			System.out.println("Type 4 to add a vehicle to the fleet");
			if (showAll1 & showAll2 & showAll3) {
				System.out.println("Type 5 to show a catalog of the vehicles available");
				System.out.println("Type 6 to list a vehicle in the ''interested in'' List of a client");
				System.out.println("Type 7 to show the information of the vehicles in the ''interested in'' list of a Client");
				System.out.println("Type 8 to sell a vehicle");
				System.out.println("Type 9 to access the old unsold automobiles parking lot");
				System.out.println("Type 10 to terminate the program");
			} else {
				System.out.println("Type 10 to terminate the program");
				System.out
						.println("\n (Register an employee, an assigned client and a vehicle to see more options) \n");
			}

			dec = scanner.nextInt();
			scanner.nextLine();
			switch (dec) {
			case 1:
				addEmployee();
				showAll1 = true;
				break;
			case 2:
				addClient();

				break;
			case 3:
				assignClient();
				showAll2 = true;
				break;
			case 4:
				addVehicle();
				showAll3 = true;
				break;
			case 5:
				if (showAll1 & showAll2 & showAll3) {
					catalog();
				} else {
					System.out.println(
							"There must be at Least one employee, one assigned client and one vehicle registered to use this option \n"
									+ "Returning to menu");
				}
				break;
			case 6:
				if (showAll1 & showAll2 & showAll3) {
					addToInterested();
				} else {
					System.out.println(
							"There must be at Least one employee, one assigned client and one vehicle registered to use this option \n"
									+ "Returning to menu");
				}
				break;
			case 7:
				if (showAll1 & showAll2 & showAll3) {
					showInterested();
				} else {
					System.out.println(
							"There must be at Least one employee, one assigned client and one vehicle registered to use this option \n"
									+ "Returning to menu");
				}
				break;
			case 8:
				if (showAll1 & showAll2 & showAll3) {
					sellVehicle();
				} else {
					System.out.println(
							"There must be at Least one employee, one assigned client and one vehicle registered to use this option \n"
									+ "Returning to menu");
				}
				break;
			case 9:
				if (showAll1 & showAll2 & showAll3) {
					accessParking();
				} else {
					System.out.println(
							"There must be at Least one employee, one assigned client and one vehicle registered to use this option \n"
									+ "Returning to menu");
				}
				break;
			case 10:
				menu = false;
				System.out.println("GoodBye!");
			}
		} while (menu);
	}

	/**
	 * addEmployee
	 * This method checks if the maximum number of employees has been reached, if not, asks for the employee's information and adds it to the company's Employee[]
	 * <b>Post</b>: An employee is added to the company's <code>employees</code> Employee[]
	 */
	public static void addEmployee() {
		if (company.checkEmployees() == false) {
			System.out.println("The maximum amount of employees has been reached. Returning to menu");
		} else {
			// String name, String lastName, String id, int sales
			System.out.println("Type in the employee's first name");
			String EmployeeName = scanner.nextLine();
			System.out.println("Type in the employee's Last name");
			String EmployeeLastName = scanner.nextLine();
			System.out.println("Type in the employee's id");
			String EmployeeId = scanner.nextLine();
			System.out.println("Type in the employee's amount of sales done");
			int EmployeeSales = scanner.nextInt();
			scanner.nextLine();
			System.out.println(company.addEmployee(EmployeeName, EmployeeLastName, EmployeeId, EmployeeSales));
		}
		System.out.println("Press enter to continue");
		scanner.nextLine();
	}
	
	/**
	 * addClient
	 * This method asks for the employee's information and adds it to the company's unassignedClients ArrayList of Client
	 * <b>Post</b>: An unassigned client is added to the unassigned clients <code>unassignedClients</code> ArrayList of Client
	 */
	public static void addClient() {
		System.out.println("Type in the new client's first name");
		String pclientName = scanner.nextLine();
		System.out.println("Type in the new client's Last name");
		String pclientLastName = scanner.nextLine();
		System.out.println("Type in the new client's id");
		String pclientId = scanner.nextLine();
		System.out.println("Type in the new client's phone number");
		String pclientPhoneNumber = scanner.nextLine();
		System.out.println("Type in the new client's email");
		String pclientEmail = scanner.nextLine();
		System.out.println(
				company.addUnassignedClient(pclientName, pclientLastName, pclientId, pclientPhoneNumber, pclientEmail));
		System.out.println("Press enter to continue");
		scanner.nextLine();
	}
	
	/**
	 * assignClient
	 * This method checks if the maximum number of assigned clients has been reached, if not, asks if the information of the client to be assigned is already 
	 * registered, if not, asks for that information; then asks to which of the Employees the Client will be assigned
	 * <b>Post</b>: a new o existing unassigned client is added to an employee's <code>assignedClients</code> Client[]
	 */
	public static void assignClient() {
		int dec;
		int dec2;
		char decChar;
		String pclientName;
		String pclientLastName;
		String pclientId;
		String pclientPhoneNumber;
		String pclientEmail;
		if (company.availableEmployees() == false) {
			System.out.println("The maximum amount of assigned clients has been reached. Returning to menu");
		} else {
			if (company.getUnassignedClients().size() != 0) {
				System.out.println("Is it an existing unassigned client? (Y/N)");
				decChar = scanner.nextLine().toUpperCase().charAt(0);
				if (decChar == 'Y') {
					System.out.println("Which unassigned client do you want to assign?");
					for (int i = 0; i < company.getUnassignedClients().size(); i++) {
						System.out.println(
								"Type " + (i + 1) + " if it is " + company.getUnassignedClients().get(i).getName() + " "
										+ company.getUnassignedClients().get(i).getLastName() + " identified with ID "
										+ company.getUnassignedClients().get(i).getId());
					}
					dec = scanner.nextInt() - 1;
					scanner.nextLine();
					System.out.println("To which employee will " + company.getUnassignedClients().get(dec).getName()
							+ " " + company.getUnassignedClients().get(dec).getLastName() + " be assigned?");
					System.out.println(company.assignableEmployees());
					dec2 = scanner.nextInt() - 1;
					scanner.nextLine();
					company.assignClientToEmployee(dec, dec2);
					System.out.println("Client assigned succesfully");
				} else {
					System.out.println("Type in the new client's first name");
					pclientName = scanner.nextLine();
					System.out.println("Type in the new client's Last name");
					pclientLastName = scanner.nextLine();
					System.out.println("Type in the new client's id");
					pclientId = scanner.nextLine();
					System.out.println("Type in the new client's phone number");
					pclientPhoneNumber = scanner.nextLine();
					System.out.println("Type in the new client's email");
					pclientEmail = scanner.nextLine();
					System.out.println("To which employee will " + pclientName + " " + pclientLastName + " be assigned?");
					System.out.println(company.assignableEmployees());
					dec = scanner.nextInt() - 1;
					scanner.nextLine();
					company.assignClientToEmployee(pclientName, pclientLastName, pclientId, pclientPhoneNumber,
							pclientEmail, dec);
					System.out.println("Client added and assigned successfully");

				}
			} else {
				System.out.println("Type in the new client's first name");
				pclientName = scanner.nextLine();
				System.out.println("Type in the new client's Last name");
				pclientLastName = scanner.nextLine();
				System.out.println("Type in the new client's id");
				pclientId = scanner.nextLine();
				System.out.println("Type in the new client's phone number");
				pclientPhoneNumber = scanner.nextLine();
				System.out.println("Type in the new client's email");
				pclientEmail = scanner.nextLine();
				System.out.println("To which employee will " + pclientName + " " + pclientLastName + " be assigned?");
				System.out.println(company.assignableEmployees());
				dec = scanner.nextInt() - 1;
				scanner.nextLine();
				company.assignClientToEmployee(pclientName, pclientLastName, pclientId, pclientPhoneNumber,
						pclientEmail, dec);
				System.out.println("Client added and assigned successfully");
			}
		}
		System.out.println("Press enter to continue");
		scanner.nextLine();
	}
	
	/**
	 * addVehicle
	 * This method adds a vehicle to the fleet
	 * <b>Post</b>: a new vehicle is added to the company's <code>fleet</code> ArrayList of Vehicle
	 */
	public static void addVehicle() {
		int dec;char decChar;double pbasePrice;boolean pnewVehicle;String pbrand;int pmodel;double pcylinderCap;double podometerRead;String plicensePlate;
		double pprice;int pyear;double paccidentCoverage;double pprice2;int pyear2;double pgasLevel;char pbikeType;double ptankCapacity;char pautoType;
		boolean ptintedWindows;int pdoors;char pfuelType;char pchargerType;double pbatteryDuration;String pcode1;String pcode2;
		System.out.println("Type in the vehicle's base price");
		pbasePrice = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Type in the vehicle's brand");
		pbrand = scanner.nextLine();
		System.out.println("Type in the vehicle's model (year)");
		pmodel = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Type in the vehicle's cylinder capacity");
		pcylinderCap = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Is the vehicle used? (Y/N)");
		decChar = scanner.nextLine().toUpperCase().charAt(0);
		if (decChar == 'Y') {
			pnewVehicle = false;
			System.out.println("Type in the vehicle's odometer reading in kilometers (kilometerage)");
			podometerRead = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Type in the vehicle's License plate");
			plicensePlate = scanner.nextLine();
			System.out.println("Type in the vehicle's SOAT price");
			pprice = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Type in the vehicle's SOAT expiration year");
			pyear = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Type in the vehicle's SOAT coverage amount");
			paccidentCoverage = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Type in the vehicle's SOAT's code");
			pcode1 = scanner.nextLine();
			System.out.println("Type in the vehicle's Technical-Mechanical Revision price");
			pprice2 = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Type in the vehicle's Technical-Mechanical Revision expiration year");
			pyear2 = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Type in the Technical-Mechanical Revision results on the gas level of the vehicle");
			pgasLevel = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Type in the vehicle's Technical-Mechanical Revision's code");
			pcode2 = scanner.nextLine();
		} else {
			pnewVehicle = true;
			plicensePlate = "";
			podometerRead = 0;
			pprice = 0;
			pyear = LocalDate.now().getYear();
			paccidentCoverage = 0;
			pprice2 = 0;
			pyear2 = LocalDate.now().getYear();
			;
			pgasLevel = 0;
			pcode1 = "";
			pcode2 = "";
		}

		System.out.println("Type 1 if the vehicle is a motorcicle");
		System.out.println("Type 2 if the vehicle is a automobile");
		dec = scanner.nextInt();
		scanner.nextLine();
		switch (dec) {
		case 1:

			System.out.println("What type of motorcycle is it");
			System.out.println("Type E if it is a standard motorcycle");
			System.out.println("Type D if it is a sports motorcycle");
			System.out.println("Type S if it is a scooter motorcycle");
			System.out.println("Type C if it is a cross motorcycle");
			pbikeType = scanner.nextLine().toUpperCase().charAt(0);
			System.out.println("Type in the motorcycle's tank capacity");
			ptankCapacity = scanner.nextDouble();
			scanner.nextLine();
			company.addMotorByke(pbasePrice, pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle, plicensePlate,
					null, pprice, pyear, paccidentCoverage, pcode1, pprice2, pyear2, pgasLevel, pcode2, pbikeType,
					ptankCapacity);
			System.out.println("motorcycle added successfully!");
			break;
		case 2:

			System.out.println("What type of automobile is it");
			System.out.println("Type S if it is a sedan type of automobile");
			System.out.println("Type C if it is an SUV/truck type of automobile");
			pautoType = scanner.nextLine().toUpperCase().charAt(0);
			System.out.println("How many doors does the automobile have?");
			pdoors = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Are the windows tinted? (Y/N)");
			decChar = scanner.nextLine().toUpperCase().charAt(0);
			if (decChar == 'Y') {
				ptintedWindows = true;
			} else {
				ptintedWindows = false;
			}
			System.out.println("Type 1 if the automobile runs on gas");
			System.out.println("Type 2 if the automobile is electric");
			System.out.println("Type 3 if the automobile is hybrid");
			dec = scanner.nextInt();
			scanner.nextLine();
			switch (dec) {
			case 1:
				System.out.println("Type in the automobile's tank capacity");
				ptankCapacity = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("What type of fuel does the automobile use?");
				System.out.println("Type E if it runs on extra");
				System.out.println("Type D if it runs on diesel");
				System.out.println("Type C if it runs on common gasoline");
				pfuelType = scanner.nextLine().toUpperCase().charAt(0);
				System.out.println(company.addAutomobileGas(pbasePrice, pbrand, pmodel, pcylinderCap, podometerRead,
						pnewVehicle, plicensePlate, null, pprice, pyear, paccidentCoverage, pcode1, pprice2, pyear2,
						pgasLevel, pcode2, pautoType, pdoors, ptintedWindows, ptankCapacity, pfuelType));
				System.out.println("gas automobile added successfully!");
				break;
			case 2:
				System.out.println("What type of charger does the automobile use?");
				System.out.println("Type F if it uses a fast charger");
				System.out.println("Type N if it uses a normal charger");
				pchargerType = scanner.nextLine().toUpperCase().charAt(0);
				System.out.println("Type in the duration of the battery (in kilometers)");
				pbatteryDuration = scanner.nextDouble();
				scanner.nextLine();
				company.addAutomobileElectric(pbasePrice, pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,
						plicensePlate, null, pprice, pyear, paccidentCoverage, pcode1, pprice2, pyear2, pgasLevel,
						pcode2, pautoType, pdoors, ptintedWindows, pchargerType, pbatteryDuration);
				System.out.println("electric automobile added successfully!");
				break;
			case 3:
				System.out.println("Type in the automobile's tank capacity");
				ptankCapacity = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("What type of fuel does the automobile use?");
				System.out.println("Type E if it runs on extra");
				System.out.println("Type D if it runs on diesel");
				System.out.println("Type C if it runs on common gasoline");
				pfuelType = scanner.nextLine().toUpperCase().charAt(0);
				System.out.println("What type of charger does the automobile use?");
				System.out.println("Type F if it uses a fast charger");
				System.out.println("Type N if it uses a normal charger");
				pchargerType = scanner.nextLine().toUpperCase().charAt(0);
				System.out.println("Type in the duration of the battery (in kilometers)");
				pbatteryDuration = scanner.nextDouble();
				scanner.nextLine();
				company.addAutomobileHybrid(pbasePrice, pbrand, pmodel, pcylinderCap, podometerRead, pnewVehicle,
						plicensePlate, null, pprice, pyear, paccidentCoverage, pcode1, pprice2, pyear2, pgasLevel,
						pcode2, pautoType, pdoors, ptintedWindows, ptankCapacity, pfuelType, pchargerType,
						pbatteryDuration);
				System.out.println("hyrbid automobile added successfully!");
				break;
			}
			break;
		}
		System.out.println("Press enter to continue");
		scanner.nextLine();
	}
	
	/**
	 * catalog
	 * This method asks for to the user's criteria and displays a catalog of the vehicles in
	 *  the company's <code>fleet</code> ArrayList of Vehicle accordingly
	 */
	public static void catalog() {

		System.out.println("Type 1 if you want to see a catalog of Motorcycles");
		System.out.println("Type 2 if you want to see a catalog of Automobiles");
		int dec = scanner.nextInt();
		scanner.nextLine();
		int dec2 = 0;
		int dec3 = 0;
		if (dec == 2 | dec == 3) {
			System.out.println("Type 1 if you want to see a catalog of gas Automobiles");
			System.out.println("Type 2 if you want to see a catalog of electric Automobiles");
			System.out.println("Type 3 if you want to see a catalog of hybrid Automobiles");
			dec2 = scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("Type 1 if you want the catalog to include used vehicles only");
		System.out.println("Type 2 if you want the catalog to include new vehicles only");
		System.out.println("Type 3 if you want to include both");
		dec3 = scanner.nextInt();
		scanner.nextLine();
		System.out.println(company.catalog(dec, dec2, dec3));
		scanner.nextLine();
	}

	/**
	 * addToInterested
	 * This method asks for the vehicle's registration number (from the company's "fleet" ArrayList of Vehicle),
	 * the employee to which the client is assigned to and the specific client, then adds that vehicle to that
	 * employee's assigned client's <code>interestedIn</code> ArrayList of Vehicle
	 * <b>Post</b>: A vehicle from the fleet is added to the client's <code>interestedIn</code> ArrayList of Vehicle
	 */
	public static void addToInterested() {
		int dec, dec2, dec3;
		System.out.println(
				"Please type in the vehicle's registration number (displayed in the catalog, if unknown type -1)");
		dec = scanner.nextInt();
		scanner.nextLine();
		if (dec != -1) {
			System.out.println("In which employee's assigned client list is the client interested in the vehicle?");
			for (int i = 0; i < company.getEmployees().length; i++) {
				System.out
						.println("Type " + (i + 1) + " if the client belongs to " + company.getEmployees()[i].getName()
								+ " " + company.getEmployees()[i].getLastName() + "'s assigned client list");
			}
			dec2 = (scanner.nextInt() - 1);
			scanner.nextLine();
			System.out.println("Select the correct client to add the vehicle to their list");
			for (int i = 0; i < company.getEmployees().length; i++) {
				System.out.println("Type " + (i + 1) + " if the client is "
						+ company.getEmployees()[dec2].getAssignedClients()[i].getName() + " "
						+ company.getEmployees()[dec2].getAssignedClients()[i].getLastName());
			}
			dec3 = (scanner.nextInt() - 1);
			scanner.nextLine();
			company.addVehicleOfInterest(dec, dec2, dec3);
			System.out.println("Vehicle added succesfully to the list");
			System.out.println("Press enter to continue");
			scanner.nextLine();
		} else {
			System.out.println("Returning to menu");
			System.out.println("Press enter to continue");
			scanner.nextLine();
		}
	}

	/**
	 * showInterested
	 * This method asks for the employee to which the client is assigned to and the specific client, then shows the 
	 * information of the vehicles in that client's <code>interestedIn</code> ArrayList of Vehicle
	 */
	public static void showInterested() {
		int dec2, dec3;
		System.out.println(
				"In which employee's assigned client list is the client whose ''interested in'' list you'd like to see?");
		for (int i = 0; i < company.getEmployees().length; i++) {
			System.out.println("Type " + (i + 1) + " if the client belongs to " + company.getEmployees()[i].getName()
					+ " " + company.getEmployees()[i].getLastName() + "'s assigned client list");
		}
		dec2 = (scanner.nextInt() - 1);
		scanner.nextLine();
		System.out.println("Select the correct client to see their list");
		for (int i = 0; i < company.getEmployees().length; i++) {
			System.out.println("Type " + (i + 1) + " if the client is "
					+ company.getEmployees()[dec2].getAssignedClients()[i].getName() + " "
					+ company.getEmployees()[dec2].getAssignedClients()[i].getLastName());
		}
		dec3 = (scanner.nextInt() - 1);
		scanner.nextLine();
		System.out.print(company.printInterestedList(dec2, dec3));
		System.out.print("Press enter to continue \n");
		scanner.nextLine();
	}

	/**
	 * sellVehicle
	 * this method asks for the employee to which the buyer is assigned to, the specific client (buyer) and the vehicle's
	 * 'Vehicle of interest' number, then it asks for the additional discount (optional), checks if that vehicle's documents 
	 * have expired, if so, asks for the information to renew them, then the method sells that specific vehicle to the client
	 * <b>Post</b>:
	 *  The vehicle's documents are renewed and assigned and that cost is added to the vehicle's <code>totalPrice</code>,
	 * 	the company's <code>totalEarnings</code> and <code>salesAmount</code> increase, the specific vehicle's <code>owner</code>
	 * 	is updated and that vehicle is removed from: all clients' <code>interestedIn</code> ArrayList of Vehicle, 
	 *  the company's <code>fleet</code> ArrayList of Vehicle (and <code>oldParkingLot</code> vehicle[][] if it was there).
	 *  the vehicle is added to the company's <code>sold</code> ArrayList of Vehicle, the employee's <code>sales</code> increase, 
	 *  and the client is removed from the employee's <code>assignedClients</code> Client[].
	 */
	public static void sellVehicle() {

		int dec, dec2, dec3;
		System.out.println("In which employee's assigned client list is the client who you want to sell a vehicle to?");
		for (int i = 0; i < company.getEmployees().length; i++) {
			System.out.println("Type " + (i + 1) + " if the client belongs to " + company.getEmployees()[i].getName()
					+ " " + company.getEmployees()[i].getLastName() + "'s assigned client list");
		}
		dec = (scanner.nextInt() - 1);
		scanner.nextLine();
		System.out.println("Select the correct client to sell a vehicle from the ''intereted in'' list");
		for (int i = 0; i < company.getEmployees().length; i++) {
			System.out.println("Type " + (i + 1) + " if the client is "
					+ company.getEmployees()[dec].getAssignedClients()[i].getName() + " "
					+ company.getEmployees()[dec].getAssignedClients()[i].getLastName());
		}
		dec2 = (scanner.nextInt() - 1);
		scanner.nextLine();
		System.out.println(
				"Please type in the vehicle's ''Vehicle of interest'' number (displayed in the ''interested in'' list, if unknown type -1)");
		dec3 = (scanner.nextInt());
		scanner.nextLine();
		if (dec3 != -1) {
			System.out.println(
					"Please type in the additional discount in decimals(if there will be no discount, type 0)");
			double paddDisc = scanner.nextDouble();
			scanner.nextLine();
			if (company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3).isNewVehicle()) {
				System.out.println("Please type in the price to pay for the new SOAT");
				double price1 = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Please type in the expiration year of the new SOAT");
				int year1 = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please Type in the vehicle's SOAT coverage amount");
				double paccidentCoverage = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Please type in the price to pay for the new Technical Mechanical revision");
				double price2 = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Please type in the expiration year of the new Technical Mechanical revision");
				int year2 = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Type in the Technical-Mechanical Revision results on the gas level of the vehicle");
				double pgasLevel = scanner.nextDouble();
				scanner.nextLine();
				System.out.println(company.sellVechicle(dec, dec2, dec3, paddDisc, price1, year1, paccidentCoverage,
						price2, year2, pgasLevel));
				System.out.println("Press enter to continue");
				scanner.nextLine();
			} else {
				if (company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3).getDocuments()[0]
						.getYear() < LocalDate.now().getYear()
						| company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3)
								.getDocuments()[1].getYear() < LocalDate.now().getYear()) {
					double pprice1;
					int pyear1;
					double paccidentCoverage;
					double pprice2;
					int pyear2;
					double pgasLevel;
					if (company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3)
							.getDocuments()[0].getYear() < LocalDate.now().getYear()
							& !(company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3)
									.getDocuments()[1].getYear() < LocalDate.now().getYear())) {
						System.out.println("This vehicle's SOAT expired, creating new one");
						System.out.println("Type in the new SOAT's price");
						pprice1 = scanner.nextDouble();
						scanner.nextLine();
						System.out.println("Type in the new SOAT's expiration year");
						pyear1 = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Type in the new SOAT's coverage amount");
						paccidentCoverage = scanner.nextDouble();
						scanner.nextLine();
						int ident = 1;
						System.out.println(company.sellVechicle(dec, dec2, dec3, paddDisc, pprice1, pyear1,
								paccidentCoverage, ident));
						System.out.println("Press enter to continue");
						scanner.nextLine();
					}
					if (company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3)
							.getDocuments()[1].getYear() < LocalDate.now().getYear()
							& !(company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3)
									.getDocuments()[0].getYear() < LocalDate.now().getYear())) {
						System.out.println("This vehicle's Technical-Mechanical Revision expired, creating new one");
						System.out.println("Type in the new Technical-Mechanical Revision's price");
						pprice2 = scanner.nextDouble();
						scanner.nextLine();
						System.out.println("Type in the new Technical-Mechanical Revision's expiration year");
						pyear2 = scanner.nextInt();
						scanner.nextLine();
						System.out.println(
								"Type in the Technical-Mechanical Revision's new results on the gas level of the vehicle");
						pgasLevel = scanner.nextDouble();
						scanner.nextLine();
						int ident = 2;
						System.out.println(
								company.sellVechicle(dec, dec2, dec3, paddDisc, pprice2, pyear2, pgasLevel, ident));
						System.out.println("Press enter to continue");
						scanner.nextLine();
					}
					if ((company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3)
							.getDocuments()[1].getYear() < LocalDate.now().getYear())
							& (company.getEmployees()[dec].getAssignedClients()[dec2].getInterestedIn().get(dec3)
									.getDocuments()[0].getYear() < LocalDate.now().getYear())) {
						System.out.println("This vehicle's SOAT expired, creating new one");
						System.out.println("Type in the new SOAT's price");
						pprice1 = scanner.nextDouble();
						scanner.nextLine();
						System.out.println("Type in the new SOAT's expiration year");
						pyear1 = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Type in the new SOAT's coverage amount");
						paccidentCoverage = scanner.nextDouble();
						scanner.nextLine();
						System.out.println("This vehicle's Technical-Mechanical Revision expired, creating new one");
						System.out.println("Type in the new Technical-Mechanical Revision's price");
						pprice2 = scanner.nextDouble();
						scanner.nextLine();
						System.out.println("Type in the new Technical-Mechanical Revision's expiration year");
						pyear2 = scanner.nextInt();
						scanner.nextLine();
						System.out.println(
								"Type in the Technical-Mechanical Revision's new results on the gas level of the vehicle");
						pgasLevel = scanner.nextDouble();
						scanner.nextLine();
						System.out.println(company.sellVechicle(dec, dec2, dec3, paddDisc, pprice1, pyear1,
								paccidentCoverage, pprice2, pyear2, pgasLevel));
						System.out.println("Press enter to continue");
						scanner.nextLine();
					}
				} else {
					company.sellVechicle(dec, dec2, dec3, paddDisc);
					System.out.println("Press enter to continue");
					scanner.nextLine();
				}
			}

		} else {
			System.out.println("Returning to menu");
			System.out.println("Press enter to continue");
			scanner.nextLine();
		}

	}

	/**
	 * accessParking
	 * this method asks if the user wants to see the information from the vehicles in a specific column of the <code>oldParkingLot</code>
	 * Vehicle[][] or from the parking lot's general information
	 */
	public static void accessParking() {
		System.out.println("Type 1 if you want to see a specific column's information");
		System.out.println("Type 2 if you want to see general information of the parking lot");
		int dec = scanner.nextInt();
		scanner.nextLine();
		if (dec == 1) {

			System.out.println("Which models information do you want to access?");
			for (int i = 0; i < 4; i++) {
				System.out
						.println("Type " + (i + 1) + " if you want to see the automobiles from the year " + (2014 - i));
			}
			System.out.println("Type 5 if you want to see the automobiles from the year 2010 and earlier");
			dec = (scanner.nextInt() - 1);
			scanner.nextLine();
			System.out.println(company.showColumnOP(dec));
		} else {
			System.out.println(company.showPLGeneralInfo());
		}
		System.out.println("Press enter to continue");
		scanner.nextLine();
	}
}
