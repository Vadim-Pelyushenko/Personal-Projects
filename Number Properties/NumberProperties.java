
public class NumberProperties
{
	// The Greatest Common Divisor of two integers
	public static int gcd(int a, int b) 
	{
		if(b == 0)
			return a;
		return gcd(b,a % b);
	}
	
	// The Greatest Common Divisor of a list of integers
	// Assumes there is at least one element in the array
	public static int gcd(int[] a) 
	{
		if(a.length == 1)
			return a[0];
		int result = gcd(a[0],a[1]);
		for(int i = 2; i < a.length; i++) 
		{
			result = gcd(result,a[i]);
		}
		return result;
	}
	
	// The Lowest Common Multiple of two integers
	public static int lcm(int a, int b) 
	{
		return a * b / gcd(a,b);
	}
	
	// The Lowest Common Multiple of a list of integers
	// Assumes there is at least one element in the array
	public static int lcm(int[] a) 
	{
		if(a.length == 1)
			return a[0];
		int result = lcm(a[0],a[1]);
		for(int i = 2; i < a.length; i++) 
		{
			result = lcm(result,a[i]);
		}
		return result;
	}
}
