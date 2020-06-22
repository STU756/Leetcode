package com.jia.jianzhiOffer;

import java.util.HashMap;
import java.util.Random;

/**
 * 面试35.复杂链表的复制
 * 题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author Administrator
 *
 */
public class Pro35 {
    public RandomListNode Clone2(RandomListNode pHead)
    {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = pHead;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode nCur =dummy;
        while(cur!=null) {
        	nCur.next = new RandomListNode(cur.label);
        	nCur = nCur.next;
        	map.put(cur, nCur);
        	cur = cur.next;
        }
        cur = pHead;
        while(cur != null) {
        	if(cur.random!=null) {
        		map.get(cur).random = map.get(cur.random);
        	}
            cur = cur.next;
        }
        return dummy.next;
    }
    
    public RandomListNode Clone(RandomListNode pHead) {
    	if(pHead == null)
    		 return null;
    	//插入新节点
    	RandomListNode cur = pHead;
    	
    	//第一步，在每个节点的后面插入复制的节点。
    	while(cur!=null) {
    		RandomListNode clone = new RandomListNode(cur.label);
    		clone.next = cur.next;
    		cur.next = clone;
    		cur = clone.next;
    	}
    	//第二步，对复制节点的 random 链接进行赋值。
    	//建立random链接
    	cur = pHead;
    	while(cur!=null) {
    		RandomListNode clone = cur.next;
    		if(cur.random!=null) {
    			clone.random = cur.random.next;
    		}
    		cur = clone.next;
    	}
    	//第三步，拆分。
    	cur = pHead;
    	RandomListNode pCloneHead = pHead.next;
    	while(cur.next!=null) {
    		RandomListNode next = cur.next;
    		cur.next = next.next;
    		cur = next;
    	}
    	return pCloneHead;
    }
    
}
