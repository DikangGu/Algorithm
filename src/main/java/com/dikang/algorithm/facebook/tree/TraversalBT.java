package com.dikang.algorithm.facebook.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * traverse a binary tree
 */
public class TraversalBT {

    public class Node{

        public Node left;
        public Node right;
        public String data;
    }

    private Queue<Node> queue = new LinkedList<Node>();
    public void traversalBTByLevel(Node root) {
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }
}
