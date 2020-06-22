package com.jia;

public class OutClass {

    class InnerClass {
    }

    static class StaticInnerClass {
    }

    public static void main(String[] args) {
        // InnerClass innerClass = new InnerClass(); // 'OuterClass.this' cannot be referenced from a static context
    	OutClass outerClass = new OutClass();
        InnerClass innerClass = outerClass.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        StaticInnerClass staticInnerClass2 = new StaticInnerClass();
        System.out.println(staticInnerClass == staticInnerClass2);
    }
}
