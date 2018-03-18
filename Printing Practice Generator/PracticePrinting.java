import java.util.Scanner;

public class PracticePrinting
{
	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("This program will generate a random series of printout statements,");
		System.out.println("which may either be print, or println\n");
		System.out.print("How many println's would you like to generate? ");
		int numLines = Integer.parseInt(scan.nextLine());
		System.out.print("How many total letters would you like to generate? ");
		int total = Integer.parseInt(scan.nextLine());
		int[] lnOrNot = new int[total];
		for(int i = 0; i < numLines; i++)
			lnOrNot[i] = 1;
		RandomPermutation.randomlyPermutate(lnOrNot);
		
		for(int i = 0; i < total; i++) 
		{
			if(lnOrNot[i] == 1)
				System.out.printf("System.out.println(\"%c\");\n",alphabet.charAt(i));
			else
				System.out.printf("System.out.print(\"%c\");\n", alphabet.charAt(i));
		}		
		System.out.println();
		System.out.println("What do you predict the output of this program will be?(Type in your answer on notepad or something)");
		System.out.println("When you are ready to check, type in 'T'");
		while(!scan.nextLine().equals("T"));
		System.out.println("The printout of the program would be: ");
		System.out.println("----------------------------------------------------");
		for(int i = 0; i < total; i++) 
		{
			if(lnOrNot[i] == 1)
				System.out.println(alphabet.charAt(i));
			else
				System.out.print(alphabet.charAt(i));
		}		
		System.out.println("----------------------------------------------------");
		System.out.println("Did you get it right?");
 	}
}
