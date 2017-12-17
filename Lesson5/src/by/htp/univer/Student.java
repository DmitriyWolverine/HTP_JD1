package by.htp.univer;

public class Student {
	
	private int age;
	private String name;
	private String surname;
	private int enterYear;
	public static int index = 1;
	
	public Student() {
		age =  ( 20 +  (int)( Math.random() * 5) );
		name = "Student_" + index;
		surname = "Studentovich_" + index;
		enterYear = ( 2000 +  (int)( Math.random() * 16) );
		index++;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getEnterYear() {
		return enterYear;
	}
	public void setEnterYear(int enterYear) {
		this.enterYear = enterYear;
	}

	@Override
	public String toString() {
		String result = name + " " + surname + " "+age+ " years old, started studying in "+enterYear;
		return result;
	}

}
