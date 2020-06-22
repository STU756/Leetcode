package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0055 {
	public boolean canJump(int[] A) {
		if (A.length == 1)
			return true;
		int low = 0;
		int high = A[0];
		while (high < A.length - 1) {
			int oldHigh = high;
			for (int i = low; i <= oldHigh; i++) {
				high = Math.max(high, i + A[i]);
			}
			if (low == high)
				return false;
			low = oldHigh;
		}
		return true;

	}

}
