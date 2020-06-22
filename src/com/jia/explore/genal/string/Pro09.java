package com.jia.explore.genal.string;

import java.util.Arrays;
/**
 * 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 * @author Administrator
 *
 */
public class Pro09 {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        Arrays.toString(strs);
        int len = Math.min(strs[0].length(),strs[strs.length - 1].length());
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < len && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) sb.append(strs[0].charAt(i++)) ; 
        return sb.toString();
    }
    public static void main(String[] args) {
//    	String[] strs = {"flower","flow","flight"};
    	String[] strs = {"dog","racecar","car"};
		Pro09 pro09 = new Pro09();
		System.out.println(pro09.longestCommonPrefix(strs));
	}
}
