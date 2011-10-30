package com.dikang.algorithm.poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sticks
 *
 * Sample Input

9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0
Sample Output

6
5
 *
 */
public class P1011 {

    static int len;
    static int[] sticks;
    static int[] used;
    static int n;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            n = sc.nextInt();
            if (n==0) return;

            sticks = new int[n];
            used = new int[n];
            int sum = 0;

            for (int i=0; i<n; i++) {
                sticks[i] = sc.nextInt();
                sum += sticks[i];
            }

            Arrays.sort(sticks);

            len = sticks[n-1];
            boolean find = false;
            for (; len<=sum/2; len ++) {

                if (sum % len == 0) {
                    used[n-1] = 1;

                    if (dfs(n-1, len-sticks[n-1])) {
                        find = true;
                        System.out.println(len);
                        break;
                    }
                    used[n-1] = 0;
                }
            }

            if (!find) {
                System.out.println(sum);
            }
        }
    }

    private static boolean dfs(int cur, int left) {
        int i;
        if (left ==0) { // find one.
            for (i=n-1; i>=0 && used[i]==1; i--) ;
            if (i<0) return true;

            used[i] = 1;
            if (dfs(i, len-sticks[i])) return true;
            used[i] = 0;
        } else {
            for (i=cur; i>=0; i--) {
                if (used[i] == 1)
                    continue;;

                if (left < sticks[i]) continue;

                if (sticks[i] == sticks[i+1] && used[i+1] == 0) continue;

                used[i] = 1;
                if (dfs(i, left-sticks[i])) return true;
                used[i] = 0;
            }

        }

        return false;
    }
}
