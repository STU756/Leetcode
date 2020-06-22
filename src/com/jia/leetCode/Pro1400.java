package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 1400. 构造 K 个回文字符串
 * 
 * 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。

如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。

 

示例 1：

输入：s = "annabelle", k = 2
输出：true
解释：可以用 s 中所有字符构造 2 个回文字符串。
一些可行的构造方案包括："anna" + "elble"，"anbna" + "elle"，"anellena" + "b"
示例 2：

输入：s = "leetcode", k = 3
输出：false
解释：无法用 s 中所有字符构造 3 个回文串。
示例 3：

输入：s = "true", k = 4
输出：true
解释：唯一可行的方案是让 s 中每个字符单独构成一个字符串。
示例 4：

输入：s = "yzyzyzyzyzyzyzy", k = 2
输出：true
解释：你只需要将所有的 z 放在一个字符串中，所有的 y 放在另一个字符串中。那么两个字符串都是回文串。
示例 5：

输入：s = "cr", k = 7
输出：false
解释：我们没有足够的字符去构造 7 个回文串。
 

提示：

1 <= s.length <= 10^5
s 中所有字符都是小写英文字母。
1 <= k <= 10^5
通过次数1,657提交次数
 * 
 * @author Administrator
 *
 */
public class Pro1400 {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if((entry.getValue() & 0x1) == 1) ++oddCount;
        }
        if(oddCount > k) return false;
        return true;
    }
    public boolean canConstruct2(String s, int k) {
        int len = s.length();
        if(len < k) return false;
        /**
        1 <= s.length <= 10^5
        s 中所有字符都是小写英文字母。
        1 <= k <= 10^5
        **/
        int[] charCount = new int[26];
        for(int i = 0 ; i < len; i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        int oddCount = 0;
        for(int i = 0; i <charCount.length; i++) {
            if(((charCount[i] & 0x1) == 1)) ++oddCount;
        }
        if(oddCount > k) return false;
        return true;
    }
}
