package model;

public class Soat extends Document{
	
	//attributes
	
	private double accidentCoverage;

	
	//methods
	
	/**
	 * Soat
	 * constructor method. instances the class  Soat
	 * @param price a double, not negative 
	 * @param year an int, not negative
	 * @param accidentCoverage a double, not negative
	 */
	public Soat(double price,int year,double accidentCoverage ) {
		super(price, year);
		this.accidentCoverage=accidentCoverage;
		int i=0;
		int j=0;
		for(;i<4;i++)
		{
			setCode(getCode()+Integer.toString(getImg()[i][j]));
		}
		i--;
		for(j=1; j<4;j++)
		{
			setCode(getCode()+Integer.toString(getImg()[i][j]));
		}
				 	 
	}
	/**
	 * Soat
	 * constructor method. instances the class  Soat
	 * @param price a double, not negative 
	 * @param year an int, not negative
	 * @param code a String, not null nor empty
	 * @param accidentCoverage a double, not negative
	 */
	public Soat(double price,int year, String code, double accidentCoverage ) {
		super(price, year,code);
		this.accidentCoverage=accidentCoverage;
	}

	/**
	 * getAccidentCoverage
	 * returns the accident coverage amount of the Soat
	 * @return a double
	 */
	public double getAccidentCoverage() {
		return accidentCoverage;
	}

	/**
	 * setAccidentCoverage
	 * sets the accident coverage amount of the Soat
	 * @param accidentCoverage a double, not negative
	 */
	public void setAccidentCoverage(double accidentCoverage) {
		this.accidentCoverage = accidentCoverage;
	}
}
