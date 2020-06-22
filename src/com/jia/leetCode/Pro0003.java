package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jia
 * 
 */
public class Pro0003 {
	public int lengthOfLongestSubstring(String s) {
		if (null == s || s.length() == 0)
			return 0;
		int max = 0;
		int j = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				max = Math.max(max, i - j);
				j = Math.max(map.get(s.charAt(i))+1, j);
			}
			map.put(s.charAt(i), i);
		}
		return Math.max(max, s.length() - j);
	}

	/*
	 * public int lengthOfLongestSubstring(String s) { int[] a = new int[30]; int
	 * max = 0; char[] sc = s.toCharArray(); for(int i=0, j=0; j<sc.length; ++j) {
	 * while(a[sc[i] - 'a'] == 1) { a[sc[i]-'a'] = 0; ++i; }
	 * 
	 * a[sc[i]-'a'] = 1; max = Math.max(max, j-i+1); } return max; }
	 */
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int max = 0;
		int j = 0;
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (hashMap.containsKey(s.charAt(i))) {
				max = Math.max(max, i - j);
				j = Math.max(hashMap.get(s.charAt(i)) + 1, j);
			}
			hashMap.put(s.charAt(i), i);
		}
		return Math.max(max, s.length() - j);
	}
	
	public static void main(String[] args) {
		String s = "dvdf";
		Pro0003 pro0003 = new Pro0003();
		System.out.println(pro0003.lengthOfLongestSubstring(s));
	}
}
