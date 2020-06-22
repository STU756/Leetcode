package com.jia;

import java.util.*;
import java.util.stream.Stream;

class This {
     static void two(int i, double d) {}
//    void three(int i, double d, String s) {}
//    void four(int i, double d, String s, char c) {}
}

 interface TwoArgs {
    void call2(int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(
            This athis, int i, double d, String s, char c);
}

public class MultiUnbound {
    public static void main(String[] args) {
//        TwoArgs twoargs = This::two;
//        ThreeArgs threeargs = This::three;
//        FourArgs fourargs = This::four;
//        This athis = new This();
//        twoargs.call2(athis, 11, 3.14);
//        threeargs.call3(athis, 11, 3.14, "Three");
//        fourargs.call4(athis, 11, 3.14, "Four", 'Z');
        TwoArgs twoargs = This::two;
        twoargs.call2(11, 3.14);

        new Random(47)
                .ints(5, 20)
                .limit(7)
                .sorted()
                .forEach(System.out::println);

        Stream.of(3.232,23432.23,3242.234)
                .forEach(System.out::println);
        List<Integer> lists = Arrays.asList(new Integer(1), new Integer(2), new Integer(3) );

        String str = "For example, add more methods to random. As long as the original method is not changed, the existing code will not be disturbed.\n" +
                "\n" +
                "\n" +
                "\n" +
                "The question is, how to transform the interface part? In particular, it involves the part of the collection class interface. If you want to " +
                "convert a collection into a stream, adding new methods directly to the interface will destroy all the old interface implementation classes.";
        Set<Integer> sets  = new HashSet<>(Arrays.asList(new Integer(1), new Integer(2), new Integer(3) ));
        sets.stream().map(e->e + 32).forEach(System.out::println);
        System.out.println("-------------------");
        System.out.println("-------------------");



    }


}