package com.jia.leetCode;

public class Pro0008 {
	private static int MAXDIV10 = Integer.MAX_VALUE / 10;
    public int myAtoi(String str) {
    	int len = str.length();
        if(null == str || len == 0) return 0;
        int i = 0;
        int sign = 1;
        while(i<len && Character.isSpaceChar(str.charAt(i))) ++i;
        while(i<len && Character.isSpaceChar(str.charAt(i))) ++i;
        if(i<len && str.charAt(i) == '-'){
        	sign = -1;
        	++i;
        }else if(i<len && str.charAt(i) == '+') {
        	++i;
        }
        int ret = 0;
        while(i< len && Character.isDigit(str.charAt(i))) {
        	int numericValue = Character.getNumericValue(str.charAt(i));
        	//-2147483648
        	//2147483647
        	if(ret > MAXDIV10 || (ret == MAXDIV10 && numericValue >=8)) {
        		return (sign >= 0)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        	}
        	ret = ret * 10 + numericValue;
        	++i;
        }
        return sign * ret;
    }
    
	public int atoi2(String str) {
	     long result = 0;
	     int i = 0;
	     boolean flag = false;
	     str = str.trim();
	     if(str.equals("")) return 0;
	     if(str.charAt(0) == '-'){
	    	 flag = true;
	    	 i++;
	     }
	     if(str.charAt(0) == '+')
	    	 i++;
	     for(; i<str.length(); i++) {
	    	 if(str.charAt(i) > '9' || str.charAt(i) < '0')
	    		 break;
	    	 int a = (int) str.charAt(i) - '0';
	    	 result = result * 10 + a;
	    	 if(result > 0x7fffffff) {
	    		 if(flag)
	    			 return 0x7fffffff * -1 - 1;
	    		 else
	    			 return 0x7fffffff;
	    	 }
	     }
	     if(flag)
	    	 return (int) result * -1;
	     else 
	    	 return (int) result;
	}
    public static void main(String[] args) {
    	Pro0008 pro0008 = new Pro0008();
//    	String str = "-2147483648";
//    	System.out.println(pro0008.myAtoi(str));
//    	String str1 = "-2147483649";
//    	System.out.println(pro0008.myAtoi(str1));
    	String str2 ="2147483646";
    	System.out.println(pro0008.myAtoi(str2));
	}
}
