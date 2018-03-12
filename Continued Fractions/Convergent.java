package calculateConvergent;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Convergent
{
	public static String sqrtContFract(int sqrt) 
	{
		String result = "[";
		int start = (int)Math.sqrt(sqrt);
		if(start*start == sqrt)
			return sqrt + "";
		result += start + ";(";
		
		int component = -start;
		int den = 1;
		do 
		{
			den = (sqrt - component*component)/den;
			component = -component;
			int next = (component + start) / den;
			result += next + ",";
			component -= next * den;
		}while(component != -start || den != 1);
		result = result.substring(0,result.length() - 1);
		result += ")]";
		return result;
	} 
	
	public static BigFraction interpretContinuedFraction(String a, int depth) 
	{
		if(a.charAt(0) != '[' || a.charAt(a.length() - 1) != ']')
			return null;
		a = a.substring(1, a.length() - 1);
		if(a.indexOf(';') == -1)
			return null;
		long[] contFract;
		String[] repTokens = null;
		if(a.indexOf('(') == -1) 
		{
			String[] tokens = a.split("\\D+");
			contFract = new long[Math.min(tokens.length, depth)];
			for(int i = 0; i < contFract.length && i < tokens.length; i++) 
			{
				contFract[i] = Long.parseLong(tokens[i]);
			}
			return calculateConvergent(contFract);
		}
		else 
		{
			if(a.indexOf(')') == -1)
				return null;
			String[] tokens = a.substring(0,a.indexOf('(')).split("\\D+");
			contFract = new long[depth]; 
			for(int i = 0; i < contFract.length; i++) 
			{
				contFract[i] = Long.parseLong(tokens[i % tokens.length]);
			}
			if(tokens.length >= contFract.length)
				return calculateConvergent(contFract);
			repTokens = a.substring(a.indexOf('(') + 1).split("\\D+");
			long[] reps = new long[repTokens.length];
			for(int i = 0; i < repTokens.length; i++) 
			{
				reps[i] = Long.parseLong(repTokens[i]);
			}
			for(int i = tokens.length; i < contFract.length; i++) 
			{
				contFract[i] = reps[(i-tokens.length) % reps.length];
			}
			return calculateConvergent(contFract);
		}
	}
	
	public static BigFraction calculateConvergent(long[] contFract) 
	{
//		for(int i = 0; i < contFract.length; i++)
//			System.out.println(contFract[i]);
		int depth = contFract.length - 1;
		BigInteger num = BigInteger.ONE;
		BigInteger den = BigInteger.valueOf(contFract[depth]);
		BigInteger temp;
		while(depth > 1) 
		{
			depth--;
			temp = den;
			den = den.multiply(BigInteger.valueOf(contFract[depth])).add(num);
			num = temp;
		}
		num = num.add(den.multiply(BigInteger.valueOf(contFract[0])));
		return new BigFraction(num,den);
	}
	
	public static void main(String[] args) 
	{
		BigFraction bf = interpretContinuedFraction(sqrtContFract(28),40);
		System.out.println(bf.toBigDecimal(100, BigDecimal.ROUND_DOWN));
		
		
//		System.out.println(bf.getNum());
//		System.out.println(bf.getDen());
//		for(int i = 0; i < 100; i++) 
//		{
//			String a = sqrtContFract(i);
//			System.out.println(i + ": " + a);
//		}
	}
}
