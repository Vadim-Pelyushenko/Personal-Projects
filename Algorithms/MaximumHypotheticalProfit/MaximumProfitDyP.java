import java.util.Random;

public class MaximumProfitDyP
{
	
	public static int maximumProfit(int[] array) 
	{
		if(array.length < 2)
			return 0;
		
		int maxProfit = 0;
		int maxValue = array[array.length - 1];
		
		for(int i = array.length - 2; i >= 0; i--) 
		{
			if(array[i] > maxValue) 
			{
				maxValue = array[i];
				continue;
			}
			
			int temp = maxValue - array[i];
			if(temp > maxProfit)
				maxProfit = temp;
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) 
	{
		Random rand = new Random();
		// Testing out the code
		int[] prices = new int[20];
		for(int i = 0; i < 20; i++)
			prices[i] = rand.nextInt(100) + 1;
		System.out.println("Stock prices over the past 20 days: ");
		for(int price : prices)
			System.out.println(price);
		
		int result = maximumProfit(prices);
		System.out.println("The most money you could have made based on the historic data: " + result);
	}
}
