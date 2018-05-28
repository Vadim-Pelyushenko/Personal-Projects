import java.util.Random;

public class TestMaximumProfit
{
	public static void main(String[] args) 
	{
		int lowestPossiblePrice = 1;
		int highestPossiblePrice = 100;
		int inputSize = 20;
		
		Random rand = new Random();
		// Testing out the code
		int[] prices = new int[inputSize];
		for(int i = 0; i < inputSize; i++)
			prices[i] = rand.nextInt(highestPossiblePrice - lowestPossiblePrice + 1) + lowestPossiblePrice;
		System.out.println("Stock prices over the past " + inputSize + " days: ");
		for(int price : prices)
			System.out.println(price);
		
		long startDAC = System.nanoTime();
		int resultDAC = MaximumProfitDAC.maximumProfit(prices);
		long endDAC = System.nanoTime();
		
		long startDyP = System.nanoTime();
		int resultDyP = MaximumProfitDyP.maximumProfit(prices);
		long endDyP = System.nanoTime();
		
		System.out.println();
		System.out.println("Maximum Profit Reported By Divide and Conquer Algorithm: " + resultDAC);
		System.out.println("Runtime: " + (endDAC - startDAC) + " nanoseconds");
		System.out.println();
		System.out.println("Maximum Profit Reported By Dynamic Programming Algorithm: " + resultDyP);
		System.out.println("Runtime: " + (endDyP - startDyP) + " nanoseconds");
	}
}
