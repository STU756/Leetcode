package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0091 {
    public int numDecodings(String s) {     
        if(s.isEmpty()||s.charAt(0)=='0') return 0;
        int[] counts=new int[s.length()+1];
        counts[0]=1;
        counts[1]=1;
        for(int i=1;i<s.length();i++){                                      //counts[i+1] stores the count for s.charAt(i)
            int digit2 = Integer.parseInt(s.substring(i-1,i+1));            //validating the integer represented by this and the last digits
            if(digit2==0) return 0;
            if(digit2<=26&&digit2>=10&&(i==s.length()-1||s.charAt(i+1)!='0')) counts[i+1]+=counts[i-1];
            if(s.charAt(i)!='0') counts[i+1]+=counts[i];                    //validating current digit
        }
        return counts[s.length()];
    }
}
