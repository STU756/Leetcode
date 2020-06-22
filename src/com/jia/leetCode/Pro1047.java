package com.jia.leetCode;

import java.util.Stack;

/**
 * 删除字符串中的所有相邻的重复项
 * 
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 
 *  
 * 
 * 示例：
 * 
 * 输入："abbaca" 输出："ca" 解释： 例如，在 "abbaca" 中，我们可以删除 "bb"
 * 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa"
 * 可以执行重复项删除操作，所以最后的字符串为 "ca"。  
 * 
 * 提示：
 * 
 * 1 <= S.length <= 20000 S 仅由小写英文字母组成。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro1047 {
	public String removeDuplicates2(String S) {
		String suf = "";
		String pre = "";
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i - 1) == S.charAt(i)) {
				if (i < S.length())
					suf = S.substring(i + 1);
				else
					suf = "";
				pre = S.substring(0, i-1);
				S = pre + suf;
				i = 0;
			}
		}
		return S;
	}
	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		int len = S.length();
		for(int i = 0; i < len; i++) {
			if(!stack.isEmpty()) {
				if(stack.peek() == S.charAt(i)) {
					stack.pop();
					continue;
				}
			}
			stack.push(S.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		stack.forEach(c -> sb.append(c));
		return sb.toString();
	}
	public static void main(String[] args) {
		Pro1047 pro1047 = new Pro1047();
		System.out.println(pro1047.removeDuplicates("abbaca"));
	}
}
