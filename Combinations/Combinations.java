import java.util.Scanner;

public class Combinations
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many unique objects are there? ");
		int uniq = Integer.parseInt(scan.nextLine());
		
		int[] count = new int[uniq];
		for(int i = 0; i < uniq; i++) 
		{
			System.out.print("How many occurences of Object " + i + " are there? ");
			count[i] = Integer.parseInt(scan.nextLine());
		}
		
		long total = 1;
		for(int val : count)
			total *= (val + 1);
		System.out.println("There are " + total + " ways to select any number of objects from the set described");
	}
}
