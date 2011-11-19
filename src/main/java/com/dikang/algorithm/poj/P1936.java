/*
 * Copyright (c) 2011. Dikang Gu(dikang85@gmail.com).
 * All Rights Reserved.
 *
 *
 * All in All
 *
 * Sample Input

sequence subsequence
person compression
VERDI vivaVittorioEmanueleReDiItalia
caseDoesMatter CaseDoesMatter

Sample Output

Yes
No
Yes
No
 */

package com.dikang.algorithm.poj;

import java.util.Scanner;

public class P1936 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            String s = words[0];
            String t = words[1];

            int lens = s.length();
            int lent = t.length();
            int i=0, j=0;

            while (i<lens && j<lent) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }

            if (i==lens) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
