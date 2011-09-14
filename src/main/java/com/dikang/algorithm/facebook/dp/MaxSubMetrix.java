package com.dikang.algorithm.facebook.dp;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class MaxSubMetrix {

    // O(n)
    public int calOneDim(int[] array) {
        int max = array[0];

        int count = 0;
        for(int i=0; i<array.length; i++) {
            if (count < 0) {
                count = 0;
            }

            count += array[i];
            if (max < count) max = count;
        }
        return max;
    }

    // O(n^3)
    public int calTwoDims(int[][] array) {
        int len = array.length;
        int max = Integer.MIN_VALUE;

        int [][][] sum = new int [len][len][len];

        for (int i=0; i<len; i++) {
            for (int k=0; k<len; k++) {
                sum[i][i][k] = array[i][k];
            }

            for (int j=i+1; j<len; j++) {
                for (int k=0; k<len; k++) {
                    sum[i][j][k] = sum[i][j-1][k] + array[j][k];
                }

                int value = calOneDim(sum[i][j]);
                if (max < value) {
                    max = value;
                }
            }
        }

        return max;
    }
}
