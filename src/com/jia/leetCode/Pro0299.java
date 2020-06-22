package com.jia.leetCode;

public class Pro0299 {
    public String getHint(String secret, String guess) {
        int[] bucket = new int[10];
        int bull = 0, cow = 0;
        for(int i = 0; i < secret.length(); i++) {
        	if(secret.charAt(i) == guess.charAt(i)) {
        		++bull;
        		continue;
        	}
        	bucket[secret.charAt(i) - '0'] += 1;
        	bucket[guess.charAt(i) - '0'] -= 1;
        }
        for(int i =0; i< bucket.length; i++) {
        	if(bucket[i] > 0)
        		cow += bucket[i];
        }
        cow = secret.length() - cow - bull;
        return bull + "A" + cow + "B";
    }
}
