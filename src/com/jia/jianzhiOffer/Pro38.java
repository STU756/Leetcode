package com.jia.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Pro38 {
    private ArrayList<String> ret;
    public ArrayList<String> Permutation(String str) {
    	this.ret = new ArrayList<String>();
    	if(str.length() == 0) return ret;
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
			//去掉重复
			if(i!=0 && cs[i] == cs[i-1] && !visited[i-1])
				continue;
			visited[i] = true;
			sb.append(cs[i]);
			breaktracking(cs, visited, sb);
			visited[i] = false;
			sb.deleteCharAt(sb.length() - 1);
		}
	}

    private boolean[] flag;
    public String[] permutation(String s) {
        ArrayList<String> list = new ArrayList<String>();
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        flag = new boolean[cs.length];
        bracktracking(cs, list, new StringBuilder());
        String[] ret = new String[list.size()];
        list.toArray(ret);
        return ret;
    }
    private void bracktracking(char[] cs, ArrayList<String> list, StringBuilder sb) {
        //terminator
        if(sb.length() == cs.length) {
            list.add(sb.toString());
        }
        for(int i = 0; i < cs.length; i++) {
            if(flag[i])
                continue;
            //去重
            if(i!=0 && cs[i] == cs[i-1] && !flag[i-1])
                continue;
            flag[i] = true;
            sb.append(cs[i]);
            bracktracking(cs, list, sb);
            flag[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
		Pro38 pro38 = new Pro38();
		pro38.permutation("abc");
	}
}
