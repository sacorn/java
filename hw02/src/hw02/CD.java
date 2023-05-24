package hw02;

public class CD extends Item implements Comparable<Item>{
	String artistName, artistLastName = "";
	int yearOfRelease = 0;
	
	//constructor
	public CD(String artistName, String artistLastName, int yearOfRelease,
			int publishedYear, int quantity, double price, String title) {
		super(publishedYear, quantity, price, title);
		this.artistName = artistName;
		this.artistLastName = artistLastName;
		this.yearOfRelease = yearOfRelease;
	}
	//returns artist first name
	public String getArtistName() {
		return this.artistName;
	}
	//returns artist's last name
	public String getArtistLastName() {
		return this.artistLastName;
	}
	//returns year CD was released
	public int getYearOfRelease() {
		return this.yearOfRelease;
	}
	//sets name of artist
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	//sets last name of artist
	public void setArtistLastName(String artistLastName) {
		this.artistLastName = artistLastName;
	}
	//sets year CD was released
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	//returns CD info
	public String toString() {
		return String.format("Artist's First Name: %s\nArtist's Last Name: %s\nYear of Release: %s",
				this.getArtistName(), this.getArtistLastName(), this.getYearOfRelease());
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
