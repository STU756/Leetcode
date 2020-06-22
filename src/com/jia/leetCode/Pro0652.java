package com.jia.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 寻找重复的子树
 * 
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
	
	两棵树重复是指它们具有相同的结构以及相同的结点值。
	
	示例 1：
	
	        1
	       / \
	      2   3
	     /   / \
	    4   2   4
	       /
	      4
	下面是两个重复的子树：
	
	      2
	     /
	    4
	和
	
	    4
	因此，你需要以列表的形式返回上述重复子树的根结点。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    	List<TreeNode> ans = new ArrayList<>();
    	HashMap<String, Integer> map = new HashMap<String,Integer>();
    	if(root == null) return ans;
    	saveRoute(root, ans, map);
    	return ans;
    }
  //递归获取每个子树的路径，保存于Map中
	private String saveRoute(TreeNode root, List<TreeNode> ans, HashMap<String, Integer> map) {
		if(root == null) return "";
		//自底向上获取每个节点的序列化值
		String route = root.val + "," + saveRoute(root.left, ans, map) + "," + saveRoute(root.right, ans, map);
		//将结果放入map，判断是否有相同的子树
		if(map.get(route) != null && map.get(route) == 1) {
			ans.add(root);
		}
		map.put(route, map.getOrDefault(route, 0) + 1);
		return route;
	}
}
