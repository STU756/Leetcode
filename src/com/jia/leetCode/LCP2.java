package com.jia.leetCode;
/**
 * LCP2.分式化简
 * 
 * 
 * @author Administrator
 *
 */
public class LCP2 {
	/**
	 * 首先a+\frac{1}{b}a+ 
		b
		1
		​	
		 的分数形式本就是极简分数，相加之后的数本就不需要通分，其最大公约数为1
		相加之后的项\frac{ab+1}{b} 
		b
		ab+1
		​	
		 中的ab+1ab+1即是下一步迭代过程中的分母
		bb就是下一步迭代的累加项，分子是b+ 左移一位数 *(ab+1)

	 * @param cont
	 * @return
	 */
    public int[] fraction(int[] cont) {
    	int[] res = new int[2];
    	res[0] = cont[cont.length - 1];
    	res[1] = 1;
    	for(int i = cont.length - 1; i > 0; i--) {
    		int temp = res[1];
    		res[1] = res[0];
    		res[0] = cont[i-1] * res[1] + temp;
    	}
        return res;
    }

}
