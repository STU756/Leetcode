package com.jia.leetCode;

import java.util.List;

/**
 * 
 * 281.锯齿迭代器
 * 
 * 给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。

	示例:
	
	输入:
	v1 = [1,2]
	v2 = [3,4,5,6] 
	
	输出: [1,3,2,4,5,6]
	
	解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
	     next 函数返回值的次序应依次为: [1,3,2,4,5,6]。
	拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢?
	
	拓展声明：
	 “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如：
	
	输入:
	[1,2,3]
	[4,5,6,7]
	[8,9]
	
	输出: [1,4,8,2,5,9,3,6,7].
 * 
 * @author Administrator
 *
 */
public class Pro0281 {
    int[] indexs;
    int point; //当前指针
    List<Integer>[] lists;
    public Pro0281(List<Integer> v1, List<Integer> v2) {
        indexs = new int[2];
        lists = new List[2];
        lists[0] = v1;
        lists[1] = v2;
        point = 0;
    }

    public int next() {
    	int ans = lists[point].get(indexs[point]);
    	++indexs[point];
    	point = (point + 1) % lists.length;
    	return ans;
    }

    public boolean hasNext() {
        for(int i = 0; i < lists.length; i++) {
        	point = (point + i) % lists.length;
        	if(indexs[point] < lists[point].size())
        		return true;
        }
        return false;
    }
}
