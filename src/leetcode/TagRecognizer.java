package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagRecognizer {

	public static void main(String[] args) {
	    final String str = "<tag>apple</tag><b>hello</b><tag>orange <tag>pear</tag></tag>";
	    String a2 = "<h1>had<h1>public</h1></h1>";
	    
	    //System.out.println(Arrays.toString(getTagValues(a2).toArray())); 
	    String tagValue = Arrays.toString(getTagValues(a2, TAG_REGEX).toArray());
	    tagValue = tagValue.substring(1, tagValue.length()-1);
	    System.out.println(Arrays.toString(getTagValues(tagValue, TAG_REGEX_2).toArray())); 
	    /*if(tagValue.contains(">")) {
	    	System.out.print(Arrays.toString(getTagValues(tagValue, TAG_REGEX_2).toArray()));
	    }*/
	}

	private static final Pattern TAG_REGEX = Pattern.compile("<h1>(.+?)</h1>", Pattern.DOTALL);

	private static final Pattern TAG_REGEX_2 = Pattern.compile(">(.+?)", Pattern.DOTALL);

	private static List<String> getTagValues(final String str, Pattern pattern) {
	    final List<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = pattern.matcher(str);
	    while (matcher.find()) {
	        tagValues.add(matcher.group(1));
	    }
	    return tagValues;
	}
	
}
