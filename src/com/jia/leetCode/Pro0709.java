package com.jia.leetCode;

public class Pro0709 {
	   public String toLowerCase(String str) {
		   if(str == null || str.length() == 0)return "";
		   char[] resc = str.toCharArray();
		   for(int i =0; i < resc.length; i++) {
			   resc[i] = Character.toLowerCase(resc[i]);
		   }
	        return new String(resc);
	    }
	   public static void main(String[] args) {
		Pro0709 pro0709 = new Pro0709();
		System.out.println(pro0709.toLowerCase("Hello"));
		System.out.println(pro0709.toLowerCase("LOVELY"));
		System.out.println(pro0709.toLowerCase("here"));
	}
}
