package cartSystemExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TheSystem {
    private HashMap<String, Item> itemCollection = new HashMap<String, Item>();
    protected TheSystem() throws FileNotFoundException {
        itemCollection = new HashMap<String, Item>();
        if(getClass().getSimpleName().equals("AppSystem"))
        {
        	FileReader file = new FileReader("sample.txt");
        	BufferedReader br = new BufferedReader(file);
        	String temp =" "; 
        	try {
				while((temp = br.readLine()) != null ) {
					String [] data = temp.split("  ");
					Item local = new Item ();
					local.setItemName(data[0]); 
					local.setItemDesc(data[1]);
					local.setItemPrice(Double.parseDouble(data[2]));
					local.setAvailableQuantity(Integer.parseInt(data[3]));
					this.itemCollection.put(data[0], local );
				}
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Couldn't Find sample.txt file");
			}
        }
        
    }
    
    public HashMap<String, Item> getItemCollection(){
      HashMap localCollection = new HashMap <String, Item>(this.itemCollection);
      return localCollection;
    }
    
    public void setItemCollection(HashMap<String, Item> copy ){
      this.itemCollection = copy;
    }
    
    public Boolean add(Item item) {
    	if(this.itemCollection.containsKey(item.getItemName())) {
    		Integer cartQuantity = this.itemCollection.get(item.getItemName()).getQuantity();
    		if(checkAvailability(item, cartQuantity))
    		{
    			int qty = this.itemCollection.get(item.getItemName()).getQuantity() +1;
    	    	Item local = new Item();
    	    	local.setItemName(item.getItemName());
    	    	local.setItemPrice(item.getItemPrice());
    	    	local.setQuantity(qty);
		    	this.itemCollection.put(item.getItemName(), local);
    		}
    	return true;
    	}
    	Item local = new Item();
    	local.setItemName(item.getItemName());
    	local.setItemPrice(item.getItemPrice());
    	local.setQuantity(1);
    	this.itemCollection.put(item.getItemName(), local);	
    	return false;
    }
    public Item remove(String itemName) {
        Item item = null;
        
        if(this.getItemCollection().containsKey(itemName)) {
        item =	this.itemCollection.get(itemName);
        		this.itemCollection.remove(itemName);
        }
        
        return item;
    }
    public Boolean checkAvailability(Item item, Integer current) {

    	if((1 + current) > item.getAvailableQuantity())
    	{
    		System.out.println("System is unable to add "  + (current+1) + " of "+ item.getItemName());
    		System.out.println("System can only add "  + (item.getAvailableQuantity()) + " of "+  item.getItemName());
    		return false; 
    	}
    	else return true;
    }
}
