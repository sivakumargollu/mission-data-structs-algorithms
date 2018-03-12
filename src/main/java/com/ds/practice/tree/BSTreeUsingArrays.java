package com.ds.practice.tree;

import java.util.Arrays;

public class BSTreeUsingArrays {

	public static void main(String[] args) {
		int[] input = new int[]{8, 5, 3, 9, 6, 34, 67, 23};
		int[] tree = new int[2 * input.length];
		BSTreeUsingArrays treeWithArrays = new BSTreeUsingArrays();
		for (int i=0; i< input.length; i++){
			int element = input[i];
			treeWithArrays.insert(tree, element);
		}
		System.out.println(Arrays.toString(tree));
		treeWithArrays.printInOrder(tree, 1);
		System.out.print("\nFinding element 67 in tree index : " + treeWithArrays.search(tree, 1, 90 ));
	}

	public int insert(int[] input, int element){
		int startIndex = 1;
		while (startIndex < input.length){
			if(input[startIndex] == 0){
				input[startIndex] = element;
				break;
			} else {
				int rightChildIndex = 2 * startIndex + 1;
				int leftChildIndex =  2 * startIndex;
				if(element > input[startIndex]){
					startIndex = rightChildIndex;
				} else {
					startIndex = leftChildIndex;
				}
			}
		}
		return element;
	}

	void printInOrder(int[] tree, int index) {

		if(index >= tree.length){
			return;
		}

		int lindex = index * 2;
		int rindex = index * 2 + 1;

		if(lindex < tree.length) {
			printInOrder(tree, lindex);
		}

		System.out.print(tree[index] + ", ");

		if(rindex < tree.length) {
			printInOrder(tree, rindex);
		}
	}

	public int search(int tree[], int startIndex, int element) {

		if (tree[startIndex] == element) {
			return startIndex;
		} else {
			int lIndex = startIndex * 2;
			int rIndex = startIndex * 2 + 1;
			if(element < tree[startIndex] && lIndex < tree.length){
				return search(tree, lIndex, element);
			}
			if(element > tree[startIndex] && rIndex < tree.length){
				return search(tree, rIndex, element);
			}
		}
		return -1;
	}
}
