package com.jia.leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pro1383 {
    /**
    *    将效率进行将序排序，每个人作为最低效率是，在其左边找出速度最大的k-1个和当前这个人的速度，求出最大的一个就是为题目所解
    **/
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];
        for(int i = 0; i < n; i++) {
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }
        Arrays.sort(items, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
        });
        Queue<Integer> queue = new PriorityQueue<Integer>();
        long sum = 0, res = 0;
        for(int i = 0; i < n; i++) {
        	if(queue.size() > k - 1) {
        		sum -= queue.poll();
        	}
        	res = Math.max(res, (sum + items[i][0]) * items[i][1]);
        	queue.add(items[i][0]);
        	sum+=items[i][0];
        }
        return (int)(res % ((int)1e9 + 7));
    }
}
