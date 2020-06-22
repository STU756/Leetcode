package com.jia.huaweionline;

import java.util.Scanner;

public class Pro01 {
    public static void main(String...args) {
        int ans = 0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length() - 1;
        while(len >= 0 && str.charAt(len) == ' ') --len;
        int tail = len;
        while(len >= 0 && !(str.charAt(len) == ' ')) --len;
        System.out.println(tail - len);
    }
}
