package by.htp.state;

public class Locality {
	private String name;
	private City[] cities;
	private int populationInLocality;
	private double square;
	
	public Locality() {
		int number = 1 + (int) (Math.random() *4);
		cities = new City[number];
		for(int i = 0 ; i < cities.length ; ++i) {
			cities[i] = new City();
		}
		int temp= 100_000;
		name = getBiggestCity().getName();
		name +=" locality";
		populationInLocality = countPopualtionInLocality();
		square = 50_000 + Math.random() * temp;
	}

	public Locality(int numberOfCities) {
		if(numberOfCities<0)
		{
			return;
		}
		cities = new City[numberOfCities];
		for(int i = 0 ; i < cities.length ; ++i) {
			cities[i] = new City();
		}
		int temp = 100_000;
		for(int i = 0 ; i < cities.length ; ++i) {
			if( cities[i].getPopualtion() > temp) {
				name = cities[i].getName();
			}
		}
		name +=" locality";
		populationInLocality = countPopualtionInLocality();
		square = 50_000 + Math.random() * 100_000;
	}
	
	public Locality( String name, City[] cities, double square) {
		if(cities == null || cities.length == 0 || name.equals("") )
		{
			return;
		}
		this.name = name;
		this.cities = cities;
		populationInLocality = countPopualtionInLocality();
		this.square = square;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City[] getCities() {
		return cities;
	}

	public void setCities(City[] cities) {
		this.cities = cities;
	}
	
	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public City getBiggestCity() {
		int temp = 100_000;
		City biggest = cities[0];
		for(int i = 0 ; i < cities.length ; ++i) {
			if( cities[i].getPopualtion() > temp) {
				biggest = cities[i];
			}
		}
		return biggest;
	}

	public int getPopulationInLocality() {
		return populationInLocality;
	}
	
	private int countPopualtionInLocality () {
		int resultInSum = 0;
		for(City city: cities) {
			resultInSum += city.getPopualtion();
		}
		return resultInSum;
	}
}
