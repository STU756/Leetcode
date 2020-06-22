package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Pro0022 {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generateOneByOne("", result, n, n);
		return result;
	}

	private void generateOneByOne(String str, List<String> result, int left, int right) {
		if(left > right) return;
		if(left > 0) {
			generateOneByOne(str + "(", result, left- 1, right);
		}
		if(right > 0) {
			generateOneByOne(str + ")", result, left, right - 1);
		}
		if(left == 0 && right == 0) {
			result.add(str);
			return;
		}
	}
}
