package com.jia.niukewang;

import java.util.Scanner;

public class Pro01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int k = scanner.nextInt();
        if((x + y + z) < (k+3))
        	throw new RuntimeException("非法切割.");
        int sum = x + y + z;
        int min = Math.min(Math.min(x, y), z);
        int max = Math.max(Math.max(x, y), z);
        long result = 0;
         if(min * 3 >= (k + 3)){
        	int temp = k / 3;
        	result = (temp +1) * (temp + 1) * (k - 2*temp + 1);
        }else {
        	int mid = sum - min - max;
        	if(mid * 2 >= (k - (min - 1) + 2)) {
        		int temp = (k - (min - 1)) / 2;
        		result = min * (temp + 1) * (k - (min - 1) - temp + 1);
        	}
        }
        System.out.println(result);
        
    }
}
