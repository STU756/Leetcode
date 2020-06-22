package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * ˳ʱ���������
 * @author Jia
 *
 */
public class Pro0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        	List<Integer> list = new ArrayList<Integer>();
        	if(matrix == null || matrix.length == 0 || matrix[0].length ==0) return list;
        	int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        	int index = 0;
            int sum = matrix[0].length * matrix.length;
        	while(index < sum) {
        		for(int i = left; i<=right && index < sum; i++) {
        			list.add(matrix[up][i]);
        			++index;
        		}
        		++up;
        		for(int i = up; i <= down &&index < sum; i++) {
        			list.add(matrix[i][right]);
        			++index;
        		}
        		--right;
        		for(int i = right; i>=left && index < sum; i--) {
        			list.add(matrix[down][i]);
        			++index;
        		}
        		--down;
        		for(int i = down; i>=up && index < sum; i--) {
        			list.add(matrix[i][left]);
        			++index;
        		}
        		++left;
        	}
        	return list;
        }

}
