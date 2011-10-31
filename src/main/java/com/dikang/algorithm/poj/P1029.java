package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * False coin
 *
 * Sample Input

5 3
2 1 2 3 4
<
1 1 4
=
1 2 5
=
Sample Output

3
 */
public class P1029 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();

        int[] candidates = new int[1001];
        int[] weight = new int[1001];
        int[] data = new int[1001];

        int total = 0;
        for (int i=0; i<K; i++) {
            int pi = sc.nextInt();

            for (int j=0; j<2*pi; j++) {
                data[j] = sc.nextInt();
            }

            sc.nextLine();
            char sign = sc.nextLine().charAt(0);

            if (sign == '=') {
                for (int j=0; j<2*pi; j++) {
                    candidates[data[j]] = 1;
                }
            } else if (sign == '<') {
                total ++;

                for (int j=0; j<pi; j++) {
                    weight[data[j]] --;
                }

                for (int j=pi; j<2*pi; j++) {
                    weight[data[j]] ++;
                }
            } else if (sign == '>') {
                total ++;

                for (int j=0; j<pi; j++) {
                    weight[data[j]] ++;
                }

                for (int j=pi; j<2*pi; j++) {
                    weight[data[j]] --;
                }
            }
        }

        int count = 0;
        int pos = 0;

        for (int i=1; i<=n; i++) {
            if (candidates[i] == 1) continue;

            if (weight[i] == total || weight[i] == -total) {
                count ++;
                pos = i;
            }
        }

        if (count != 1) {
            System.out.println(0);
        } else {
            System.out.println(pos);
        }

    }
}
