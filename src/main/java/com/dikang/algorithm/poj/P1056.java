package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1056 {

    static class Trie {

        public Trie[] children;
        public int key;

        public Trie(int key) {
            children = new Trie[2];
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean decodable = true;
        Trie root = new Trie(0);
        Trie node = root;
        int caseNo = 0;
        while(sc.hasNext()) {
            String line = sc.nextLine().trim();
            if (line.equals("9")) {
                caseNo ++;
                if (decodable) {
                    System.out.println("Set " + caseNo + " is immediately decodable");
                } else {
                    System.out.println("Set " + caseNo + " is not immediately decodable");
                }

                root = new Trie(0);
                decodable = true;

            } else if (!line.equals("9")) {

                if (!decodable)
                    continue;

                boolean duplicated = true;
                node = root;
                for (char c : line.toCharArray()) {
                    if (node.children[0] == null && node.children[1] == null && node != root) {
                        if(duplicated)
                            break;
                    }

                    if (node.children[c-'0'] == null) {
                        node.children[c-'0'] = new Trie(c-'0');
                        duplicated = false;
                    }
                    node = node.children[c-'0'];

                }

                if (duplicated) decodable = false;
            }
        }
    }
}
