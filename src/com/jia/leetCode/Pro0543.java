package com.jia.leetCode;
/**
 * 543.二叉树的直径
 * 
 * 
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \     
      4   5    
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。
 * 
 * @author Administrator
 *
 */
public class Pro0543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    private int maxDepth(TreeNode node) {
        if(node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        max = Math.max(left+ right, max);
        return Math.max(left, right) + 1;
    }
}
