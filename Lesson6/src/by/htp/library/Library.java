package by.htp.library;

public class Library {
	private String name = "Library";
	private String address = "Nezalezhnosti 101";
	private Book[] books;
	private int number;

	public Library() {
		super();
		number = 1;
		books = new Book[number];
		for(int i = 0 ; i < number ; ++i) {
			books[i] = new Book();
		}
	}
	
	public Library( int number) {
		super();
		this.number = number;
		books = new Book[number];
		for(int i = 0 ; i < number ; ++i) {
			books[i] = new Book();
		}
	}
	
	public Library(String name, String address, int number) {
		super();
		this.number = number;
		this.name = name;
		this.address = address;
		books = new Book[number];
		for(int i = 0 ; i < number ; ++i) {
			books[i] = new Book();
		}
	}
	
	public Library(String name, String address, Book[] books) {
		super();
		this.name = name;
		this.address = address;
		this.books = books;
	}
	
	private void copyBooks(Book[] firstArray, Book [] secondArray) {
		for( int i = 0 ; (i < firstArray.length) && (i< secondArray.length) ; ++i )
		{
			firstArray[i] = secondArray[i].cloneBook();
		}
	}
	private void copyBooksSkipInd(Book[] firstArray, Book [] secondArray, int skipInd) {
		int j = 0;
		for( int i = 0 ; (j < firstArray.length) && (i< secondArray.length) ; ++i )
		{
			if(i == skipInd) {
				continue;
			}
			firstArray[j] = secondArray[i].cloneBook();
			j++;
		}
	}
	
	
	//2
	public void addBook(Book newBook) {
		if(newBook == null) {
			return;
		}
		number++;
		Book [] newArray = new Book[number];
		copyBooks(newArray, books);
		newArray[newArray.length-1] = newBook;
		books = newArray;
	}
	//3
	public Book getOldest() {
		if( books.length < 1)
		{
			System.out.println("Empty library");
			return null;
		}
		int currentYear = 2018;
		Book oldest = null;
		for( int i = 0 ; i < books.length ; ++i) {
			if ( books[i].getYear() < currentYear ) {
				currentYear = books[i].getYear();
				oldest = books[i];
			}
		}
		return oldest;
	}
	//4
	public void sortBooksByYear() {
		sortBooksByYear(books);
	}
	
	
	//5
	public Book[] getBooksInYear(int year) {
		int newSize = 0;
		for(int i = 0 ; i < books.length; ++i) {
			if(books[i].getYear() == year) {
				newSize++;
			}
		}
		Book [] result = new Book[newSize];
		int j = 0;
		for(int i = 0 ; i < books.length; ++i) {
			if(books[i].getYear() == year) {
				result[j] = books[i];
				j++;
			}
		}
		return result;
	}
	
	//6
	public Book[] getBooksByAuthor(String authorName) {
		int newSize = 0;
		for(int i = 0 ; i < books.length; ++i) {
			if(books[i].getAuthor().equals(authorName)) {
				newSize++;
			}
		}
		Book [] result = new Book[newSize];
		int j = 0;
		for(int i = 0 ; i < books.length; ++i) {
			if(books[i].getAuthor().equals(authorName)) {
				result[j] = books[i];
				j++;
			}
		}
		return result;
	}
	//7
	public Book[] getBooksByAuthorAndByTitle(String authorName, String title) {
		int newSize = 0;
		for(int i = 0 ; i < books.length; ++i) {
			if(books[i].getAuthor().equals(authorName) && books[i].getTitle().equals(title)) {
				newSize++;
			}
		}
		Book [] result = new Book[newSize];
		int j = 0;
		for(int i = 0 ; i < books.length; ++i) {
			if(books[i].getAuthor().equals(authorName) && books[i].getTitle().equals(title)) {
				result[j] = books[i];
				j++;
			}
		}
		return result;
	}
	//8
	public int removeOneBook(Book removeBook) {
		for ( int i = 0 ; i< books.length ; ++i) {
			if(books[i].getAuthor().equals(removeBook.getAuthor()) &&
					books[i].getTitle().equals(removeBook.getTitle()) &&
					books[i].getYear() == removeBook.getYear()  &&
					books[i].getNumberOfPages() == removeBook.getNumberOfPages() )
			{
				number--;
				Book[] newArr = new Book[number];
				copyBooksSkipInd(newArr,books,i);
				books = newArr;
				return 1;
			}
		}
		return -1;
	}
	
	public void removeAllBooks(Book removeBook) {
		int value = 1;
		do {
			value = removeOneBook (removeBook);
		}
		while(value>0);
	}
	
	//9
	public void showNumberOfIdenticalBooks() {
		int[] array = new int[books.length];
		Book [] temp = new Book[books.length];
		copyBooks(temp, books);
		for(int i = 0 ; i < books.length ; ++i) {
			for(int j = i + 1 ; j < books.length ; ++j) {
				if(temp[i]!=null && temp[j]!=null && 
						temp[i].getAuthor().equals(temp[j].getAuthor()) &&
						temp[i].getTitle().equals(temp[j].getTitle()) &&
						temp[i].getYear() == temp[j].getYear()  &&
								temp[i].getNumberOfPages() == temp[j].getNumberOfPages()) {
					array[i]++;
					temp[j]=null;
				}
			}
		}
		for(int i = 0 ; i < books.length ; ++i) {
			if(array[i]>=1) {
				System.out.println(books[i].getTitle()+", "+books[i].getAuthor()+", "
						+books[i].getYear()+ " number of the same books is "+ (array[i]+1));
			}
		}
	}
	//10
	public void sortBooksByTitle() {
		for( int i = 0 ; i < (books.length - 1); i++ ) {
			int localMaxInd = i;
		
			for( int j = localMaxInd + 1; j < books.length ; j++) {
				
				if( books[j].compareTitle(books[localMaxInd]) < 0) {
					localMaxInd = j;
				}
			}
			swap(books, i, localMaxInd);
		}	
	}
	
	public void sortBooksByAuthorAndTitle (){
		for( int i = 0 ; i < (books.length - 1); i++ ) {
			int localMaxInd = i;
		
			for( int j = localMaxInd + 1; j < books.length ; j++) {
				
				if( books[j].compareAuthor(books[localMaxInd]) < 0) {
					localMaxInd = j;
				}
				else if( books[j].compareAuthor(books[localMaxInd]) ==  0) {
					if( books[j].compareTitle(books[localMaxInd]) < 0) {
						localMaxInd = j;
					}
				}
			}
			swap(books, i, localMaxInd);
		}	
	}
	
	//11
	public Book[] findBooksByAuthorDuringPeriod(String author, int firstYear, int secondYear) {
		Book[] res;
		int size = 0;
		for(int i = 0 ; i < books.length ; i++ ) {
			if( books[i].getAuthor().equals(author) && books[i].getYear()>=firstYear && books[i].getYear() <= secondYear) {
				size++;
			}
		}
		if(size ==0) {
			return null;
		}
		res = new Book[size];
		int j = 0 ;
		for(int i = 0 ; i < books.length ; i++ ) {
			if( books[i].getAuthor().equals(author) && books[i].getYear()>=firstYear && books[i].getYear() <= secondYear) {
				res[j] = books[i];
				j++;
			}
		}
		sortBooksByAuthorAndYear(res);
		return res;
	}
	
	private void sortBooksByYear(Book[] arr) {
		for( int i = 0 ; i < (arr.length - 1); i++ ) {
			int localMaxInd = i;
			for( int j = localMaxInd + 1; j < arr.length ; j++) {
				if( arr[j].getYear()<arr[localMaxInd].getYear() ) {
					localMaxInd = j;
				}
			}
			swap(arr, i, localMaxInd);
		}	
	}
	
	private void sortBooksByAuthorAndYear(Book[] arr) {
		for( int i = 0 ; i < (arr.length - 1); i++ ) {
			int localMaxInd = i;
		
			for( int j = localMaxInd + 1; j < arr.length ; j++) {
				
				if( arr[j].compareAuthor(arr[localMaxInd]) < 0) {
					localMaxInd = j;
				}
				else if( arr[j].compareAuthor(arr[localMaxInd]) ==  0) {
					if( arr[j].getYear()<arr[localMaxInd].getYear() ) {
						localMaxInd = j;
					}
				}
			}
			swap(arr, i, localMaxInd);
		}	
	}
	
	
	private static void swap (Book[] array, int i, int j) {
		Book temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void printBooks() {
		for (int i = 0 ; i < books.length ; ++i) {
			System.out.println(books[i]);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}