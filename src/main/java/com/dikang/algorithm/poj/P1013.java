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
            for (int j=0; j<12; j++) candidates[j] = 5;

            for (int j=0; j<3; j++) {
                String line = sc.nextLine();
                String[] segs = line.split(" ");
                if (segs[2].equals("even")) {
                    for (char c : segs[0].toCharArray()) {
                        candidates[c-'A'] = 0;
                    }

                    for (char c : segs[1].toCharArray()) {
                        candidates[c-'A'] = 0;
                    }
                } else if (segs[2].equals("up")) {
                    for (char c : segs[0].toCharArray()) {
                        if (candidates[c-'A'] == 0) {
                            continue;
                        } else if (candidates[c-'A'] < 0) {
                            candidates[c-'A'] = 0;
                        } else if (candidates[c-'A'] == 5) {
                            candidates[c-'A'] = 1;
                        } else {
                            candidates[c-'A'] += 1;
                        }
                    }

                    for (char c : segs[1].toCharArray()) {
                        if (candidates[c-'A'] == 0) {
                            continue;
                        } else if (candidates[c-'A'] == 5) {
                            candidates[c-'A'] = -1;
                        } else if (candidates[c-'A'] >0) {
                            candidates[c-'A'] = 0;
                        } else {
                            candidates[c-'A'] -= 1;
                        }
                    }
                }  else if (segs[2].equals("down")) {
                    for (char c : segs[1].toCharArray()) {
                        if (candidates[c-'A'] == 0) {
                            continue;
                        } else if (candidates[c-'A'] < 0) {
                            candidates[c-'A'] = 0;
                        } else if (candidates[c-'A'] == 5) {
                            candidates[c-'A'] = 1;
                        } else {
                            candidates[c-'A'] += 1;
                        }
                    }

                    for (char c : segs[0].toCharArray()) {
                        if (candidates[c-'A'] == 0) {
                            continue;
                        } else if (candidates[c-'A'] == 5) {
                            candidates[c-'A'] = -1;
                        } else if (candidates[c-'A'] >0) {
                            candidates[c-'A'] = 0;
                        } else {
                            candidates[c-'A'] -= 1;
                        }
                    }
                }
            }

            int j;
            int min=0;
            int mini=0;
            int max=0;
            int maxi=0;
            for (j=0; j<12 && candidates[j] != 5; j++) {
                min = candidates[j];
                mini = j;
                max = candidates[j];
                maxi = j;
                break;
            }

            for (;j<12; j++) {
                if (candidates[j] == 5) continue;

                if (min > candidates[j]) {
                    min = candidates[j];
                    mini = j;
                }

                if (max < candidates[j]) {
                    max = candidates[j];
                    maxi = j;
                }
            }

            if (Math.abs(min) > Math.abs(max)) {
                char c = (char) ('A' + mini);
                System.out.println(c + " is counterfeit coin and it is light.");
            } else {
                char c = (char) ('A' + maxi);
                System.out.println(c + " is counterfeit coin and it is heavy.");
            }
        }
    }
}
