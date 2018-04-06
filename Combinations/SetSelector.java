import java.util.Iterator;

public class SetSelector<T> implements Iterable<T[]>
{
	T[] vals;
	int[] quant;
	
	/** 
	 * @param objects
	 * @param quantities
	 */
	public SetSelector(T[] objects, int[] quantities)
	{
		this.vals = objects;
		this.quant = quantities;
	}
	
	@Override
	public Iterator<T[]> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
