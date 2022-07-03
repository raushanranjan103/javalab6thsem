import java.util.*;

public class driver {
	public static void main(String[] args ) {
		
		Scanner sc = new Scanner(System.in);
		String authName , title , publisher;
		double price;
		boolean flag;
		
		// part a
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("C++" , "Balaguruswamy" , "macmillan" , 576.76));
		books.add(new Book("Java" , "Schildt" , "McGrawhill" , 773.03));
		books.add(new Book("DBMS" , "Stallings" , "Cengage" , 125.76));
		books.add(new Book("Design Patterns" , "Shallowy" , "Wiley" , 813.17));
		books.add(new Book("Head First Java" , "Kathy Sierra" , "O'Reilly Media;" , 900));
		
		// part b
		Iterator<Book> itb = books.iterator();
		System.out.println("Unsorted Books details\n");
		while(itb.hasNext())
			itb.next().details();
		
		ArrayList<Book> sortedBooks = new ArrayList<Book>(books);
		Collections.sort(sortedBooks , new priceComparator());
		
		itb = sortedBooks.iterator();
		System.out.println("Sorted Books details\n");
		while(itb.hasNext())
			itb.next().details();
		
		HashMap<String , Book> books_with_ids = new HashMap<String, Book>();
		itb = sortedBooks.iterator();
		
		while(itb.hasNext()) {
			Book b = itb.next();
			books_with_ids.put(b.toString(), b);
		}
		
		System.out.println("Books with Unique Id.\n");	
		for(Map.Entry<String, Book> entry : books_with_ids.entrySet()) {
			System.out.println("Unique Book Id : " + entry.getKey());
			entry.getValue().details();
		}
		
		// part c
		System.out.print("Enter the name of Author : ");
		authName = sc.nextLine();
		
		flag = false;
		for(Book b : books)
			if(b.author.equals(authName)) {
				flag = true;
				b.details();
			}
		
		if(!flag)
			System.out.println("Book with the author name " + authName + " not found.");
		
		System.out.print("Enter the price : ");
		price = sc.nextDouble();
		sc.nextLine();
		
		ArrayList<Book> highPricedBook = new ArrayList<Book>();
		for(Book b : books)
			if(b.price > price) {
				highPricedBook.add(b);
			}
		
		for(Book b : highPricedBook)
			b.details();
		
		// part d
		flag = false;
		System.out.print("Enter the title/partial title of the book : ");
		title = sc.nextLine();
		
		for(Book b : books)
			if(b.title.contains(title)) {
				b.details();
				flag = true;
			}
		
		if(!flag)
			System.out.println("Book with the title " + title + " not found.");
		
		// part e
		flag = false;
		System.out.print("Enter the name of the publisher : ");
		publisher = sc.nextLine();
		for(Book b : books)
			if(b.publisher.equals(publisher)) {
				b.details();
				flag = true;
			}
		
		if(!flag)	
			System.out.println("Book with the specified publisher " + publisher + " not found.");
		
		System.out.print("Enter the title of the book to update its publisher : ");
		title = sc.nextLine();
		for(Book b : books)
			if(b.title.contains(title)) {
				flag = true;
				System.out.print("Enter the new Publisher name : ");
				b.publisher = sc.nextLine();
				b.details();
				break;
			}
		
		if(!flag)
			System.out.println("Book with the title " + title + " not found.");
		
		sc.close();
	}
}