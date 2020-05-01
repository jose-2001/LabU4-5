package model;

public class Soat extends Document{
	
	//attributes
	
	private double accidentCoverage;

	
	//methods
	public Soat(double price,int year,double accidentCoverage ) {
		super(price, year);
		this.accidentCoverage=accidentCoverage;
		int i=0;
		int j=0;
		for(;i<4;i++)
		{
			setCode(getCode()+Integer.toString(getImg()[i][j]));
		}
		for(j=1; j<4;j++)
		{
			setCode(getCode()+Integer.toString(getImg()[i][j]));
		}
		// setCode(Integer.toString(getImg()[0][0])+Integer.toString(getImg()[1][0])+Integer.toString(getImg()[2][0])+Integer.toString(getImg()[3][0])+Integer.toString(getImg()[3][1])+Integer.toString(getImg()[3][2])+Integer.toString(getImg()[3][3]));		 
		 
	}


	public double getAccidentCoverage() {
		return accidentCoverage;
	}


	public void setAccidentCoverage(double accidentCoverage) {
		this.accidentCoverage = accidentCoverage;
	}
}
