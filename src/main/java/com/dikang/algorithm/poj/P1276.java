package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Cash Machine
 *
 * Sample Input

735 3  4 125  6 5  3 350
633 4  500 30  6 100  1 5  0 1
735 0
0 3  10 100  10 50  10 10
Sample Output

735
630
0
0
 *
 */
public class P1276 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int cash = sc.nextInt();
            int N = sc.nextInt();

            if (N == 0) {
                System.out.println(0);
                continue;
            }

            if (cash == 0) {
                System.out.println(0);
                for (int i=0; i<N; i++) {
                    sc.nextInt();
                    sc.nextInt();
                }
                continue;
            }

            int[] nums = new int[N];
            int[] bills = new int[N];

            int[] dp = new int[cash+5];
            int[] val = new int[500];
            int k = 0;

            for (int i=0; i<N; i++) {
                nums[i] = sc.nextInt();
                bills[i] = sc.nextInt();

                int j=1;
                while(j <= nums[i]) {
                    val[k++] = bills[i] * j;
                    nums[i] -= j;
                    j *= 2;
                }

                if (nums[i] > 0) {
                    val[k++] = bills[i] * nums[i];
                }
            }

            for (int i=0; i<k; i++) {
                for (int j=cash; j>=0; j--) {
                    if (j-val[i] >=0) {
                        dp[j] = Math.max(dp[j], dp[j-val[i]] + val[i]);
                    }
                }
            }
            System.out.println(dp[cash]);
        }
    }
}
