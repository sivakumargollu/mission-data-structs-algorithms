package com.ds.practice.sorting;

import java.util.Arrays;

/**
 * Divides input array into smaller units, sort them and merge back again.
 * Time complexity - n(logn) for all cases
 * Space complexity O(n)
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] input = new int[] { 45, 34, 56, 32, 52, 15, 12, 19, 100, 24, 36 };
		MergeSort ms = new MergeSort();
		System.out.println("\n Merge sort " + Arrays.toString(ms.mergeSort(input)));
	}

	public int[] mergeSort(int[] input) {
		if (input.length == 1) {
			return input;
		}
		if (input.length == 2) {
			if (input[0] > input[1]) {
				int tmp = input[1];
				input[1] = input[0];
				input[0] = tmp;
			}
			return input;
		}

		int[] left = mergeSort(Arrays.copyOfRange(input, 0, input.length / 2));
		int[] right = mergeSort(Arrays.copyOfRange(input, input.length / 2, input.length));
		System.out.print("\n Before merge ");
		print(input);
		int len = left.length + right.length;
		int[] sorted = new int[len];

		int l = 0;
		int r = 0;
		int k = 0;
		System.out.println("\n Merging left " + Arrays.toString(left) + " Right " + Arrays.toString(right));
		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				sorted[k] = left[l];
				l++;
			} else {
				sorted[k] = right[r];
				r++;
			}
			k++;
		}

		while (l < left.length) {
			sorted[k] = left[l];
			l++;
			k++;
		}

		while (r < right.length) {
			sorted[k] = right[r];
			r++;
			k++;
		}

		System.out.print("\nAfter merge ::");
		print(sorted);
		return sorted;

	}

	public void print(int[] input) {
		for (int i : input) {
			System.out.print(i + ", ");
		}
	}

}
