package com.jia.leetCode;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class Pro0058 {
	public int lengthOfLastWord(String s) {
		if(s==null || s.length() ==0) return 0;
		String[] strArr = s.split(" +");
		if(strArr.length > 0)
		    return strArr[strArr.length-1].length();
		 else return 0;
	}
	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(new Pro0058().lengthOfLastWord(s));
	}
}
