
/*
Given an array strings, determine whether it follows 
the sequence given in the patterns array. In other words, 
there should be no i and j for which strings[i] = strings[j] 
and patterns[i] ≠ patterns[j] or for which 
strings[i] ≠ strings[j] and patterns[i] = patterns[j]

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = true;
*/

import java.util.*;
class areFollowingPatterns
{
	public static void main(String[] args)
	{
		//test 7
		String[] strings = {"re", "jjinh", "rnz", "frok", 
						 "frok", "hxytef", "hxytef", "frok"};
		String[] patterns = {"kzfzmjwe", "fgbugiomo", "ocuijka", "gafdrts", 
					"gafdrts", "ebdva", "ebdva", "gafdrts"};
		areFollowingPatterns(strings, patterns);
	}
	
	public static boolean areFollowingPatterns(String[] strings, String[] patterns)
	{
		Hashtable<String, String> ht = new Hashtable<String, String>();
		
		if (strings.length != patterns.length) {return false;}
		
		ArrayList<String> s = new ArrayList<String>();
		for (int i = 0; i < strings.length; i++)
		{
			if (!s.contains(strings[i]))
			{
				s.add(strings[i]);
			}
		}
		
		ArrayList<String> p = new ArrayList<String>();
		for (int i = 0; i < patterns.length; i++)
		{
			if (!p.contains(patterns[i]))
			{
				p.add(patterns[i]);
			}
		}
		
		if ( s.size() != p.size() ) {return false;}
		
		for (int i = 0; i < s.size(); i++)
		{
			ht.put(s.get(i), p.get(i));
		}
		
		String temp = "";
		for (int i = 0; i < strings.length; i++)
		{
			temp = ht.get(strings[i]);
			if ( !temp.equals(patterns[i]) )
			{
				return false;
			}
		}
		
		return true;
	}
}