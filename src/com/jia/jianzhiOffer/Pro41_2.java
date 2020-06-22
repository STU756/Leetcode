package com.jia.jianzhiOffer;

import java.util.HashMap;

/**
 * 面试题41.2：字符流中的第一个不重复的字符串
 * 
 * 题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * @author Administrator
 *
 */
public class Pro41_2 {
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
}
