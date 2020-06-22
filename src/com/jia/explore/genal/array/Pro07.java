package com.jia.explore.genal.array;

import java.util.Arrays;

public class Pro07 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >=0; i--) {
        	int temp = digits[i] + carry;
        	carry = temp / 10;
        	digits[i] = temp % 10;
        	if(carry == 0) return digits; 
        }
        int[] dest = new int[digits.length + 1];
        dest[0] = carry;
        System.arraycopy(digits, 0, dest, 1, digits.length);
        return dest;
    }
    public static void main(String[] args) {
		int[] digits = {9,8,9};
		Pro07 pro07 = new Pro07();
		System.out.println(Arrays.toString(pro07.plusOne(digits)));
	}
}
