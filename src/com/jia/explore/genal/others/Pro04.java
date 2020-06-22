package com.jia.explore.genal.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 帕斯卡三角形
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author Administrator
 *
 */
public class Pro04 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++) {
        	if(ans.isEmpty()) {
        		ans.add(Arrays.asList(1));
        	}else if(ans.size()==1) {
        		ans.add(Arrays.asList(1,1));
        	}else {
        		List<Integer> preList = ans.get(i-2);
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(1);
        		for(int j = 0; j < preList.size()-1; j++) {
        			list.add(preList.get(j) + preList.get(j+1));
        		}
        		list.add(1);
        		ans.add(list);
        	}
        }
        return ans;
    }
    
    public static void main(String[] args) {
		Pro04 pro02 = new Pro04();
		int n = 5;
		pro02.generate(5);
	}
}
