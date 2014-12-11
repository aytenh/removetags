package com.removetags;

public class RemoveTags {

    public static String stripHtmlRegex(String source) {

	return source.replaceAll("<.*?>", "");
    }

    public static String stripTagsCharArray(String source) {

    char[] array = new char[source.length()];
	int arrayIndex = 0;
	boolean inside = false;

	for (int i = 0; i < source.length(); i++) {
	    char let = source.charAt(i);
	    if (let == '<') {
		inside = true;
		continue;
	    }
	    if (let == '>') {
		inside = false;
		continue;
	    }
	    if (!inside) {
		array[arrayIndex] = let;
		arrayIndex++;
	    }
	}
	return new String(array, 0, arrayIndex);
    }

    public static void main(String[] args) {

	final String html = "<p id=x>Menim, <b>ilk</b> proqramim, "
		+ "menim <i>ilk</i> nailiyyetim.</p>";
	System.out.println(html);
	String test = stripHtmlRegex(html);
	System.out.println(test);
	String test2 = stripTagsCharArray(html);
	System.out.println(test2);
    }
}
