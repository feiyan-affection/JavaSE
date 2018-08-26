package org.westos.algorithm.chap02.chap2_2;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/23 15:43
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class Merge {

    // 归并所需的辅助数组
    private static Comparable[] T;

    /**
     *  原地归并排序
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void mergeSort(Comparable[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;

        // 将a数组复制到t数组中
        for (int k = low; k <= high; k++) {
            T[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = T[j++];
            } else if (j > high) {
                a[k] = T[i++];
            } else if (less(T[j], a[i])) {
                a[k] = T[j++];
            } else {
                a[k] = T[i++];
            }
        }
    }


    public static void sort(Comparable[] a, int low, int high) {
        if(low >= high){
            return;
        }
        int mid = low + (high - low)/2;
        sort(a, low, mid);
        sort(a, mid+1, high);
        mergeSort(a, low, mid, high);
    }

    /**
     * 自顶向下归并
     * @param a
     */
    public static void sortFromUpToBottom(Comparable[] a) {
        T = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    /**
     * 子底向上归并
     * @param a
     */
    public static void sortFromBottomToUp(Comparable[] a) {
        int n = a.length;
        T = new Comparable[a.length];

        // i : 子数组大小
        for (int i = 1; i < n ; i=i+i) {
            // j : 子数组的索引
            for (int j = 0; j < n-i; j+=i+i) {
                mergeSort(a, j, j+i-1, Math.min(j+i+i-1, n-1));
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {3, 2, 5, 8, 4, 7, 1, 9, 6};
        sortFromUpToBottom(a);
        sortFromBottomToUp(a);
        show(a);
    }
}
