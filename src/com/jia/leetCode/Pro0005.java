package com.jia.leetCode;

public class Pro0005 {
    public String longestPalindrome(String s) {
    	if(null == s || s.length() == 0) return "";
    	int max  = 0;
    	String retStr = "";
        for(int i =0; i < s.length(); i++) {
        	for(int j = 0; j < s.length(); j++) {
        		if(isPalindrome(s, i, j) && j - i + 1 >= max) {
        			max = j-i+1;
        			retStr = s.substring(i, j+1);
        		}
        	}
        }
        return retStr;
    }

	private boolean isPalindrome(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "a";
		Pro0005 pro0005 = new Pro0005();
		System.out.println(pro0005.longestPalindrome(s));
	}
}
