package com.dikang.algorithm.poj;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * Sample Input
 * 12
4873279
ITS-EASY
888-4567
3-10-10-10
888-GLOP
TUT-GLOP
967-11-11
310-GINO
F101010
888-1200
-4-8-7-3-2-7-9-
487-3279

 Sample Output
 310-1010 2
487-3279 4
888-4567 3

 or
 No duplicates.

 */

import java.util.*;
public class P1002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<String, Integer>();

        String line = scanner.nextLine();
        int num = Integer.parseInt(line);
        for (int i=0; i<num; i++) {
            line = scanner.nextLine();
            line = line.replaceAll("-", "");

            StringBuilder numberSB = new StringBuilder();
            for (int j=0; j<line.length();j++) {
                char c = line.charAt(j);
                if ('0' <= c && c <= '9') {
                    numberSB.append(c);
                } else {
                    int t = c - 'A';
                    if(c >= 'Q')
                        t -= 1;
                    t = t/3 + 2;
                    numberSB.append(String.valueOf(t));
                }
            }

            String number = numberSB.toString();
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }

        int dup = 0;
        SortedMap<String, Integer> sortedMap = new TreeMap<String, Integer>();
        for (String number : map.keySet()) {
            if (map.get(number) > 1) {
                sortedMap.put(number, map.get(number));
                dup = 1;
            }
        }
        if (dup == 0) {
            System.out.println("No duplicates.");
        } else {
            for (String number : sortedMap.keySet()) {
                System.out.println(number.substring(0, 3) + "-" +
                        number.substring(3) + " " + sortedMap.get(number));
            }
        }
    }
}
