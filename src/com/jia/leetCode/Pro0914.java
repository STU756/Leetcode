package com.jia.leetCode;

public class Pro0914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] bucket = new int[10000];
        for(int i = 0; i<deck.length; i++) {
        	++bucket[deck[i]];
        }
        int temp = bucket[0];
        for(int i = 0; i< bucket.length;i++) {
        	if(bucket[i]!=0) {
        		temp = mcf(temp, bucket[i]);
        	}
        }
        return temp >= 2;  //公因数大于2
    }
    //最大公因数
    private int mcf(int a, int b) {
    	 while (a % b != 0) {
             int c = a % b;
             a = b;
             b = c;
         }
         return b;
    }
}
