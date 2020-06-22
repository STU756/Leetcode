package com.jia.leetCode.list;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}
}
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
}
public class LinkedListTest {
	public ListNode insert(ListNode head, int x, ListNode p) {
		// create a new Node to the new Head
		ListNode now = new ListNode(-1);
		now.next = head;
		head = now;

		ListNode current = now;
		while (x-- > 0 && current.next != null) {
			current = current.next;
		}
		if (x > 0) {
			return head.next;
		}
		ListNode pre = current;
		current = current.next;
		pre.next = p;
		p.next = current;
		return head.next;
	}

	public boolean delete(ListNode head, int deleteValue) {
		ListNode current = head;
		while (current != null && current.val != deleteValue)
			current = current.next;
		if (current == null)
			return false;
		ListNode now = current;
		while (current != null) {
			now = current;
			current = current.next;
			now.val = current.val;
		}
		now.next = null;
		return true;
	}

	public boolean delete2(ListNode head, int deleteValue) {
		ListNode now = new ListNode(-1);
		now.next = head;
		head = now;

		ListNode current = head;
		while (current.next != null && current.next.val != deleteValue)
			current = current.next;
		if (current.next == null)
			return false;
		now = current.next.next;
		current.next = now;
		head = head.next;
		return true;
	}

	/**
	 * �б�ת
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = null;
		ListNode current = head;
		while (current != null) {
			head = current;
			current = current.next;
			head.next = pre;
			pre = head;
		}
		return head;
	}

	/**
	 *
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode current = head;
		ListNode curNext = head;
		while (curNext.next != null && curNext.next.next != null) {
			if (current == curNext)
				return true;
			curNext = curNext.next.next;
			current = current.next;
		}
		return false;
	}

	/**
	 **/
	public ListNode detectCycle(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = head;
		do {
			if (p2 == null || p2.next == null)
				return null;
			p1 = p1.next;
			p2 = p2.next.next;
		} while (p1 != p2);
		p1 = head;
		for (; p1 != p2; p1 = p1.next, p2 = p2.next)
			;
		return p1;
	}

	/**
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0;
		int lenB = 0;
		int len = 0;
		ListNode current = headA;
		for (; current != null; current = current.next, ++lenA)
			;
		current = headB;
		for (; current != null; current = current.next, ++lenB)
			;
		if (lenA > lenB) {
			len = lenA - lenB;
			for (; len > 0; len--, headA = headA.next)
				;
		} else {
			len = lenB;
			for (; len > 0; len--, headB = headB.next)
				;
		}
		for (; headA != null && headB != null; headA = headA.next, headB = headB.next) {
			if (headA == headB)
				return headA;
		}
		return null;
	}

	/**
	 *
	 */
	/*
	 * public RandomListNode copyRandomList(RandomListNode head) { if(head ==
	 * null) return head; Map<RandomListNode,RandomListNode> map = new
	 * HashMap<RandomListNode,RandomListNode>(); RandomListNode current = head;
	 * //�����¾ɽڵ��map for(;current!=null;) { map.put(current,new
	 * RandomListNode(current.label)); current = current.next; } current = head;
	 * RandomListNode now = head; head = map.get(current); head.random =
	 * map.get(current.random); RandomListNode preNode = head;
	 * for(;current.next!=null;){ current=current.next; now = map.get(current);
	 * now.random = map.get(current.random); preNode.next = now; preNode = now;
	 * } preNode.next = null; return head; }
	 */
	/**
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode pre = head;
		RandomListNode cur = head.next;

		// ����
		for (; pre != null;) {
			cur = pre;
			RandomListNode newNode = new RandomListNode(cur.label);
			pre = pre.next;
			cur.next = newNode;
			newNode.next = pre;
		}

		// ����
		pre = head;
		for (; pre != null; pre = pre.next.next) {
			pre.next.random = (pre.random == null) ? null : pre.random.next;
		}

		// ���
		RandomListNode h = head.next;
		cur = h;
		RandomListNode tail = head;
		for (;;) {
			tail = tail.next = cur.next;
			if (tail == null) {
				break;
			}
			cur = cur.next = tail.next;
		}

		return h;
	}

	/**
	 * ���������һ��
	 */
	
	public ListNode partition(ListNode head, int x) {
		ListNode h1 = null, h2 =null;
		ListNode p1 = null, p2 = null;
		for(;head!=null;head=head.next) {
			if(head.val < x) {
				if(h1!=null) {
					p1 = p1.next = head;
				}else {
					p1 = h1 = head;
				}
			}else {
				if(h2!=null) {
					p2 = p2.next = head;
				}else {
					h2 = p2 = head;
				}
			}
		}
		if(p2!= null) {
			p2.next = null;
		}
		if(p1!=null) {
			p1.next = h2;
		}
		return (h1==null)?h2:h1;
	}
	
	/**
	 * 
	 * @param head
	 * @return
	 */
	
	public TreeNode sortedListToBST(ListNode head) {
		
		int len = 0;
		TreeNode root = null;
		for(ListNode temp = head;temp!=null;temp =temp.next,++len);
		return help(head,0, len-1);
	}

	private TreeNode help(ListNode head, int start, int end) {
		if(start > end) return null;
		int mid = (start + end) >>> 1;
		TreeNode root = new TreeNode(head.val);
		root.left = help(head, start, mid-1);
		root.right = help(head,mid+1,end);
		return root;
	}
	
}


