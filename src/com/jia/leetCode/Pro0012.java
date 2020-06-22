package com.jia.leetCode;

public class Pro0012 {
	public String intToRoman(int num) {
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < values.length; i++) {
			while(num>=values[i]) {
				num -= values[i];
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Pro0012 pro0012 = new Pro0012();
		System.out.println(pro0012.intToRoman(1));
		System.out.println(pro0012.intToRoman(2));
		System.out.println(pro0012.intToRoman(4));
		System.out.println(pro0012.intToRoman(9));
		System.out.println(pro0012.intToRoman(58));
		System.out.println(pro0012.intToRoman(1994));
	}
}
