package com.jia;

import java.util.Arrays;
import java.util.Comparator;

public class TestDemo {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        String temp = s2;
        s2 += s2;
        s2 = s2.replaceFirst(s1, "");
        return s2.equals(temp);
    }
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.isFlipedString(s1, s2));;
    }


    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int last = 0;
        int index = 0;
        int[][] res = new int[intervals.length][2];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= intervals[last][1]) {
                intervals[last][1] = Math.max(intervals[last][1], intervals[i][1]);
            }else {
                res[index][0] = intervals[last][0];
                res[index][1] = intervals[last][1];
                last = i;
                ++index;
            }
        }
        //处理最后一个
        res[index][0] = intervals[last][0];
        res[index][1] = intervals[last][1];
        return Arrays.copyOf(res, index + 1);
    }







    public boolean patternMatching(String pattern, String value) {
        //1.pattern为空
        if(pattern.length() == 0) return value.length() == 0;
        //2.pattern不为空
        //2.1 value为空
        if(value.length() == 0) {
            //全部为a或者全部为b
            int i = 0;
            while(i < pattern.length() && pattern.charAt(i) == pattern.charAt(0)) ++i;
            return i == pattern.length();
        }
        //2.2 value不为空
        int pLen = pattern.length(), vLen = value.length();
        int aCnt = 0;//记录pattern中a的个数
        int bCnt = 0;//记录pattern中b的个数
        for(int i = 0; i < pLen; i++) {
            if(pattern.charAt(i) == 'a') {
                ++aCnt;
            }else if(pattern.charAt(i) == 'b'){
                ++bCnt;
            }
        }
        //2.2.1假设pattern中a的个数为0，或者b的个数为0
        if(aCnt == 0) return helper(value, bCnt);
        if(bCnt == 0) return helper(value, aCnt);
        //2.2.2 假设a，b其中有一个为空
        if(helper(value, aCnt)) return true; //b为空
        if(helper(value, bCnt)) return true;// a为空
        //2.2.3 a,b都不为空，枚举a,b匹配的长度，使得a * len_a + b * len_b = vLen;
        //len_a唯一确定len_b，只需枚举len_a
        for(int len_a = 1; len_a * aCnt <= vLen - bCnt; len_a ++) {
            if((vLen - len_a * aCnt) % bCnt != 0) continue;
            int len_b = (vLen - len_a * aCnt) / bCnt;
            if(check(pattern, value, len_a, len_b)) return true;
        }
        return false;
    }
    private boolean check(String pattern, String value, int len_a, int len_b) {
        String strA = "", strB = "";
        for(int i = 0, j = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'a') {
                if("".equals(strA)) {
                    strA = value.substring(j, j+len_a);
                    j += len_a;
                }else {
                    for(int k = 0; k < len_a; k++) {
                        if(value.charAt(j) != strA.charAt(k)){
                            return false;
                        }
                        ++j;
                    }
                }
            }else if(pattern.charAt(i) == 'b') {
                if("".equals(strB)) {
                    strB = value.substring(j, j + len_b);
                    j += len_b;
                }else {
                    for(int k = 0; k < len_b; k++) {
                        if(value.charAt(j)!= strB.charAt(k)) {
                            return false;
                        }
                        ++j;
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }


    private boolean helper(String str, int k) {
        if(str == null || str.length() == 0) { return false; }
        int len = str.length();
        if(len % k != 0) { return false; }
        int substrLen = len / k;
        for(int i = 0, j = 0; i < len; i++, j++){
            if(j == substrLen) { j = 0;}
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}
