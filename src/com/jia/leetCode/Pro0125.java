package com.jia.leetCode;

public class Pro0125 {
    //filter char and reverse string
    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(('A' <= c && c <= 'Z') ||('a' <= c && c <= 'z') ||('0' <= c && c <= '9')) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase());
    }

    //
    public boolean isPalindrome3(String s) {
        if(s == null) { return false; }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        return s.toLowerCase().equals(new StringBuilder(s).reverse().toString().toLowerCase());
    }
    //two points
    public boolean isPalindrome(String s){
        if(s == null) { return false; }
        // if(s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left < right ) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
    public static void main(String[] args) {
//		String s = "A man, a plan, a canal: Panama";
		String s = "1a2";
		System.out.println(new Pro0125().isPalindrome(s));
	}
}
