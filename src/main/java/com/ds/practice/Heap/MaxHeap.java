package com.ds.practice.Heap;

import com.ds.practice.tree.Node;
import com.ds.practice.tree.TreeUtils;

import java.util.LinkedList;

/**
 * Build a Maximum (Max) Heap using the Williams method.
 * Time complexity - O(nk) -> O(n*n) in most cases
 * Where is N is size of array and K is tree size,
 */
public class MaxHeap {

	public Node root;

	public static void main(String[] args) {
		int[] input = new int[] { 3, 1, 6, 5, 2, 4, 10, 30, 100, 101, 99, 1000 };
		MaxHeap maxHeap = new MaxHeap(input);
		TreeUtils.printLevelOrderTraversal(maxHeap.root);
	}

	public MaxHeap() {

	}

	public MaxHeap(int[] input) {
		for (int i = 0; i < input.length; i++) {
			int element = input[i];
			this.root = insert(root, element);
			this.root = heapify(root);
		}
	}

	//Insertion rule top -> botton, left -> right,
	// Hence we are following level order traversal to insert element
	//Given input length K and Size of tree , Timecomplexity = O(nk)
	public Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}

		LinkedList<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(node);

		while (!nodeQueue.isEmpty()) {
			Node currentNode = nodeQueue.poll();
			if (currentNode.left == null) {
				currentNode.left = new Node(value);
				break;
			} else {
				nodeQueue.add(currentNode.left);
			}
			if (currentNode.right == null) {
				currentNode.right = new Node(value);
				break;
			} else {
				nodeQueue.add(currentNode.right);
			}
		}
		return node;
	}

	//Heapifying the Tree so that maximum element comes on top
	//Given input length K and size of tree N, Timecomplexity = O(nk)
	public Node heapify(Node node) {

		if (node == null) {
			return node;
		}

		if (node.left == null && node.right == null) {
			return node;
		}

		if (node.left != null) {
			heapify(node.left);
			if (node.left.value > node.value) {
				int tmp = node.left.value;
				node.left.value = node.value;
				node.value = tmp;
			}
		}

		if (node.right != null) {
			heapify(node.right);
			if (node.right.value > node.value) {
				int tmp = node.right.value;
				node.right.value = node.value;
				node.value = tmp;
			}
		}
		return node;
	}

	public Node addValue(int value) {
		this.root = insert(this.root, value);
		this.root = heapify(this.root);
		return this.root;
	}

	public Node getLeafNode(Node rootNode) {
		if (rootNode == null) {
			return rootNode;
		}
		TreeUtils.printLevelOrderTraversal(rootNode);
		LinkedList<Node> que = new LinkedList<>();
		que.add(rootNode);
		Node lastNode = null;
		while (!que.isEmpty()) {
			Node currentNode = que.poll();
			if (currentNode.left != null) {
				que.add(currentNode.left);
			}
			if (currentNode.right != null)
				que.add(currentNode.right);
			lastNode = currentNode;
		}
		System.out.println("\n Returning as leaf : " + lastNode.value);
		return lastNode;
	}

	public boolean removeNode(Node root, Node rmNode) {
		if (rmNode == null) {
			return true;
		}
		System.out.println("Trying to remove " + rmNode.value);
		LinkedList<Node> que = new LinkedList<>();
		que.add(root);
		boolean removed = false;
		while (!que.isEmpty()) {
			Node currentNode = que.poll();
			if (currentNode.left != null) {
				if (currentNode.left.value.equals(rmNode.value)) {
					currentNode.left = null;
					removed = true;
					break;
				} else {
					que.add(currentNode.left);
				}
			}
			if (currentNode.right != null) {
				if (currentNode.right.value.equals(rmNode.value)) {
					currentNode.right = null;
					removed = true;
					break;
				} else {
					que.add(currentNode.right);
				}
			}
		}
		System.out.println("Removal satus " + removed);
		return removed;
	}
}
