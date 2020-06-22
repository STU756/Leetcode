package com.jia.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * m面试题40：
 * 
 * @author Administrator
 *
 */
public class Pro40 {
	/**
	 * 使用最小堆 大小为 K 的最小堆 复杂度：O(NlogK) + O(K) 特别适合处理海量数据
	 * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
	 * 
	 * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		if (input == null || input.length == 0 || k <= 0 || k > input.length)
			return new ArrayList<Integer>();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		for (int val : input) {
			heap.add(val);
			while (heap.size() > k) {
				heap.poll();
			}
		}
		return new ArrayList<>(heap);
	}

	/**
	 * 通过快排选择 复杂度 O(n) + O(1) 只有允许修改数组元素时才可以使用 快速排序的 partition() 方法，会返回一个整数 j 使得
	 * a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。可以利用这个特性找出数组的第
	 * K 个元素， 这种找第 K 个元素的算法称为快速选择算法。
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (input == null || input.length == 0 || k <= 0 || k > input.length) {
			return ret;
		}
		partition(input, 0, input.length - 1, k - 1);

		for (int i = 0; i < k; i++) {
			ret.add(input[i]);
		}
		// Collections.sort(ret);
		return ret;
	}

	private void partition(int[] array, int start, int end, int k) {
		/*** 快排partition函数原代码——start ***/
		int left = start;
		int right = end;

		int p = array[start];
		while (left < right) {
			while (left < right && array[right] >= p)
				--right;
			if (left < right)
				array[left++] = array[right];
			while (left < right && array[left] <= p)
				++left;
			if (left < right)
				array[right--] = array[left];
		}
		array[left] = p;

		/*** 定位判断 ***/
		if (left == k) {
			return;
		} else if (left > k) {
			partition(array, start, left - 1, k);
		} else {
			partition(array, left + 1, end, k);
		}
	}

	public static void main(String[] args) {
		Pro40 pro40 = new Pro40();
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int k = 4;
		pro40.GetLeastNumbers_Solution(input, k);
	}
}
