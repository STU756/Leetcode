package com.jia.leetCode.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pro0809 {
    List<String> ret;
    int n;
    public List<String> generateParenthesis(int n) {
    	ret = new ArrayList<String>();
    	if(n <= 0) return ret;
    	bracktracking(n, 0, 0, 0, new char[n*2]);
    	return ret;
    }
    private void bracktracking(int n, int k, int l, int r, char[] cs) {
    	if(l == n&& r==n) {
    		ret.add(new String(cs));
    		return;
    	}
    	if(l<n) {
    		cs[k] = '(';
    		bracktracking(n, k+1, l+1, r, cs);
    	}
    	if(r<n && l>r) {
    		cs[k] = ')';
    		bracktracking(n, k+1, l, r+1, cs);
    	}
    }
        
    
    public static void main(String[] args) {
		Pro0809 pro0809 = new Pro0809();
		System.out.println(pro0809.generateParenthesis(3));
	}
}
