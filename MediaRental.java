package Project;

import java.util.*;

 
public class MediaRental implements MediaRentallnt {                     
	// define a class that implements the media rental interface
	
	private int MaximumLimit = 2; 
	// set the maximum limit to 2 (for limited plan)

	private ArrayList<Customer> customer_List = new ArrayList<>();      
	// create an array list that will contain the customers information
	
	private ArrayList<Media> media_List = new ArrayList<>();          
	// create an array list that will contain the media information

	private boolean Check_Plan(String plan)                        
	// method that checks the given plan if it valid or not
	
	{
		if (plan != null && (plan.equalsIgnoreCase("UNLIMITED") || plan.equalsIgnoreCase("LIMITED"))) 
		{
			return true;
		}

		else
		{
			throw new RuntimeException("INVALID PLAN , CHOOSE UNLIMITED OR LIMITED !"); 
			// if not throw an exception
		}
	}

	public void addCustomer(String name, String address, String plan) 
	// method that adds the customer to the customer list
	
	{
		if (name != null && address != null && Check_Plan(plan)) 
		  // check if the information are valid
		{

			Customer C = new Customer(); 
			// if yes create a new customer object with the given information

			C.setName(name);
			C.setAddress(address);
			C.setPlan(plan);

			customer_List.add(C); 
			// add the customer to the customers list

		}

		else 
		{
			throw new RuntimeException("No name ! , No address !"); 
			// if there is no name or no address throw an exception
		}
	}

	private boolean Check_Rating(String rating) 
	// a method to check if the rating is valid or not
	
	{
		if (rating != null&& (rating.equalsIgnoreCase("HR") || rating.equalsIgnoreCase("DR") || rating.equalsIgnoreCase("AC")))
		{
			return true;
		}

		else 
		{
			throw new RuntimeException("INVALID RATING , CHOOSE HR OR AC OR DR !");
			//if not throw an exception
		}
	}

	public void addMovie(String title, int copiesAvailable, String rating) 
	// a method to add movies
	
	{
		if (title != null && copiesAvailable >= 0 && Check_Rating(rating)) 
			//check if the information are valid
		{

			Movie M = new Movie();
			// if yes create a new movie object with the given information
			
			M.setTitle(title);
			M.setCopiesAvailable(copiesAvailable);
			M.setRating(rating);

			media_List.add(M);
			//add the movie to the media list

		}

		else
		{
			throw new RuntimeException("No title ! ,  Copies cannot be Negative !");
			// if not throw an exception
		}
	}

	public void addGame(String title, int copiesAvailable, double weight) 
	//method to add games
	
	{
		if (title != null && copiesAvailable >= 0 && weight > 0) 
			//check if there is a title and weight
		{
			Game G = new Game();
			//if yes create a new game object with the given information
			
			G.setTitle(title);
			G.setCopiesAvailable(copiesAvailable);
			G.setWeight(weight);

			media_List.add(G);
			// add the game to the media list

		}

		else 
		{
			throw new RuntimeException("No title ! , Weight Can not be Zero ! , Copies cannot be Negative !");
			// if not throw an exception
		}
	}

	public void addAlbum(String title, int copiesAvailable, String artist, String songs)
	// a method to add albums
	
	{
		if (title != null && copiesAvailable >= 0 && artist != null && songs != null)
			//check if there is a title and artist
		{

			Album A = new Album();
			//if yes create a new album object with the given information
			
			A.setTitle(title);
			A.setArtist(artist);
			A.setCopiesAvailable(copiesAvailable);

			String [] SongsArray = songs.split(",");
			ArrayList<String> S = new ArrayList<>(Arrays.asList(SongsArray));
			A.setSongs(S);

			media_List.add(A);
			// add the album to the media

		}

		else
		{
			throw new RuntimeException("No titel ! , No Artist Name ! , Copies cannot be Negative ! , No songs !");
			//if not throw an exception
		}
	}

	public void setLimitedPlanLimit(int value) 
	// method to set the maximum limit for the limited plan
	
	{
		this.MaximumLimit = value;
		//change the original limit to the given value
	}

	
	private void sort_customers ()
	// a method to sort the customers according to their names
	
	{
		Collections.sort(customer_List, new Comparator<Customer>()
				// sort the customer list in alphabetical order
				{
					public int compare(Customer C1, Customer C2) 
					{
						String cus1 = C1.getName();
						String cus2 = C2.getName();
						return cus1.compareToIgnoreCase(cus2);
					}

				});

	}
	
	
	public String getAllCustomersInfo()
	// method to print the customers list
	
	{
	    sort_customers();
	    // call the method that sorts the customers list according to their names

		String C_Info = "";
		// String for each customer info
		
		String Each_Info = "";
		// String that will contain the whole customers info

		for (int i = 0; i < customer_List.size(); i++) 
		// loop to get each customer info
			
		{
			Each_Info =  "    Name->    "      + customer_List.get(i).getName().toString() +
					     "    Address-> "      + customer_List.get(i).getAddress().toString() +
					     "    Plan->    "      + customer_List.get(i).getPlan().toString() +
					     "    Rented Media-> " + customer_List.get(i).getRentedMedia().toString() +
					     "    interests-> "    + customer_List.get(i).getCustomerInterests().toString();
			
			// get the name , address ,  plan, interests , and rented list  for the customer number i 
			
			C_Info += Each_Info + "\n";
		
		}

		return C_Info;
	}

	private void sort_Media()
	// a method to sort the media according to the titles
	
	{
		Collections.sort(media_List, new Comparator<Media>()
				// sort the media list according to the titles
						
				{

					@Override
					public int compare(Media M1, Media M2) 
					{

						String med1 = M1.getTitle();
						String med2 = M2.getTitle();
						return med1.compareToIgnoreCase(med2);
					}

				});
	}
	
	
	public String getAllMediaInfo()
		// method to print the media info
	{
		
	    sort_Media();
	    //call the method to sort the media list
	    
	    String Each_Info = "";
	    // create a string the will contain each media info
	    
	    String M_Info = "";
	    // create a string that will contain the whole media list information
	    
	    for(int i = 0 ; i < media_List.size() ; i++)
	    {
	    	Each_Info = media_List.get(i).toString();
	    	// call the toString method according to the type of the media i (game , album , movie)
	    	
	    	M_Info += Each_Info + "\n";
	    }

	    return M_Info;
		
	}

	
	public boolean addToCart(String customerName, String mediaTitle)
	// method for adding media to the customer cart (list of interests)
	
	{
		Customer addTo_customer = null;
		// create a new customer object with initial value null
		
		boolean done = false;

		for (int i = 0 ; i < customer_List.size() ; i++)
			// a loop to find the specified customer 
			
		{
			if (customer_List.get(i).getName().equalsIgnoreCase(customerName)) 
		
			{
				addTo_customer = customer_List.get(i);
				// get the specified customer information
				
				break;
				// if the customer is found break the loop
			}
			
		}

		ArrayList<String> added_customer_cart = addTo_customer.getCustomerInterests();
		// create an array list that contains the specified customer interests

		for(int j = 0  ; j < media_List.size() ; j++)
		{
			if(media_List.get(j).getTitle().equalsIgnoreCase(mediaTitle))
				// check if this media title exists
				
			{
				if (!added_customer_cart.contains(mediaTitle) && Check_Copies(mediaTitle))
					// check if the customer already have the media or not
					
				{
					added_customer_cart.add(mediaTitle);
					// add the title to customer interests
					
					done = true;
					//return true
					
				}

				else 
				{
					done = false;
					// if the customer already have the media return false
				}
			}
		}
		

		return done;
	}

	public boolean removeFromCart(String customerName, String mediaTitle) 
	// method to remove media from the customer cart (interests)
	
	{
		Customer removeFrom_customer = null;
		// create a new customer object with initial value null
		
		boolean done = false;

		for (int i = 0; i < customer_List.size(); i++) 
			//search for the customer in the customer list
			
		{
			if (customer_List.get(i).getName().equalsIgnoreCase(customerName))
			{
				removeFrom_customer = customer_List.get(i);
				// if the customer is found give the created object its information
				
				break;
			}
			
		}

				ArrayList<String> removed_customer_cart = removeFrom_customer.getCustomerInterests();
				// create a new array List that contains the interests of the specified customer
				
				if (removed_customer_cart.contains(mediaTitle) && !removed_customer_cart.isEmpty() && edit_Copies(mediaTitle))
					// check if the list of interest of the customer contains the media
				{
					removed_customer_cart.remove(mediaTitle);
					// remove the title from the customer interests
					
					done = true;
					//return true
				}

				else 
				{
					done = false;
					// else return false
				}
				
		return done;

	}

	private boolean Check_Copies(String mediatitle) 
	// method to check if there is copies or not
	
	{
		boolean ThereIsCopy = false;
		Media Wanted = null;

		for (int i = 0; i < media_List.size(); i++) 
			// a loop to find the specified media information
			
		{
			if (media_List.get(i).getTitle().equalsIgnoreCase(mediatitle)) 
			{
				Wanted = media_List.get(i);
				break;
				// if media is founded break the loop
			}
			
		}

		if (Wanted.getCopiesAvailable() > 0) 
		{
			ThereIsCopy = true;
			// return true to show that there is copies
			
			Wanted.setCopiesAvailable(Wanted.getCopiesAvailable() - 1);
			// adjust the number of copies for the specified media
		}

		else 
		{
			ThereIsCopy = false;
			// return false if there is no copies
		}

		return ThereIsCopy;
	}

	
	private boolean edit_Copies(String mediaTitle) 
	// method to edit the number of copies after renting a media
	
	{
		boolean edit = false;

		for (int i = 0; i < media_List.size(); i++) 
			
		{
			if (media_List.get(i).getTitle().equalsIgnoreCase(mediaTitle))
				// search for the media in the media list
		
			{
				media_List.get(i).setCopiesAvailable((media_List.get(i).getCopiesAvailable()) + 1);
				// adjust the number of copies
				
				edit = true;
			}
			
		}

		return edit;
	}

	public String processRequests()
	// method to print the processing message
	
	{
		sort_customers();
	
		String FullProcessingMessage = "Processing Message : " + "\n";
		// String the will contain the whole processing message

		for (int i = 0; i < customer_List.size(); i++)
		{
			String plan = customer_List.get(i).getPlan();
			// get the plan for the customer i
			
			ArrayList<String> interests = customer_List.get(i).getCustomerInterests();
			// get the list of interest of customer i
			
			ArrayList<String> rented = customer_List.get(i).getRentedMedia();
			// get the rented media list for customer i

			if (!interests.isEmpty()) 
				// check if the interests is empty or nor
			{
				for (int j = 0; j < interests.size(); j++) 
				{
					if (plan.equalsIgnoreCase("LIMITED")) 
						// check the kind of plan for the customer i
					{
						if (rented.size() == MaximumLimit) 
						{
							break;
							// if the customer exceed the limit break 
						}

						else if (rented.size() < MaximumLimit) 
							// if the customer did'nt exceed the limit
							
						{
							if(!rented.contains(interests.get(j)))
							{
							
								rented.add(interests.get(j));
								// add the interest j  to the rented media list of the customer i
									
								FullProcessingMessage += "Sending [" + interests.get(j) + "]" + 
									                      "to [" + customer_List.get(i).getName().toString() + "]" + "\n";
							}
						}
					}

					else if (plan.equalsIgnoreCase("UNLIMITED"))
						// check the plan for customer i
						
					{
						if(!rented.contains(interests.get(j)))
						{
							
							rented.add(interests.get(j));
							//add the interest j to the rented media list of customer i
								
							FullProcessingMessage += "Sending [" + interests.get(j) + "]" + 
								                     "to [" + customer_List.get(i).getName().toString() + "]" + "\n";
						}
					}
				}
			}

		}

		return FullProcessingMessage;
	}

	
	public boolean returnMedia(String customerName, String mediaTitle) 
	// method to return a specified media
	
	{
		boolean Return = false;

		for (int i = 0; i < customer_List.size(); i++) 
		{
			if (customer_List.get(i).getName().equalsIgnoreCase(customerName))
			{
				ArrayList<String> rented = customer_List.get(i).getRentedMedia();
				// get the rented media list of the specified customer
				

				if (rented.contains(mediaTitle)) 
					// check if the customer have the media
				{
					rented.remove(mediaTitle);
					edit_Copies(mediaTitle);
					Return = true;
					
					// if yes remove the media , edit the number of copies and return true to show that the media is returned
				}

				else 
				{
					Return = false;
					// return false if the customer does'nt have the media
				}
			}
		}

		return Return;
	}
	

	public ArrayList<String> SearchMedia(String title , String rating , String artist , String songs )
	// method to search for specific media
	
	{
		
         ArrayList<String> titles = new ArrayList<>();
         // he array list that will contain the titles result
         
         
         if( title == null && rating == null && artist == null && songs == null)
        	 // if all parameters return all titles in the media list
        	 
         {
        	 for(int j = 0 ; j < media_List.size() ; j++)
        		 // get all the titles and add them to the titles list
        		 
        	 {
        		 titles.add(media_List.get(j).getTitle());
        	 }
         }
         
         
			else 
			{
				
				for (int i = 0; i < media_List.size(); i++) 
					//check from what kind is the object i
				{
					if (media_List.get(i) instanceof Album)
						// if the object i is an album cast it an get the needed information
						
					{
						Album x = (Album) media_List.get(i);

						if (x.getTitle().equalsIgnoreCase(title) || x.getArtist().equalsIgnoreCase(artist))
							// check the title and artist
							
						{
							titles.add(x.getTitle());
							//if they are the same add the title to the return list
						}
						
							for(int k =0 ; k < x.getSongs().size() ; k++)
								// check if the song exists
							{
								if(x.getSongs().get(k).equalsIgnoreCase(songs))
									
								{
									titles.add(x.getTitle());
									//if yes add the title to the return list
								}
							}
						
					}

					else if (media_List.get(i) instanceof Movie)
						// if the object i is a movie cast it an get the needed information
					{
						Movie x = (Movie) media_List.get(i);

						if (x.getTitle().equalsIgnoreCase(title) || x.getRating().equalsIgnoreCase(rating)) 
							// check the rating or title according to which one is given
						{
							titles.add(x.getTitle());
						}

					}

					else if (media_List.get(i) instanceof Game)
						// if the object i is a game cast it an get the needed information
					{
						Game x = (Game) media_List.get(i);

						if (x.getTitle().equalsIgnoreCase(title)) 
						{
							titles.add(x.getTitle());
						}

					}
				}

			}
         
         Collections.sort(titles);
         // sort the return list
      
 		return titles;
   } 
	
}
