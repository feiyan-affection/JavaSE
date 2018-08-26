package org.westos.algorithm.chap02.chap2_2;

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
 * @Date: Created in 2018/8/26 9:06
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description: 间接排序
 */
public class IndirectMergeSort {

    public int[] merge(Comparable[] src, int low, int mid, int high, int[] perm){
        int i = low;
        int j = mid + 1;

        Comparable[] temp = src.clone();
        for (int k = low; k <= high; k++) {
            temp[k] = perm[k];
        }

        for (int k = low; k <= high; k++) {
            if(i > mid){
                perm[k] = (int) temp[j++];
            }else if(j > high){
                perm[k] = (int) temp[i++];
            }else if(less(src[(int) temp[j]], src[(int) temp[i]])){
                perm[k] = (int) temp[j++];
            }else{
                perm[k] = (int) temp[i++];
            }
        }

        return perm;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public int[] sort(Comparable[] src, int low, int high, int[] perm){

        if(low >= high){
            return perm;
        }

        int mid = low + (high - low) / 2;
        perm = sort(src, low, mid, perm);
        perm = sort(src, mid + 1, high, perm);
        perm = merge(src, low, mid, high, perm);

        return perm;
    }

    public int[] sort(Comparable[] src){
        int[] perm = new int[src.length];

        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }

        return sort(src, 0, src.length-1, perm);
    }

    @Test
    public void testSort(){
        Comparable[] src = {3, 2, 5, 8, 4, 7, 6, 9, 1};
        int[] perm = sort(src);
        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < perm.length; i++) {
            System.out.print(perm[i] + " ");
        }
    }
}