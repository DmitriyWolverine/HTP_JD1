package by.htp.univer;

import java.util.HashMap;
import java.util.Map;

public class Group {
	
	private int number = 1;
	private Student [] students;
	private int numberOfStudents;
	
	public Group() {
		numberOfStudents = 5;
		students = new Student [numberOfStudents];
	}
	
	public Group(int size) {
		if(size > 15) {
			System.out.println("Imposible to study in so big group!\nSize = 15!");
		}
		numberOfStudents = 15;
		students = new Student [numberOfStudents];
	}
	
	public Group(Student [] students) {
		if( students.length > 15) {
			System.out.println("Imposible to study in so big group!\n Size = 15!");
		}
		numberOfStudents = 15;
		this.students = new Student[numberOfStudents];
		for( int i = 0 ; i< 15 ; i++) {
			this.students[i] = students[i];
		}
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public void greetNewStudent() {
		System.out.println("Hello new student");
	}
	
	public double calculateAverageAge() {
		double result= 0;
		int number = 0;
		for(Student st: students) {
			if(st!=null)
			{
				result += st.getAge();
				number++;
			}
		}
		result = result/ number;
		return result;
	}
	
	public int calculateStudentsFromYear(int year) {
		int result = 0;
		for(Student st: students) {
			if(( st!=null ) && (st.getEnterYear() == year))
			{
				result++;
			}
		}
		return result;
	}
	
	public void findYearWithMaximumNumberOfStudents() {
		Map<Integer, Integer> yearsAndNumber = new HashMap<>();
		for(Student st: students) {
			if( ( st!=null )  )
			{
				if(  yearsAndNumber.containsKey(st.getEnterYear() ) ) {
					yearsAndNumber.put(st.getEnterYear(), yearsAndNumber.get(st.getEnterYear()) + 1);
				}
				else {
					yearsAndNumber.put(st.getEnterYear(),1);
				}
			}
		}
		int maxNumber = 0;
		for(Map.Entry<Integer, Integer> pair: yearsAndNumber.entrySet()) {
			if(pair.getValue() > maxNumber) {
				maxNumber = pair.getValue();
			}
		}
		
		for(Map.Entry<Integer, Integer> pair: yearsAndNumber.entrySet()) {
			if(pair.getValue() ==  maxNumber) {
				System.out.println("The most number of students was in "+pair.getKey()+"; The were "+ pair.getValue()+" students");
			}
		}
	}
	
	public void showAllStudents() {
		if(students != null) {
			for(int i = 0 ; i < students.length ; ++i) {
				System.out.println(students[i]);
			}
		}
	}
	
}
