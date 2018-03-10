package com.ds.practice.tree;

public class TreeTravesor {

	public static void printInOrder(Node n) {
		if (n == null) {
			return;
		}
		printInOrder(n.left);
		System.out.print(n.value + ",");
		printInOrder(n.right);
	}

	public static void printPreOrder(Node n) {
		if (n == null) {
			return;
		}
		System.out.print(n.value + ",");
		printPreOrder(n.left);
		printPreOrder(n.right);
	}

	public static void printPostOrder(Node n) {
		if (n == null) {
			return;
		}
		printPostOrder(n.left);
		printPostOrder(n.right);
		System.out.print(n.value + ",");
	}

	public static void printLevelOrderTraversal(Node n) {
		if (n == null) {
			return;
		}
		java.util.LinkedList<Node> linkedList = new java.util.LinkedList<>();
		linkedList.add(n);

		while (!linkedList.isEmpty()) {
			Node currentElement = linkedList.poll();
			System.out.print(currentElement.value + ", ");
			if (currentElement.left != null) {
				linkedList.add(currentElement.left);
			}

			if (currentElement.right != null) {
				linkedList.add(currentElement.right);
			}
		}
	}
}

