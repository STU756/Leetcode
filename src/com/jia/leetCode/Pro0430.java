package com.jia.leetCode;
/**
 * 430. 扁平化多级双向链表
 * 
 * 
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。

 

示例:

输入:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

输出:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
 

以上示例的说明:

给出以下多级双向链表:


 

我们应该返回如下所示的扁平双向链表:



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0430 {
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	}
    public Node flatten(Node head) {
        if(head == null) return null;
        Node cur = head;
        Node tail = null;
        //把节点cur.child不为null的节点与cur.next进行交换
        while(cur!=null) {
        	if(cur.child!=null) {
        		Node temp = cur.next;
                if(temp!=null)
        		    temp.prev = null;//cur.next 的prev指针设置为null
        		cur.next = cur.child;
        		cur.next.prev = cur;
        		cur.child = temp;
        	}
            tail = cur;
        	cur = cur.next;
        }
        //把整条节点child不为空的链表插入tail 和 tail.next之间
        Node tailNext = null;
        cur = head;
        while(cur!=tailNext) {
        	if(cur.child!=null) {
        		//把整一段链表插入tail 和 tail.next之间
        			Node tmpCur = cur.child;
        			cur.child = null;
        			tail.next = tmpCur;
        			tmpCur.prev = tail;
        		if(tailNext!=null) {
        			while(tmpCur.next!=null) tmpCur = tmpCur.next;
        			tmpCur.next = tailNext;
        			tailNext.prev = tmpCur;
        		}
        		tailNext = tail.next;
        	}
        	cur = cur.next;
        }
        return head;
    }
}
