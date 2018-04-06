import java.security.InvalidParameterException;
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
		if(!sel.containsKey(item))
			return 0;
		return sel.get(item);
	}
	
	public boolean contains(T item) 
	{
		return sel.containsKey(item);
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
		if(!sel.containsKey(item))
			throw new NoSuchElementException();
		int val = sel.get(item);
		if(val < n)
			throw new InvalidParameterException("There are less items than you are trying to take");
		if(val == n)
			sel.remove(item);
		else
			sel.put(item, val - n);
	}
	
	public void add(T item) 
	{
		if(sel.containsKey(item))
			sel.put(item, sel.get(item) + 1);
		else
			sel.put(item, 1);
	}
	
	public void add(T item, int n) 
	{
		if(sel.containsKey(item))
			sel.put(item, sel.get(item) + n);
		else
			sel.put(item, n);
	}
}
