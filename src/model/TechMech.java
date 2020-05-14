package model;

public class TechMech extends Document{

	//attributes
	
	private double gasLevel;
	
	//methods
	/**
	 * TechMech
	 * constructor method. instances the class TechMech
	 * @param price a double, not negative 
	 * @param year an int, not negative
	 * @param gasLevel a double, positive
	 */
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
		}
		
		/**
		 * TechMech
		 * @param price a double, not negative 
		 * @param year an int, not negative
		 * @param code a String, not Empty nor null
		 * @param gasLevel a double, positive
		 */
		public TechMech(double price,int year, String code, double gasLevel ) {
			super(price, year,code);
			this.gasLevel=gasLevel;		
		}

		/**
		 * gasLevel
		 * returns the gas level results in the Technical Mechanical revision
		 * @return a double
		 */
		public double getGasLevel() {
			return gasLevel;
		}

		/**
		 * setGasLevel
		 * sets the gas level results in the Technical Mechanical revision
		 * @param gasLevel a double, positive
		 */
		public void setGasLevel(double gasLevel) {
			this.gasLevel = gasLevel;
		}
}
