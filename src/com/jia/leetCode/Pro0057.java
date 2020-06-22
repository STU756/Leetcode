package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Insert Interval 
 * @author Jia
 *
 */
class Interval {
	int start;
	int end;
	Interval(){start=0; end =0;}
	Interval(int s, int e) {start = s; end = e;}
}
public class Pro0057 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for(Interval i: intervals) {
			if(newInterval == null || i.end <newInterval.start) {
				result.add(i);
			}else if(i.start>newInterval.end) {
				result.add(newInterval);
				result.add(i);
				newInterval = null;
			}else {
				newInterval.start = Math.min(newInterval.start,i.start);
				newInterval.end = Math.max(newInterval.end, i.end);
			}
		}
		if(newInterval != null)
			result.add(newInterval);
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = null;
		Arrays.sort(arr);
	}
	
}
