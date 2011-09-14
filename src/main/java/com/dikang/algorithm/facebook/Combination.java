package com.dikang.algorithm.facebook;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class Combination {
    int[] result = new int[10];
    public int len;

    public void printCombination(int k, int n) {

        if (k==0) {
            for (int i=1; i<=len; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }

        for(int i=k; i<=n; i++) {
            result[k] = i;
            printCombination(k-1, i-1);
        }
    }

    public static void main(String[] argv) {

        Combination combination = new Combination();
        combination.len = 2;
        combination.printCombination(2, 4);
    }
}
