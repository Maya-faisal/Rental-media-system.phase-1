package Project;
import java.io.*;

public class Driver {

	static MediaRental test = new MediaRental();
	

	public static void testAddingCustomers(String customerName, String address, String plan)
	{
	     test.addCustomer(customerName, address, plan);
	}

	public static void testAddingMedia(String title, int copiesAva, String rating , String artist, int weight , String songs) 
	{
		if( artist == null && songs == null && weight == 0)
		{
			test.addMovie(title, copiesAva, rating);
		}
		
		else if( weight == 0 && rating == null)
		{
			test.addAlbum(title, copiesAva, artist, songs);
		}
		
		else if(artist == null && rating == null && songs == null)
		{
			test.addGame(title, copiesAva, weight);
		}
		
		else
		{
			throw new RuntimeException("CHECK THE INFORMATION !");
		}
	}

	public static void testingAddingToCart(String customerName, String mediaTitle) throws IOException
	{
		FileWriter output = new FileWriter(new File("output.txt"),true);
		PrintWriter out = new PrintWriter(output);
		
		out.println(test.addToCart(customerName, mediaTitle));
		
		out.close();
	}

	public static void testingRemovingFromCart(String customerName, String mediaTitle) throws IOException 
	{
		FileWriter output = new FileWriter(new File("output.txt"),true);
		PrintWriter out = new PrintWriter(output);
		
		out.println(test.removeFromCart(customerName, mediaTitle));
		
		out.close();
	}

	public static void testProcessingRequestsOne() throws IOException 
	{
		FileWriter output = new FileWriter(new File("rented.txt"),true);
		PrintWriter out = new PrintWriter(output);
		
		out.println(test.processRequests());
		
		out.close();
	}

	public static void testProcessingRequestsTwo() throws IOException 
	{
		FileWriter output = new FileWriter(new File("rented.txt"),true);
		PrintWriter out = new PrintWriter(output);
		
		out.println(test.processRequests());
		
		out.close();
	}

	public static void testReturnMedia(String customerName, String mediaTitle) throws IOException 
	{
		FileWriter output = new FileWriter(new File("output.txt"),true);
		PrintWriter out = new PrintWriter(output);
		
		out.println(test.returnMedia(customerName, mediaTitle));
		
		out.close();
	}

	public static void testSearchMedia(String title, String rating, String artist, String songs) throws IOException 
	{
		FileWriter output = new FileWriter(new File("output.txt"),true);
		PrintWriter out = new PrintWriter(output);
		
		out.println(test.SearchMedia(title, rating, artist, songs));
		
		out.close();
	}
	
	private static void getcustomers() throws IOException
	{
		FileWriter output = new FileWriter(new File("customers.txt"),true);
		PrintWriter out = new PrintWriter(output);
		
		out.println(test.getAllCustomersInfo());
		
		out.close();
	}
	
	private static void getMedia() throws IOException
	{
		FileWriter output = new FileWriter(new File("media.txt"),true);
		PrintWriter out = new PrintWriter(output);
		
		out.println(test.getAllMediaInfo());
		
		out.close();
	}
	
	public static void main(String[] args) throws IOException 
	{
	    testAddingCustomers("Maya","Ramallah","LIMITED");
	    testAddingCustomers("Lara","Ramallah","UNLIMITED");
	    
	    testAddingMedia("Movie1",1,"HR",null,0,null);
	    testAddingMedia("Movie2",3,"HR",null,0,null);
	    testAddingMedia("Album1",3,null,"Artist1",0,"Song1,Song2");
	    testAddingMedia("Game1",2,null,null,20,null);
	 
	    getMedia();
	    
	    testingAddingToCart("Maya","Movie1");
	    testingAddingToCart("Lara","Game1");
	    
	    testProcessingRequestsOne();
	    
	    testingRemovingFromCart("Maya","Movie1");
	    testingAddingToCart("Lara","Album1");
	  
	    testProcessingRequestsTwo();
	    
	    testReturnMedia("Maya","Movie1");
	    
	    getcustomers();
	    
	    testSearchMedia(null,null,null,null);
	    testSearchMedia(null,null,null,"Song2");
		
	   
	}
}
