package model;

public class TechMech extends Document{

	//attributes
	
	private double gasLevel;
	
	//methods
		public TechMech (double price,int year,double gasLevel ) {
			super(price, year);
			this.gasLevel=gasLevel;
			int i=0;
			int j=0;
			for(j=0;j<4;j++)
			{
				setCode(getCode()+Integer.toString(getImg()[i][j]));
			}
			i=1;
			for(j=2; j>=0;j--)
			{				
				setCode(getCode()+Integer.toString(getImg()[i][j]));
				i++;
			}
			i=3;
			for(j=0;j<4;j++)
			{
				setCode(getCode()+Integer.toString(getImg()[i][j]));
			}
			 //setCode(Integer.toString(getImg()[0][0])+Integer.toString(getImg()[1][0])+Integer.toString(getImg()[2][0])+Integer.toString(getImg()[3][0])+Integer.toString(getImg()[3][1])+Integer.toString(getImg()[3][2])+Integer.toString(getImg()[3][3]));		 
			 
		}
		

		public double getGasLevel() {
			return gasLevel;
		}

		public void setGasLevel(double gasLevel) {
			this.gasLevel = gasLevel;
		}
}
