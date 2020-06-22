package com.jia.leetCode;
/**
 * 
 * 二叉搜索树中第K小的元素
 * 
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0230 {
    int i = 0;
    int val = -1;
    public int kthSmallest2(TreeNode root, int k) {
        inorder(root, k);
        return val;
    }
    private void inorder(TreeNode root, int k) {
        if(root!=null) {
            inorder(root.left, k);
            if(++i == k) {
                val = root.val;
                return;
            }
            inorder(root.right, k);
        }
    }
    
    
    public int kthSmallest(TreeNode root, int k) {
    	help(root, k);
    	return val;
    }
    private int help(TreeNode root, int k) {
    	if(root == null)
    		return 0;
    	
    	int c = kthSmallest(root.left, k);
    	int c2 = 0;
    	if(val != -1 || c <= k) {
    		return c;
    	}else {
    		if(k-c == 1) {
    			val = root.val;
    			return c;
    		}
    		c2 = kthSmallest(root.right, k-c - 1);
    	}
    	return c + c2 + 1;
    }
    
}
