package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 939.二叉树的堂兄弟节点
 * 
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。

我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。

只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。

 

示例 1：


输入：root = [1,2,3,4], x = 4, y = 3
输出：false
示例 2：


输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
输出：true
示例 3：



输入：root = [1,2,3,null,4], x = 2, y = 3
输出：false
 

提示：

二叉树的节点数介于 2 到 100 之间。
每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * @author Administrator
 *
 */
public class Pro0993 {
	//存放节点值和对应的深度
	Map<Integer, Integer> depth;
	//存放节点和对应的父节点
	Map<Integer,TreeNode> map;
	/**
	 * 求二叉树的堂兄弟节点：
	 * 只需要找出两节点x和y深度一样，同时两个节点父节点不同
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
    public boolean isCousins(TreeNode root, int x, int y) {
    	depth = new HashMap<Integer, Integer>();
    	map = new HashMap<>();
    	dfs(root, null);
    	return depth.get(x) == depth.get(y) && map.get(x) != map.get(y);
    }
	private void dfs(TreeNode node, TreeNode parent) {
		if(node!=null) {
			depth.put(node.val, parent!=null? depth.get(parent.val) + 1 : 0);
			map.put(node.val, parent);
			dfs(node.left, node);
			dfs(node.right, node);
		}
	}
}
