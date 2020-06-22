package com.jia.leetCode;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si <
 * ei)，请你判断一个人是否能够参加这里面的全部会议。
 * 
 * 示例 1:
 * 
 * 输入: [[0,30],[5,10],[15,20]] 输出: false 示例 2:
 * 
 * 输入: [[7,10],[2,4]] 输出: true
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/meeting-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0252 {
	public boolean canAttendMeetings(int[][] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			for (int j = i + 1; j < intervals.length; j++) {
				if (overlap(intervals, i, j))
					return false;
			}
		}
		return true;
	}

	private boolean overlap(int[][] intervals, int i, int j) {
		return Math.min(intervals[i][1], intervals[j][1]) > Math.max(intervals[i][0], intervals[j][0]);
	}

}
