package by.htp.state;

public class State {
	private int totalPopulation;
	private City capital;
	private String name;
	private Region[] regions;
	private static int counter = 1;
	private double totalSquare;

	public State() {
		name = "Empire_"+counter;
		counter++;
		int numberOfRegions = 1 + (int)( Math.random() * 4);
		regions = new Region[numberOfRegions];
		
		for(int i = 0 ; i < regions.length ; ++i) {
			regions[i] = new Region();
			totalPopulation += regions[i].getPopulationInRegion(); 
			totalSquare += regions[i].getSquareOfRegion();
		}
		capital = regions[0].getBiggestCityInRegion();
		for(int i = 0 ; i < regions.length ; ++i) {
			if(regions[i].getBiggestCityInRegion().getPopualtion() > capital.getPopualtion() ) {
				capital = regions[i].getBiggestCityInRegion();
			}
		}
		capital.setPopualtion(capital.getPopualtion()*10);
		capital.setCapital(true);
	}
	
	public State(String name) {
		super();
		this.name = name;
		int numberOfRegions = 1 + (int)( Math.random() * 4);
		regions = new Region[numberOfRegions];
		
		for(int i = 0 ; i < regions.length ; ++i) {
			regions[i] = new Region();
			totalPopulation += regions[i].getPopulationInRegion(); 
			totalSquare += regions[i].getSquareOfRegion();
		}
		capital = regions[0].getBiggestCityInRegion();
		for(int i = 0 ; i < regions.length ; ++i) {
			if(regions[i].getBiggestCityInRegion().getPopualtion() > capital.getPopualtion() ) {
				capital = regions[i].getBiggestCityInRegion();
			}
		}
		capital.setPopualtion(capital.getPopualtion()*10);
		capital.setCapital(true);
		counter++;
	}

	public State(City capital, String name) {
		super();
		capital.setPopualtion(capital.getPopualtion()*10);
		capital.setCapital(true);
		this.capital = capital;
		this.name = name;
		counter++;
		int numberOfRegions = 1 + (int)( Math.random() * 4);
		regions = new Region[numberOfRegions];
		
		for(int i = 0 ; i < regions.length ; ++i) {
			regions[i] = new Region();
			totalPopulation += regions[i].getPopulationInRegion(); 
			totalSquare += regions[i].getSquareOfRegion();
		}
		counter++;
	}

	public State(int totatlPopulation, City capital, String name, Region[] regions) {
		this.totalPopulation = totatlPopulation;
		this.capital = capital;
		this.name = name;
		this.regions = regions;
		for(int i = 0 ; i < regions.length ; ++i) {
			totalSquare += regions[i].getSquareOfRegion();
		}
		counter++;
	}
	
	private String regionCentresToString() {
		StringBuilder builder = new StringBuilder();
		for( int i = 0 ; i < regions.length ; ++i) {
			if( i ==  (regions.length - 1) ) {
				builder.append( regions[i].getBiggestCityInRegion().getName());
				break;
			}
			builder.append( regions[i].getBiggestCityInRegion().getName()+" ");
		}
		return builder.toString();
	}

	@Override
	public String toString() {
		String result = "Welcom to "+ name + "!!!\n" +"The capital is : "+ capital.getName() +
				" and there are "+ capital.getPopualtion()+" people live there\n"+
				"Total population is: "+ totalPopulation +" in "+ regions.length+" regions!\n"+
				"Total square is : "+ totalSquare+" aquare kilometres\n"+
				"Main cities in regions are: "+ regionCentresToString();
		return result;
	}
}
