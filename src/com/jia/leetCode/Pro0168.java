package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro0168 {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n != 0) {
			sb.append((char)((--n)%26 + 'A'));
			n /=26;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(new Pro0168().convertToTitle(2147483647));
	}
}
