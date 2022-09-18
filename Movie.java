package Project;

public class Movie extends Media implements Comparable<Movie> {

	private String rating;

	public Movie() 
	{

	}

	public Movie(String title, int copiesAvailable, String rating)
	{
		super(title, copiesAvailable);
		this.rating = rating;

	}
	
	public String getRating() 
	{
		return rating;
	}

	public void setRating(String rating) 
	{
		this.rating = rating;
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString()
	{
		return super.toString() + "    Rating -> " + getRating() ;
	}



}
