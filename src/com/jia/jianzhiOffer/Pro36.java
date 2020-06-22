package com.jia.jianzhiOffer;
/**
 *面试题36： 二叉搜索树与双向链表
 * 题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author Administrator
 *
 */
public class Pro36 {
    TreeNode preNode = null;
    TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        inorderTraveseConvertNode(pRootOfTree);
        //while(preNode!=null && preNode.left != null) preNode = preNode.left;
        return head;
    }
    private void inorderTraveseConvertNode(TreeNode node) {
        if(node == null) return;
        if(node.left != null) {
            inorderTraveseConvertNode(node.left);
        }
        if(head == null) head = node;
        node.left = preNode;
        if(preNode != null) {
            preNode.right = node;
        }
        preNode = node;
        if(node.right != null) {
            inorderTraveseConvertNode(node.right);
        }
    }
}
