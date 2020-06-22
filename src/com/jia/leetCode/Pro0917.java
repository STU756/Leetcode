package com.jia.leetCode;
/**
 * 917.仅仅反转字母
 * 
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
	示例 1：
	
	输入："ab-cd"
	输出："dc-ba"
	示例 2：
	
	输入："a-bC-dEf-ghIj"
	输出："j-Ih-gfE-dCba"
	示例 3：
	
	输入："Test1ng-Leet=code-Q!"
	输出："Qedo1ct-eeLg=ntse-T!"
	 
	
	提示：
	
	S.length <= 100
	33 <= S[i].ASCIIcode <= 122 
	S 中不包含 \ or "

 * @author Administrator
 *
 */
public class Pro0917 {
	//two points partition
    public String reverseOnlyLetters(String S) {
        if(S == null || S.length() == 0) return "";
        int left = 0, right = S.length() - 1;
        char[] charArray = S.toCharArray();
        while(left < right) {
        	while(left < right && !Character.isLetter(charArray[left])) ++left;
        	while(left < right && !Character.isLetter(charArray[right])) --right;
        	if(left < right) {
        		swap(charArray, left, right);
        		++left;
        		--right;
        	}
        }
        return new String(charArray);
    }

	private void swap(char[] charArray, int left, int right) {
		char temp = charArray[left];
		charArray[left] = charArray[right];
		charArray[right] = temp;
	}
}
