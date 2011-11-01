package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 *  Parliament
 *
 * Sample Input

7
Sample Output

3 4
 *
 */
public class P1032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i=2;
        int sum = 0;

        while (sum + i <= N) {
            sum += i;
            i ++;
        }

        int left = N - sum;

        if (left == (i-2)) {
            for (int j=2; j<i; j++) {
                System.out.print((j+1) + " ");
            }
        } else {
            int j=2;
            for (; j<i-left; j++) {
                System.out.print(j + " ");
            }

            for (; j<i; j++) {
                System.out.print((j+1) + " ");
            }
        }
        System.out.println();
    }
}
