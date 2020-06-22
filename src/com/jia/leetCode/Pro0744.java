package com.jia.leetCode;
/**
 * 744.寻找比目标字母大的最小字母
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。

在比较时，数组里字母的是循环有序的。举个例子：

如果目标字母 target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
如果目标字母 target = 'n' 并且有序数组为 letters = ['m', 'z', 'c', 'f', 'j'] ，则答案返回 'z' 。
 

示例：

输入:
letters = ["c", "f", "j"]
target = "a"
输出: "c"

输入:
letters = ["c", "f", "j"]
target = "c"
输出: "f"

输入:
letters = ["c", "f", "j"]
target = "d"
输出: "f"

输入:
letters = ["c", "f", "j"]
target = "g"
输出: "j"

输入:
letters = ["c", "f", "j"]
target = "j"
输出: "c"

输入:
letters = ["c", "f", "j"]
target = "k"
输出: "c"

 * 
 * @author Administrator
 *
 */
public class Pro0744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int minDistance = 26;
        int minIndex = -1;
        for(int i = 0; i < letters.length; i++) {
            int distance = letters[i] - target;
            if( distance <= 0) {
                distance += 26;
            }
            if(minDistance > distance) {
                minDistance = distance;
                minIndex = i;
            }
        }
        return letters[minIndex];
    }
}
