package hw02;

public class Book extends Item implements Comparable<Item> {
	String authorName, authorLastName, publisher = "";
	int numOfPages, edition = 0;

	//constructor
	public Book(String authorName, String authorLastName, String publisher,
			int numOfPages, int edition, int publishedYear, int quantity,
			double price, String title) {
		super(publishedYear, quantity, price, title);
		this.authorName = authorName;
		this.authorLastName = authorLastName;
		this.publisher = publisher;
		this.numOfPages = numOfPages;
		this.edition = edition;
	}
	//returns author
	public String getAuthor() {
		return this.authorName;
	}
	//returns authors last name
	public String getAuthorLastName() {
		return this.authorLastName;
	}
	//returns publisher
	public String getPublisher() {
		return this.publisher;
	}
	//return number of pages of a book
	public int getNumOfPages() {
		return this.numOfPages;
	}
	//return book's edition
	public int getEdition() {
		return this.edition;
	}
	//sets authors name
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	//sets authors last name
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	//sets book's publisher
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	//set number of pages of book
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	//sets edition of book
	public void setEdition(int edition) {
		this.edition = edition;
	}
	//returns nice representation of the book display all data fields with their respective values
	public String toString() {
		return String.format("Book's Author: %s\nPublusher: %s/nEdition: %s\nNumber of Pages: %s",
				this.getAuthor(), this.getPublisher(), this.getEdition(), this.getNumOfPages());
	}
	/*@Override
	public int compareTo(Item other) {
		if(getAuthorLastName().compareTo(other.getAuthorLastName()) > 0) { // checks what comes first in last Names
			return 1;
		} else if(getAuthorLastName().compareTo(other.getAuthorLastName()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}*/
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
