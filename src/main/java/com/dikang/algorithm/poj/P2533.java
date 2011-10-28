package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Longest Ordered Subsequence
 *
 * Sample Input

7
1 7 3 5 9 4 8
Sample Output

4
 */
public class P2533 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n];
        int[] len = new int[n];

        for (int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }

        len[0] = 1;
        for (int i=1; i<n; i++) {
            len[i] = 1;
            for (int j=0; j<i; j++) {
                if (num[j] < num[i]) {
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(max, len[i]);
        }
        System.out.println(max);
    }
}
