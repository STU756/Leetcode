package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro0040 {
	private void combinationSum2(int[] num, int begin, List<List<Integer>> result, List<Integer> current, int currentSum, int target) {

	    if (currentSum == target) {
	        List<Integer> newList = new ArrayList<Integer>();
	        newList.addAll(current);
	        result.add(newList);
	        return;
	    }
	    else if (currentSum > target) {
	        return;
	    }

	    for (int i = begin; i != num.length; ++i) {

	        currentSum += num[i];
	        current.add(num[i]);
	        combinationSum2(num, i+1, result, current, currentSum, target);
	        current.remove(current.size() - 1);
	        currentSum -= num[i];

	        // eliminate duplicates
	        while (i < num.length - 1 && num[i] == num[i+1]) ++i;
	    }    

	}

	public List<List<Integer>> combinationSum2(int[] num, int target) {
	    Arrays.sort(num);
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    combinationSum2(num, 0, result, new ArrayList<Integer>(), 0, target);
	    return result;
	}
}
