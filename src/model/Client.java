package model;
import java.util.ArrayList;
public class Client extends Person {

	//attributes
	
	private String phoneNumber;
	private String email;
	
	//Relations
	
	private ArrayList<Vehicle> interestedIn;
	
	//methods 
	
	/**
	 * Client
	 * constructor method. instances the class Client
	 * @param name a String, not empty nor null
	 * @param lastName a String, not empty nor null
	 * @param id a String, not empty nor null
	 * @param phoneNumber a String, not empty nor null
	 * @param email a String, not empty nor null
	 */
	Client(String name, String lastName, String id, String phoneNumber, String email){
		super(name, lastName, id);
		this.phoneNumber=phoneNumber;
		this.email=email;
		interestedIn= new ArrayList<Vehicle>();
	}

	/**
	 * getPhoneNumber
	 * returns the phone number of the client
	 * @return a String
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * setPhoneNumber
	 * sets the phone number of the client
	 * @param phoneNumber a String, not null
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * getEmail
	 * returns the email of the Client
	 * @return a String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail
	 * sets the email of the Client
	 * @param email a String, not empty nor null
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getInterestedIn
	 * returns the "interested in" list of vehicles of the Client
	 * @return an ArrayList of Vehicle
	 */
	public ArrayList<Vehicle> getInterestedIn() {
		return interestedIn;
	}
	
	/**
	 * setInterestedIn
	 * sets the "interested in" list of vehicles of the Client
	 * @param interestedIn an ArrayList of Vehicle not null
	 */
	public void setInterestedIn(ArrayList<Vehicle> interestedIn) {
		this.interestedIn = interestedIn;
	}
}
