package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1050 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] metrix = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                metrix[i][j] = sc.nextInt();
            }
        }

        int[] sum = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sum[j] = metrix[i][j];
            }

            int tmp = calculateMax(sum, n);
            max = Math.max(max, tmp);
            for (int j=i+1; j<n; j++) {
                for (int k=0; k<n; k++) {
                    sum[k] += metrix[j][k];
                }

                tmp = calculateMax(sum, n);
                max = Math.max(max, tmp);
            }
        }

        System.out.println(max);
    }

    public static int calculateMax(int[] data, int n) {
        int sum = data[0];
        int max = sum;

        for (int i=1; i<n; i++) {
            if (sum < 0) {
                sum = data[i];
            } else {
                sum += data[i];
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
