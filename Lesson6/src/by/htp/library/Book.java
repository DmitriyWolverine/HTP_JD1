package by.htp.library;

public class Book {
	private int year;
	private String title;
	private String author;
	private int numberOfPages;
	
	private static int numberOfBook = 1;
	
	public Book() {
		super();
		year = (int) (Math.random() * 2018) ;
		title = "Title" + numberOfBook;
		author = "Author"+ numberOfBook;
		numberOfPages = 100 + (int) (Math.random() * 800);
		numberOfBook++;
	}
	
	public Book(int year) {
		this();
		this.year = year;
	}
	
	public Book(int year, int numberOfPAges) {
		this();
		this.numberOfPages = numberOfPAges;
		this.year = year;
	}
	
	public Book(int year, String title, String author, int numberOfPAges) {
		super();
		this.year = year;
		this.title = title;
		this.author = author;
		this.numberOfPages = numberOfPAges;
		numberOfBook++;
	}
	
	public Book ( Book book) {
		this.year = book.getYear();
		this.title = book.getTitle();
		this.author = book.getAuthor();
		this.numberOfPages = book.getNumberOfPages();
	}
	
	public Book cloneBook() {
		return new Book(this);
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPAges) {
		this.numberOfPages = numberOfPAges;
	}
	public int compareTitle(Book book) {
		return title.compareTo(book.getTitle());
	}
	public int compareAuthor(Book book) {
		return author.compareTo(book.getAuthor());
	}
	
	@Override
	public String toString() {
		return ("Title: "+title+ "; Author: "+ author +  "; Number Of pages: "+numberOfPages+ "; Year: "+ year) ;
	}
}