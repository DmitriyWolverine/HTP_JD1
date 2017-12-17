package by.htp.univer;

public class MainApp {

	public static void main(String[] args) {
		Student [] students = new Student[17];
		for( int i = 0 ; i < students.length; ++i) {
			students[i] = new Student();
		}
		Group group = new Group(students);
		group.showAllStudents();
		System.out.println("Average age is: "+group.calculateAverageAge());
		int choseYear = 2005;
		System.out.println("There are "+group.calculateStudentsFromYear(choseYear) + " in "+choseYear);
		group.findYearWithMaximumNumberOfStudents();
	}
}
