package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro0119 {
	 public List<Integer> getRow(int numRows) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> list;
		numRows++;
		if (numRows <= 0)
			return list = new ArrayList<Integer>();
		if (numRows == 1) {
			list =  new ArrayList<Integer>();
			list.add(1);
			return list;
		}
		if (numRows == 2) {
			list =  new ArrayList<Integer>();
			list.add(1);
			List<Integer> list2 = new ArrayList<Integer>();
			list2.add(1);
			list2.add(1);
			ll.add(list);
			ll.add(list2);
			return list2;
		}
		for (int i = 1; i <= numRows; i++) {
			if(i==1) {
				list =  new ArrayList<Integer>();
				list.add(1);
				ll.add(list);
			}
			else if(i==2) {
				list =  new ArrayList<Integer>();
				list.add(1);
				list.add(1);
				ll.add(list);
			}
			else {
				list =  new ArrayList<Integer>();
				list.add(1);
				List<Integer> l = ll.get(i-2);
				for(int j=1; j<i-1; j++) {
					list.add(j, l.get(j-1) + l.get(j));
				}
				list.add(i-1, 1);
				ll.add(list);
			}
		}
		return ll.get(numRows-1);
	}
	
	
}
