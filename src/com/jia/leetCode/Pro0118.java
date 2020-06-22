package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro0118 {
	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> list;
		if (numRows <= 0)
			return ll;
		if (numRows == 1) {
			list =  new ArrayList<Integer>();
			list.add(1);
			ll.add(list);
			return ll;
		}
		if (numRows == 2) {
			list =  new ArrayList<Integer>();
			list.add(1);
			List<Integer> list2 = new ArrayList<Integer>();
			list2.add(1);
			list2.add(1);
			ll.add(list);
			ll.add(list2);
			return ll;
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
		return ll;
	}
    List<List<Integer>> ans = new ArrayList<>();
    //递归
    public List<List<Integer>> generate(int numRows) {
        help(numRows);
        return ans;
    }
    private void help(int numRows) {
        if(numRows == 1) {
            ans.add(Arrays.asList(new Integer[] {1}));   
            return;
        }
        if(numRows == 2) {
            ans.add(Arrays.asList(new Integer[]{1,1}));
            return;
        }
    }
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list.get(4));
	}
}
