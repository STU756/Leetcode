package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Pro1305 {
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1, list1);
        inorder(root2, list2);
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        for(; i < list1.size() && j < list2.size(); ) {
        	if(list1.get(i)<list2.get(j)) {
        		ans.add(list1.get(i++));
        	}else {
        		ans.add(list2.get(j++));
        	}
        }
        while(i < list1.size()) ans.add(list1.get(i++));
        while(j<list2.size()) ans.add(list2.get(j++));
        return ans;
    }
	private void inorder(TreeNode root2, List<Integer> list) {
		if(root2 == null) return;
		inorder(root2.left, list);
		list.add(root2.val);
		inorder(root2.right, list);
	}
}
