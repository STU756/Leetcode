package com.jia.leetCode;

public class Pro0169 {
	/**
	 * 方法二：使用快排中的partition找出中位数，再利用中位数进行统计是否符合要求超过一半的数
	 */

	public int majorityElement(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int result = partition(array, 0, array.length - 1);
		if (checkMoreThanHalf(array, result)) {
			return result;
		}
		return 0;
	}

	private boolean checkMoreThanHalf(int[] array, int result) {
		int len = array.length;
		int count = 0;
		for (int val : array) {
			if (result == val) {
				++count;
			}
			if (count > len / 2)
				return true;
		}
		return false;
	}

	private int partition(int[] array, int start, int end) {
		/*** 快排partition函数原代码——start ***/
		int left = start;
		int right = end;

		int p = array[start];
		while (left < right) {
			while (left < right && array[right] >= p) right--;
				;
			if (left < right)
				array[left++] = array[right];
			while (left < right && array[left] <= p) left++;
				;
			if (left < right)
				array[right--] = array[left];
		}
		array[left] = p;

		/*** 定位判断 ***/
		if (left == array.length / 2) {
			return array[left];
		} else if (left > array.length / 2) {
			return partition(array, start, left - 1);
		} else {
			return partition(array, left + 1, end);
		}
	}
	public static void main(String[] args) {
		int[] array = {3,2,3};
		Pro0169 pro0169 = new Pro0169();
		System.out.println(pro0169.majorityElement(array));
	}
}
