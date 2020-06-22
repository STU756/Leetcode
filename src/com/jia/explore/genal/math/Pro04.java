package com.jia.explore.genal.math;

public class Pro04 {
    public int romanToInt(String s) {
    	int length = s.length();
        int[] charVals = new int[length];
        charVals[0] = getValue(s.charAt(0));
        int sum = charVals[0];
        for(int i = 1; i < length; i++) {
        	charVals[i] = getValue(s.charAt(i));
        	sum+=charVals[i];
        	if(charVals[i-1] <charVals[i])
        		sum -= (2*charVals[i-1]);
        }
        return sum;
    }
    private int getValue(char c) {
    	switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;

		default:
			break;
		}
    	return 0;
    }
}
