package com.jia.jianzhiOffer;
/**
 * 面试题54：二叉树的第k个节点
 * 题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
按结点数值大小顺序第三小结点的值为4。
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro54 {
    private int k;
    private TreeNode retNode;
    //先序遍历查找第k小节点值
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null || k <1) return null;
        this.k = k;
        inorderTraverse(pRoot);
        return retNode;
    }
    private void inorderTraverse(TreeNode node) {
        if(node == null || k <= 0) return;
        inorderTraverse(node.left);
        --k;
        if(k == 0)
            retNode = node;
        inorderTraverse(node.right);
    }
    
    int count  = 0;
    int ans = 0;
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     * 示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
 

限制：

1 ≤ k ≤ 二叉搜索树元素个数
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }
    private void dfs(TreeNode root, int k ) {
        if(root == null) return;
        dfs(root.right, k);//先遍历右
        ++count;
        if(count == k) {
            ans = root.val;
            return;
        }
        dfs(root.left, k);//再遍历左
    }
}
