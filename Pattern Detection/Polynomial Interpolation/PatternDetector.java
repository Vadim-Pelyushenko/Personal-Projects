package patternDetection;
import java.util.ArrayList;
import java.util.Scanner;

public class PatternDetector
{
	public static Polynomial guess(ArrayList<Integer> seq) 
	{
		return findPattern(countDifferences(seq));
	}
	
	private static Polynomial debugFindPattern(ArrayList<Integer[]> diff) 
	{
		if(diff.get(0).length == 1) 
		{
			Polynomial result = new Polynomial();
			result.addTerm(new Term(0,diff.get(0)[0]));
			return result;
		}
		System.out.println("Polynomializing...");
		int polynomialDegree = diff.size() - 1;
		Polynomial result = new Polynomial();
		int toFix = diff.get(diff.size() - 1)[0];
		result.addTerm(new Term(polynomialDegree,toFix,factorial(polynomialDegree)));	
		result.normalize();
		ArrayList<Integer[]> polyDiff = countDifferences(result.plugInValuesWithoutCoeff(0, diff.get(0).length - 1));
		for(int i = diff.size() - 2; i >= 0; i--) 
		{
			toFix = diff.get(i)[0]*result.getDen() - polyDiff.get(i)[0];
			result.addTerm(new Term(i,toFix,factorial(i)*result.getDen()));
			polyDiff = countDifferences(result.plugInValuesWithoutCoeff(0, diff.get(0).length - 1));
		}
		System.out.println("Polynomialized");
		return result;
	}
	
	public static Polynomial findPattern(ArrayList<Integer[]> diff) 
	{
		if(diff.get(0).length == 1) 
		{
			Polynomial result = new Polynomial();
			result.addTerm(new Term(0,diff.get(0)[0]));
			return result;
		}
		int polynomialDegree = diff.size() - 1;
		Polynomial result = new Polynomial();
		int toFix = diff.get(diff.size() - 1)[0];
		result.addTerm(new Term(polynomialDegree,toFix,factorial(polynomialDegree)));	
		result.normalize();
		ArrayList<Integer[]> polyDiff = countDifferences(result.plugInValuesWithoutCoeff(0, diff.get(0).length - 1));
		for(int i = diff.size() - 2; i >= 0; i--) 
		{
			toFix = diff.get(i)[0]*result.getDen() - polyDiff.get(i)[0];
			result.addTerm(new Term(i,toFix,factorial(i)*result.getDen()));
			polyDiff = countDifferences(result.plugInValuesWithoutCoeff(0, diff.get(0).length - 1));
		}
		return result;
	}
	
	public static ArrayList<Integer[]> countDifferences(ArrayList<Integer> numbers) 
	{
		ArrayList<Integer[]> differences = new ArrayList<Integer[]>();
		Integer[] diff0 = new Integer[numbers.size()];
		for(int i = 0; i < diff0.length; i++) 
		{
			diff0[i] = numbers.get(i);
		}
		differences.add(diff0);
		int prev = 0;
		while(true) 
		{
			Integer[] prevDiff = differences.get(prev);
			Integer[] nextDiff = new Integer[prevDiff.length - 1];
			for(int i = 0; i < nextDiff.length; i++) 
			{
				nextDiff[i] = prevDiff[i + 1] - prevDiff[i];
			}
			differences.add(nextDiff);
			prev++;
			if(listIsConstant(nextDiff))
				break;
		}
		return differences;
	}
	
	private static ArrayList<Integer[]> debugCountDifferences(ArrayList<Integer> numbers) 
	{
		System.out.println("Counting differences...");
		ArrayList<Integer[]> differences = new ArrayList<Integer[]>();
		Integer[] diff0 = new Integer[numbers.size()];
		for(int i = 0; i < diff0.length; i++) 
		{
			diff0[i] = numbers.get(i);
		}
		differences.add(diff0);
		int prev = 0;
		while(true) 
		{
			Integer[] prevDiff = differences.get(prev);
			Integer[] nextDiff = new Integer[prevDiff.length - 1];
			for(int i = 0; i < nextDiff.length; i++) 
			{
				nextDiff[i] = prevDiff[i + 1] - prevDiff[i];
			}
			differences.add(nextDiff);
			prev++;
			if(listIsConstant(nextDiff))
				break;
		}
		System.out.println("Differences counted");
		return differences;
	}
	
	public static boolean listIsConstant(Integer[] list) 
	{
		if(list.length == 0)
			return true;
		int a = list[0];
		for(int i = 1; i < list.length; i++)
			if(list[i] != a)
				return false;
		return true;
	}
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to enter numbers through (C)onsole or through a (F)ile?");
		String choice = scan.nextLine();
		if(choice.charAt(0) == 'F' || choice.charAt(0) == 'f') 
		{
			System.out.print("Enter the file name: ");
			String fileName = scan.nextLine();
			scan = new Scanner(fileName);
			while(scan.hasNextLine()) 
			{
				String[] tokens = scan.nextLine().split("\\s+");
				for(String t : tokens)
					numbers.add(Integer.parseInt(t));
			}
			scan.close();
		}
		else if(choice.charAt(0) == 'C' || choice.charAt(0) == 'c') 
		{
			System.out.println("Keep entering numbers in the sequence in the order they must come out of the function");
			System.out.println("The program is more certain(usually) about its answer truly representing the sequence");
			System.out.println("with more inputs");
			System.out.println("You may enter numbers one per line, or multiple per line");
			System.out.println("Enter D to stop entering numbers");
			while(true) 
			{
				try 
				{
					String line = scan.nextLine();
					if(line.equalsIgnoreCase("D"))
						break;
					String[] tokens = line.split("\\s+");
					for(String t : tokens)
						numbers.add(Integer.parseInt(t));
				}
				catch(Exception ex) 
				{
					System.out.println("Please make sure to not enter charactes besides numbers(or D by itself)");
					System.out.println("All numbers you've entered so far as still stored, you may continue entering numbers");
				}
			}
		}
		System.out.println("generating function...");
		Polynomial function = findPattern(countDifferences(numbers));
		System.out.println("Resulting function: " + function);
		int certainty = numbers.size() - (function.terms.size());
		System.out.println("Certainty rating(5+ is fairly confident imo): " + certainty);
		System.out.println("The certainty rating is equal to the degree of freedom the function has, vs what it used");
		System.out.println("For instance, you can generate any 5 integers in a sequence you want as long as you have at least");
		System.out.println("5 terms(a quartic equation) in your polynomial function. If the polynomial function takes less terms");
		System.out.println("than is guaranteed to fit the sequence, then it is more likely to represent the true function");
		// All of the numbers have been collected, time to analyse
	}
	
	public static int factorial(int n) 
	{
		int result = 1;
		for(int i = 1; i <= n; i++) 
		{
			result *= i;
		}
		return result;
	}
}
