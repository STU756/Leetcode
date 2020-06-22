package com.jia.leetCode;
/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

	注意:
	你可以假设树中没有重复的元素。
	
	例如，给出
	
	前序遍历 preorder = [3,9,20,15,7]
	中序遍历 inorder = [9,3,15,20,7]
	返回如下的二叉树：
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder == null || preorder.length != inorder.length) return null;
         return help(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

	private TreeNode help(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
		if(preLeft > preRight)  return null;
		TreeNode root = new TreeNode(preorder[preLeft]);
		int i = inLeft;
		for(; i<= inRight; i++) {
			if(inorder[i] == preorder[preLeft]) break;
		}
		root.left = help(preorder, preLeft + 1, preLeft + i - inLeft, inorder, inLeft, i - 1);
		root.right = help(preorder, preLeft + i - inLeft + 1, preRight, inorder, i+1, inRight);
		return root;
	}

}
