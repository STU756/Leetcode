package com.jia.leetCode;
/**
 * 204. 计数质数
 * 
 * 统计所有小于非负整数 n 的质数的数量。

	示例:
	
	输入: 10
	输出: 4
	解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * @author Administrator
 *
 */
public class Pro0204 {
    public int countPrimes(int n) { 
		boolean[] prime = new boolean[n];
		for(int i = 2; i < n; i++) {
			if(!prime[i]) {
				// 将i的2倍、3倍、4倍...都标记为非素数
	            for(int j = 2; j*i<n; j++) {
	            	prime[i*j] = true;
	            }
			}
		}
		int sum = 0;
		for(int i = 2; i<n; ++i) {
			if(!prime[i])
				++sum;
		}
		return sum;
	}
    public int countPrimes2(int n) {
        int sum = 0;
        for(int i = 2; i< n; i++) {
        	if(isPrime(i)) {
        		++sum;
        	}
        }
        return sum;
    }

	private boolean isPrime(int n) {
		if(n == 2) return true;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
}
