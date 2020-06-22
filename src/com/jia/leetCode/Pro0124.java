package com.jia.leetCode;


/**
 * 二叉树中的最大路径和
 * 
 * 左右子树分离，任意2个节点的问题可以抽象最近公共祖先问题。
 * 
 * @author Administrator
 *
 */
public class Pro0124 {
	private int ans = 0x80000000;
    public int maxPathSum(TreeNode root) {
    	if(root == null) return 0;
    	maxDeep(root);
    	return ans;
    }
    private int maxDeep(TreeNode root) {
    	if(root == null) return 0;
    	if(root.left == null && root.right == null) {
    		ans = Math.max(ans, root.val);
    		return root.val;
    	}else {
    		int leftSum = maxDeep(root.left);
    		int rightSum = maxDeep(root.right);
    		int temp = Math.max(leftSum, rightSum) + root.val;
    		temp = Math.max(temp, root.val);  //判断当前节点val为负数
    		ans = Math.max(ans, temp);//可能为不包括当前节点的一段
    		ans = Math.max(ans, leftSum + rightSum + root.val);  //左右子树和当前节点的和
    		return temp;
    	}
	}

}
