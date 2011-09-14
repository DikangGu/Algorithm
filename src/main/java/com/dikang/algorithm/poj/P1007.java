package com.dikang.algorithm.poj;

import java.util.*;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1007 {

    private static int calInversion(String DNA) {
        int len = DNA.length();
        int count = 0;

        for (int i=0; i<len-1; i++) {
            for (int j=i+1; j<len; j++) {
                if (DNA.charAt(i) > DNA.charAt(j)) {
                    count ++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedMap<Integer, List<String>> map = new
                TreeMap<Integer, List<String>>();

        int length = scanner.nextInt();
        int size = scanner.nextInt();

        for (int i=0; i<size; i++) {
            String DNA = scanner.next();
            int count = calInversion(DNA);

            if (!map.containsKey(count)) {
                ArrayList<String> dnas = new ArrayList<String>();
                dnas.add(DNA);
                map.put(count, dnas);
            } else {
                List<String> dnas = map.get(count);
                dnas.add(DNA);
            }
        }

        for (int count : map.keySet()) {
            List<String> dnas = map.get(count);
            for (String dna : dnas) {
                System.out.println(dna);
            }
        }
    }
}
