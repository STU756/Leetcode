package com.jia.leetCode;
/**
 * 687.最长同值路径
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0687 {
	
	
	/**
	 * 自顶向下，暴力搜索
	 * 
	 * @param root
	 * @return
	 */
	int count = 0;
	public int longestUnivaluePath2(TreeNode root) {
		search_top_down(root);
		return count;
	}
	//搜索整棵树
	private void search_top_down(TreeNode root) {
		//返回条件
		if(root == null) return;
		//2.搜索当前节点
		bfs(root);
		//3.搜索子树
		search_top_down(root.left);
		search_top_down(root.right);
	}
	private int bfs(TreeNode root) {
		//1.递归返回条件
		if(root == null) return 0;
		int left = 0, right = 0;
		//2.递归体
		if(root.left != null && root.left.val == root.val) {
			left = bfs(root.left) + 1;
		}
		if(root.right != null && root.right.val == root.val) {
			right = bfs(root.right) + 1;
		}
		//3.合并子问题
		int current = Math.max(left, right);
		count = Math.max(count, left + right);//更新count
		return current;
	}
	
	/**
	 * 自顶向上搜索，可以避免重复搜索。从当前节点返回到上一层数值经过当前节点最大节点是。
	 * 用count来记录搜索过程的最长路径
	 * @param root
	 * @return
	 */
	public int longestUnivaluePath(TreeNode root) {
		//自底向上搜索
		bfs2(root);
		return count;
	}
	private int bfs2(TreeNode root) {
		//1.递归返回条件
		if(root == null) return 0;
		//2.递归搜索
		int left = bfs2(root.left);
		int right = bfs2(root.right);
		
		//3.合并子问题
		int lp = 0, rp = 0;
		if(root.left!=null && root.left.val == root.val) {
			lp +=left;
		}
		if(root.right != null && root.right.val == root.val) {
			rp += right;
		}
		count = Math.max(count, lp + rp);
		return Math.max(lp, rp) +1;
	}
	
	public static void main(String[] args) {
		
	}
}
