package Project;

public abstract class Media {

	protected String title;
	protected int copiesAvailable;

	public Media()
	{

	}

	public Media(String title, int copiesAvailable)
	{

		this.title = title;
		this.copiesAvailable = copiesAvailable;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public int getCopiesAvailable()
	{
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable)
	{
		this.copiesAvailable = copiesAvailable;
	}
	
	public String toString()
	{
		return "    Title -> " + getTitle() + "    Copies Available -> " + getCopiesAvailable();
	}
	
	// public abstract boolean equals(Object x);

}
