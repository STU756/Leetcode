package com.jia.leetCode;
/**
 * 686. 重复叠加字符串匹配
 * 
 * @author Administrator
 *
 */
public class Pro0686 {
    public int repeatedStringMatch(String A, String B) {
        String temp = A;
        int dumplicatedCount = 1;
        while(A.length() < B.length()) {
            A += temp;
            ++dumplicatedCount;
        }
        if(A.indexOf(B) == -1) {
            A+=temp;
            ++dumplicatedCount;
            if(A.indexOf(B) == -1) 
                return -1;
        }
        return dumplicatedCount;
    }
}
