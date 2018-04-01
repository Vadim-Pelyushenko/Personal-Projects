import java.util.LinkedList;

public class SelfPrinter
{
	public static void papinv(LinkedList<String> lines, LinkedList<String> invoc, String s) 
	{
		lines.add(s);
		s = s.replace("\\", "\\\\").replace("\n", "\\n").replace("\"","\\\"").replace("\t", "\\t");
		String temp = "\t\tpapinv(lines,invocs,\"" + s + "\");";
		invoc.add(temp);
	} 
	
	public static void main(String[] args) 
	{
		LinkedList<String> lines = new LinkedList<String>();
		LinkedList<String> invocs = new LinkedList<String>();
		LinkedList<String> post = new LinkedList<String>();
		papinv(lines,invocs,"import java.util.LinkedList\n");
		papinv(lines,invocs,"public class SelfPrinter\n{");
		papinv(lines,invocs,"\tpublic static void papinv(LinkedList<String> lines, LinkedList<String> invoc, String s)\n\t{");
		papinv(lines,invocs,"\t\tlines.add(s);");
		papinv(lines,invocs,"\t\ts = s.replace(\"\\\\\", \"\\\\\\\\\").replace(\"\\n\",\"\\\\n\").replace(\"\\\"\",\"\\\\\\\"\").replace(\"\\t\", \"\\\\t\");");
		papinv(lines,invocs,"\t\tString temp = \"\\t\\tpapinv(lines,invocs,\\\"\" + s + \"\\\");\";");
		papinv(lines,invocs,"\t\tinvoc.add(temp);");
		papinv(lines,invocs,"\t}\n");
		papinv(lines,invocs,"\tpublic static void main(String[] args)\n\t{");
		papinv(lines,invocs,"\t\tLinkedList<String> lines = new LinkedList<String>();");
		papinv(lines,invocs,"\t\tLinkedList<String> invocs = new LinkedList<String>();");
		papinv(lines,invocs,"\t\tLinkedList<String> post = new LinkedList<String>();");
		papinv(post,invocs,"\t\tfor(String s : lines)");
		papinv(post,invocs,"\t\t\tSystem.out.println(s);");
		papinv(post,invocs,"\t\tfor(String s : invocs)");
		papinv(post,invocs,"\t\t\tSystem.out.println(s);");
		papinv(post,invocs,"\t\tfor(String s : post)");
		papinv(post,invocs,"\t\t\tSystem.out.println(s);");
		papinv(post,invocs,"\t}\n}");
		for(String s : lines)
			System.out.println(s);
		for(String s : invocs)
			System.out.println(s);
		for(String s : post)
			System.out.println(s);
	}
}
