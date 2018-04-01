import java.util.LinkedList;

public class SelfPrinter
{
	public static void papinv(LinkedList<String> lines, LinkedList<String> invoc, String s) 
	{
		lines.add(s);
		String temp = "papinv(lines,invocs,\"" + s + "\");";
		invoc.add(temp.replace("\n", "\\n").replace("\\", "\\\\").replace("\"","\\\""));
	} 
	
	public static void main(String[] args) 
	{
		LinkedList<String> lines = new LinkedList<String>();
		LinkedList<String> invocs = new LinkedList<String>();
		papinv(lines,invocs,"import java.util.LinkedList\n");
		papinv(lines,invocs,"public class SelfPrinter\n{\n");
		papinv(lines,invocs,"public static void papinv(LinkedList<String> lines, LinkedList<String> invoc, String s)\n{");
		papinv(lines,invocs,"lines.add(s);");
		papinv(lines,invocs,"String temp = \"papinv(lines,invocs,\\\"\" + s + \"\\\");\";");
		papinv(lines,invocs,"invoc.add(temp.replace(\"\\n\", \"\\\\n\").replace(\"\\\\\", \"\\\\\\\\\").replace(\"\\\"\",\"\\\\\\\"\");");
		for(String s : lines)
			System.out.println(s);
		for(String s : invocs)
			System.out.println(s);
	}
}
