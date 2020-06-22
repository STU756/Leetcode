package com.jia.leetCode;

/**
 * 1271.十六进制魔术数字
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro1271 {
	/**
	 *只包含 {"A", "B", "C", "D", "E", "F", "I", "O"} ，那么我们就认为这个转换是有效的。

	给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回 "ERROR" 。

	 * 
	 * @param num
	 * @return
	 */
	public String toHexspeak(String num) {
		String[] strs = { "O", "I", "", "", "", "", "", "", "", "", "A", "B", "C", "D", "E", "F" };
		Long number = Long.valueOf(num), remainder;
		StringBuilder sb = new StringBuilder();
		while(number!=0) {
			remainder = number % 16;
			if(remainder>1 && remainder<10)
				return "ERROR";
			number /= 16;
			sb.append(strs[remainder.intValue()]);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Pro1271 pro1271 = new Pro1271();
		System.out.println(pro1271.toHexspeak("257"));
		;
	}
}
