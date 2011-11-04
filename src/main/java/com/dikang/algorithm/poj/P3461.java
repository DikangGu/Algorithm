package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Oulipo
 *
 * Sample Input

3
BAPC
BAPC
AZA
AZAZAZA
VERDI
AVERDXIVYERDIAN
Sample Output

1
3
0


 */
public class P3461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<n; i++) {
            String w = sc.nextLine().trim();
            String t = sc.nextLine().trim();

            int len = w.length();
            int[] next = new int[len];

            next[0] = -1;
            int k = -1;

            for (int j=1; j<len; j++) {
                while (k!=-1 && w.charAt(k+1) != w.charAt(j)) k = next[k];
                if (w.charAt(k+1) == w.charAt(j)) k++;
                next[j] = k;
            }

            int lent = t.length();
            int sum = 0;
            k = -1;
            for (int j=0; j<lent; j++) {
                while (k!=-1 && w.charAt(k+1) != t.charAt(j)) k = next[k];
                if (w.charAt(k+1) == t.charAt(j)) k++;
                if (k == len - 1) {
                    sum ++;
                    k = next[k];
                }
            }

            System.out.println(sum);
        }
    }
}
