package cartSystemExample;


import java.io.FileNotFoundException;
import java.util.HashMap;

public class AppSystem extends TheSystem {
    public AppSystem() throws FileNotFoundException {
    }
    public void display() {
        HashMap<String, Item> current = this.getItemCollection();
        int i=1;
        System.out.println("	Menu Items	");
        for(Item item : current.values()) {
        	
        	System.out.println(i + " " + item.getItemName() + " " + item.getItemDesc() + " " + item.getItemPrice() + " "+ item.getAvailableQuantity());
        	i++;
        }
        
    }
    public Boolean add(Item item) {
     
    	if(this.getItemCollection().containsKey(item.getItemName())) {
    		
    		System.out.println(item.getItemName() + " is already in the System ");
    		return false;
    	}
    	
    	else 
    	{
    		HashMap<String, Item> local = new HashMap <String, Item>();
    		local = getItemCollection(); 
    		local.put(item.getItemName(), item); 
    		this.setItemCollection(local);
    		return true;
    	}
    }
}
