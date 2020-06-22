package com.jia.leetCode;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class Pro0067 {
	 public String addBinary(String a, String b) {
	        if(a==null && b==null && a.length()==0 && b.length()==0) return null;
	        if(a == null && a.length() ==0) return b;
	        if(b == null && b.length()==0) return a;
	        int increse = 0;
	        int curValue = 0;
	        if(a.length() > b.length()) {
	        	String temp = a;
	        	a = b;
	        	b = temp;
	        }
	        StringBuilder sb = new StringBuilder();
	        int i=a.length()-1, j=b.length()-1;
	        for(; i>=0; i--, j--) {
	        	curValue = a.charAt(i)-'0' + b.charAt(j)-'0' + increse;
	        	increse = curValue / 2;
	        	curValue = curValue % 2;
	        	sb.append(curValue);
	        }
	        for(; j>=0; j--) {
	        	curValue = b.charAt(j) - '0' + increse;
	        	increse = curValue / 2;
	        	curValue = curValue % 2;
	        	sb.append(curValue);
	        }
	        if(increse==1) sb.append(increse);
	        return sb.reverse().toString();
	        
	    }
	 public static void main(String[] args) {
		String a = "11";
		String b= "1";
		System.out.println(new Pro0067().addBinary(a, b));
	}
}
