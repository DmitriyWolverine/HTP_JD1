package by.htp.state;

public class Region {
	private String name;
	private Locality [] localities;
	private int populationInRegion;
	private double squareOfRegion;
	
	public Region() {
		int numberOfLocalities = 1 + (int)( Math.random() * 4);
		localities = new Locality[numberOfLocalities];
		for(int i = 0 ; i< numberOfLocalities; ++i) {
			localities[i] = new Locality();
			squareOfRegion += localities[i].getSquare();
		}
		name = getBiggestCityInRegion().getName() + " region";
		populationInRegion = countPopualtionInRegion();
	}

	public Region(int numberOfLocalities) {
		if(numberOfLocalities <0)
		{
			return;
		}
		
		localities = new Locality[numberOfLocalities];
		for(int i = 0 ; i< numberOfLocalities; ++i) {
			localities[i] = new Locality();
			squareOfRegion += localities[i].getSquare();
		}
		name = getBiggestCityInRegion().getName() + " region";
		populationInRegion = countPopualtionInRegion();
	}

	public Region(String name, Locality[] localities) {
		if(localities == null || localities.length == 0 || name.equals("") )
		{
			return;
		}
		this.name = name;
		this.localities = localities;
		for(int i = 0 ; i< localities.length; ++i) {
			squareOfRegion += localities[i].getSquare();
		}
		populationInRegion = countPopualtionInRegion();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Locality[] getLocalities() {
		return localities;
	}

	public void setLocalities(Locality[] localities) {
		this.localities = localities;
	}
	
	public double getSquareOfRegion() {
		return squareOfRegion;
	}

	public void setSquareOfRegion(double squareOfRegion) {
		this.squareOfRegion = squareOfRegion;
	}

	public City getBiggestCityInRegion() {
		City biggest = localities[0].getBiggestCity();
		for(int i = 0 ; i < localities.length ; ++i) {
			if( localities[i].getBiggestCity().getPopualtion() > biggest.getPopualtion()) {
				biggest = localities[i].getBiggestCity();
			}
		}
		return biggest;
	}
	
	public int getPopulationInRegion() {
		return populationInRegion;
	}
	
	private int countPopualtionInRegion () {
		int resultInSum = 0;
		for(Locality l: localities) {
			resultInSum += l.getPopulationInLocality();
		}
		return resultInSum;
	}
}
