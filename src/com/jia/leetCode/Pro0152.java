package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//dp problem
public class Pro0152 {
	 public int maxProduct(int[] A) {
	        int po = 0, ne = 0, res = A[0];

	        for(int i=0; i<A.length;i++){
	            if(A[i]>0){
	                po = (po*A[i]>A[i]) ? po*A[i]:A[i];
	                ne = ne * A[i];
	                if(po > res)    res = po;
	            }else if(A[i]<0){
	                int buff = ne;
	                ne = (po*A[i]>A[i]) ? A[i]:po*A[i];
	                po = buff * A[i];
	                if(po!=0 && po > res)   res = po;
	            }else if(A[i] == 0){
	                po = 0; ne = 0;
	                if(res < 0)     res = 0;
	            }
	        }
	        return res;
	    }

}
