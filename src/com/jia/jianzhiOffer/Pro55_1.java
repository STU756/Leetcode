package com.jia.jianzhiOffer;

import java.util.LinkedList;

/**
 * 面试题55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

 

提示：

节点总数 <= 10000

 * @author Administrator
 *
 */
public class Pro55_1 {
    public int maxDepth2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean isAllNull = true;
            while(size > 0) {
                TreeNode node = queue.remove();
                if(node != null) {
                    isAllNull = false;
                    queue.add(node.left);
                    queue.add(node.right);
                }
                --size;
            }
            if(!isAllNull)
                ++ans;
        }
        return ans;
    }
    
    //递归
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
