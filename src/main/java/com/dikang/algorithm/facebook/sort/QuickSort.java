package com.dikang.algorithm.facebook.sort;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class QuickSort {

    public void quickSort(int [] array, int start, int end) {
        if (start < end) {
            int mid = partion(array, start, end);
            quickSort(array, start, mid - 1);
            quickSort(array, mid+1, end);
        }
    }

    private int partion(int[] array, int start, int end) {

        int pivot = array[start];
        while (start < end) {
            while(array[end] >= pivot && start < end) end --;
            array[start] = array[end];
            while(array[start] <= pivot && start < end) start ++;
            array[end] = array[start];
        }

        array[start] = pivot;

        return start;
    }


    public static void main(String[] argv) {
        QuickSort quickSort = new QuickSort();
        int [] array = new int[] {3, 1, 2, 6, 5, 4};
        quickSort.quickSort(array, 0, array.length - 1);

        for (int item : array) {
            System.out.print(item);
            System.out.print(" ");
        }
    }
}
