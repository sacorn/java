package hw02;

abstract class Item {
	int publishedYear, quantity = 0;
	double price = 0.0;
	String title = "";
	
	//constructor
	public Item(int publishedYear, int quantity, double price, String title) {
		this.publishedYear = publishedYear;
		this.quantity = quantity;
		this.price = price;
		this.title = title;
		
	}
	//returns published year
	public int getPublishedYear() {
		return this.publishedYear;
	}
	//returns quantity
	public int getQuantity() {
		return this.quantity;
	}
	//returns price
	public double getPrice() {
		return this.price;
	}
	//returns title
	public String getTitle() {
		return this.title;
	}
	//sets published year
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	//sets quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	//sets price
	public void setPrice(double price) {
		this.price = price;
	}
	//sets title
	public void setTitle(String title) {
		this.title = title;
	}
	//protected abstract String getAuthorLastName();

}
