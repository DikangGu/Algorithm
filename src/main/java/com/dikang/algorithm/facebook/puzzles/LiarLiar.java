package com.dikang.algorithm.facebook.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
Test Input:
5
Stephen 1
Tommaso
Tommaso 1
Galileo
Isaac 1
Tommaso
Galileo 1
Tommaso
George 2
Isaac
Stephen

Test Output
3, 2
 */
public class LiarLiar {

    private static Map<String, Integer> nameToIndex = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String line = reader.readLine();

        int num = Integer.valueOf(line);

        int[][] graph = new int[num][num];
        int [] color = new int[num];

        for (int i=0; i<num; i++) {
            line = reader.readLine();

            String[] parts = line.split(" ");

            int p;
            if (!nameToIndex.containsKey(parts[0])) {
                p = nameToIndex.size();
                nameToIndex.put(parts[0], nameToIndex.size());
            } else {
                p = nameToIndex.get(parts[0]);
            }

            for (int j=0; j<Integer.valueOf(parts[1]); j++) {
                int q;
                line = reader.readLine();
                if (!nameToIndex.containsKey(line)) {
                    q = nameToIndex.size();
                    nameToIndex.put(line, q);
                } else {
                    q = nameToIndex.get(line);
                }
                graph[p][q] = 1;
                graph[q][p] = 1;
            }
        }

        //BFS
        Queue<Integer> queue= new LinkedList<Integer>();
        queue.add(0);
        color[0] = 1;

        while(!queue.isEmpty()) {

            int index = queue.poll();

            for (int i=0; i<num; i++) {
                if (i== index) continue;

                if (color[i] != 0) continue;

                if (graph[i][index] == 1) {
                    if (color[index] == 1) {
                        color[i] = 2;
                    } else {
                        color[i] = 1;
                    }

                    queue.add(i);
                }
            }
        }

        int black = 0;
        int white = 0;
        for (int i=0; i<num; i++) {
            if (color[i] == 1) {
                black ++;
            } else if (color[i] == 2) {
                white ++;
            }
        }

        System.out.println(black + ", " + white);
    }

}
