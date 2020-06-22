package com.jia.jianzhiOffer;

/**
 * 17.打印从1到最大的n的位数
 *
 */
public class Pro17 {
    public int[] printNumbers(int n) {
        if(n < 1) return null;
        n = (int)Math.pow(10, n);
        int[] ret = new int[n-1];
        for(int i = 1; i < n; i++) {
            ret[i-1] = i;
        }
        return ret;
    }


    /**
     * n表示位数
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        if(n <= 0) {
            return;
        }
        int[] digits = new int[n];

        print1ToMaxOfNDigitsRecursively(digits, 0, n);
    }

    private void print1ToMaxOfNDigitsRecursively(int[] digits, int index, int n) {
        if(index == n) {
            printNumber(digits);
            return;
        }
        for(int i = 0; i < 10; i++) {
            digits[index] = i;
            print1ToMaxOfNDigitsRecursively(digits, index + 1, n);
        }
    }

    private void printNumber(int[] digits) {
        if(digits == null || digits.length == 0) return;
        boolean isPreZero = true;
        for(int i = 0; i < digits.length; i++) {
            if(digits[i] != 0 || !isPreZero) {
                System.out.print(digits[i]);
                isPreZero = false;
            }
        }
        if(isPreZero) System.out.print(0);
        System.out.println();
    }

    public static void main(String[] args) {
        Pro17 pro17 = new Pro17();
        pro17.print1ToMaxOfNDigits(1);
    }
}
