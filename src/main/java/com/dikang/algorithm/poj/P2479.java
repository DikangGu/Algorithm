package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Maximum sum
 *
 *
 Sample Input

1

10
1 -1 2 2 3 -3 4 -4 5 -5
 Sample Output

 13
 */
public class P2479 {

    private static int[] forward = new int[50002];
    private static int[] backward = new int[50002];
    private static int[] data = new int[50002];

    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int caseNo = Integer.valueOf(line);

        for (int i=0; i<caseNo; i++) {
            int n = sc.nextInt();

            int max = Integer.MIN_VALUE;
            int result = max;

            for (int j=0; j<n; j++) {
                data[j] = sc.nextInt();

                if (result <0) {
                    result = data[j];
                } else {
                    result += data[j];
                }

                if (max < result)
                    max = result;

                forward[j] = max;
            }

            max = Integer.MIN_VALUE;
            result = max;

            for (int j=n-1; j>=0; j--) {
                if (result < 0) {
                    result = data[j];
                } else {
                    result += data[j];
                }

                if (max < result)
                    max = result;

                backward[j] = max;
            }

            max = Integer.MIN_VALUE;
            for (int j=1; j<n; j++) {
                //long t = calOneDim(data, 0, i-1) + calOneDim(data, i, len-1);
                int t = forward[j-1] + backward[j];
                if (max < t) {
                    max = t;
                }
            }

            System.out.println(max);
        }

    }

    private static int calculate(int[] data, int len) {
        int max = Integer.MIN_VALUE;

        calOneDim(data, len);

        for (int i=1; i<len; i++) {
            //long t = calOneDim(data, 0, i-1) + calOneDim(data, i, len-1);
            int t = forward[i-1] + backward[i];
            if (max < t) {
                max = t;
            }
        }

        return max;
    }

    private static void calOneDim(int[] data, int len) {

        int max = Integer.MIN_VALUE;
        int result = max;
        for (int i=0; i<len; i++) {
            if (result <0) {
                result = data[i];
            } else {
                result += data[i];
            }

            if (max < result)
                max = result;

            forward[i] = max;
        }

        max = Integer.MIN_VALUE;
        result = max;

        for (int i=len-1; i>=0; i--) {
            if (result < 0) {
                result = data[i];
            } else {
                result += data[i];
            }

            if (max < result)
                max = result;

            backward[i] = max;
        }
    }
}
