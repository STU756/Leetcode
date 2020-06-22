package com.jia.leetCode;

public class Pro0014 {
    public String longestCommonPrefix(String[] strs) {
    	if(null == strs || strs.length == 0) return "";
    	String res = strs[0];
    	for(int i = 1; i < strs.length; i++) {
    		while(strs[i].indexOf(res) != 0) {
    			res = res.substring(0, res.length() - 1);
    		}
    	}
    	return res;
    }
    
	public String longestCommonPrefix2(String[] strs) {
		if(strs == null || strs.length ==0) return "";
		StringBuilder sb = new StringBuilder();
	    for(int i=0; i<strs[0].length(); i++) {
	    	char c = strs[0].charAt(i);
	    	for(String str : strs) {
	    		if((i>= str.length()) || (c != str.charAt(i))) {
	    			return sb.toString();
	    		}
	    	}
	    	sb.append(c);
	    }
	    return sb.toString();
	 }
    public static void main(String[] args) {
		Pro0014 pro0014 = new Pro0014();
		String[] strs = {"flower","flow","flight"};
		System.out.println(pro0014.longestCommonPrefix(strs));
	}
}
