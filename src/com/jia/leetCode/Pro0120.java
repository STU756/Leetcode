package com.jia.leetCode;

import java.util.LinkedList;
import java.util.List;

public class Pro0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size()==0) return 0;
        List<Integer> currentRow = null, upperRow = null;
        for(int i= triangle.size()-1; i>0;--i) {
            currentRow = triangle.get(i);
            upperRow = triangle.get(i-1);
        	for(int j=0; j < upperRow.size();++j) {
        		int current = upperRow.remove(j);
        		upperRow.add(j,current + Math.min(currentRow.get(j),currentRow.get(j+1)));
        	}
        }
        return triangle.get(0).get(0);
    }

}
