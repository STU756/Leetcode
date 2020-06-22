package com.jia.leetCode;
/**
 * 796.旋转字符串
 * 
 * 给定两个字符串, A 和 B。

	A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
	
	示例 1:
	输入: A = 'abcde', B = 'cdeab'
	输出: true
	
	示例 2:
	输入: A = 'abcde', B = 'abced'
	输出: false
	注意：
	
	A 和 B 长度不超过 100。

 * 
 * @author Administrator
 *
 */
public class Pro0796 {
    public boolean rotateString(String A, String B) {
        if(A == null || B == null) return false;
        int aLen = A.length(), bLen = B.length();
        if(aLen!=bLen) return false;
        if(aLen == 0) return true; // ""  "" 空字符串
        int a = 1, b = 0;
        while(a<aLen) {
            if(A.charAt(a) == B.charAt(b)) {
                int i  = a + 1;
                if(i == aLen) i = 0;
                while(i!=a&&A.charAt(i) == B.charAt(++b)) {
                    ++i;
                    if(i == aLen)
                        i = 0;
                }
                if(i == a) return true;
            }
            a++;
            b = 0;
        }
        return false;
    }
    
    public static void main(String[] args) {
		Pro0796 pro0796 = new Pro0796();
		pro0796.rotateString("abcde", "cdeab");
	}
}
