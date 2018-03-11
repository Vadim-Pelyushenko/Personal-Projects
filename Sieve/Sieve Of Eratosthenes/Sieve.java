package sieveOfEratosthenes;

import java.util.ArrayList;
import java.util.Collections;

public class Sieve
{
	public boolean[] sieve;
	public ArrayList<Integer> primes;
	public int lastTestedValue;
	
	// Creates a sieve that can prime factorize any numbers less than or equal to the input
	public Sieve(long val) 
	{
		lastTestedValue = 0;
		primes = new ArrayList<Integer>((int)Math.sqrt(val) + 1);
		sieve = new boolean[(int)Math.sqrt(val) + 1];
		sieve[0] = true;
		sieve[1] = true;
		int start = 2;
		while(true) 
		{
			int prime = nextPrime(start);
			if(prime == -1)
				break;
			primes.add(prime);
			for(int i = prime*2; i < sieve.length; i += prime) 
			{
				sieve[i] = true;
			}
			start = prime + 1;
		}
	}
	
	// getAllPrimes = true, means that we want to get all the primes <= val
	// getAllPrimes = false, means that we want to be able to factorize all numbers <= val
	public Sieve(int val, boolean getAllPrimes) 
	{
		if(getAllPrimes) 
		{
			primes = new ArrayList<Integer>(val);
			sieve = new boolean[val + 1];
		}			
		else 
		{
			primes = new ArrayList<Integer>((int)Math.sqrt(val) + 1);
			sieve = new boolean[(int)Math.sqrt(val) + 1];
		}
		sieve[0] = true;
		sieve[1] = true;
		int start = 2;
		while(true) 
		{
			int prime = nextPrime(start);
			if(prime == -1)
				break;
			primes.add(prime);
			for(int i = prime*2; i < sieve.length; i += prime) 
			{
				sieve[i] = true;
			}
			start = prime + 1;
		}
	}
	
	public void expandSieve(int length) 
	{
		sieve = new boolean[length];
		for(Integer p : primes) 
		{
			int start = p - ((lastTestedValue + 1) % p);
			if(start == p)
				start = 0;
//			System.out.println("testing(" + p + ") first: " + (start + lastTestedValue + 1) + " at index " + start);
			for(int j = start; j < sieve.length; j += p) 
			{
//				System.out.println("marking: " + j + " (" + (j + lastTestedValue + 1) + ")");
				sieve[j] = true;
			}
//			System.out.println();
		}
		int start = 0;
		while(true) 
		{
			int prime = nextPrime(start);
			if(prime == -1)
				break;
//			System.out.println("position of prime: " + prime);
			prime += lastTestedValue + 1;
//			System.out.println("new prime: " + prime);
//			System.out.println("will start marking at index: " + (prime - lastTestedValue - 1));
//			System.out.println();
			primes.add(prime);
			for(int i = prime - lastTestedValue - 1; i < sieve.length; i += prime) 
			{
//				System.out.println("marking: " + i + " (" + (i + lastTestedValue + 1) + ")");
				sieve[i] = true;
			}
			start = prime - lastTestedValue;
		}
	}
	
	public int nextPrime(int start) 
	{
		for(int i = start; i < sieve.length; i++) 
		{
			if(!sieve[i]) 
				return i;
		}
		lastTestedValue += sieve.length - 1;
		return -1;
	}
	
	public ArrayList<Factor> primeFactorization(long a) 
	{
		ArrayList<Factor> result = new ArrayList<Factor>();
		for(int i = 0; i < primes.size() && a != 1; i++) 
		{
			if(a == 0)
				System.exit(0);
			int nextPrime = primes.get(i);
			if(a % nextPrime == 0) 
			{
				Factor f = new Factor(a,nextPrime);
				result.add(f);
				a /= f.evaluate();
			}
		}
		if(a != 1)
			result.add(new Factor(a,a));
		return result;
	}
	
	public ArrayList<Long> properDivisors(long a) 
	{
		ArrayList<Factor> pf = primeFactorization(a);
		int numDivisors = 1;
		for(int i = 0; i < pf.size(); i++) 
		{
			numDivisors *= pf.get(i).frequency + 1;
		}
		ArrayList<Long> divisors = new ArrayList<Long>(numDivisors);
		divisors.add(1L);
		for(Factor f : pf) 
		{
			long multiplicand = f.value;
			int pre = divisors.size();
			for(int i = 0; i < f.frequency; i++) 
			{
				for(int j = 0; j < pre; j++) 
				{
					divisors.add(divisors.get(j) * multiplicand);
				}
				multiplicand *= f.value;
			}
		}
		divisors.remove(divisors.size() - 1);
		Collections.sort(divisors);
		return divisors;
	}
	
	public boolean isPrime(long a) 
	{
		if(a < 2)
			return false;
		if(a < primes.get(primes.size() - 1)) 
		{
			return primes.indexOf((int)a) != -1;
		}
		return primeFactorization(a).get(0).value == a;
	}
	
	public static void main(String[] args) 
	{
//		Random rand = new Random();
//		int a = rand.nextInt(1000000000);
//		Sieve s = new Sieve(a);
//		ArrayList<Factor> f = s.primeFactorization(a);
//		System.out.println(a);
//		for(int i = 0; i < f.size(); i++) 
//		{
//			System.out.print(f.get(i) + " ");
//		}
		
//		int value = 220;
//		Sieve s = new Sieve(value);
//		ArrayList<Factor> f = s.primeFactorization(value);
//		for(int i = 0; i < f.size(); i++) 
//		{
//			System.out.print(f.get(i) + " ");
//		}
//		System.out.println();
//		ArrayList<Long> pd = s.properDivisors(value);
//		for(Long l : pd) 
//		{
//			System.out.println(l);
//		}
		
//		Testing Expansion of Sieve
//		Sieve s = new Sieve(10,true);
//		s.expandSieve(90);
//		ArrayList<Integer> primes = s.primes;
//		for(Integer i : primes)
//			System.out.print(i + " ");
//		System.out.println();
//		
//		s = new Sieve(100,true);
//		primes = s.primes;
//		for(Integer i : primes)
//			System.out.print(i + " ");
//		System.out.println();
//		
//		System.out.println();
//		
//		s = new Sieve(10,true);
//		s.expandSieve(990);
//		primes = s.primes;
//		for(Integer i : primes)
//			System.out.print(i + " ");
//		System.out.println();
//		
//		s = new Sieve(1000,true);
//		primes = s.primes;
//		for(Integer i : primes)
//			System.out.print(i + " ");
//		System.out.println();
		
//		Second test of expansion
//		Sieve s = new Sieve(100,true);
//		s.expandSieve(100);
//		s.expandSieve(200);
//		s.expandSieve(600);
//		ArrayList<Integer> primes = s.primes;
//		for(Integer i : primes)
//			System.out.print(i + " ");
//		System.out.println();
//		
//		s = new Sieve(1000,true);
//		primes = s.primes;
//		for(Integer i : primes)
//			System.out.print(i + " ");
//		System.out.println();
	}
}
