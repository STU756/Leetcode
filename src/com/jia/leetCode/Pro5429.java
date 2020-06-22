package com.jia.leetCode;

import java.util.Arrays;

public class Pro5429 {
    public int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        if(k >= len) { return arr; }
        Arrays.sort(arr);
        int[] ans = new int[k];
        int index = 0;
        int medianNumber = ((len & 1) == 1)? arr[len / 2] : (arr[len / 2 - 1] + arr[len / 2]) / 2;
        int left = 0, right = len - 1;
        while(index < k && left <= right) {
            if(Math.abs(arr[right] - medianNumber) >= Math.abs(medianNumber - arr[left])) {
                ans[index++] = arr[right --];
            }else {
                ans[index++] = arr[left++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Pro5429 pro5429 = new Pro5429();
        int[] arr =  {1,2,3,4,5 };
        int k = 2;
        System.out.println(Arrays.toString(pro5429.getStrongest(arr, k)));;
    }


}
