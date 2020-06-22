package com.jia.leetCode;

public class Pro0344 {
	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public String reverseString2(String s) {
		char[] word = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char temp = word[i];
			word[i] = word[j];
			word[j] = temp;
			i++;
			j--;
		}
		return new String(word);

	}

	public String reverseString3(String s) {
		char[] word = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			word[i] = (char) (word[i] ^ word[j]);
			word[j] = (char) (word[i] ^ word[j]);
			word[i] = (char) (word[i] ^ word[j]);
			i++;
			j--;
		}
		return new String(word);

	}

	// Divide and Conquer(Recursive)
	// time:O(nlog n), space:O(log n)
	public String reverseString5(String s) {
		int length = s.length();
		if (length <= 1)
			return s;
		String leftStr = s.substring(0, length / 2);
		String rightStr = s.substring(length / 2, length);
		return reverseString(rightStr) + reverseString(leftStr);
	}
}
