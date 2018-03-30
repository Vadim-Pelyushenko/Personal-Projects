import java.util.Scanner;

public class Power_Reduction
{	
	public static void calculateNextCoefficients(int[] coeffs, int n) 
	{
		// Even powered reduction...
		if(n % 2 == 0) 
		{
			// Account for reflection
			coeffs[0] = coeffs[1];
			for(int i = 1; i <= n; i += 2) 
			{
				coeffs[i-1] += coeffs[i];
				coeffs[i+1] += coeffs[i];
				coeffs[i] = 0;
			}
		}
		else 
		{
			// Avoid trying to reflect what is not represented
			coeffs[1] = coeffs[0];
			coeffs[0] = 0;
			for(int i = 2; i <= n; i+= 2) 
			{
				coeffs[i-1] += coeffs[i];
				coeffs[i+1] += coeffs[i];
				coeffs[i] = 0;
			}
		}
	}
	
	public static void printFormula(int[] coeffs, int n) 
	{
		int div = (int) Math.pow(2, n - 1);
		
		int start = coeffs[0] == 0 ? 3 : 2;
		if(start == 2) 
			System.out.print(new Fraction(coeffs[0],div * 2));
		else
			System.out.printf("%scos(x)", new Fraction(coeffs[1],div));
		
		for(int i = start; i <= n; i += 2) 
			System.out.printf(" + %scos(%dx)", new Fraction(coeffs[i],div), i);
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("This program will generate the power reduction formulas for cos^n(x)");
		System.out.println("Up to what value of n would you like to generate?");
		int n = Integer.parseInt(scan.nextLine());
		
		// Keeps track of only half the coefficients in the original table, because it is reflected
		int[] coeffs = new int[n+1];
		coeffs[0] = 0;
		coeffs[1] = 1;
		for(int i = 2; i <= n; i++) 
		{
			calculateNextCoefficients(coeffs,i);
//			printList(coeffs);
			printFormula(coeffs,i);
		}
	}
	
	// For debugging
	private static void printList(int[] list) 
	{
		for(int i = 0; i < list.length; i++) 
			System.out.printf("%-2d ",list[i]);
		System.out.println();
	}
}
