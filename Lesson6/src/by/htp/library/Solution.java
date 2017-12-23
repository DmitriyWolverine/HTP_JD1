package by.htp.library;

public class Solution {

	public static void main(String[] args) {
		//1 Create class library, contains array filled with books
		Library lb = new Library(10);

		lb.printBooks();
		//2 Implement method "add book
		lb.addBook(new Book(1867,"The War and peace","L.N.Tolstoy",1500));
		lb.addBook(new Book(1867,"Another Book","Unknown author",150));
		lb.addBook(new Book(1977,"The War and peace","L.N.Tolstoy",430));
		lb.addBook(new Book(2017,"The War and something","L.N.Tolstoy",430));
		lb.addBook(new Book(1867,"The War and peace","L.N.Tolstoy",1500));
		lb.addBook(new Book(2017,"The War and something","L.N.Tolstoy",430));
		lb.addBook(new Book(1867,"The War and peace","L.N.Tolstoy",1500));
		lb.addBook(new Book(1867,"The War and peace","L.N.Tolstoy",1500));
		lb.addBook(new Book(1867,"The War and peace","L.N.Tolstoy",1500));
		System.out.println("");
		//3 Find oldest book
		System.out.println(lb.getOldest());
		lb.printBooks();
		System.out.println("");
		//4 Sort books by year
		lb.sortBooksByYear();
		lb.printBooks();
		System.out.println("");
		//5 Find books written in one year
		for(Book b: lb.getBooksInYear(1867)) {
			System.out.println(b);
		}
		System.out.println("");
		//6 Find books written by one author
		for(Book b: lb.getBooksByAuthor("L.N.Tolstoy")) {
			System.out.println(b);
		}
		System.out.println("");
		//7 Find books written by one author and with the same title
		for(Book b: lb.getBooksByAuthorAndByTitle("L.N.Tolstoy","The War and peace")) {
			System.out.println(b);
		}
		System.out.println("");
		//8 Remove all books with chosen characteristics 
		lb.removeAllBooks(new Book(1867,"Another Book","Unknown author",150));
		lb.printBooks();
		System.out.println("");
		//9 Print all identical books(copies) and their number
		lb.showNumberOfIdenticalBooks();
		System.out.println("");
		//10 sort by title and by author and then by title
		lb.sortBooksByTitle();
		lb.printBooks();
		System.out.println("");
		lb.sortBooksByAuthorAndTitle();
		lb.printBooks();
		System.out.println("");
		//11 Print all books written by chosen author and during one period of time
		for(Book b: lb.findBooksByAuthorDuringPeriod("L.N.Tolstoy",1800,2018) ){
			System.out.println(b);
		}
		System.out.println("");
	}

}
