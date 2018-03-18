package patternDetection;

public class Fraction
{
	private int num;
	private int den;
	
	public Fraction(int num, int den) 
	{
		this.num = num;
		this.den = den;
		simplify();
	}
	
	public void simplify() 
	{
		int f = gcd(num,den);
		num /= f;
		den /= f;
	}
	
	public int multiply(int a) 
	{
		return a * num / den;
	}
	
	public void multiplyBy(int a) 
	{
		num *= a;
		simplify();
	}
	
	public void multiplyBy(Fraction a) 
	{
		num *= a.num;
		den *= a.den;
		simplify();
	}
	
	public void divideBy(int a) 
	{
		den *= a;
		simplify();
	}
	
	public void divideBy(Fraction a) 
	{
		num *= a.den;
		den *= a.num;
		simplify();
	}
	
	public Fraction reciprocal() 
	{
		return new Fraction(den,num);
	}
	
	public void add(Fraction a) 
	{
		int f = gcd(this.den,a.den);
		this.num *= a.den / f;
		this.den *= a.den / f;
		this.num += a.num * (this.den / f);
		simplify();
	}
	
	public static int gcd(int a, int b) 
	{
		if(b == 0)
			return a;
		return gcd(b,a % b);
	}
	
	public static int lcm(int a, int b) 
	{
		return a * b / gcd(a,b);
	}
	
	public int getNum() 
	{
		return num;
	}
	
	public void setNum(int a) 
	{
		num = a;
		simplify();
	}
	
	public int getDen() 
	{
		return den;
	}
	
	public void setDen(int a) 
	{
		den = a;
		simplify();
	}
	
	public String toString() 
	{
		if(equals(1))
			return "";
		if(den == 1)
			return num + "";
		return "(" + num + "/" + den + ")";
	}
	
	public boolean equals(int a) 
	{
		return num/den == a && num % den == 0;
	}
	
	public boolean equals(Fraction a) 
	{
		a.simplify();
		simplify();
		return a.num == num && a.den == den;
	}
	
	public boolean isNegative() 
	{
		return num * den < 0;
	}
	
	public int compareTo(Fraction f) 
	{
		return num * f.den - f.num * den;
	}
}
