package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 138. 复制带随机指针的链表
 * 
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的深拷贝。 

 

示例：



输入：
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

解释：
节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0138 {
	class Node{
		int val;
		Node next;
		Node random;
		public Node(int val) {
			this.val = val;
		}
	}
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        //loop :copy all the nodes
        while(cur!=null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //loop2 : assign value to next and random pointers
        while(cur!=null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
