import java.util.Iterator;

public class SampleUsage
{
	public static void main(String[] args) 
	{
		Coin[] c = new Coin[3];
		c[0] = new Coin('P');
		c[1] = new Coin('N');
		c[2] = new Coin('Q');		
		int[] quantities = {5,7,3};
		
		System.out.println("Here are all the ways you can combine 5 Pennies, 7 Nickels, and 3 Quarters to get different dollar amounts!\n");
		SetSelector<Coin> select = new SetSelector<Coin>(c,quantities);
		Iterator<Selection<Coin>> iter = select.iterator();
		while(iter.hasNext()) 
		{
			Selection<Coin> sel = iter.next();
			int totalValue = 0;
			int[] quan = new int[3];
			for(int i = 0; i < c.length; i++) 
			{
				quan[i] = sel.getQuantity(c[i]);
				totalValue += quan[i]*c[i].value();
			}
			int dollar = totalValue / 100;
			int cents = totalValue % 100;
			System.out.printf("%d Pennies, %d Nickels, %d Quarters = $%d.%02d\n",quan[0],quan[1],quan[2],dollar,cents);
		}
	}
	
	private static class Coin
	{
		char type;
		
		private Coin(char type)
		{
			this.type = type;
		}
		
		private int value() 
		{
			switch(type) 
			{
				case 'P':
					return 1;
				case 'N':
					return 5;
				case 'Q':
					return 25;
				default:
					return 0;
			}
		}
	}
}
