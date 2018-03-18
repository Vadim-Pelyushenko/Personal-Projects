package patternDetection;
import java.util.ArrayList;

public class Polynomial
{
	Fraction coefficient;
	ArrayList<Term> terms;
	
	public Polynomial() 
	{
		coefficient = new Fraction(1,1);
		terms = new ArrayList<Term>();
	}
	
	public void addTerm(Term t) 
	{
		unNormalize();
		terms.add(t);
		normalize();
	}
	
	public int evaluate(int input) 
	{
		int sum = 0;
		for(Term t : terms)
			sum += t.evaluate(input);
		return coefficient.multiply(sum);
	}
	
	public int evaluateWithoutCoeff(int input) 
	{
		int sum = 0;
		for(Term t : terms)
			sum += t.evaluate(input);
		return sum;
	}
	
	// make all terms have whole coefficients, all encapsulated with one coefficient
	public void normalize() 
	{
		if(terms.size() <= 1) 
		{
			coefficient.multiplyBy(new Fraction(1,terms.get(0).getCoefficient().getDen()));
			terms.get(0).setDen(1);
			return;
		}
		int currentLCM = Fraction.lcm(terms.get(0).getCoefficient().getDen(), terms.get(1).getCoefficient().getDen());
		for(int i = 2; i < terms.size(); i++) 
		{
			currentLCM = Fraction.lcm(currentLCM, terms.get(i).getCoefficient().getDen());
		}
		
		for(int i = 0; i < terms.size(); i++)
			terms.get(i).multiply(currentLCM);
		coefficient.divideBy(currentLCM);
	}
	
	// distribute the coefficient
	public void unNormalize() 
	{
		for(Term t: terms)
			t.multiply(coefficient);
		coefficient = new Fraction(1,1);
	}
	
	public ArrayList<Integer> plugInValues(int low, int high)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = low; i <= high; i++) 
		{
			result.add(evaluate(i));
		}
		return result;
	}
	
	public ArrayList<Integer> plugInValuesWithoutCoeff(int low, int high)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = low; i <= high; i++) 
		{
			result.add(evaluateWithoutCoeff(i));
		}
		return result;
	}
	
	public int getNum() 
	{
		return coefficient.getNum();
	}
	
	public int getDen() 
	{
		return coefficient.getDen();
	}
	
	public String toString() 
	{
		String result = "";
		if(terms.size() == 0)
			return "0";
		if(!coefficient.equals(1))
			result += coefficient + "*(";
		result += terms.get(0);
		for(int i = 1; i < terms.size(); i++) 
		{
			if(!terms.get(i).getCoefficient().equals(0)) 
			{
				if(terms.get(i).isNegative())
					result += " - ";
				else
					result += " + ";
				result += terms.get(i);
			}
		}
		if(!coefficient.equals(1))
			result += ")";
		return result;
	}
}
