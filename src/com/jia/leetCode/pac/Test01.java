package com.jia.leetCode.pac;

import com.jia.leetCode.TreeNode;

public class Test01 {
	   public TreeNode buildTree(int[] preorder, int[] inorder) {
	        return build(preorder,0,preorder.length-1, inorder, 0, inorder.length-1);
	    }

		private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
			if(preStart == preEnd) {
				return new TreeNode(preorder[preStart]);
			}
			if(preStart < preEnd) {
				int rootIndex = inStart;
				for(int i = inStart; i <= inEnd; i++) {
					if(inorder[i] == preorder[preStart]) {
						rootIndex = i;
						break;
					}
				}
				TreeNode root = new TreeNode(preorder[preStart]);
				root.left = build(preorder, preStart+1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1);
				root.right = build(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex+1, inEnd);
				return root;
			}
			return null;
		}
}
