package com.jia.jianzhiOffer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //Time:O(n) Space:O(n)
    public void reOrderArray(int [] array) {
        int oddCnt = 0;
        for(int a : array) {
            if((a&0x1) == 1)
                ++oddCnt;
        }
        int[] copy = array.clone();
        int i = 0;
        for(int num : copy) {
            if((num&0x1) == 1) {
                //odd
                array[i++] = num;
            }else {
                //even
                array[oddCnt++] = num;
            }
        }
    }

	public static void main(String[] args){
		Main m = new Main();
		int[] array = {1,2,3,4,5,6,7,8};
		m.reOrderArray(array);
		
	}
	        
}
