package model;

public abstract class Person {

	//attributes
	
	private String name;
	private String lastName;
	private String id;
	
	//methods
	
	/**
	 * Person
	 * constructor method. sets the attributes to the values in the parameters, does not instance class because it is Abstract
	 * @param name a String, not empty nor null
	 * @param lastName a String, not empty nor null
	 * @param id a String, not empty nor null
	 */
	public Person(String name, String lastName, String id) {
		this.name=name;
		this.lastName=lastName;
		this.id=id;
	}
	/**
	 * getName
	 * returns the name of the person
	 * @return a String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setName
	 * sets the name of the person
	 * @param name a String, not empty nor null
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getLastName
	 * returns the last name of the person
	 * @return a String 
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * setLastName
	 * sets the last name of the person
	 * @param lastName a String, not empty nor null
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * getId
	 * returns the ID of the person
	 * @return a String
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * setId
	 * sets the ID of the person
	 * @param id a String, not empty nor null
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
