package com.jia.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class Pro0165 {
    public int compareVersion(String v1, String v2) {
    	String[] s1 = null;
    	String[] s2 = null;
    	if(v1.contains(".")) {
    		s1 = v1.split("\\.");
    	}else {
    		s1 = new String[1];
    		s1[0] = v1.toString();
    	}
    	if(v2.contains(".")) {
        	s2 = v2.split("\\.");
    	}else {
    		s2 = new String[1];
    		s2[0] = v2.toString();
    	}
    	System.out.println(Arrays.toString(s1));
    	System.out.println(Arrays.toString(s2));
        for(int i=0; i<s1.length&&i<s2.length; i++) {
        	if(Integer.parseInt(s1[i]) > Integer.parseInt(s2[i])) {
        		return 1;
        	}else if(Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])) {
        		return -1;
        	}
        }
        if(s1.length == s2.length) return 0;
        Pattern pattern = Pattern.compile("0+");
        if(s1.length > s2.length) {
        	int i = s2.length;
        	for(;i<s1.length; i++) {
        		if(!Pattern.matches("0+",s1[i])) 
        			return 1;
        	}
        	return 0;
        }else {
        	int i = s1.length;
        	for(; i<s2.length; i++) {
        		if(!Pattern.matches("0+",s2[i]))
        			return -1;
        	}
        	return 0;
        }
    }
	public static void main(String[] args) {
		String v1 = "1.0.0000";
		String v2 = "1";
		System.out.println(new Pro0165().compareVersion(v1, v2));
	}
}
