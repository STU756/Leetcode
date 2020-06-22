package com.jia.leetCode.sortandsearch;

import java.util.Collections;

public class SortandSearch {


	/*
	 * public boolean searchMatrix(int[][] matrix, int target) { int m =
	 * matrix.length; int n = matrix[0].length; for(int r=0, c = n-1; r<m && c
	 * >=0;) { if(matrix[r][c] > target) { c--; }else if(matrix[r][c] < target)
	 * { r++; }else { return true; } } return false; }
	 */
	public boolean find(int[][] a, int x1, int y1, int x2, int y2, int target) {
		if ((x1 > x2) || (y1 > y2)) {
			return false;
		}
		int midx = (x1 + x2) >> 1;
		int midy = (y1 + y2) >> 1;
		if (a[midx][midy] == target) {
			return true;
		}
		return (a[midx][midy] > target) ? (find(a, x1, y1, midx - 1, y2, target) || find(
				a, midx, y1, x2, midy - 1, target))
				: (find(a, x1, midy + 1, x2, y2, target) || find(a, midx + 1,
						y1, x2, midy, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		return find(matrix, 0, 0, m - 1, n - 1, target);
	}
	
	
	/**
	 * �������кõ��������λ��
	 */
	
	public double findMedianSortedArrays(int[] A,int[] B) {
		int la = A.length;
		int lb = B.length;
		if(A == null || la == 0) {
			return (B==null)?0.0:(((lb &1) == 0)?(B[lb>>1-1]+B[lb>>1])*.5:B[lb>>1]);
		}
		if(B == null || lb==0) {
			return (A==null)?0.0:(((la & 1) == 0)?(A[la>>1-1] + A[la>>1]*.5):A[la>>1]);
		}
		
		return (((la + lb)&1) == 1)?find2(A,B,la,lb,(la+lb)>>1):
			(find2(A,B,la,lb,(la+lb)>>1 -1) + find2(A,B, la,lb,(la+lb)>>1))*.5;
	}

	private int find2(int[] a, int[] b, int la, int lb, int k) {
		int i =0, j = 0;
		for(;(i<la)&&(j<lb);) {
			--k;
			if(a[i]<b[j]) {
				if(k==0) {
					return a[i];
				}
				i++;
			}else if(k == 0) {
				return b[j];
			} else {
				j++;
			}
		}
		return (i>=la)?b[j+k-1] : a[i+k-1];
	}
	
	/**
	 * ������������
	 */
	void sortColors(int A[], int n) {
		int i =0;
		int j = n;
		for(int k=0;k<j;++k) {
			if(A[k] == 0){
				swap(A, i, k);
				i++;
			}else if(A[k] == 2) {
				swap(A,--j,k--);
			}
		}
	}

	private void swap(int[] a, int i, int k) {
		int temp = a[i];
		a[i] = a[k];
		a[k] = temp;
	}
	
	
}
