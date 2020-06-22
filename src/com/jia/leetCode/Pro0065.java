package com.jia.leetCode;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 * 
 * Update (2015-02-10): The signature of the C++ function had been updated. If
 * you still see your function signature accepts a const char * argument, please
 * click the reload button to reset your code definition.
 * 
 * @author Administrator
 *
 */
public class Pro0065 {
	public boolean isNumber(String s) {
		int j = 0, n = s.length();
		while (j < n && Character.isWhitespace(s.charAt(j)))
			j++;
		if (j < n && (s.charAt(j) == '+' || s.charAt(j) == '-'))
			j++;
		boolean isNumeric = false;
		while (j < n && Character.isDigit(s.charAt(j))) {
			j++;
			isNumeric = true;
		}
		if (s.charAt(j) == '.') {
			j++;
			while (j < n && Character.isDigit(s.charAt(j))) {
				j++;
				isNumeric = true;
			}
		}
		if (j < n && s.charAt(j) == 'e') {
			j++;
			isNumeric = false;
			if(j <n && (s.charAt(j) == '+' || s.charAt(j) == '-')) j++;
			while (j < n && Character.isDigit(s.charAt(j))) {
				j++;
				isNumeric = true;
			}
		}
		while (j < n && Character.isWhitespace(s.charAt(j)))
			j++;
		return isNumeric && j == n;
	}
}
