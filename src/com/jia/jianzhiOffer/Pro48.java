package com.jia.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 面试题38: 字符串的排序
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro48 {
	ArrayList<String> ret;
	public ArrayList<String> Permutation(String str) {
		ret = new ArrayList<String>();
		if(str == null || str.length() == 0)
			return ret;
		char[] cs = str.toCharArray();
		Arrays.sort(cs);
		StringBuilder sb = new StringBuilder();
		breaktracking(cs, new boolean[cs.length], sb);
		return ret;
	}
	private void breaktracking(char[] cs, boolean[] visited, StringBuilder sb) {
		if(sb.length() == cs.length) {
			ret.add(sb.toString());
		}
		for(int i = 0; i < cs.length; i++) {
			if(visited[i]) continue;
			//去重
			if(i!=0 && cs[i] == cs[i-1] && !visited[i-1])
				continue;
			visited[i] = true;
			sb.append(cs[i]);
			breaktracking(cs, visited, sb);
			visited[i] = false;
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
