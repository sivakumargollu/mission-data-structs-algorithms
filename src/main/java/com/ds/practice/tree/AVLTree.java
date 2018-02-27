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
		int[] input = {0, -1, 2, 3, 4, 6, 7, 8, 9, 10, 12, 13};
		AVLTree avlTree = new AVLTree();
		for (int i=0; i<input.length; i++) {
			avlTree.insertIntoAVL(avlTree.root, input[i]);
		}

		avlTree.printInOrder(avlTree.root);

	}

	private Node rotateRight(Node vn) {
		Node newRoot = vn.right;
		newRoot.left = vn;
		newRoot.left.right = null;
		return newRoot;
	}

	private Node rotateLeft(Node vn) {
		Node newRoot = vn.left;
        newRoot.right = vn;
		newRoot.right.left = null;
        return vn;
	}


	private Node rotateRightLeft(Node vn) {
		Node tmpVn = vn;
		vn.right = vn.right.left;
		vn.right.right = tmpVn.right;
		vn.right.right.left = null;
		return rotateRight(vn);
	}

	private Node rotateLeftRight(Node vn) {
       Node tmpVn = vn;
       vn.left = vn.left.right;
       vn.left.left = tmpVn.left;
       vn.left.left.right = null;
       return rotateLeft(vn);
	}

	private Node insertIntoAVL(Node node, Integer element){
		if(node == null){
			node = new Node(element);
			if(root == null){
				root = node;
			}
			return node;
		}
		if(element >= node.value){
			node.right = insertIntoAVL(node.right, element);
		}
		else {
			node.left = insertIntoAVL(node.left, element);
		}

		int balanced = getHeight(node.left) - getHeight(node.right);

		if(balanced > 1){
			if(getHeight(node.left.left) > getHeight(node.left.right)){
				return rotateLeft(node);
			} else {
				node = rotateLeftRight(node);
			}
		} else if(balanced < -1){
			if(getHeight(node.right.right) > getHeight(node.right.left)){
				return rotateRight(node);
			} else {
				return rotateRightLeft(node);
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
