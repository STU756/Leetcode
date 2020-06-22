package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram" 输出: true 示例 2:
 * 
 * 输入: s = "rat", t = "car" 输出: false
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0242 {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null)
			return (s == null && t == null) ? true : false;
		if (s.length() == 0 || t.length() == 0)
			return (s.length() == 0 && t.length() == 0) ? true : false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!map.containsKey(c)) {
				return false;
			} else {
				if (map.get(c) - 1 == 0) {
					map.remove(c);
				} else {
					map.put(c, map.get(c) - 1);
				}
			}
		}
		return map.size() == 0 ? true : false;
	}

	public static void main(String[] args) {
		Pro0242 pro0242 = new Pro0242();
		System.out.println(pro0242.isAnagram("rat", "car"));
		System.out.println(pro0242.isAnagram("anagram", "nagaram"));
	}
}
