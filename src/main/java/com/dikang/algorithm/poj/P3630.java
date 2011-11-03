package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P3630 {

    static class Trie {

        public Trie[] children;
        public int key;
        public boolean hasChildren;

        public Trie(int key) {
            children = new Trie[10];
            this.key = key;
            hasChildren = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int caseNo = 0;
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            sc.nextLine();

            boolean decodable = true;
            Trie root = new Trie(0);
            Trie node;

            for (int j=0; j<num; j++) {
                String line = sc.nextLine().trim();

                if (!decodable)
                    continue;

                boolean duplicated = true;
                node = root;
                for (char c : line.toCharArray()) {

                    if ((!node.hasChildren) && node != root) {
                        if(duplicated)
                            break;
                    }

                    if (node.children[c-'0'] == null) {
                        node.children[c-'0'] = new Trie(c-'0');
                        duplicated = false;
                    }
                    node.hasChildren = true;
                    node = node.children[c-'0'];

                }

                if (duplicated) decodable = false;
            }

            if (decodable) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
