public class Book {
	
	String title , author , publisher ;
	double price;
	
	Book(String title , String author , String publisher , double price) { 
		this.title =  title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	void details() {
		System.out.println("Title     : " + title);
		System.out.println("Author    : " + author);
		System.out.println("Publisher : " + publisher);
		System.out.println("Price     : " + price);
		System.out.println();
	}	
}