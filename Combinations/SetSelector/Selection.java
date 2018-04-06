import java.util.HashMap;
import java.util.NoSuchElementException;

public class Selection<T>
{
	int totalItems;
	HashMap<T,Integer> sel;
	
	public Selection(T[] objects, int[] quantities)
	{
		int totalNonZero = 0;
		for(int i = 0; i < quantities.length; i++) 
			if(quantities[i] != 0)
				totalNonZero++;
		sel = new HashMap<T,Integer>(totalNonZero);
		for(int i = 0; i < quantities.length; i++) 
		{
			sel.put(objects[i], quantities[i]);
			totalItems += quantities[i];
		}			
	}
	
	public int getQuantity(T item) 
	{
		return sel.get(item);
	}
	
	public void take(T item) 
	{
		if(!sel.containsKey(item))
			throw new NoSuchElementException();
		int val = sel.get(item);
		if(val == 1)
			sel.remove(item);
		else
			sel.put(item, val - 1);
	}
	
	public void take(T item, int n) 
	{
		
	}
}