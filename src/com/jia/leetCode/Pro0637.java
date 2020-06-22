package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pro0637 {
    public List<Double> averageOfLevels(TreeNode root) {
    	List<Double> res = new ArrayList<Double>();
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	int size = 1;
    	int k = 0;//
    	double sum = 0;
    	int temp = 0;
    	while(!queue.isEmpty()) {
    		sum = 0;
            k = 0;
    		temp = 0;
    		while(k<size) {
    			
    			TreeNode last = queue.pollLast();
    			sum+=last.val;
    			if(null!=last.left) {
    				queue.addFirst(last.left);
    				++temp;
    			}
    			if(null!=last.right) {
    				queue.addFirst(last.right);
    				++temp;
    			}
    			++k;
    		}
    		res.add(sum / size);
    		size = temp;
    	}
    	return res;
    }
}
