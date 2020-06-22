package com.jia.explore.genal.others;

public class Pro03 {
    public int reverseBits(int n) {
    	int i = 0;
    	int result = 0;
    	while(i < 32) {
    		int temp = n & 0x1;
    		n = n >> 1;
    		result = (result <<1) | temp;
    		i++;
    	}
    	return result;
    }
}
