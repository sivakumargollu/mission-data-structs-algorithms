package com.ds.practice.tree;

import problems.interview.RemoveDuplicatesWithTree;

public class AVLTree {

	Node root;

	class Node {
		Node left;
		Node right;
		Integer value;

		public Node(int value){
			this.value = value;
		}
	}

	Integer getHeight(Node n){
		if(n == null){
			return 0;
		}
		return 1 + Math.max(getHeight(n.left), getHeight(n.right));
	}

	public static void main(String args[]){
		int[] input = {1, 2, 3, 6, 5, -2, -5, -8};
		AVLTree avlTree = new AVLTree();
		for (int i=0; i<input.length; i++) {
			avlTree.root = avlTree.insertIntoAVL(avlTree.root, input[i]);
		}
		avlTree.printInOrder(avlTree.root);

	}

	private Node rotateRight(Node vn) {
		Node newRoot = vn.left;
		vn.left = newRoot.right;
		newRoot.right = vn;
		return newRoot;
	}

	private Node rotateLeft(Node vn) {
		Node newRoot = vn.right;
		vn.right = newRoot.left;
        newRoot.left = vn;
        return newRoot;
	}

	private Node insertIntoAVL(Node node, Integer element){

		if(node == null){
			node = new Node(element);
			return node;
		}

		if(element > node.value){
			node.right = insertIntoAVL(node.right, element);
		}
		else if(element < node.value) {
			node.left = insertIntoAVL(node.left, element);
		}

		int balanced = getHeight(node.left) - getHeight(node.right);

		if(balanced > 1){
			if(getHeight(node.left.left) > getHeight(node.left.right)){
				return rotateRight(node);
			} else {
				node = rotateRight(node);
				node = rotateLeft(node);
			}
		} else if(balanced < -1){
			if(getHeight(node.right.right) > getHeight(node.right.left)){
				return rotateLeft(node);
			} else {
				node = rotateLeft(node);
				node = rotateRight(node);
			}
		}
		return node;
	}

	void printInOrder(Node n){
		if(n==null){
			return;
		}
		printInOrder(n.left);
		System.out.print(n.value + ",");
		printInOrder(n.right);
	}
}
