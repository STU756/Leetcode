package com.jia.leetCode;
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Pro0159 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
    	int i = 0;
    	char[] bufTemp = new char[4];
    	int size = 0;
        while(n>0&&(size = read4(bufTemp))>0) {
        	for(int j = 0; j < Math.min(n, size); j++) {
        		buf[i++] = bufTemp[j]; 
        	}
        	n -= 4;
        }
        return i;
    }

	private int  read4(char[] bufTemp) {
		// TODO Auto-generated method stub
		return 0;
	}
}
