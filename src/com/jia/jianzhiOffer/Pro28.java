package com.jia.jianzhiOffer;
/**
 * 28.对称二叉树
 * 题目描述
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，
如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author Administrator
 *
 */
public class Pro28 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    private boolean isSymmetrical(TreeNode lNode,TreeNode rNode) {
        if(lNode == null && rNode == null) return true;
        if(lNode == null || rNode == null || lNode.val!=rNode.val) return false;
        return isSymmetrical(lNode.left, rNode.right) && isSymmetrical(lNode.right, rNode.left);
    }
}
