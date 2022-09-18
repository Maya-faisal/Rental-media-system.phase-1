package Project;

public class Game extends Media implements Comparable<Game> {

	private double weight;

	public Game() 
	{

	}

	public Game(String title, int copiesAvailable, double weight)
	{
		super(title, copiesAvailable);
		this.weight = weight;

	}
	public Game(String title)
	{
		this.title = title;
	}
	
	public double getWeight() 
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	@Override
	public int compareTo(Game o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String toString()
	{
		return  super.toString() + "    weight ->" + getWeight() ;
	}
}
