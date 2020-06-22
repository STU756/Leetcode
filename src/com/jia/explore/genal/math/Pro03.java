package com.jia.explore.genal.math;

/**
 * 
 * 3的幂 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 27 输出: true 示例 2:
 * 
 * 输入: 0 输出: false 示例 3:
 * 
 * 输入: 9 输出: true 示例 4:
 * 
 * 输入: 45 输出: false 进阶： 你能不使用循环或者递归来完成本题吗？
 * 
 */
public class Pro03 {
	/**
	 * 不使用递归或循环的思路：先计算最大的3的幂次方的数，然后判断n能否被最大3次幂整除即可。
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		int max3Power = 1162261467;
		return (max3Power % n == 0) ? true : false;
	}
	/**
	 * Integer最大的3的幂次方的数
	 * @return
	 */
	private int getIntMax3Power() {
		int sum = 1;
		while (sum * 3 < Integer.MAX_VALUE) {
			sum *= 3;
		}
		return sum;
	}

	public boolean isPowerOfThree2(int n) {
		if (n == 0)
			return false;
		while (n != 1) {
			if ((n % 3) != 0)
				return false;
			n /= 3;
		}
		return true;
	}

	public static void main(String[] args) {

		Pro03 pro03 = new Pro03();
		pro03.isPowerOfThree(27);
	}
}
