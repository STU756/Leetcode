package com.jia.leetCode;

import java.util.Arrays;
import java.util.Stack;

public class Pro0148 {
	public void mergeSort(int[] a) {
		sort(a, 0, a.length - 1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	private void sort(int[] a, int low, int high) {
		int[] temArr = new int[a.length];
		if(low < high) {
			int mid = (low + high) >> 1;
			sort(a, 0, mid);
			sort(a, mid + 1, high);
		    int i = low, j = mid + 1, k=low;
		    while(i<=mid && j<=high) {
		    	if(a[i] > a[j]) {
		    		temArr[k++] = a[j++];
		    	}else {
		    		temArr[k++] = a[i++];
		    	}
		    }
		    
		    while(i<=mid) {
		    	temArr[k++] = a[i++];
		    }
		    while(j<=high) {
		    	temArr[k++] = a[j++];
		    }
		    
		    for(i=low; i<=high; i++) {
		    	a[i] = temArr[i];
		    }
		}
	}
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
	
	
	private int ListLength(ListNode head) {
		int i = 1;
		ListNode temp = head;
		while(temp.next!= null) {
			i++;
			temp = temp.next;
		}
		return i;
	}
	
	public ListNode merge(ListNode h1, ListNode h2) {
		if(h1 == null) {
			return h2;
		}
		if(h2 == null) {
			return h1;
		}
		if(h1.val < h2.val) {
			h1.next = merge(h1.next, h2);
			return h1;
		}else {
			h2.next = merge(h1, h2.next);
			return h2;
		}
	}
	
	public ListNode sortList(ListNode head) {
		if(head == null)	
			return head;
		if(head.next == null) {
			return head;
		}
		
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode pre = head;
		while(p2!=null && p2.next != null) {
			pre = p1;
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		pre.next = null;
		ListNode h1 = sortList(head);
		ListNode h2 = sortList(p1);
		return merge(h1, h2);
	}
	public static void main(String[] args) {
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		new Pro0148().mergeSort(a);
	}
}
