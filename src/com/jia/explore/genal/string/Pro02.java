package com.jia.explore.genal.string;
/**
 整数反转
 * @author Administrator
 *
 */
public class Pro02 {
    public int reverse(int x) {
        long result = 0;
        int temp = x;
        while(temp!=0) {
        	result = result * 10 + (temp % 10);
        	temp /= 10;
        }
        return  result > Integer.MAX_VALUE || result<Integer.MIN_VALUE ? 0 : (int) result;
    }
    public static void main(String[] args) {
    	Pro02 pro02 = new Pro02();
    	System.out.println(pro02.reverse(1534236469));
	}
}
