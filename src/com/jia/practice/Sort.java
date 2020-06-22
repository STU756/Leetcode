package com.jia.practice;


import java.util.Arrays;


public class Sort {


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 4, 6, 4, 2, 8, 9};
//		 System.out.println(Arrays.toString(bubbleSort(arr)));
//		 System.out.println(Arrays.toString(insertSort(arr)));
//		System.out.println(Arrays.toString(binaryInsertSort(arr)));
//		System.out.println(Arrays.toString(bucketSort(arr)));
//        System.out.println(Arrays.toString(mergeSort(arr)));
//		System.out.println(Arrays.toString(quicklySort(arr)));
        System.out.println(Arrays.toString(heapSort(arr)));


    }



    private static int[] mergeSort(int[] arr) {
        mSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mSort(int[] arr, int st, int ed) {
        if(st < ed) {
            int m = st + ((ed - st) >> 1);
            mSort(arr, st, m);
            mSort(arr, m + 1, ed);
            merge(arr, st, m, ed);
        }
    }

    private static void merge(int[] arr, int st, int m, int ed) {
        int left1 = st, left2 = m + 1;
        int[] tmpArr = new int[arr.length];
        int index = st;
        while(left1 <= m && left2 <= ed) {
            if(arr[left1] < arr[left2]) {
                tmpArr[index ++ ] = arr[left1++];
            }else {
                tmpArr[index++] = arr[left2++];
            }
        }
        while(left1 <= m) tmpArr[index++] = arr[left1++];
        while(left2 <= ed) tmpArr[index++] = arr[left2++];
        //copy array
        while(st <= ed) arr[st] = tmpArr[st++];
    }

    private static int[] quicklySort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void qSort(int[] arr, int st, int ed) {
        int povit = arr[st], left = st, right = ed;
        while (left < right) {
            while (left < right && arr[right] >= povit) --right;
            if (left < right) arr[left++] = arr[right];
            while (left < right && arr[left] <= povit) ++left;
            if (left < right) arr[right--] = arr[left];
        }
        arr[left] = povit;
        if (left - st > 1) qSort(arr, st, left - 1);
        if (ed - right > 1) qSort(arr, right + 1, ed);
    }


    private static int[] bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        int[] buckets = new int[max - min + 1];
        for (int val : arr) {
            ++buckets[val - min];
        }
        int i = 0, j = 0;
        while (i < arr.length) {
            while (buckets[j] > 0) {
                --buckets[j];
                arr[i++] = j + min;
            }
            j++;
        }
        return arr;
    }

    private static int[] binaryInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int st = 0, ed = i - 1;
            int tmp = arr[i];
            while (st <= ed) {
                int m = st + ((ed - st) >> 1);
                if (arr[m] > tmp) {
                    ed = m - 1;
                } else if (arr[m] <= tmp) {
                    st = m + 1;
                }
            }
            System.out.println(st);
            int index = i - 1;
            while (index >= st) {
                arr[index + 1] = arr[index];
                --index;
            }
            arr[st] = tmp;
        }
        return arr;
    }

    private static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = temp;
        }
        return arr;
    }


    private static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean isSort = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int j, int i) {
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
    }

    private static int[] heapSort(int[] arr) {
        for(int i = arr.length / 2; i >=0; i--) {
            buildHeap(arr, arr.length, i);
        }
        for(int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            buildHeap(arr, i, 0);
        }
        return arr;
    }

    private static void buildHeap(int[] arr, int heapSize, int index) {
        int left = index << 1, right = (index << 1) + 1;
        int largestIndex = index;
        if(left < heapSize && arr[left] > arr[largestIndex]) largestIndex = left;
        if(right < heapSize && arr[right] > arr[largestIndex]) largestIndex = right;
        if(largestIndex!=index) {
            swap(arr, largestIndex, index);
            buildHeap(arr, heapSize, largestIndex);
        }
    }
}
