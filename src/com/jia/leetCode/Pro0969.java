package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 969.煎饼排序
 * 
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。

	返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
	
	 
	
	示例 1：
	
	输入：[3,2,4,1]
	输出：[4,2,4,3]
	解释：
	我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
	初始状态 A = [3, 2, 4, 1]
	第一次翻转后 (k=4): A = [1, 4, 2, 3]
	第二次翻转后 (k=2): A = [4, 1, 2, 3]
	第三次翻转后 (k=4): A = [3, 2, 1, 4]
	第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。 
	示例 2：
	
	输入：[1,2,3]
	输出：[]
	解释：
	输入已经排序，因此不需要翻转任何内容。
	请注意，其他可能的答案，如[3，3]，也将被接受。
	 
	
	提示：
	
	1 <= A.length <= 100
	A[i] 是 [1, 2, ..., A.length] 的排列

 * 
 * @author Administrator
 *
 */
public class Pro0969 {
    /**
    思路: 这道题,要想到如何通过翻转把列表最大数依次往列表底移动.

    例如:[3,2,4,1]---->[?,?,?,4]

    我们可以先找到数字4的位置,将数字4前进行翻转变成[4,2,3,1],接下来我们在整体翻转[1,3,2,4],这样我们把数字4移动列表底.

    然后,我们[1,3,2,4]--->[?,?,3,4],还是用刚才方法,首先找到数字3,翻转数字3前面的,再翻转已经排好数字(这里指数字4)前就可以了.
    */
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        for(int i  = A.length-1; i > 0; --i) {
            int maxIndex = i;
            for(int j = 0; j < i; j++) {
                if(A[j]>A[maxIndex]){
                    maxIndex = j;
                }
            }
            if(i!=maxIndex) {
                swap(A, 0, maxIndex);
                list.add(maxIndex+1);
                swap(A, 0, i);
                list.add(i+1);
            }
        }
        return list;
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
