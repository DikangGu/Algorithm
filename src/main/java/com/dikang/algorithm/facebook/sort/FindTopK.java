package com.dikang.algorithm.facebook.sort;

import java.util.Arrays;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * binary search
 *
 */
public class FindTopK {

    int count = 0;

    public int findTopK(int [] nums, int k, int left, int right) {
        int i = left;
        int j = right;

        count ++;
        System.out.println(count);

        int pivot = nums[i];

        while(i < j) {
            while(nums[j]>= pivot && i < j) j --;
            nums[i] = nums[j];
            while(nums[i]<=pivot && i < j) i ++;
            nums[j] = nums[i];
        }

        nums[i] = pivot;

        int m = right - i + 1;
        if (m == k) {
            System.out.println(nums[i]);
            return nums[i];
        } else if (m>k) {
            return findTopK(nums, k, i+1, right);
        } else if (m<k) {
            return findTopK(nums, k-m, left, i-1);
        }

        return 0;
    }

    public static void main(String[] argv) {
        int a[] = {7, 8, 9, 54, 6, 4, 11, 1, 2, 33};
        int b[] = a.clone();
        Arrays.sort(b);
        for (int i=0; i<b.length; i++) System.out.print(b[i] + " ");
        System.out.println();

        int k = 5;

        FindTopK findTopK = new FindTopK();
        findTopK.findTopK(a, k, 0, a.length-1);
    }
}
