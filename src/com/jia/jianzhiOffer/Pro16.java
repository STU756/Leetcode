package com.jia.jianzhiOffer;
/**
 * 面试题16：数值的整数次方
 * @author Administrator
 *
 */
public class Pro16 {
   public double myPow(double base, int n) {
        if(n == 0) return 1;
        if(n == 1) return base;
        if(n == -1) return 1/base;
        double half = myPow(base, n / 2);
        double mod = myPow(base, n % 2);
        return half * half * mod;
    }
}
