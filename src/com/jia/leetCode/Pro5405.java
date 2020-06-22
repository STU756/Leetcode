package com.jia.leetCode;

public class Pro5405 {

    public int countTriplets(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int b = 0;
                for(int k = i; k <= j; k++) {
                    b ^= arr[k];
                }
                int a = 0;
                for(int k = i; k < j; k++) {
                    a^= arr[k];
                    b ^= arr[k];
                    if(a == b) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Pro5405 pro5405 = new Pro5405();
//        int[] arr = {2,3,1,6,7};
//        int[] arr = {2,3};
//        int[] arr = {1,3,5,7,9};
        int[] arr = {7,11,12,9,5,2,7,17,22};
//        int[] arr = {1,1,1,1,1};
        System.out.println(pro5405.countTriplets(arr));;
    }
}
