package com.jia.leetCode.array;

public class PermutationTest {
	public void permutation(String str) {
		if (str == null || str.length() == 0) {
			System.out.println(str);
			return;
		}
		char[] c = str.toCharArray();
		permutation(c, 0, c.length - 1);
	}

	private void permutation(char[] c, int from, int to) {
		if (from == to) {
			for (int i = 0; i <= to; i++) {
				System.out.print(c[i]);
			}
			System.out.println();
		}

		for (int i = from; i <= to; i++) {
			if (!isSwap(c, from, i))
				continue;
			swap(c, i, from);
			permutation(c, from + 1, to);
			swap(c, i, from);
		}

	}

	private boolean isSwap(char[] c, int from, int to) {
		boolean bCan = true;
		for (int i = from; i < to; i++) {
			if (c[to] == c[i]) {
				bCan = false;
				break;
			}
		}
		return bCan;
	}

	private void swap(char[] c, int i, int from) {
		char temp = c[i];
		c[i] = c[from];
		c[from] = temp;
	}

	public static void main(String[] args) {
		PermutationTest p = new PermutationTest();
		p.permutation("aacd");
	}
}
