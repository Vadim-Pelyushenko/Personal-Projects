import java.util.Random;
import java.util.Scanner;

public class HardProblems
{
	// The randomly generated problem will always ask you to use
	// a,b,b,c to make the value a*b
	// The answer will always be in the form a/(b-c/b)
	// a is a randomly generated value, as is b, but c is equal to b*b - 1
	public static void main(String[] args) 
	{
		Random rand = new Random();
		int a = rand.nextInt(8) + 3;
		int b = rand.nextInt(8) + 3;
		int c = b*b-1;
		int d = a*b;
		System.out.printf("Try to make an expression that evaluates to %d using (%d,%d,%d,%d)\n",d,a,b,b,c);
		System.out.println("You must use each of the four numbers once");
		System.out.println("You can add, substract, multiply, or divide to reach the result");
		System.out.println("Enter any key to see the answer");
		(new Scanner(System.in)).nextLine();
		System.out.printf("The answer is: %d/(%d-(%d/%d))",a,b,c,b);
	}
}
