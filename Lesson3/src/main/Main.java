package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1. Заполнить массив размером 100 элементов случайными числами
		int firstIntArray[] = initializeIntArrayByRandomPositiveValues(100);
		
		// 2. Вывести из массива (задание 1) все чётные элементы на экран
		int numberOfEven = getEvenNumber(firstIntArray);
		System.out.println("2)\tEven elements from the array :");
		printEven(firstIntArray);
		
		// 3. Посчитать разность всех нечётных элементов массива
		System.out.println("3)\tTotal difference of odd elements :");
		System.out.println(differenceOddElements(firstIntArray));
		
		// 4. Посчитать количество чётных и нечётных элементов в массиве,
		//    кол-во чётных и нечётных вывести на экран
		int numberOfOdd = firstIntArray.length - numberOfEven;
		System.out.println("4)\tNumber of odd elements :"+numberOfOdd+"\nNumber of even elements :"+numberOfEven );
		
		// 5. Найти и вывести на экран максимальный / минимальный элемент
		System.out.println("5)\tMax :"+getMax(firstIntArray)+"\nMin :"+getMin(firstIntArray) );
		
		// 6. Найти максимальный и минимальный элемент среди чётных/нечётных элементов
		System.out.println("6)\tMax odd :"+getMaxOdd(firstIntArray)+"\nMin odd :"+getMinOdd(firstIntArray) );
		System.out.println("\tMax even :"+getMaxEven(firstIntArray)+"\nMin even :"+getMinEven(firstIntArray) );
		
		// 7. Сохранить в массив типа char свою фамилию и имя (размер массива не должен превышать количество 
		//	    символов в фамилии пробел имени
		// 7.1 Реализовать считывание фио для задачи 7 с клавиатуры
		System.out.println("7)\tName and Surname:");
		char[] nameAndSurname = getNameAndSurname();
		printArray(nameAndSurname);
		
		// 8. Добавить в массив из задания 7 пробел и отчество
		System.out.println("8)\tName, Surname and Second name:");
		printArray(getNameSurnameAndSecondName(nameAndSurname));
		
		// 9. Удалить из массива (1е задание) все элементы, кратные 3
		// 9.1 Привести размер массива из задания 9 в соответствие с реальным количеством хранимых элементов
		System.out.println("9)\tArray without values divisible by 3 :");
		int[] workingArray = deleteElementDivisibleByThree(firstIntArray);
		printArray(workingArray);
		
		// 10. Отсортировать массив по возрастанию / убыванию следующими способами 
		// пузырьком, вставками, выбором, Быстрая сортировка
		System.out.println("10\tRequired sort array methods...");
		int[] arrayForBubbles = initializeIntArrayByRandomPositiveValues(50);
		System.out.println("\nSorted by bubbles method: ");
		printArray(arrayForBubbles);
		sortByBubbles(arrayForBubbles);
		printArray(arrayForBubbles);
		
		System.out.println("\n=============================");
		
		int[] arrayForSelection = initializeIntArrayByRandomPositiveValues(50);
		System.out.println("\nSorted by selection method: ");
		printArray(arrayForSelection);
		sortBySelect(arrayForSelection);
		printArray(arrayForSelection);
		
		System.out.println("\n=============================");
		
		int[] arrayForInsertion = initializeIntArrayByRandomPositiveValues(50);
		System.out.println("\nSorted by insertion method: ");
		printArray(arrayForInsertion);
		sortByInserts(arrayForInsertion);
		printArray(arrayForInsertion);
		
		System.out.println("\n=============================");
		
		int[] arrayForQuicksort = initializeIntArrayByRandomPositiveValues(50);
		System.out.println("\nSorted by quick sort: ");
		printArray(arrayForQuicksort);
		sortByQuickSort(arrayForQuicksort, 0, arrayForQuicksort.length-1);
		printArray(arrayForQuicksort);
		
		System.out.println("\n=============================");
		
		// 11. Найти в массиве и вывести на экран все элементы в заданном диапазоне (например от 20 до 23)
		System.out.println("11)\tNumbers between two values: ");
		printAllElementsBetweenTwoValues(firstIntArray);
		
	}
	
	private static void printAllElementsBetweenTwoValues(int[] array ) {
		
		int firstValue = enterPositiveIntegerValue();
		int secondValue = enterPositiveIntegerValue();
		
		if(firstValue>= secondValue ) {
			for(int i = 0 ; i < array.length ; ++i) {
				if(  (array[i]<=firstValue) && (array[i]>=secondValue) ) {
					System.out.print(array[i]+ " ");
				}
			}
		}
		else {
			for(int i = 0 ; i < array.length ; ++i) {
				if(  (array[i]<=secondValue) && (array[i]>=firstValue)  ) {
					System.out.print(array[i]+ " ");
				}
			}
		}
		System.out.print("\n");
	}
	
	private static void sortByBubbles(int[] array) {
		for( int i = 0 ; i< array.length - 1; i++ ) {
			for( int j = i+1; j < array.length ; j++) {
				if(array[i]>= array[j]) {
					swap(array, i, j);
				}
			}
		}
	}
	
	private static void sortBySelect(int[] array) {
		for( int i = 0 ; i < array.length - 1 ; i++ ) {
			int localMaxInd = i;
		
			for( int j = localMaxInd + 1; j < array.length ; j++) {
				
				if( array[j]>= array[localMaxInd] ) {
					localMaxInd = j;
				}
			}
			swap(array, i, localMaxInd);
		}
	}
	
	private static void sortByInserts(int[] array) {
		int temp;
		int curInd;
		for( int i = 1 ; i<array.length; i++ ) {
			temp = array[i];
			curInd = i;
			while( (curInd > 0) && (array[curInd-1]>temp) ) {
				array[curInd] = array [ curInd - 1];
				curInd--;
			}
			array[curInd] = temp;
			
		}
	}
	
    private static void sortByQuickSort(int [] array ,int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
            	swap(array,i,j);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        sortByQuickSort(array,start, cur);
        sortByQuickSort(array,cur+1, end);
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
	
	private static void printEven(int[]arr) {
		int evenNumber = 0;
		for( int i = 0 ; i < arr.length ; ++i) {
			if( (arr[i]&1) != 1) {
				
				System.out.print(arr[i]+"\t");
				evenNumber++;
				if(evenNumber%10==0 )
				{
					System.out.print("\n");
				}
			}
		}
		System.out.print("\n");
	}
	
	private static int differenceOddElements(int[]arr) {
		int totalEvenDifference = 0;
		for( int i = 0 ; i < arr.length ; ++i) {
			if( (arr[i]&1) == 1) {
				totalEvenDifference -= arr[i];
			}
		}
		return totalEvenDifference;
	}
	
	private static int getEvenNumber(int[]arr) {
		int evenNumber = 0;
		for( int i = 0 ; i < arr.length ; ++i) {
			if( (arr[i]&1) != 1) {
				evenNumber++;
			}
		}
		return evenNumber;
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

	private static int getMin(int[]arr) {
		int min = arr[0] ; 
		for( int i = 0 ; i < arr.length ; ++i) {
			if (arr[i] <= min ) {
				min = arr[i];
			}
		}
		return min;
	}
	
	private static int getMinEven( int [] arr ) {
		int minEven = 99 ; 
		for( int i = 0 ; i < arr.length ; ++i) {
			if ( ( (arr[i]&1) != 1) && (arr[i] <= minEven) )
				minEven = arr[i];
		}
		return minEven;
	}
	
	private static int getMaxEven ( int [] arr ) {
		int maxEven = 0 ; 
		for( int i = 0 ; i < arr.length ; ++i) {
			if ( ( (arr[i]&1) != 1) && (arr[i] >= maxEven) )
				maxEven = arr[i];
		}
		return maxEven;
	}
	private static int getMaxOdd(int[]arr) {
		int maxOdd = 0 ; 
		for( int i = 0 ; i < arr.length ; ++i) {
			if ( ( (arr[i]&1) == 1) && (arr[i] >= maxOdd) )
				maxOdd = arr[i];
		}
		return maxOdd;
	}
	
	private static int getMinOdd(int[]arr) {
		int minOdd = 99 ; 
		for( int i = 0 ; i < arr.length ; ++i) {
			if ( ( (arr[i]&1) == 1) && (arr[i] <= minOdd) )
				minOdd = arr[i];
		}
		return minOdd;
	}
	
	
	private static char[] getNameAndSurname() {
		System.out.println("Enter your name, press 'space' and enter last name: " );
		String userName = enterString();
		char[] fullName = new char[userName.length()];
		initCharArrayByString(userName, fullName );
		return fullName;
	}
	
	private static char[] getNameSurnameAndSecondName( char[] nameAndSurname) {
		System.out.println("Enter your second name" );
		String secondName = enterString();
		char[] fullNameWithSecondName = new char[nameAndSurname.length + secondName.length() + 1];
		int temp=0;
		for  (int i = 0 ; i < fullNameWithSecondName.length; ++i ) {
			if(i < nameAndSurname.length ) {
				fullNameWithSecondName[i] = nameAndSurname[i];
			}
			else if (i == nameAndSurname.length ) {
				fullNameWithSecondName[i]=' ';
			}
			else {
				if(temp < secondName.length() )
				{
					fullNameWithSecondName[i] = secondName.charAt(temp);
					temp++;
				}
			}
		}
		return fullNameWithSecondName;
	}
	
	private static int[] deleteElementDivisibleByThree(int[] previousArr) {
		int extraElemetns = 0;
		for( int i = 0 ; i < previousArr.length; ++i) {
			if( previousArr[i]%3 == 0) {
				extraElemetns++;
			}
		}
		int[] newArray = new int[ previousArr.length - extraElemetns];
		int iterArray = 0;
		for( int i = 0 ; i < previousArr.length; ++i) {
			if( previousArr[i] % 3 != 0) {
				newArray[iterArray] = previousArr[i];
				iterArray++;
			}
		}
		return newArray;
	}
	
	
	private static void printArray(int []x) {
		for( int i = 0 ; i < x.length; ++i) {
			System.out.print(x[i]+ " ");
			if((i+1)%50==0 ) {
				System.out.println("");
			}
		}
		System.out.println();
	}
	
	private static void printArray(char []x) {
		for( int i = 0 ; i < x.length; ++i) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

	
	private static void initCharArrayByString(String str, char[] charArr) {
		for( int i = 0 ; i < charArr.length; ++i) {
			charArr[i] = str.charAt(i);
		}
	}
	
	private static String enterString() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	private static void swap (int[] array, int i , int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static int enterPositiveIntegerValue() {
		Scanner scanner = new Scanner(System.in);
		int value = -1;
		do {
            if ( scanner.hasNextInt() )
            {
                if ( (value = scanner.nextInt())  <= 0)
                {
                    System.out.println("Enter Number above zero!");

                }
                else
                {
                    System.out.println("You have entered " + value);
                }
            }
            else
            {
                System.out.println("Please, enter integer number: ");
                scanner.next();
            }
        }
        while( value <= 0 );
		return value;

	}
}

	
