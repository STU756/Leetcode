package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jia
 * 
 */
public class Pro0004 {
	/*
	 * public double findMedianSortedArrays(int[] A, int[] B) { int la =
	 * A.length; int lb = B.length; if (A == null || la == 0) { if (B == null ||
	 * lb == 0) { return 0.0; } return ((lb & 1) == 1) ? B[(lb + 1) >> 1] :
	 * (B[lb >> 1] + B[(lb + 1) >> 1]) * .5; } if (B == null || lb == 0) { if (A
	 * == null || la == 0) return 0.0; return ((la & 1) == 1) ? A[(la + 1) >> 1]
	 * : (A[la >> 1] + A[(la + 1) >> 1]) * .5; } return (((la + lb) & 1) == 1) ?
	 * find(A, B, la, lb, (la + lb + 1) >> 1) : (find(A, B, la, lb, (la + lb) >>
	 * 1) + find(A, B, la, lb, (la + lb) >> 1 + 1)) * .5;
	 * 
	 * }
	 * 
	 * private int find(int[] a, int[] b, int la, int lb, int k) { int i = 0, j
	 * = 0; for (; (i < la) && (j < lb);) { --k; if (a[i] < b[j]) { if (k == 0)
	 * { return a[i]; } ++i; } else if (k == 0) { return b[j]; } else { ++j; } }
	 * return (i >= la) ? b[j + k - 1] : a[i + k - 1]; }
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        return (find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2 + 1) / 2) + find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1)) * 0.5;
    }

    
    private int find(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int cnt) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //确保nums1是短的
        if (len1 > len2) {
            return find(nums2, start2, end2, nums1, start1, end1, cnt);
        }
        //如果len1已经为空，直接从nums2找
        if (len1 == 0) {
            return nums2[start2 + cnt - 1];
        }
        //找第1个数，比较nums1[0]和nums2[0]谁更小即可
        if (cnt == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //因为nums1比较短，因此取位置时要考虑实际长度
        int pos1 = start1 + Math.min(cnt / 2, len1) - 1;
        int pos2 = start2 + cnt / 2 - 1;
        if (nums1[pos1] > nums2[pos2]) {
            return find(nums1, start1, end1, nums2, pos2 + 1, end2, cnt - cnt / 2);
        } else {
            return find(nums1, pos1 + 1, end1, nums2, start2, end2, cnt - Math.min(cnt / 2, len1));
        }
    }


	public static void main(String[] args) {
		int[]	B = {1};
		int[]   A = {1};
		System.out.println(new Pro0004().findMedianSortedArrays(A, B));
	}
}
