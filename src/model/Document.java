package model;
import java.util.Random;
public class Document {

	//attributes
	
	private double price;
	private int year;
	private int[][] img;
	private String code;
	
	//methods
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int[][] getImg() {
		return img;
	}

	public void setImg(int[][] img) {
		this.img = img;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
