import java.util.LinkedList;

public class SelfPrinter
{
	public static void printAndPrintCall(LinkedList<String> lines, LinkedList<String> invoc, String s) 
	{
		lines.add(s);
		invoc.add("printAndPrintCall(lines,invoc," + s + ");");
	} 
	
	public static void main(String[] args) 
	{
		
	}
}
