package sieveOfEratosthenes;

public class Factor
{
	long value;
	long frequency;
	
	public Factor(long num, long prime) 
	{
		value = prime;
		frequency = 0;
		while(num % prime == 0) 
		{
			num /= prime;
			frequency++;
		}
	}
	
	public void exponentiate(int pow) 
	{
		frequency *= pow;
	}
	
	public boolean equals(Factor f) 
	{
		return value == f.value && frequency == f.frequency;
	}
	
	public long evaluate() 
	{
		long result = 1;
		for(int i = 0; i < frequency; i++)
			result *= value;
		return result;
	}
	
	public String toString() 
	{
		return value + "^" + frequency;
	}
}
