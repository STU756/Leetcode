package com.jia.leetCode;

public class Pro1217 {
    public int minCostToMoveChips(int[] chips) {
    	int odd = 0, even = 0;
        for (int x : chips) {
            if ((x & 1) !=1) ++odd;
            else ++even;
        }
        return Math.min(odd, even);
    }
}
