package com.dikang.algorithm.facebook.tree;

public class LLRBTree<Key extends Comparable<Key>, Value> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;
	
	private class Node {
		Key key;
		Value val;
		Node left, right;
		boolean color;
		
		Node (Key key, Value value, boolean color) {
			this.key = key;
			this.val = value;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x) {
		if (null == x) return false;
		return x.color == RED;
	}                         
	
	private Node insert(Node h, Key key, Value val) {
		if (null == h) {
			return new Node(key, val, RED);
		}                                  
		
		int cmp = key.compareTo(h.key);
		if (cmp == 0) {
			h.val = val;
		} else if (cmp < 0) {
			h.left = insert(h.left, key, val);
		} else {
			h.right = insert(h.right, key, val);
		}                                       
		
		return h;
	}            
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.color = h.color;
		x.left = h;
		x.left.color = RED;
		
		return x;
	}            
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.color = h.color;
		x.right = h;
		x.right.color = RED;
		
		return x;
	}
	
	
}