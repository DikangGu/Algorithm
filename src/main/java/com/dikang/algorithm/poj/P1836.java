package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1836 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        float[] heights = new float[n];

        for(int i=0; i<n; i++) {
            heights[i] = sc.nextFloat();
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int max = 0;

        dp1[0] = 1;
        for (int i=1; i<n; i++) {
            dp1[i] = 1;

            for (int j=0; j<i; j++) {
                if (heights[j] < heights[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }

            }
        }

        dp2[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            dp2[i] = 1;
            for (int j=i+1; j<n; j++) {
                if (heights[j] < heights[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                max = Math.max(max, dp1[i] + dp2[j]);
            }
        }

        System.out.println(n - max);
    }
}
