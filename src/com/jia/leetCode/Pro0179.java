package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0179 {
	public String largestNumber(int[] num) {
		if (num.length == 0)
			return "";
		if (num.length == 1)
			return Integer.toString(num[0]);
		String[] str = new String[num.length];
		for (int i = 0; i < num.length; i++)
			str[i] = Integer.toString(num[i]);
		Arrays.sort(str, new StringComparator());
		StringBuilder sb = new StringBuilder("");
		for (int i = num.length - 1; i >= 0; i--)
			sb.append(str[i]);
		if (sb.charAt(0) == '0')
			return "0";
		return sb.toString();
	}

	class StringComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			if (s1.length() == 0 && s2.length() == 0)
				return 0;
			if (s2.length() == 0)
				return 1;
			if (s1.length() == 0)
				return -1;
			for (int i = 0; i < s1.length() && i < s2.length(); i++) {
				if (s1.charAt(i) > s2.charAt(i)) {
					return 1;
				} else if (s1.charAt(i) < s2.charAt(i)) {
					return -1;
				}
			}
			if (s1.length() == s2.length())
				return 0;
			if (s1.length() > s2.length()) {
				if (s1.charAt(0) < s1.charAt(s2.length()))
					return 1;
				else if (s1.charAt(0) > s1.charAt(s2.length()))
					return -1;
				else
					return compare(s1.substring(s2.length()), s2);
			} else {
				if (s2.charAt(0) < s2.charAt(s1.length()))
					return -1;
				else if (s2.charAt(0) > s2.charAt(s1.length()))
					return 1;
				else
					return compare(s1, s2.substring(s1.length()));
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		System.out.println(new Pro0179().largestNumber(nums));
	}

}
