package Netflix;

public class Movie {

	private String title;
	private String rating;
	private String genre;
	private int year;
	private int score;
	
	public Movie() {
		title = "";
		rating = "";
		genre = "";
		year = 0;
		score = 0;
	}
	
	public Movie(String title, String rating, String genre, int year, int score) {
		this.title = title;
		this.rating = rating;
		this.genre = genre;
		this.year = year;
		this.score = score;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getScore() {
		return score;
	}
	
	public String toString() {
		String s = title + " - " + rating + " - " + genre + " - " + year + " - " + score;
		return s;
	}
}
