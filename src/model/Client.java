package model;
import java.util.ArrayList;
public class Client extends Person {

	//attributes
	
	private String phoneNumber;
	private String email;
	
	//Relations
	
	private ArrayList<Vehicle> interestedIn;
	
	//methods 
	
	Client(String name, String lastName, String id, String phoneNumber, String email){
		super(name, lastName, id);
		this.phoneNumber=phoneNumber;
		this.email=email;
		interestedIn= new ArrayList<Vehicle>();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Vehicle> getInterestedIn() {
		return interestedIn;
	}

	public void setInterestedIn(ArrayList<Vehicle> interestedIn) {
		this.interestedIn = interestedIn;
	}
}
