package com.dikang.algorithm.facebook.puzzles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class Breathaylzer {

    public static Set<String> allowWords = new HashSet<String>();
    public static Map<String, Integer> visited = new HashMap<String, Integer>();
    public static Queue<String> queue = new LinkedList<String>();

    public static String characters = "abcdefghijklmnopqrstuvwxyz";

    private static int calculate(String word) {
        queue.clear();
        visited.clear();
        queue.add(word);
        visited.put(word, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int changes = visited.get(cur);
            if (allowWords.contains(cur.toUpperCase())) {
                return changes;
            }

            //change
            char[] letters = cur.toCharArray();

            // replacing
            for (int i=0; i<letters.length; i++) {
                char[] newLetters = letters.clone();

                for(int j=0; j<characters.length(); j++) {
                    newLetters[i] = characters.charAt(j);
                    String newWord = new String(newLetters);

                    if (visited.containsKey(newWord)) continue;

                    if (allowWords.contains(newWord.toUpperCase())) {
                        System.out.println(newWord);
                        return changes + 1;
                    }

                    visited.put(newWord, changes + 1);
                    queue.add(newWord);
                }
            }

            //Adding a string
            for (int i=0; i<letters.length; i++) {
                String start = cur.substring(0, i);
                String end = cur.substring(i);

                for (int j=0; j<characters.length(); j++) {

                    String newWord = start + characters.charAt(j) + end;

                    if (visited.containsKey(newWord)) continue;

                    if (allowWords.contains(newWord.toUpperCase())) {
                        System.out.println(newWord);
                        return changes + 1;
                    }

                    visited.put(newWord, changes + 1);
                    queue.add(newWord);
                }
            }

            // remove
            for (int i=0; i<cur.length(); i++) {

                String newWord = cur.substring(0, i);

                if (i<cur.length() - 1) {
                    newWord += cur.substring(i+1);
                }

                if (visited.containsKey(newWord)) continue;

                if (allowWords.contains(newWord.toUpperCase())) {
                    System.out.println(newWord);
                    return changes + 1;
                }

                visited.put(newWord, changes + 1);
                queue.add(newWord);
            }


        }

        return 0;
    }

    public static void main(String[] args) throws IOException {

        String fileName = "/tmp/tw06.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();

        try {
            while (null != line) {
                allowWords.add(line);
                line = reader.readLine();
            }
        } finally {
            reader.close();
        }

        reader = new BufferedReader(new InputStreamReader(System.in));
        line = reader.readLine();

        int total = 0;
        for (String word : line.split(" ")) {
            total += calculate(word);
        }

        System.out.println(total);
    }
}
