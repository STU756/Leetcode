package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 
 * 给定一个二叉树，返回它的中序 遍历。

	示例:
	
	输入: [1,null,2,3]
	   1
	    \
	     2
	    /
	   3

	输出: [1,3,2]
	进阶: 递归算法很简单，你可以通过迭代算法完成吗？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 * @author Jia
 *
 */
public class Pro0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> ans = new ArrayList<>();
        if(root== null) return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode curr = root;
        while(curr.left!=null) {
        	stack.push(curr.left);
        	curr = curr.left;
        }
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	ans.add(node.val);
        	if(node.right != null) {
        		stack.push(node.right);
        		curr = node.right;
        		while(curr.left!=null) {
        			stack.push(curr.left);
        			curr = curr.left;
        		}
        	}
        }
        return ans;
    }
    List<Integer> ans = new ArrayList<>();
    //递归
    public List<Integer> inorderTraversal2(TreeNode root) {
    	if(root!=null) {
    		inorderTraversal2(root.left);
    		ans.add(root.val);
    		inorderTraversal(root.right);
    	}
    	return ans;
    }
    
    public List<Integer> inorderTraversal3(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<>();
    	while(!stack.isEmpty() || root!=null) {
    		while(root!=null) {
    			stack.push(root);
    			root = root.left;
    		}
    		if(!stack.isEmpty()) {
    			root = stack.pop();
    			ans.add(root.val);
    			root = root.right;
    		}
    	}
    	return ans;
    }
	
}
