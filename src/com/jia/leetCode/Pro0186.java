package com.jia.leetCode;

public class Pro0186 {
	public void reverseWords(char[] s){
		reverse(s, 0, s.length);
		for(int i= 0, j=0; j<=s.length; j++) {
			if(j == s.length ||s[j] == ' '){
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}
	
	/**
	 * reverse the string of the index from start to end
	 * @param s 
	 * @param start 
	 * @param end 
	 */
	private void reverse(char[] s, int start, int end) {
		for(int i=0; i<(end - start) /2; i++){
			char temp = s[start + i];
			s[start + i] = s[end -i -1];
			s[end -i - 1] = temp;
		}
	}
}
