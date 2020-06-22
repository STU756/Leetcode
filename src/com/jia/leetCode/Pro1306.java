package com.jia.leetCode;

public class Pro1306 {
	boolean[] visited;
    public boolean canReach(int[] arr, int start) {
    	if(arr == null || arr.length == 0 ||start < 0 || start >= arr.length) 
    		return false;
        visited = new boolean[arr.length];
        return bfs(arr, start);
    }
	private boolean bfs(int[] arr, int start) {
		if(arr[start] == 0) return true;
		visited[start] = true;
		int x1 = start + arr[start];
		int x2 = start - arr[start];
		boolean isFind1 = false;
		boolean isFind2 = false;
		if(x1 >= 0 && x1 < arr.length && !visited[x1]) {
			isFind1 = bfs(arr, x1);
		}
		if(x2 >= 0 && x2 < arr.length && !visited[x2]) {
			isFind2 = bfs(arr, x2);
		}
		return isFind1 || isFind2;
	}
}
