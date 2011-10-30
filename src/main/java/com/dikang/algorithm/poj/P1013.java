package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine().trim());
        int[] candidates = new int[12];

        for (int i=0; i<n; i++) {
            // 0: good, -1: lighter, 1: heavier, 5: unknown
            for (int j=0; j<12; j++) candidates[j] = 0;
            String[][] segs = new String[3][3];

            for (int j=0; j<3; j++) {
                String line = sc.nextLine();
                String[] words = line.split(" ");
                segs[j][0] = words[0];
                segs[j][1] = words[1];
                segs[j][2] = words[2];
            }

            for (int j=0; j<12; j++) {

                candidates[j] = -1; // lighter
                boolean find = true;

                for (int k=0; k<3; k++) {
                    int left=0;
                    int right=0;
                    for(char c : segs[k][0].toCharArray()) {
                        left += candidates[c-'A'];
                    }
                    for(char c : segs[k][1].toCharArray()) {
                        right += candidates[c-'A'];
                    }

                    String compare = segs[k][2];
                    if (!((compare.equals("even") && left == right ) ||
                            (compare.equals("up") && left > right ) ||
                            (compare.equals("down") && left < right))) {
                        find = false;
                        break;
                    }
                }

                if (find) {
                    char c = (char)('A' + j);
                    System.out.println(c + " is the counterfeit coin and it is light.");
                    break;
                }

                candidates[j] = 1;
                find = true;

                for (int k=0; k<3; k++) {
                    int left=0;
                    int right=0;
                    for(char c : segs[k][0].toCharArray()) {
                        left += candidates[c-'A'];
                    }
                    for(char c : segs[k][1].toCharArray()) {
                        right += candidates[c-'A'];
                    }

                    String compare = segs[k][2];
                    if (!((compare.equals("even") && left == right ) ||
                            (compare.equals("up") && left > right ) ||
                            (compare.equals("down") && left < right))) {
                        find = false;
                        break;
                    }
                }

                if (find) {
                    char c = (char)('A' + j);
                    System.out.println(c + " is the counterfeit coin and it is heavy.");
                    break;
                }
                candidates[j] = 0;
            }

        }

    }
}
