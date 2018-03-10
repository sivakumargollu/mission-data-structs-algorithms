package com.ds.practice.Heap;

import com.ds.practice.tree.Node;
import com.ds.practice.tree.TreeTravesor;

import java.util.LinkedList;

/**
 * Build a Maximum (Max) Heap using the Williams method.
 */
public class MaxHeap {

	Node root;

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap();
		int[] input = new int[] { 3, 1, 6, 5, 2, 4, 10, 30, 100, 101, 99, 1000 };
		for (int i = 0; i < input.length; i++) {
			int element = input[i];
			maxHeap.root = maxHeap.insert(maxHeap.root, element);
			maxHeap.root = maxHeap.heapify(maxHeap.root);
		}

		TreeTravesor.printLevelOrderTraversal(maxHeap.root);
	}

	//Insertion rule top -> botton, left -> right,
	// Hence we are following level order traversal to insert element
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
	Node heapify(Node node) {

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
}
