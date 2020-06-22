package com.jia.leetCode;
/**
 * 426. 将二叉搜索树转化为排序的双向链表
 * 
 * 将一个二叉搜索树就地转化为一个已排序的双向循环链表。可以将左右孩子指针作为双向循环链表的前驱和后继指针。

为了让您更好地理解问题，以下面的二叉搜索树为例：

 



 

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

 



 

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。

下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0426 {
	Node first = null;
	Node last = null;
	public Node treeToDoublyList(Node root) {
	    if (root == null) return null;
	    help(root);
	    //最后收尾连接
	    last.right = first;
	    first.left = last;
	    return first;
	}
	private void help(Node node) {
		if(node != null) {
			help(node.left);
			if(last!=null) {
				last.right = node;
				node.left = last;
			}else {
				first = node;
			}
			last = node;
			help(node.right);
		}
	}
}
