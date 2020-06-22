package com.jia.jianzhiOffer;

import java.util.HashMap;

public class Pro21 {
    //Time:O(n) Space:O(n)
    public void reOrderArray2(int [] array) {
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
    // bubble sort  Time:O(n^2)
     public void reOrderArray(int [] array) {
         int N = array.length;
         for(int i = N - 1; i > 0; i--) {
             for(int j = 0; j < i;j++) {
                 if((array[j]&1)==0 && (array[j+1]&1)==1) {
                     swap(array, j, j+1);
                 }
             }
         }
     }
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
}
