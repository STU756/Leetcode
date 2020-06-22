package com.jia.leetCode;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class Pro0038 {
	 public String countAndSay(int n) {
	        if(n==1){
	            return "1";
	        }
	        Integer count=1;
	        int i;
	        String s=countAndSay(n-1);
	        StringBuilder nextString=new StringBuilder();
	        for(i=1;i<s.length();i++){
	            if(s.charAt(i)==s.charAt(i-1)){
	                count++;
	            }
	            else{
	                nextString.append(count.toString()+s.charAt(i-1));
	                count=1;
	            }           
	        }
	        nextString.append(count.toString()+s.charAt(i-1));
	        return nextString.toString();
	    }
}
