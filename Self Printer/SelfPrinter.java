public class SelfPrinter
{
	public static String lines = "";
	public static String invocs = "";
	public static String post = "";

	public static void papinv(String s, boolean isPost)
	{
		if(isPost){post += s + "\n";}
		else{lines += s + "\n";}
		s = s.replace("\\", "\\\\").replace("\n", "\\n").replace("\"","\\\"").replace("\t", "\\t");
		String temp = "\t\tpapinv(\"" + s + "\"," + isPost + ");";
		invocs += temp + "\n";
	}

	public static void main(String[] args)
	{
		papinv("public class SelfPrinter\n{",false);
		papinv("\tpublic static String lines = \"\";",false);
		papinv("\tpublic static String invocs = \"\";",false);
		papinv("\tpublic static String post = \"\";\n",false);
		papinv("\tpublic static void papinv(String s, boolean isPost)\n\t{",false);
		papinv("\t\tif(isPost){post += s + \"\\n\";}",false);
		papinv("\t\telse{lines += s + \"\\n\";}",false);
		papinv("\t\ts = s.replace(\"\\\\\", \"\\\\\\\\\").replace(\"\\n\", \"\\\\n\").replace(\"\\\"\",\"\\\\\\\"\").replace(\"\\t\", \"\\\\t\");",false);
		papinv("\t\tString temp = \"\\t\\tpapinv(\\\"\" + s + \"\\\",\" + isPost + \");\";",false);
		papinv("\t\tinvocs += temp + \"\\n\";",false);
		papinv("\t}\n",false);
		papinv("\tpublic static void main(String[] args)\n\t{",false);
		papinv("\t\tSystem.out.print(lines);",true);
		papinv("\t\tSystem.out.print(invocs);",true);
		papinv("\t\tSystem.out.print(post);",true);
		papinv("\t}\n}",true);
		System.out.print(lines);
		System.out.print(invocs);
		System.out.print(post);
	}
}
