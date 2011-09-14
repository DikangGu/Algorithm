package com.dikang.algorithm.interviewstreet.peg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 *
There are K pegs. Each peg can hold discs in decreasing order of radius when looked from bottom to top of the peg. There are N discs who have radius 1 to N; Given the initial configuration of the pegs and the final configuration of the pegs, output the moves required to transform from the initial to final configuration. You are required to do the transformations in minimal number of moves.
A move consists of picking the topmost disc of any one of the pegs and placing it on top of anyother peg.
At anypoint of time, the decreasing radius property of all the pegs must be maintained.

Constraints:
1<= N<=8
3<= K<=5

Time Limit: 60 seconds.

Input Format:
N K
2nd line contains N integers, each in the range 1 to K, the i-th integer denotes, the peg to which disc of radius i is present in the initial configuration.
3rd line denotes the final configuration in a format similar to the initial configuration.

Output Format:
The first line contains M - The minimal number of moves required to complete the transformation.
The following M lines describe a move, by a peg number to pick from and a peg number to place on.
If there are more than one solutions, it's sufficient to output any one of them. You can assume, there is always a solution with less than 7 moves and the initial confirguration will not be same as the final one.

Sample Input #00:

2 3
1 1
2 2
Sample Output #00:

3
1 3
1 2
3 2


Sample Input #01:
6 4
4 2 4 3 1 1
1 1 1 1 1 1
Sample Output #01:
5
3 1
4 3
4 1
2 1
3 1
NOTE: You need to write the full code taking all inputs are from stdin and outputs to stdout
 *
 */
public class Solution {

    private static Map<String, List<String>> map = new HashMap<String, List<String>>(0);

    private static String finalString = "";
    private static int[] pegsTop;

    private static int N;
    private static int K;

    private static Queue<List<Integer>> queue = new LinkedList<List<Integer>>();

    private static String arrayToString(int[] array) {
        String result = "";

        for (int value : array) {
            result += String.valueOf(value);
        }

        return result;
    }

    private static String arrayToString(List<Integer> array) {
        String result = "";

        for (int value : array) {
            result += String.valueOf(value);
        }

        return result;
    }

    private static void constructPegsTop(int[] discStat) {
        pegsTop = new int[K];
        for (int i=0; i<K; i++) {
            pegsTop[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<N; i++) {
            int k = discStat[i];

            if (pegsTop[k] > i) {
                pegsTop[k] = i;
            }
        }
    }

    private static void constructPegsTop(List<Integer> discStat) {
        pegsTop = new int[K];
        for (int i=0; i<K; i++) {
            pegsTop[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<N; i++) {
            int k = discStat.get(i);

            if (pegsTop[k] > i) {
                pegsTop[k] = i;
            }
        }
    }

    private static <E> List<E> copyList(List<E> original) {
        List<E> result = new ArrayList<E>(original.size());

        for (E value : original) {
            result.add(value);
        }

        return result;
    }

    private static boolean calculate(int[] currentStat) {

        String currentString = arrayToString(currentStat);
        if (currentString.equals(finalString)) {
            return true;
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int value : currentStat) {
            list.add(value);
        }
        queue.add(list);

        while (!queue.isEmpty()) {

            List<Integer> stat = queue.poll();

            currentString = arrayToString(stat);
            constructPegsTop(stat);

            for (int i=0; i<K; i++) {
                for (int j=0; j<K; j++) {

                    if (j == i) {
                        continue;
                    }

                    if (pegsTop[i] < pegsTop[j]) {

                        List<Integer> newStat = copyList(stat);
                        newStat.set(pegsTop[i], j);

                        String newString = arrayToString(newStat);

                        if (map.containsKey(newString)) {
                            continue;
                        }

                        List<String> path = copyList(map.get(currentString));
                        path.add(String.valueOf(i+1) + " " + String.valueOf(j+1));
                        map.put(newString, path);
                        queue.add(newStat);

                        if (newString.equals(finalString)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        String[] tmp = line.split(" ");
        N = Integer.valueOf(tmp[0]);
        K = Integer.valueOf(tmp[1]);

        int[] initStat = new int[N];
        int[] finalStat = new int[N];

        line = in.readLine();
        tmp = line.split(" ");

        for (int i=0; i<N; i++) {
            initStat[i] = Integer.valueOf(tmp[i]) - 1;
        }

        line = in.readLine();
        tmp = line.split(" ");

        for (int i=0; i<N; i++) {
            finalStat[i] = Integer.valueOf(tmp[i]) - 1;
        }

        finalString = arrayToString(finalStat);
        map.put(arrayToString(initStat), new ArrayList<String>());

        calculate(initStat);

        List<String> path = map.get(finalString);
        System.out.println(path.size());
        for (int i=0; i<path.size(); i++) {
            System.out.println(path.get(i));
        }

    }
}
