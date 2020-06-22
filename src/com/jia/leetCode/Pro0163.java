package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Pro0163 {
	public List<String> findMissingRanges(int[] vals, int start, int end){
		List<String> ranges = new ArrayList<String>();
		int prev = start - 1;
		for(int i=0; i<=vals.length; i++) {
			int curr = (i == vals.length) ? end + 1: vals[i];
			if(curr -prev >= 2) {
				ranges.add(getRange(prev + 1, curr - 1));
			}
			prev = curr;
		}
		return ranges;
	}

	private String getRange(int from, int to) {
		return (from == to)? String.valueOf(from) : from + "->" + to;
	}
	public static void main(String[] args) {
		int[] values = {0, 1, 3, 50, 75};
		int start = 0;
		int end = 99;
		Pro0163 pro163 = new Pro0163();
		System.out.println(pro163.findMissingRanges(values, start, end));;
	}
}
