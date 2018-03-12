package calculateConvergent;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigFraction
{
	private BigInteger num;
	private BigInteger den;
	
	public BigFraction(BigInteger num, BigInteger den) 
	{
		this.num = num;
		this.den = den;
		simplify();
	}
	
	public BigFraction(long num, long den) 
	{
		this.num = BigInteger.valueOf(num);
		this.den = BigInteger.valueOf(den);
		simplify();
	}
	
	public void simplify() 
	{
		BigInteger f = num.gcd(den);
		num = num.divide(f);
		den = den.divide(f);
	}
	
	public void multiplyBy(long a) 
	{
		num = num.multiply(BigInteger.valueOf(a));
		simplify();
	}
	
	public void multiplyBy(BigInteger a) 
	{
		num = num.multiply(a);
		simplify();
	}
	
	public void multiplyBy(BigFraction a) 
	{
		num = num.multiply(a.num);
		den = den.multiply(a.den);
		simplify();
	}
	
	public void divideBy(long a) 
	{
		den = den.multiply(BigInteger.valueOf(a));
		simplify();
	}
	
	public void divideBy(BigFraction a) 
	{
		num = num.multiply(a.den);
		den = den.multiply(a.num);
		simplify();
	}
	
	public BigFraction reciprocal() 
	{
		return new BigFraction(num,den);
	}
	
	public void add(BigFraction a) 
	{
		BigInteger f = a.den.gcd(this.den);
		this.num = this.num.multiply(a.den.divide(f));
		this.den = this.den.multiply(a.den.divide(f));
		this.num = this.num.add(a.num.multiply((this.den.divide(f))));
		simplify();
	}
	
	public BigInteger getNum() 
	{
		return num;
	}
	
	public void setNum(BigInteger a) 
	{
		num = a;
		simplify();
	}
	
	public BigInteger getDen() 
	{
		return den;
	}
	
	public void setDen(BigInteger a) 
	{
		den = a;
		simplify();
	}
	
	public String toString() 
	{
		if(equals(1))
			return "";
		if(den.equals(1))
			return num + "";
		return "(" + num + "/" + den + ")";
	}
	
	public boolean equals(BigInteger a) 
	{
		return num.divide(den).equals(a) && num.mod(den).equals(0);
	}
	
	public boolean equals(BigFraction a) 
	{
		a.simplify();
		simplify();
		return a.num == num && a.den == den;
	}
	
	public boolean isNegative() 
	{
		return !(num.signum() == 1 ^ num.signum() == 1);
	}
	
	public int compareTo(BigFraction f) 
	{
		BigInteger result = num.multiply(f.den).subtract(f.num.multiply(den));
		return result.compareTo(BigInteger.ZERO);
	}
	
	public BigDecimal toBigDecimal(int scale, int mode) 
	{
		return new BigDecimal(this.num).divide(new BigDecimal(this.den),scale,mode);
	}
}
