package com.jia.explore.genal.string;

import java.util.HashMap;
import java.util.Map;
/**
 * 
  字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 

注意事项：您可以假定该字符串只包含小写字母。
 * @author Administrator
 *
 */
public class Pro03 {
    public int firstUniqChar(String s) {
    	int len = s.length();
    	Map<Character, Integer> map = new HashMap<Character,Integer>();
    	for(int i = 0; i< len; i++) {
    		map.put(s.charAt(i), map.containsKey(s.charAt(i))? map.get(s.charAt(i)) + 1 : 1);
    	}
    	for(int i = 0; i < len; i++) {
    		if(map.get(s.charAt(i)) == 1) return i;
    	}
    	return - 1;
    }
}
