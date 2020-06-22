package com.jia;

public class GCDemo {
    public static void main(String[] args) {

        {
            char[] chars = "aa".toCharArray();
            byte[] buf = new byte[1024 * 1024 * 30];
        }
        int a = 0;
        /**
         * [GC (System.gc()) [PSYoungGen: 34653K->824K(76288K)] 34653K->832K(251392K), 0.0010010 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [Full GC (System.gc()) [PSYoungGen: 824K->0K(76288K)] [ParOldGen: 8K->628K(175104K)] 832K->628K(251392K), [Metaspace: 3206K->3206K(1056768K)], 0.0051891 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * Heap
         *  PSYoungGen      total 76288K, used 655K [0x000000076af00000, 0x0000000770400000, 0x00000007c0000000)
         *   eden space 65536K, 1% used [0x000000076af00000,0x000000076afa3ee8,0x000000076ef00000)
         *   from space 10752K, 0% used [0x000000076ef00000,0x000000076ef00000,0x000000076f980000)
         *   to   space 10752K, 0% used [0x000000076f980000,0x000000076f980000,0x0000000770400000)
         *  ParOldGen       total 175104K, used 628K [0x00000006c0c00000, 0x00000006cb700000, 0x000000076af00000)
         *   object space 175104K, 0% used [0x00000006c0c00000,0x00000006c0c9d030,0x00000006cb700000)
         *  Metaspace       used 3212K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 349K, capacity 388K, committed 512K, reserved 1048576K
        **/
        System.gc();//没有buf的原因，在编译的时候buf的 slot被复用了，而没有用{}包裹buf的时候ParOldGen存在buf对象
    }
}
