package Project;

import java.util.*;

public class Customer {

	private String name;
	private String address;
	private String plan;
	private ArrayList<String> CustomerInterests = new ArrayList<>();
	private ArrayList<String> RentedMedia = new ArrayList<>();

	public Customer() 
	{

	}

	public Customer(String name, String address, String plan, ArrayList<String> customerInterests,
			ArrayList<String> rentedMedia)
	{

		this.name = name;
		this.address = address;
		this.plan = plan;
		CustomerInterests = customerInterests;
		RentedMedia = rentedMedia;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPlan()
	{
		return plan;
	}

	public void setPlan(String plan) 
	{
		this.plan = plan;
	}

	public ArrayList<String> getCustomerInterests() 
	{
		return CustomerInterests;
	}

	public void setCustomerInterests(ArrayList<String> customerInterests)
	{
		CustomerInterests = customerInterests;
	}

	public ArrayList<String> getRentedMedia() 
	{
		return RentedMedia;
	}

	public void setRentedMedia(ArrayList<String> rentedMedia)
	{
		RentedMedia = rentedMedia;
	}

}
