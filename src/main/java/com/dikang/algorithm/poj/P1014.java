package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Dividing
 */
public class P1014 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int caseNo = 0;
        while(sc.hasNext()) {
            caseNo ++;
            int sum = 0;
            int[] data = new int[6];
            for (int i=0; i<6; i++) {
                data[i] = sc.nextInt();
                sum += data[i]*(i+1);
            }

            if (sum == 0) break;

            System.out.println("Collection #" + caseNo + ":");
            if (solve(data, sum)) {
                System.out.println("Can be divided.");
            } else {
                System.out.println("Can't be divided.");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[] data, int sum) {
        if (sum % 2 !=0)
            return false;

        int[] value = new int[500];
        boolean[] dp = new boolean[sum/2 + 1];
        int k = 0;

        for (int i=0; i<6; i++) {
            int j=1;
            while (j<data[i]) {
                value[k++] = (i+1) * j;
                data[i] -= j;
                j*=2;
            }

            if (data[i] > 0) {
                value[k++] = (i+1)*data[i];
            }
        }

        dp[0] = true;
        for (int i=0; i<k; i++) {
            for (int j=sum/2; j>=0; j--) {
                if (j>=value[i]) {
                    dp[j] = dp[j-value[i]] == true? dp[j-value[i]] : dp[j];
                }
            }
        }

        return dp[sum/2];
    }


}
