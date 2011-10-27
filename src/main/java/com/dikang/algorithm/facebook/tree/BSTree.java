package com.dikang.algorithm.facebook.tree;

import java.util.Date;
import java.util.Random;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class BSTree {

    public class Node implements Comparable<Node>{

        public int key;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }

        public Node(Node node) {
            key = node.key;
            left = node.left;
            right = node.right;
            parent = node.parent;
        }

        @Override
        public int compareTo(Node node) {
            return key - node.key;
        }
    }


    private Node root;
    private Node prev;
    private Node head;

    public BSTree() {
        root = null;
    }

    /**
     * insert a node into the tree
     * @param key
     */
    public Node insert(Node node, int key) {
        if (null == node) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
            node.left.parent = node;
        } else {
            node.right = insert(node.right, key);
            node.right.parent = node;
        }

        return node;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(Node node, int key) {
        if (null == node) {
            return;
        }

        if (key < node.key) {
            delete(node.left, key);
        } else if (key > node.key) {
            delete(node.right, key);
        } else {

            Node x, y;
            if (node.left == null && node.right == null) {
                y = node;
            } else {
                y = InOrderSuccessor(node);
            }

            if (y.left != null) x = y.left;
            else x = y.right;

            if (null != x) x.parent = y.parent;

            // set parent
            if (y.parent == null) {
                root = x;
            } else if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }

            if (y!=node) {
                node.key = y.key;
            }
        }
    }

    public Node toDoubleLinkedList() {
        prev = null;
        head = null;

        toDoubleLinkedList(root);

        return head;
    }

    public void toDoubleLinkedList(Node node) {
        if (null == node)
            return;

        toDoubleLinkedList(node.left);

        node.left = prev;
        if (null != prev) {
            prev.right = node;
        } else {
            head = node;
        }

        Node right = node.right;
        head.left = node;
        node.right = head;

        prev = node;
        toDoubleLinkedList(right);
    }

    /**
     * Inorder the BST recursivly
     *
     */
    public void InOrder() {
        InorderPrint(root);
    }

    private void InorderPrint(Node node) {
        if (null == node) {
            return;
        }

        InorderPrint(node.left);
        System.out.print(node.key + ",");
        InorderPrint(node.right);
    }

    /**
     * InOrder the BST non-recursivly
     *
     */
    public void InOrderNonRecurise() {
        if (null == root) return;

        Node p = root;
        while(null != p.left) {
            p = p.left;
        }
        System.out.print(p.key + ",");

        while( (p=InOrderSuccessor(p)) != null) {
            System.out.print(p.key + ",");
        }

    }

    public Node InOrderSuccessor(Node node) {
        Node p = node;

        if (p.right == null) {
            while(p.parent != null && p.parent.right == p) {
                p = p.parent;
            }

            return p.parent;
        }

        p  = p.right;
        while (null != p.left)
            p = p.left;

        return p;
    }

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        Random random = new Random(new Date().getTime());

        for (int i=0; i<20; i++) {
            tree.insert(random.nextInt(100));
        }

        tree.InOrder();
        System.out.println();

        tree.InOrderNonRecurise();
        System.out.println();

        Node head = tree.toDoubleLinkedList();
        Node p = head;
        do {
            System.out.print(p.key + ",");
            p = p.right;
        } while(p != head);
        System.out.println();
    }
}
