/*
 * Copyright (c) 2011. Dikang Gu(dikang85@gmail.com).
 * All Rights Reserved.
 *
 * Sample Input

2
3
ABCD
BCDFF
BRCD
2
rose
orchid

Sample Output

2
2

 */

package com.dikang.algorithm.poj;

import java.util.Scanner;

public class P1226 {

    private static int calculate(String[] words) {

        String first = words[0];
        int largest = 0;

        int len = first.length();
        String sub="";
        while (len > 0) {

            boolean find = true;

            for (int i=0; i+len <= first.length(); i++) {
                find = true;

                sub = first.substring(i, i+len);

                int lensub = sub.length();
                char[] inverse = new char[lensub];
                for (int p=0; p<lensub; p++) {
                    inverse[p] = sub.charAt(lensub - p -1);
                }
                String strInverse = new String(inverse);

                for (int j=1; j<words.length; j++) {
                    if (!words[j].contains(sub) &&
                            !words[j].contains(strInverse)) {
                        find = false;
                        break;
                    }
                }

                if (find)
                    break;
            }

            if (find) {
                largest = len;
                break;
            }
            len --;
        }
        return largest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int cases = Integer.valueOf(line);

        for (int i=0; i<cases; i++) {
            line = sc.nextLine();
            int n = Integer.valueOf(line);

            String[] words = new String[n];
            for (int j=0; j<n; j++) {
                words[j] = sc.nextLine();
            }
            System.out.println(calculate(words));

        }

    }
}

