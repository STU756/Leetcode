package com.jia.leetCode;

public class Pro0084 {
	//暴力求解
    public int largestRectangleArea2(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int result = 0;
        for(int i = 0; i< heights.length; i++) {
        	for(int j = i; j < heights.length; j++) {
        		result = Math.max(result, minHeight(heights, i, j) * (j -i + 1));
        	}
        }
        return result;
    }
    /**
     * 返回数组height下表left到right的最小值
     * @param heights
     * @param left
     * @param right
     * @return
     */
	private int minHeight(int[] heights, int left, int right) {
		int minHeight = heights[left];
		for(int i = left+1; i <= right; i++) {
			minHeight = Math.min(minHeight, heights[i]);
		}
		return minHeight;
	}

	/**
	 *
	 * 二分求解  O(NlogN)
	 * @param heights
	 * @return
	 */
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) return 0;
		return help(heights, 0, heights.length - 1);
	}
	//类似快排的partition
	private int help(int[] heights, int l, int r) {
		if(l > r) return 0;
		//找出最低的一个柱子
		int min = l;
		for(int i = l + 1; i <= r; i++) {
			if(heights[min] > heights[i]) {
				min = i;
			}
		}
		//当前[l,r]最大矩形为  长*高 = (r - l + 1) * heights[min]
		int area = (r - l + 1) * heights[min];
		//二分为左半部分和又半部分  [l, min - 1] 和 [min+1, r]
		area = Math.max(area, help(heights, l, min - 1));
		area = Math.max(area, help(heights, min+1, r));
		return area;
	}

	public static void main(String[] args) {
		Pro0084 pro0084 = new Pro0084();
		int[] heights = {4,2,0,3,2,4,3,4};
		System.out.println(pro0084.largestRectangleArea(heights));
	}
}
