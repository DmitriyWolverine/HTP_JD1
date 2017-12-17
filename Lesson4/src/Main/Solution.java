package Main;

public class Solution {

	public static void main(String[] args) {
		// 1) array divided be max value of array
		System.out.println( "Array and divide it by maximum");
		int []firstArray = initializeIntArrayByRandomPositiveValues(100);
		printArray(firstArray);
		double []doubleArray = massiveDividedByMax(firstArray);
		printArray(doubleArray);
		System.out.println( "");
		// 2) work with real numbers
		System.out.println( "Second task : sum of squares");
		double[] secondTaskArray = initializeDoubleArrayByRandomPositiveValues(20);
		System.out.println( secondTask(secondTaskArray) );
		System.out.println( "");
		// 3) swap 2 strings in a matrix
		System.out.println( "Third task: Swap 2 rows:");
		thirdTask();
		System.out.println( "");
		// 4) find maximum value in every column
		System.out.println( "fourth task: maximum in each column:");
		findMaxInEveryColumn();
		System.out.println( "");
		// 5) count how many times we can see <some elemen>
		System.out.println( "fifth task: count the direct element:");
		fifthTask(3);
		System.out.println( "");
		// 6) found numbers with  two digits and sum of them is divisible by 2
		System.out.println( "sixs task: found numbers with two digits and divisible by 2:");
		sixsTask();
	}
	
	
	
	private static int sixsTask() {
		
		int[][] array = initMatrixBySpecialWay(10,10);
		printMatr (array);
		int counter = 0 ;
		for (int i = 0 ; i < array.length ; ++i) {
			int curStringLength =  array[i].length;
			for( int j = 0 ; j < curStringLength; ++j) {
				if( (array[i][j] > 9)&& (array[i][j] <=99) ) {
					if( ( getSumOfDigits(array[i][j])&1) == 0 ) {
						System.out.print(array[i][j] + " ");
						counter++;
					}
				}
			}
		}
		System.out.println("\nWe have found "+counter+ " elements according to number 6 conditions" );
		return counter;
	}
	
	private static int getSumOfDigits (int number) {
		String numberStr = ""+number;
		int sumOfDigits = 0;
		for(int i = 0 ; i < numberStr.length() ; ++i) {
			sumOfDigits += Integer.parseInt(numberStr.charAt(i)+"");
		}
		return sumOfDigits;
	}
	
	
	
	private static int countDirectElemetn(int[][] matr, int element) {
		int counter = 0;
		
		for (int i = 0 ; i < matr.length ; ++i) {
			int curStringLength =  matr[i].length;
			for( int j = 0 ; j < curStringLength; ++j) {
				if(matr[i][j] == element) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	private static void fifthTask(int element) {
		int[][] workingArray = initMatrix(7,6);
		printMatr(workingArray);
		int answer = countDirectElemetn(workingArray, element );
		
		System.out.println("We have found "+ element + " "+ answer+" times" );
	}
	
	
	private static int[][] initMatrix ( int height, int length){
		int[][] matr = new int [height] [length];
		for(int i = 0 ; i < height ; ++i) {
			matr[i] = initializeIntArrayByRandomPositiveValues(length);
		}
		return matr;
	}
	
	
	private static int[][] initMatrixBySpecialWay ( int height, int length){
		int[][] matr = new int [height] [length];
		for(int i = 0 ; i < height ; ++i) {
			for (int j = 0 ; j <length ; ++j ) {
				matr[i][j] = (int) (Math.random() *200);
			}
		}
		return matr;
	}
	
	private static void swapTwoStrings (int[][] previousMatrix, int firstString, int secondString){
		if( (firstString>= previousMatrix.length)  || (secondString >= previousMatrix.length) ) {
			return ;
		}
		//int [][] result = new int[previousMatrix.length][previousMatrix[0].length];
		int [] tempArray = new int[previousMatrix[0].length];
		
		tempArray = previousMatrix[firstString];
		previousMatrix[firstString] = previousMatrix[secondString];
		previousMatrix[secondString] = tempArray;
	}
	
	private static void thirdTask() {
		int[][] matr = initMatrix(5,5);
		printMatr(matr);
		swapTwoStrings (matr, 1,3);
		printMatr (matr);
		
	}
	
// task 4	
	private static int[] findMaxInEveryColumn (){
		int[][] workingMatr = initMatrix(6,6);
		
		printMatr(workingMatr);
		
		int [] maximums = new int[workingMatr[0].length];
		
		for (int i = 0 ; i < workingMatr[0].length ; ++i ) {
			int temp = workingMatr[i][0];
			for( int j = 0 ; j <  workingMatr.length; ++j) {
				if( workingMatr[i][j] > temp ) {
					temp = workingMatr[i][j];
				}
			}
			maximums[i] = temp;
		}
		
		printArray(maximums);
		return maximums;
	}
	
	
	private static void printMatr(int[][] array) {
		for ( int i = 0 ; i< array.length; ++i ) {
			printArray(array[i]);
		}
	}
	
	private static double[] initializeDoubleArrayByRandomPositiveValues(int size) {
		
		if(size <= 0) {
			return null;
		}
		double array[] = new double[size];
		for( int i = 0 ; i < array.length ; ++i) {
			array[i] =  (size/2) - (Math.random() * size) ;
		}
		
		printArray(array);
		
		return array;
	}
	
	private static double[] getPositiveAndEverySecond (double[] array) {
		int newArraySize = 0;
		
		for( int i = 1 ; i < array.length; i = i+2) {
			if (array[i] > 0)   {
				newArraySize++;
			}
		}
		
		double [] resultArray = new double[newArraySize];
		int j = 0;
		for( int i = 0 ; i < array.length; ++i) {
			if( ( (i&1) == 1 ) && (array[i] > 0)  ) {
				resultArray[j] = array[i];
				j++;
			}
		}
		
		printArray(resultArray);
		
		return resultArray;
	}
	
	private static double countSquareSum(double [] array) {
		double res = 0 ;
		for( int i = 0 ; i < array.length; ++i) {
			res += (array[i] * array[i]);
		}
		return res;
	}
	
	
	private static double secondTask(double[] previousArray) {
		return countSquareSum(getPositiveAndEverySecond (previousArray));
	}
	
	
	
	
	private static int[] initializeIntArrayByRandomPositiveValues(int size) {
		
		if(size <= 0) {
			return null;
		}
		int array[] = new int[size];
		for( int i = 0 ; i < array.length ; ++i) {
			array[i] = (int) (Math.random() * size);
		}
		return array;
	}
	
	private static int getMax(int[]arr) {
		int max = arr[0];
		for( int i = 0 ; i < arr.length ; ++i) {
			if( arr[i] >= max ) {
				max = arr[i];
			}
		}
		return max;
	}
	
	private static double[] massiveDividedByMax(int[]array) {
		double[] newArray = new double [array.length];
		int max = getMax(array);
		for(int i = 0 ; i <array.length; ++i ) {
			newArray[i] = (double)array[i] / max ;
		}
		return newArray;
	}
	
	private static void printArray(int []x) {
		for( int i = 0 ; i < x.length; ++i) {
			System.out.print(x[i]+ "\t");
			if((i+1)%10==0 ) {
				System.out.println("");
			}
		}
		System.out.println();
	}
	
	private static void printArray(double []x) {
		for( int i = 0 ; i < x.length; ++i) {
			System.out.print(x[i]+ "\t");
			if((i+1)%10==0 ) {
				System.out.println("");
			}
		}
		System.out.println();
	}
}
