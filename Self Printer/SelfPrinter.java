import java.util.LinkedList;

public class SelfPrinter
{
	public static void papinv(LinkedList<String> lines, LinkedList<String> invoc, String s, String list)
	{
		lines.add(s);
		s = s.replace("\\", "\\\\").replace("\n", "\\n").replace("\"","\\\"").replace("\t", "\\t");
		String temp = "\t\tpapinv(" + list + ",invocs,\"" + s + "\",\"" + list + "\");";
		invoc.add(temp);
	}

	public static void main(String[] args)
	{
		LinkedList<String> lines = new LinkedList<String>();
		LinkedList<String> invocs = new LinkedList<String>();
		LinkedList<String> post = new LinkedList<String>();
		papinv(lines,invocs,"import java.util.LinkedList;\n","lines");
		papinv(lines,invocs,"public class SelfPrinter\n{","lines");
		papinv(lines,invocs,"\tpublic static void papinv(LinkedList<String> lines, LinkedList<String> invoc, String s, String list)\n\t{","lines");
		papinv(lines,invocs,"\t\tlines.add(s);","lines");
		papinv(lines,invocs,"\t\ts = s.replace(\"\\\\\", \"\\\\\\\\\").replace(\"\\n\", \"\\\\n\").replace(\"\\\"\",\"\\\\\\\"\").replace(\"\\t\", \"\\\\t\");","lines");
		papinv(lines,invocs,"\t\tString temp = \"\\t\\tpapinv(\" + list + \",invocs,\\\"\" + s + \"\\\",\\\"\" + list + \"\\\");\";","lines");
		papinv(lines,invocs,"\t\tinvoc.add(temp);","lines");
		papinv(lines,invocs,"\t}\n","lines");
		papinv(lines,invocs,"\tpublic static void main(String[] args)\n\t{","lines");
		papinv(lines,invocs,"\t\tLinkedList<String> lines = new LinkedList<String>();","lines");
		papinv(lines,invocs,"\t\tLinkedList<String> invocs = new LinkedList<String>();","lines");
		papinv(lines,invocs,"\t\tLinkedList<String> post = new LinkedList<String>();","lines");
		papinv(post,invocs,"\t\tfor(String s : lines)","post");
		papinv(post,invocs,"\t\t\tSystem.out.println(s);","post");
		papinv(post,invocs,"\t\tfor(String s : invocs)","post");
		papinv(post,invocs,"\t\t\tSystem.out.println(s);","post");
		papinv(post,invocs,"\t\tfor(String s : post)","post");
		papinv(post,invocs,"\t\t\tSystem.out.println(s);","post");
		papinv(post,invocs,"\t}\n}","post");
		for(String s : lines)
			System.out.println(s);
		for(String s : invocs)
			System.out.println(s);
		for(String s : post)
			System.out.println(s);
	}
}
