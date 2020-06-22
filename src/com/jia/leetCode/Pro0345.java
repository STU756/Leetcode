package com.jia.leetCode;
/**
 * 345. 反转字符串中的元音字母
 * 
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

	示例 1:
	
	输入: "hello"
	输出: "holle"
	示例 2:
	
	输入: "leetcode"
	输出: "leotcede"
	说明:
	元音字母不包含字母"y"。

 * 
 * 
 * @author Administrator
 *
 */
public class Pro0345 {
	public String reverseVowels(String s) {
		String vowels = "aeiouAEIOU";
		int start = 0, end = s.length() - 1;
		char[] chars = s.toCharArray();
		while(start < end) {
			while(start < end && !vowels.contains(s.charAt(start)+"")) ++ start;
			while(start < end && !vowels.contains(s.charAt(end) +"")) --end;
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			++start;
			--end;
		}
		return new String(chars);
	}
}
