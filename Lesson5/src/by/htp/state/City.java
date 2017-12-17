package by.htp.state;

public class City {
	private String name;
	private int popualtion;
	private boolean isCapital;
	
	private static int cityCounter = 1 ;
	
	
	public City() {
		name = "SinCity"+cityCounter;
		popualtion = 100_000 + (int)(Math.random() * 200_000 );
		isCapital = false;
		cityCounter++;
	}
	
	public City(String name, int popualtion) {
		this.name = name;
		this.popualtion = popualtion;
		this.isCapital = false;
		cityCounter++;
	}
	
	public City(String name, int popualtion, boolean isCapital) {
		this.name = name;
		this.popualtion = popualtion;
		this.isCapital = isCapital;
		cityCounter++;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopualtion() {
		return popualtion;
	}
	public void setPopualtion(int popualtion) {
		this.popualtion = popualtion;
	}
	public boolean isCapital() {
		return isCapital;
	}
	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}

}
