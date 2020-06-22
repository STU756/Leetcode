package com.jia.jianzhiOffer;

import java.util.Arrays;
import java.util.List;

public class Pro20 {
    /**
    []  ： 字符集合
    ()  ： 分组
    ?   ： 重复 0 ~ 1 次
    +   ： 重复 1 ~ n 次
    *   ： 重复 0 ~ n 次
    .   ： 任意字符
    \\. ： 转义后的 .
    \\d ： 数字
    **/
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0) return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        int[] intArr  = {1,2,3,4,5};
        Integer[] integerArr  = {1,2,3,4,5};
        String[] strArr = {"1", "2", "3", "4", "5"};
        List list1 = Arrays.asList(intArr);
        List list2 = Arrays.asList(integerArr);
        List list3 = Arrays.asList(strArr);
        System.out.println("list1中的数量是：" + list1.size());
        System.out.println("list2中的数量是：" + list2.size());
        System.out.println("list3中的数量是：" + list3.size());
    }
}
