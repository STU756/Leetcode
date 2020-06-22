package com.jia.leetCode.interview;

import com.jia.leetCode.TreeNode;

/**
 * 面试题37：序列化二叉树
 * 
 * 请实现两个函数，分别用来序列化和反序列化二叉树。

示例: 

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

 * 
 * @author Administrator
 *
 */
public class Pro37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "null";
        return root.val + "," + serialize(root.left) + ","+serialize(root.right);
    }
    String data;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.data = data;
        return deserialize();
    }
	private TreeNode deserialize() {
		if(data.length() == 0) return null;
        int index = data.indexOf(",");
        String node = index == -1? data : data.substring(0, index);
        data = index == -1? "" : data.substring(index+1);
        if(node.equals("null")) {
        	return null;
        }
        int val = Integer.parseInt(node);
        TreeNode t = new TreeNode(val);
        t.left = deserialize(data);
        t.right = deserialize(data);
        return t;
	}
}
