package com.jia.leetCode;
/**
 * 增减字符串匹配
 * 
 * 
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

如果 S[i] == "I"，那么 A[i] < A[i+1]
如果 S[i] == "D"，那么 A[i] > A[i+1]
 

示例 1：

输出："IDID"
输出：[0,4,1,3,2]
示例 2：

输出："III"
输出：[0,1,2,3]
示例 3：

输出："DDI"
输出：[3,2,0,1]
 

提示：

1 <= S.length <= 1000
S 只包含字符 "I" 或 "D"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-string-match
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0942 {
	/**
	 * 
	 * 'D'代表着倒序，'I'代表生序，那么如果为'D'，只要取最大值max，同时最大值减一，作为下一个'D'的最大值；如果为'I'，则正好相反，取最小值min，同时加一，作为下一个'I'的最小值；剩下最后一个值，max=min，取啥都行

	 * @param S
	 * @return
	 */
    public int[] diStringMatch(String S) {
    	int sLen = S.length();
    	int[] ans = new int[sLen + 1];
    	int max = sLen;
    	int min = 0;
    	for(int i = 0; i < sLen; i++) {
    		if('D' == S.charAt(i)) {
    			ans[i] = max--;
    		}else {
    			ans[i] = min++;
    		}
    	}
    	ans[sLen] = max;
    	return ans;
    }
}
