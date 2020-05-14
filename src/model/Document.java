package model;
import java.util.Random;
public class Document {

	//attributes
	
	private double price;
	private int year;
	private int[][] img;
	private String code;
	
	//methods
	/**
	 * Document
	 * constructor method. instances the class Document
	 * @param price a double, not negative
	 * @param year an int, not negative
	 */
	public Document(double price,int year) {
		this.price=price;
		this.year=year;
		Random rand= new Random();
		img = new int[4][4];
		for (int i=0; i<4; i++)
		{
			for(int j=0; j<4;j++)
			{
				img[i][j]= rand.nextInt(100);
			}
		}
		code="";
	}

	/**
	 * Document 
	 * constructor method. instances the class Document
	 * @param price a double, not negative
	 * @param year an int, not negative
	 * @param code a String, not empty nor null
	 */
	public Document(double price,int year, String code) {
		this.price=price;
		this.year=year;
		this.code=code;
	}
	
	/**
	 * getPrice
	 * returns the price of the document
	 * @return a double
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * setPrice
	 * sets the price of the document
	 * @param price a double, positive
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * getYear
	 * returns the year of the expiration of the Document
	 * @return an int
	 */
	public int getYear() {
		return year;
	}

	/**
	 * setYear
	 * sets the year of the expiration of the Document
	 * @param year an int, not negative
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * getImg
	 * returns the image of the Document
	 * @return an int[][]
	 */
	public int[][] getImg() {
		return img;
	}

	/**
	 * setImg
	 * sets the image of the Document
	 * @param img an int[][] not empty nor null
	 */
	public void setImg(int[][] img) {
		this.img = img;
	}

	/**
	 * getCode
	 * returns the code of the Document
	 * @return a String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * setCode
	 * sets the code of the Document
	 * @param code a String
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
