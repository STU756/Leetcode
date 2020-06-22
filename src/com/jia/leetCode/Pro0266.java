package com.jia.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 266. 回文排列
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。

示例 1：

输入: "code"
输出: false
示例 2：

输入: "aab"
输出: true
示例 3：

输入: "carerac"
输出: true

 * @author Administrator
 *
 */
public class Pro0266 {
    public boolean canPermutePalindrome(String s) {
    	Set<Character> set = new HashSet<Character>();
    	for(int i =0 ; i < s.length(); i++) {
    		if(set.contains(s.charAt(i))) {
    			set.remove(s.charAt(i));
    		}else {
    			set.add(s.charAt(i));
    		}
    	}
    	return set.size() < 2;
    }
}
