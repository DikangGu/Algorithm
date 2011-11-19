/*
 * Copyright (c) 2011. Dikang Gu(dikang85@gmail.com).
 * All Rights Reserved.
 */

package com.dikang.algorithm.poj;

import java.util.Scanner;

public class P3080 {

    public static String calculate(String[] words) {

        String result = "";
        int largest = 0;
        String first = words[0];
        int len = first.length();

        while (len >= 3) {
            if (largest > len)
                break;

            for (int i=0; i+len <= first.length(); i++) {
                String sub = first.substring(i, i+len);
                boolean find = true;

                for (int j=1; j<words.length; j++) {
                    if (!words[j].contains(sub)) {
                        find = false;
                        break;
                    }
                }

                if (find) {
                    largest = len;
                    if (result == "") {
                        result = sub;
                    } else {
                        if (result.compareTo(sub) > 0) {
                            result = sub;
                        }
                    }
                }
            }

            len --;
        }

        if (largest == 0) {
            return "no significant commonalities";
        }

        return result;
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
