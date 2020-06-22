package com.jia.leetCode;

import java.util.Arrays;
import java.util.Collections;

/**
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.
 * @author Administrator
 *
 */
public class Pro0151 {
	public String reverseWords(String s){
		StringBuilder sb = new StringBuilder();
		int j = s.length();
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == ' ') {
				j = i;
			}else if(i == 0 || s.charAt(i - 1) == ' ') {
				if(sb.length() != 0) {
					sb.append(' ');
				}
				sb.append(s.substring(i, j));
			}
		}
		return sb.toString();
	}
	public String reverseWords2(String s) {
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}
}
