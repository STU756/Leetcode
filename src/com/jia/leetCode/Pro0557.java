package com.jia.leetCode;
/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

	示例 1:
	
	输入: "Let's take LeetCode contest"
	输出: "s'teL ekat edoCteeL tsetnoc" 
	注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0557 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        int pre = 0;
        int len = s.length();
        int i = 0;
        while(i<len&&Character.isWhitespace(s.charAt(i))) {i++;pre = i;}
        while(i<len){
        	char c = s.charAt(i);
        	if(i>0&&Character.isWhitespace(c)){ 
        		s = reverse(s,pre, i-1);
        		while(i<len&&Character.isWhitespace(s.charAt(i))) {i++;pre = i;}
        	}
        	else{
        		i++;
        	}
        }
        if(pre<len) s = reverse(s, pre, len-1);
        return s;
    }
    private  String reverse(String s, int start, int end){
    	char[] charArray = s.toCharArray();
    	while(start < end){
    		char temp = charArray[start];
    		charArray[start++] = charArray[end];
    		charArray[end--] = temp;
    	}
    	return new String(charArray);
    }
}
