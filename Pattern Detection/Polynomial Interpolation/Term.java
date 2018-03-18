package patternDetection;

public class Term
{
	private Fraction coefficient;
	private int power;
	
	public Term(int power) 
	{
		this.coefficient = new Fraction(1,1);
		this.power = power;
	}
	
	public Term(int power, int coeff) 
	{
		this.coefficient = new Fraction(coeff,1);
		this.power = power;
	}
	
	public Term(int power, int num, int den) 
	{
		this.coefficient = new Fraction(num,den);
		this.power = power;
	}
	
	public int evaluate(int input) 
	{
		int result = 1;
		for(int i = 0; i < power; i++)
			result *= input;
		return coefficient.multiply(result);
	}
	
	public void multiply(int a) 
	{
		coefficient.multiplyBy(a);
	}
	
	public void multiply(Fraction a) 
	{
		coefficient.multiplyBy(a);
	}
	
	public Fraction getCoefficient() 
	{
		return coefficient;
	}
	
	public void setNum(int a) 
	{
		coefficient.setNum(a);
	}
	
	public int getNum() 
	{
		return coefficient.getNum();
	}
	
	public void setDen(int a) 
	{
		coefficient.setDen(a);
	}
	
	public int getDen() 
	{
		return coefficient.getDen();
	}
	
	public String toString() 
	{
		if(coefficient.equals(1)) 
		{
			if(power == 1)
				return "x";
			else if(power == 0)
				return "1";
			return "x^" + power;
		}
		if(coefficient.equals(0))
			return "";
		String coeffPart = coefficient + "";
		coeffPart = coeffPart.replaceAll("-", "");
		String powerPart;
		if(power == 0)
			return coeffPart;
		else if(power == 1) 
			powerPart = "x";
		else
			powerPart = "x^" + power;
		return coeffPart + "*" + powerPart;
	}
	
	public boolean isNegative() 
	{
		return coefficient.isNegative();
	}
}
