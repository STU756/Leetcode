package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Pro0039 {
	List<List<Integer>> answer;
	LinkedList<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        answer = new ArrayList<List<Integer>>();
        path = new LinkedList<Integer>();
        help(candidates, 0, 0, target, path, answer);
        return answer;
    }

	private void help(int[] a, int now, int sum, int target,
			LinkedList<Integer> path, List<List<Integer>> answer) {
		if(sum > target) {
			return ;
		}
		if(now >= a.length) {
			if(sum == target) {
				answer.add(path);
			}
			return;
		}
		if((now == 0) || (a[now-1]!= a[now])) {
			path.addLast(a[now]);
			help(a, now, sum + a[now], target, path, answer);
			path.pollLast();
		}
		
		help(a, now + 1, sum, target, path, answer);
	}

}
