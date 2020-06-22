package com.jia.explore.genal.tree;

import java.util.Stack;

/**
 * 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * 
 * 
 * @author Administrator
 *
 */
public class Pro03 {
	//递归实现
    public boolean isSymmetric2(TreeNode root) {
    	/**
    	 * 左子树的左子树和右子树的右子树相同，
        	左子树的右子树，和右子树的左子树相同。我们采用递归的方式
    	 */
        if(root== null) return true;
        return comRoot(root.left, root.right);
    }

	private boolean comRoot(TreeNode left, TreeNode right) {
		if(left == null)
			return right == null;
		if(right == null) 
			return false;  //left 不为空，此时right为空，返回false
		if(left.val != right.val)  // 比较左右不为空时的值比较，如果相等就进行下一层递归，否则返回false
			return false;
		// 左子树的左子树和右子树的右子树比较，左子树的右子树和右子树的左子树比较
		return comRoot(left.left, right.right) && comRoot(left.right, right.left);
	}
	//迭代实现
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;//空对称
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root.left, q = root.right;
		stack.push(p);
		stack.push(q);
		while(!stack.isEmpty()) {
			p = stack.pop();
			q = stack.pop();
			if(p == null && q == null) //p,q都为空节点
				continue;
			if(p == null || q == null)  //p,q有一个为空节点，不堆成
				return false;
			if(p.val!=q.val)
				return false;
			stack.push(p.left);
			stack.push(q.right);
			stack.push(p.right);
			stack.push(q.left);
		}
		return true;
	}
}
