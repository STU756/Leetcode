package com.jia.leetCode;
/**
 * 字符的最短距离
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

示例 1:

输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
说明:

字符串 S 的长度范围为 [1, 10000]。
C 是一个单字符，且保证是字符串 S 里的字符。
S 和 C 中的所有字母均为小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0821 {
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        //找出前两个出现的位置
        int l = S.indexOf(C), r = S.indexOf(C, l + 1);
        for(int i = 0; i< S.length(); i++) {
        	//计算左指针的距离
        	ans[i] = Math.abs(l - i);
        	if(r!=-1) {//如果右指针存在，取较小距离
        		ans[i] = Math.min(ans[i], r - i);
        		if(i == r) {
        			ans[i] = 0;
        			l = r;
        			r = S.indexOf(C, r + 1);
        		}
        	}
        }
        return ans;
    }
}
