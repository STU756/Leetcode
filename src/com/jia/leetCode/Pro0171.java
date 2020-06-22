package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro0171 {
	public int titleToNumber(String s) {
		int result = 0;
		int temp  = 1;
		if (s == null || s.length() == 0)
			return 0;
		for(int i = s.length()-1; i>=0; i--
		) {
			result = result + (s.charAt(i) - 'A' + 1) * temp;
			temp *= 26;
		}
		return result;
	}
	public static void main(String[] args) {
		String s = "AAA";
		System.out.println(new Pro0171().titleToNumber(s));
	}
}
