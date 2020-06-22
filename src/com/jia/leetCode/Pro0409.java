package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 409.最长回文串
 * 
 * 
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 
 * @author Administrator
 *
 */
public class Pro0409 {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            sum += entry.getValue() / 2 * 2;
        }
        return sum < s.length()? sum + 1 : sum;
    }
}
