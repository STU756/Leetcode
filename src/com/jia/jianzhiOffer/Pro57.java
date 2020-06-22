package com.jia.jianzhiOffer;

import java.util.ArrayList;

public class Pro57 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        //two points
        if(array == null || array.length < 2) return new ArrayList<Integer>();
        int l = 0, r = array.length - 1;
        ArrayList<Integer> ret = new ArrayList<>();
        while(l < r) {
            if(array[l] + array[r] == sum) {
                
                ret.add(array[l]);
                ret.add(array[r]);
                return ret;
            }else if(array[l] + array[r] > sum) {
                --r;
            }else {
                ++l;
            }
        }
        return ret;
    }
    
    public int[] twoSum(int[] array, int sum) { 
        //two points
        if(array == null || array.length < 2) return null;
        int l = 0, r = array.length - 1;
        while(l < r) {
            if(array[l] + array[r] == sum) {
                return new int[]{array[l], array[r]};
            }else if(array[l] + array[r] > sum) {
                --r;
            }else {
                ++l;
            }
        }
        return null;
    }
}
