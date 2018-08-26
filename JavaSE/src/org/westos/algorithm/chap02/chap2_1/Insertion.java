package org.westos.algorithm.chap02.chap2_1;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/23 10:59
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class Insertion {

    public static void sort(Comparable[] a){
        int n = a.length;

        // 这样的排序每一次都要交换
        /*for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]) ; j--) {
                exch(a, j, j-1);
            }
        }*/

        // 不需要交换的插入排序，使较大元素右移一位只需访问一次数组
        /*for (int i = 1; i < n; i++) {
            Comparable temp = a[i];
            int j = i;
            for (; j > 0 && less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }*/


        // 该循环相邻元素比较完之后数组的第一个元素a[0]是最小的
        boolean isExchanged = false;
        for (int i = n - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                isExchanged = true;
            }
        }

        // 如果没有交换，说明数组已经是有序的，直接结束方法
        if (!isExchanged) {
            return;
        }

        // a[0] 是哨兵,已经是最小的，无序判断，减少了边界判断带来的性能损耗
        for (int i = 2; i < n; i++) {
            for (int j = i; less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
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
        Integer[] a = {3, 7, 4, 6, 1};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
