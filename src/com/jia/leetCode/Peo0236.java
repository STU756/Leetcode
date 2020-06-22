package com.jia.leetCode;

import com.jia.jianzhiOffer.TreeNode;

public class Peo0236 {
    /**

    二叉树最近公共祖先
    三种情况：
    1.p q 一个在左子树 一个在右子树 那么当前节点即是最近公共祖先
    2.p q都在右子树
    3.p q 都在左子树
    **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) 
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        if(left!=null) {
            //p q都在左子树
            return left;
        }
        if(right != null) {
            //p q都在右子树
            return right;
        }
        return null;
    }
}
