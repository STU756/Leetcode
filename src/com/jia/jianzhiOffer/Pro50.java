package com.jia.jianzhiOffer;

import java.util.HashMap;
/**
 * interview problem 50:第一个只出现一次的字符 
 * @author Administrator
 *
 */
public class Pro50 {
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    StringBuilder sb = new StringBuilder();
    int len = 0;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
    	map.put(ch, map.getOrDefault(ch, 0) + 1);
    	sb.append(ch);
    	++len;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i = 0; i < len; i++) {
        	char c = sb.charAt(i);
        	if(map.get(c) == 1)
        		return c;
        }
        return '#';
    }
    
    //nowcoder
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if(len == 0) return -1;
        HashMap<Character,Integer> map  = new HashMap<Character,Integer>();
        for(int i = 0; i < len; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for(int i = 0; i < len; i++)
            if(map.get(str.charAt(i)) == 1)
                return i;
        return -1;
    }
    //leetcode
    public char firstUniqChar(String str) {
        int len = str.length();
        if(len == 0) return ' ';
        HashMap<Character,Integer> map  = new HashMap<Character,Integer>();
        for(int i = 0; i < len; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if(map.get(c) == 1)
                return c;
        }
        return ' ';
    }
}
