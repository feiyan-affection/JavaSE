package org.westos.algorithm.chap02.chap2_3;

import org.junit.Test;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/26 10:06
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description： 快速排序
 */
public class Quick {

    public static void sort(Comparable[] src) {
        sort(src, 0, src.length - 1);
    }

    private static void sort(Comparable[] src, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(src, low, high);
        sort(src, low, j - 1);
        sort(src, j + 1, high);
    }

    private static int partition(Comparable[] src, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = src[low];
        while (true) {
            while (less(src[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            while (less(v, src[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(src, i, j);
        }
        exch(src, low, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] src, int i, int j) {
        Comparable t = src[i];
        src[i] = src[j];
        src[j] = t;
    }

    private static void show(Comparable[] src) {
        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] src) {
        for (int i = 0; i < src.length; i++) {
            if (less(src[i], src[i - 1])) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSort(){
        Comparable[] src = {3, 2, 5, 8, 4, 7, 6, 9, 1};
        sort(src);
        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i] + " ");
        }
    }

    public void part(int[] arr, int low, int high){
        int i = low;
        int j = high;
        int k = 0;
        int v = arr[low];

        while (i <= j){
            while (arr[j] > v){
                j--;
            }

            while (arr[i] < v){
                i++;
            }

            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        while (i <= low){

        }

        while (j <= high){

        }
    }
}
