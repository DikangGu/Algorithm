package com.dikang.algorithm.interviewstreet.diameter;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 *
The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. The diagram below shows a tree with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).

In particular, note that the diameter of a tree T is the largest of the following quantities:
the diameter of T's left subtree
the diameter of T's right subtree
the longest path between leaves that goes through the root of T
Given the root node of the tree, return the diameter of the tree
Sample Test Cases:

Input #00:
Consider the tree:


Output #00:
5

Explanation:
The diameter of the tree is 5

 */
public class Solution {
    class Node {
        Node left, right;
        int data;
        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    static int diameterOfTree(Node root) {

        if (root == null) {
            return 0;
        }

        int left = diameterOfTree(root.left);
        int right = diameterOfTree(root.right);

        int leftdepth = 0;
        int rightdepth = 0;

        if (root.left == null && root.right == null) {
            root.data = 1;
        } else if (root.left == null) {
            root.data = root.right.data + 1;
            rightdepth = root.right.data;
        } else if (root.right == null) {
            root.data = root.left.data + 1;
            leftdepth = root.left.data;
        } else {
            root.data = root.left.data > root.right.data ? root.left.data + 1 : root.right.data + 1;
            leftdepth = root.left.data;
            rightdepth = root.right.data;
        }

        int crossRoot = leftdepth + rightdepth + 1;

        int max = left;
        if (max < right) {
            max = right;
        }

        if (max < crossRoot) {
            max = crossRoot;
        }

        return max;
    }
}
