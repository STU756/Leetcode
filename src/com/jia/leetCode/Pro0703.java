package com.jia.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * 703. 数据流中的第K大元素 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 
 * 你的 KthLargest 类需要一个同时接收整数 k
 * 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * 
 * 示例:
 * 
 * int k = 3; int[] arr = [4,5,8,2]; KthLargest kthLargest = new KthLargest(3,
 * arr); kthLargest.add(3);   // returns 4 kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5 kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8 说明: 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * 
 * @author Administrator
 *
 */
public class Pro0703 {
	Queue<Integer> queue;
	int k;

	public Pro0703(int k, int[] nums) {
		this.k = k;
		queue = new PriorityQueue<Integer>(k);
		for (int num : nums) {
			add(num);
		}
	}

	public int add(int val) {
		if (queue.size() < k) {
			queue.add(val);
		} else if (queue.peek() < val) {
			queue.poll();
			queue.add(val);
		}
		return queue.peek();
	}

	public static void main(String[] args) {
		Pro0703 pro0703 = new Pro0703(3, new int[] { 4, 5, 8, 2 });
		System.out.println("aa");

	}
}
