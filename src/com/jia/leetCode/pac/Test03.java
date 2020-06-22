package com.jia.leetCode.pac;


public class Test03 {
	public int wiggleMaxLength(int[] nums) {
	    if(nums.length < 2){
	        return nums.length;
	    }
	    final int BEGAN = 0;
	    final int UP = 1;
	    final int DOWN = 2;
	    int stat = BEGAN;
	    int res = 1;
	    for (int i = 1; i < nums.length; i++) {
	        switch (stat) {
	            case BEGAN:{
	                //如果后者比前面的小就要将下一轮放置在UP上面，因为下一轮需要判断的是上升的情况
	                if (nums[i - 1] < nums[i]) {
	                    stat = UP;
	                    res ++;      
	                    break;                 
	                } else if(nums[i - 1] > nums[i]) {
	                    stat = DOWN;
	                    res ++;
	                    break;
	                }else{
	                    break;
	                }
	            }
	            case UP:{
	                if (nums[i - 1] > nums[i]) {
	                    stat = DOWN;
	                    res ++;
	                }
	                //如果下面的还是比上个up，则直接跳出，轮到下一个，且状态不变
	                break;

	            }
	            case DOWN:{
	                if (nums[i - 1] < nums[i]) {
	                    stat = UP;
	                    res ++;
	                }
	                //如果下面的还是比上个up，则直接跳出，轮到下一个，且状态不变
	                break;
	            }
	           
	        }
	        
	    }
	    return res;
	    
	}
    
    public static void main(String[] args) {
    	int[] nums = {1,17,5,10,13,15,10,5,16,8};
		Test03 test03 = new Test03();
		System.out.println(test03.wiggleMaxLength(nums));;
	}
}
