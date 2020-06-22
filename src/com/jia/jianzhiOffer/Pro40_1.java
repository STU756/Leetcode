package com.jia.jianzhiOffer;

import java.util.ArrayList;
/**
 * 
 * 面试题40.1:数据流中的中位数
 * 题目描述
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
使用GetMedian()方法获取当前读取数据的中位数
 * 
 * @author Administrator
 *
 */
public class Pro40_1 {
	private ArrayList<Integer> data = new ArrayList<Integer>();
	private boolean state = true;
	//插入
	public void Insert(Integer num) {
		data.add(num);
	}
	
	public Double GetMedian() {
		if(data.size() ==0) {
			state = false;
			return -1.;
		}
		int r1 = partition(data, 0, data.size()-1, data.size() / 2);
		if((data.size()&1) == 1)
			return (double)r1;
		int r2 = partition(data, 0, data.size()-1, (data.size()-1) / 2);
		return (r2 + r1) / 2.;
	}
	private int partition(ArrayList<Integer> data, int start, int end, int k) {
		/*** 快排partition函数原代码——start ***/
		int left = start;
		int right = end;

		int p = data.get(start);
		while (left < right) {
			while (left < right && data.get(right) >= p)
				--right;
			if (left < right) {
				swap(data, left, right);
				++left;
			}
			while (left < right && data.get(left) <= p)
				++left;
			if (left < right) {
				swap(data, left, right);
				--right;
			}
		}
		data.set(left, p);

		/*** 定位判断 ***/
		if (left == k) {
			return data.get(k);
		} else if (left > k) {
			return partition(data, start, left - 1, k);
		} else {
			return partition(data, left + 1, end, k);
		}
	}
	private void swap(ArrayList<Integer> data, int index1, int index2) {
		int tmp = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, tmp);
	}
}
