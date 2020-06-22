package com.jia.leetCode;

public class Pro0006 {
	 public String convert(String s, int numRows) {
		 StringBuffer[] sb = new StringBuffer[numRows];
		 for(int i =0; i < sb.length;i++) {
			 sb[i] = new StringBuffer();
		 }
		 int len = s.length();
		 int i =0;
		 while(i < len) {
			 for(int idx = 0; idx < numRows&&i<len; idx++) sb[idx].append(s.charAt(i++));
			 for(int idx=numRows-2; idx >=1&&i<len; idx--)
				 sb[idx].append(s.charAt(i++));
		 }
		 for(i =1; i<sb.length;i++) {
			 sb[0].append(sb[i]);
		 }
		 return sb[0].toString();
	 }
}
