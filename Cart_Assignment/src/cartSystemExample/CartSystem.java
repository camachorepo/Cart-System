package cartSystemExample;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class CartSystem extends TheSystem{
    public CartSystem() throws FileNotFoundException {
    	
    	
    	
    }
    public void display() {
     HashMap <String, Item> cart = new HashMap<String,Item>(this.getItemCollection()); 
     

     if(cart.isEmpty()) {
    	 System.out.println("Sub Total: 0.0 ");
    	 System.out.println("Tax: 0.0 ");
    	 System.out.println("Total: 0.0");
    	 
     }
     else {
         for(Item item : cart.values()) {
         	 
        	double price = item.getQuantity()*item.getItemPrice(); 
        	price = Double.parseDouble(String.format("%.2f", price));
         	double tax = price * .05;
         	tax = Double.parseDouble(String.format("%.2f", tax));
         	double total = tax + price;
         	total = Double.parseDouble(String.format("%.2f", total));
         	System.out.println(item.getItemName());
         	System.out.println(" subtotal: " + price);
         	System.out.println(" Tax: "+ tax);
         	System.out.println(" Item Total: " + total);
         	
         }
     }
    }
}
