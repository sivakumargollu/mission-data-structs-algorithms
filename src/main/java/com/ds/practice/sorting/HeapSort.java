package com.ds.practice.sorting;

import com.ds.practice.Heap.MaxHeap;
import com.ds.practice.tree.Node;
import com.ds.practice.tree.TreeUtils;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] input = new int[] { 3, 1, 6, 5, 2, 4, 10, 30, 100, 101, 99, 1000 };
		MaxHeap maxHeap = new MaxHeap(input);
		HeapSort heapSort = new HeapSort();
		int[] sortedArray = heapSort.sort(maxHeap);
		System.out.println(Arrays.toString(sortedArray));
	}

	public int[] sort(MaxHeap heap) {
		int nodeCount = TreeUtils.getNodeCount(heap.root, 0);
		int[] sorted = new int[nodeCount];
		int k = 0;
		while (k < nodeCount) {
			sorted[k] = heap.root.value;
			Node lastNode = heap.getLeafNode(heap.root);
			heap.removeNode(heap.root, lastNode);
			heap.root.value = lastNode.value;
			heap.heapify(heap.root);
			k++;
		}
		return sorted;
	}
}
