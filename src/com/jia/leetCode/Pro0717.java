package com.jia.leetCode;

public class Pro0717 {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0; i<bits.length;) {
        	if(i==bits.length - 1 && bits[i] == 0) return true;
        	if(bits[i] == 1) i+=2;
        	else 
        		++i;
        }
        return false;
    }
    
    public static void main(String[] args) {
		Pro0717 pro0717 = new Pro0717();
		System.out.println(pro0717.isOneBitCharacter(new int[]{1, 0, 0}));
		System.out.println(pro0717.isOneBitCharacter(new int[]{0, 0, 0}));
		System.out.println(pro0717.isOneBitCharacter(new int[]{0}));
		System.out.println(pro0717.isOneBitCharacter(new int[]{1}));
		System.out.println(pro0717.isOneBitCharacter(new int[]{1, 1, 1, 0}));
	}
}
