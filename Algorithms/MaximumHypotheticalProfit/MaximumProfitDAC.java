import java.util.Random;

public class MaximumProfitDAC
{
	// A wrapper
	public static int maximumProfit(int[] array) 
	{
		return maxProfit(array,0,array.length)[0];
	}	
	
	// Takes 3 parameters:
	// The array
	// The start
	// The end
	// With the start and the end describing which section of the array to search
	// start included, end excluded
	// Returns an array with 3 elements:
	// The first containing the maximum profit of the array
	// The second containing the minimum value of the array
	// The third containing the maximum value of the array
	private static int[] maxProfit(int[] array, int start, int end) 
	{
		if(end - start == 1)
			return new int[] {0,array[start],array[start]};
		
		int mid = (start + end)/2;
		int[] left = maxProfit(array,start,mid);
		int[] right = maxProfit(array,mid,end);
		
		int combCase = right[2] - left[1];
		int subResult = left[0] > right[0] ? left[0] : right[0];
		int profit = Math.max(combCase, subResult);
		
		int min = Math.min(left[1], right[1]);
		int max = Math.max(left[2], right[2]);
		
		return new int[] {profit,min,max}; 
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