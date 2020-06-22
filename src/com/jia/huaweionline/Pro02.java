package com.jia.huaweionline;

import java.util.Scanner;

public class Pro02 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        char c = scanner.next().toLowerCase().charAt(0);
        int ans = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) ans++;
        }
        System.out.println(ans);
    }
}