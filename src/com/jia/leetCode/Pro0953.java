package com.jia.leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 953.验证外星语词典
 * 
 * @author Administrator
 *
 */
public class Pro0953 {
	public boolean isAlienSorted(String[] words, String order) {
		int[] dict = new int[26];
		for (int i = 0; i < order.length(); i++) {
			dict[order.charAt(i) - 'a'] = i;
		}
		boolean isDiff = false;
		for (int k = 0; k < words.length - 1; k++) {
			String str1 = words[k];
			String str2 = words[k + 1];
			for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					isDiff = true;
					if (dict[str1.charAt(i) - 'a'] > dict[str2.charAt(i) - 1]) {
						return false;
					}
					break;
				}
			}
			if (!isDiff) {
				if (str1.length() > str2.length())
					return false;
			}
		}
		return true;
	}
}
