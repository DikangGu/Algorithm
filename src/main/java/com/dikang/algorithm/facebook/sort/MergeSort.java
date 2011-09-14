package com.dikang.algorithm.facebook.sort;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class MergeSort {

    public void mergeSort(int[] array, int start, int end) {

        if (start < end) {
            int mid = (start + end) >> 1;

            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {
        int [] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i<=mid & j <=end) {
            if (array[i] <= array[j]) {
                tmp[k] = array[i];
                i++;
            } else {
                tmp[k] = array[j];
                j++;
            }
            k++;
        }

        while (i<=mid) {
            tmp[k] = array[i];
            k++;
            i++;
        }

        while (j<=end) {
            tmp[k] = array[j];
            k++;
            j++;
        }

        for (int t=0; t<tmp.length; t++) {
            array[t + start] = tmp[t];
        }
    }

    public static void main(String [] args) {
        int [] array = new int[]{6, 5, 3, 2,4, 1};
        new MergeSort().mergeSort(array, 0, array.length - 1);

        for (int t : array) {
            System.out.print(t + ",");
        }

        System.out.println();
    }
}
