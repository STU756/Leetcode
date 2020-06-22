package com.jia.leetCode;
/**
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0680 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        boolean isDelete = false;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right) || !isDelete) {
                if(s.charAt(left) == s.charAt(right)) {
                    ++left;
                    --right;
                }else {
                    //删除一个字符
                    isDelete = true;
                    //删除左边  删除右边
                    return palindromeString(s, left+1, right) || palindromeString(s, left, right-1);
                }
            }else {
                return false;
            }
        }
        return left >= right;
    }
    private boolean palindromeString(String s, int left, int right) {
        if(left >= right) return true;
        return (s.charAt(left) == s.charAt(right)) && palindromeString(s, ++left, --right);
    }
    
    public static void main(String[] args) {
    	Pro0680 pro0680 = new Pro0680();
    	System.out.println(pro0680.palindromeString("abc", 0, 2));
    	System.out.println(pro0680.validPalindrome("abc"));
    	
    }
}
