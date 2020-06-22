package com.jia.leetCode.pac.chater3;

import java.io.UnsupportedEncodingException;

public class Pro01 {
	/**
	 * 中文汉字有两个字节和三个字节
	 * @param str
	 * @param len
	 * @return
	 */
	public String truncateStr(String str, int len) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (char cc : str.toCharArray()) {
			int cLen = charLen(cc);
			if(count == len) 
				return sb.toString();
			if (cLen > 1) {         //汉字  包括占两个字节和三个字节
				if (count + cLen >= len)
					return sb.toString();
				sb.append(cc);
				count += cLen;
			} else if (cLen == 1) {  //普通ASSIC码
				++count;
				sb.append(cc);
			} else {
				break;
			}
		}
		return sb.toString();
	}
	/**
	 * 计算字符的长度，普通ASSIC占用一个字节，汉字占用两个或者三个字节
	 * @param c 输入字符
	 * @return  字符占用字节的长度
	 */
	private int charLen(char c) {
		return String.valueOf(c).getBytes().length;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		Pro01 pro01 = new Pro01();
		System.out.println(pro01.truncateStr("人ABC", 4));
		;
		System.out.println(pro01.truncateStr("人ABC门DEF", 6));
		;
	}
}
