package com.dikang.algorithm.facebook.tree;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class RedBlackTree {

    public enum Color {
        RED,
        BLACK
    }

    public class Node {
        public Color color;
        public int key;
        public Node left;
        public Node right;
        public Node p;
    }

    private Node root;

    public RedBlackTree() {
        root = null;
    }

    /**
     * left rotate
     *
     * @param x
     */
    private void leftRotate(Node x) {

        Node y = x.right;
        x.right = y.left;
        x.right.p = x;
        y.left = x;
        y.p = x.p;

        // adjust the parent
        if (x.p == null) {
            root = y;
        } else if(x == x.p.left) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }

        x.p = y;
    }

    /**
     * Right Rotate
     *
     * @param y
     */
    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right.p = y;
        x.right = y;

        x.p = y.p;
        if (y.p == null) {
            root = x;
        } else if (y == y.p.left) {
            y.p.left = x;
        } else {
            y.p.right = x;
        }

        y.p = x;
    }

    /**
     * insert a node into the RB tree
     *
     * @param z
     */
    public void treeInsert(Node z) {
        z.left = null;
        z.right = null;
        z.color = Color.RED;

        if (root == null) {
            root = z;
            z.p = null;
        }
        else {
            Node t = root;
            while (true) {
                if (z.key <= t.key) {
                    if (t.left == null) {
                        t.left = z;
                        break;
                    } else {
                        t = t.left;
                    }
                } else {
                    if (t.right == null) {
                        t.right = z;
                        break;
                    } else {
                        t = t.right;
                    }
                }
            }
            z.p = t;
        }

        treeInsertFixup(z);
    }

    private void treeInsertFixup(Node z) {
        while(z.p != null && z.p.color == Color.RED) {

        }
    }
}
