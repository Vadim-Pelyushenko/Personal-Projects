import java.util.Iterator;
import java.util.NoSuchElementException;

public class SetSelector<T> implements Iterable<Selection<T>>
{
	T[] vals;
	int[] quant;
	int total;

	/**
	 * A Set Selector takes in a set of unique objects, along with the quantities of each object. So one could have for
	 * instance, Red balls and Green balls, with there being 3 Red balls and 7 Green balls.
	 * 
	 * @param objects
	 *            the set of unique objects
	 * @param quantities
	 *            an array that corresponds to the quantity of each object
	 */
	public SetSelector(T[] objects, int[] quantities)
	{
		this.vals = objects;
		this.quant = quantities;
		total = 1;
		for (int i = 0; i < quant.length; i++)
			total *= (quant[i] + 1);
	}

	// This returns an iterator that iterates through all the possible selections from the set
	// of elements. All the possible ways that you could select from 3 red, and 2 blue balls for
	// instance is: [0,0] [0,1] [0,2] [1,0] [1,1] [1,2] [2,0] [2,1] [2,2] [3,0] [3,1] [3,2]
	// where each index represents the quantities of each object.
	@Override
	public Iterator<Selection<T>> iterator()
	{
		return new SetSelectorIterator();
	}

	class SetSelectorIterator implements Iterator<Selection<T>>
	{
		int current = 0;
		int[] quanIter;

		public SetSelectorIterator()
		{
			quanIter = new int[quant.length];
		}

		@Override
		public boolean hasNext()
		{
			return current != total;
		}

		@Override
		public Selection<T> next()
		{
			if (!hasNext())
				throw new NoSuchElementException();
			Selection<T> result = new Selection<T>(vals,quanIter);
			for (int i = 0; i < quanIter.length; i++)
			{
				if (quanIter[i] == quant[i])
					quanIter[i] = 0;
				else
				{
					quanIter[i]++;
					break;
				}
			}
			current++;
			return result;
		}
	}
}
