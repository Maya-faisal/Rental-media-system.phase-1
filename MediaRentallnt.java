package Project;
import java.util.*;

public interface MediaRentallnt 

{

	void addCustomer(String name , String address , String plan);
	void addMovie(String title , int copiesAvailable , String rating);
	void addGame(String title , int copiesAvaliable , double weight);
	void addAlbum(String title , int copiesAvaliable , String Artist , String songs);
	void setLimitedPlanLimit(int value);
	String getAllCustomersInfo();
	String getAllMediaInfo();
	boolean addToCart(String customerName , String mediaTitle);
	boolean removeFromCart(String customerName , String mediaTitle);
    String processRequests();
	boolean returnMedia(String customerName , String mediaTitle);
	ArrayList<String> SearchMedia(String title , String rating , String artist , String songs);
	
}
