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

        int i=1;
        int sum = 0;

        while (sum + i + 1 <= N) {
            i++;
            sum += i;
        }

        int left = N - sum;

        if (left == i) {
            for (int j=3; j<=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println(i+2);
        } else if (left == 0) {
            int j = 2;
            for (;j<i; j++)
                System.out.print(j + " ");
            System.out.println(i);
        } else {
            int j=2;
            for (; j<=i-left; j++) {
                System.out.print(j + " ");
            }

            j = i-left + 2;
            for (; j<=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println(i+1);
        }
    }
}
