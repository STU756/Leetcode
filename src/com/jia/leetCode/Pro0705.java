package com.jia.leetCode;
/**
 * 设计哈希集合
 * 
 * 
 * 不使用任何内建的哈希表库设计一个哈希集合

具体地说，你的设计应该包含以下的功能

add(value)：向哈希集合中插入一个值。
contains(value) ：返回哈希集合中是否存在这个值。
remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

示例:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // 返回 true
hashSet.contains(3);    // 返回 false (未找到)
hashSet.add(2);          
hashSet.contains(2);    // 返回 true
hashSet.remove(2);          
hashSet.contains(2);    // 返回  false (已经被删除)

注意：

所有的值都在 [0, 1000000]的范围内。
操作的总数目在[1, 10000]范围内。
不要使用内建的哈希集合库。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-hashset
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */

/**
 * 由于是简易模拟HashMap的key存储，所以不带扩容，使用固定长度数组
冲突时使用双向链表在同一个bucket下存储
y = x ％ length 作为哈希函数
// 数组加双向链表，y = x ％ length 作为哈希函数
 * @author Administrator
 *
 */
public class Pro0705 {
    class Node{
        int val;
        Node prev, next;
        
        Node (int val) {
            this.val = val;
        }
    }

    private int length = 100;
    private Node[] data = new Node[length];
    
    /** Initialize your data structure here. */
    public Pro0705() {
        
    }
    
    public void add(int key) {
        int index = key % length;
        Node curr = data[index];
        if (curr == null) {
            Node node = new Node(key);
            data[index] = node;
            return;
        }
        while(true) {
            if (curr.val == key) {
                return;
            }
            if(curr.next == null) {
                Node node = new Node(key);
                node.prev = curr;
                curr.next = node;
                return;
            } else {
                curr = curr.next;
            }
        }
    }
    
    public void remove(int key) {
        int index = key % length;
        Node curr = data[index];
        if (curr != null && curr.val == key) {
            Node next = curr.next;
            if (next != null) {
                next.prev = null;
            }
            data[index] = next;
            return;
        }
        while(curr != null) {
            if (curr.val == key) {
                Node next = curr.next;
                Node prev = curr.prev;
                if (next != null) {
                    next.prev = prev;
                }
                if (prev != null) {
                    prev.next = next;
                }
                return;
            }
            curr = curr.next;
        }   
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % length;
        Node curr = data[index];
        while(curr != null) {
            if (curr.val == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
