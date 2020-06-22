package com.jia.jianzhiOffer;
/**
 * 
 * 33.二叉树搜索树的后续遍历序列
 * 
 * 题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。

例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。


 * @author Administrator
 *
 */
public class Pro33 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if(sequence == null || sequence.length == 0)return true;
		return verify(sequence, 0, sequence.length - 1);
	}

	private boolean verify(int[] sequence, int st, int ed) {
		if(ed - st <=1) return true;
		int rootVal = sequence[ed];
		int cutIndex = st;
		while(cutIndex < ed && sequence[cutIndex] <= rootVal)
			cutIndex++;
		for(int i = cutIndex; i < ed; i++ ) {
			if(sequence[i] < rootVal)
				return false;
		}
		return false;
		//return verifyPostorder(postorder, st, curIndex-1) && verifyPostorder(postorder, curIndex, ed-1);
	}

}
