package com.jia.leetCode;

import java.util.HashSet;
import java.util.Set;

public class Pro0859 {
    public boolean buddyStrings(String A, String B) {
        int aLen = A.length();
        int bLen = B.length();
        if(aLen != bLen || aLen < 2) { return false; }
        if(A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < aLen; i++) {
                if(set.contains(A.charAt(i))) {
                    return true;
                }
                set.add(A.charAt(i));
            }
            return false;
        }
        //tow pointer
        int left = 0, right = aLen - 1;
        int changeCount = 1;
        while(left < right) {
            while(left < right && A.charAt(left) == B.charAt(left)) ++left;
            while(left < right && A.charAt(right) == B.charAt(right)) -- right;
            if(changeCount > 0 && left < right && A.charAt(left) == B.charAt(right) && A.charAt(right) == B.charAt(left)) {
                left ++;
                right --;
                --changeCount;
            }else {
                break;
            }
        }
        return (left < right || changeCount == 1)? false : true;
    }
    public static void main(String[] args) {
        Pro0859 pro0859 = new Pro0859();
        System.out.println(pro0859.buddyStrings("aa","aa"));;
        System.out.println(pro0859.buddyStrings("ab","ab"));;
        System.out.println(pro0859.buddyStrings("ab","ba"));;
    }
}
