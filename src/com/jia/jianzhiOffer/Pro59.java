package com.jia.jianzhiOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 面试题59：滑动窗口最大值
 * 
 * 题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。

例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，
他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 * 
 * @author Administrator
 *
 */
public class Pro59 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> ret = new ArrayList<>();
		if (size > num.length || size < 1)
	        return ret;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1,o2)-> o2 - o1);
		for(int i = 0; i < size; i++) {
			maxHeap.add(num[i]);
		}
		ret.add(maxHeap.peek());
		for(int i = 0, j = i+size; j<num.length; j++, i++) {
			maxHeap.remove(num[i]);
			maxHeap.add(num[j]);
			ret.add(maxHeap.peek());
		}
		return ret;
	}
	
}
