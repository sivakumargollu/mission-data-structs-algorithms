package com.ds.practice.sorting;

import java.util.Arrays;

/**
 * Sort based on most significant degit and least significant digit i.e sorting will be done sequentially on one's position, Tens' position, so on..
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] input = new int[] { 10, 34, 55, 38, 73, 27, 33 };
		int[] output = new int[input.length];

		//GetMax Number;
		int max = Integer.MIN_VALUE;
		for (int i : input) {
			if (i > max) {
				max = i;
			}
		}

		//counting digits in max number
		int digitCount = 1;
		while (max % Math.pow(10, digitCount) != max) {
			digitCount++;
		}

		System.out.println("Max digit count " + digitCount);

		//iterating 'digitCount' times.
		int k = digitCount;
		while (k >= 1) {
			int outpuIndex = 0;
			for (int i = 0; i <= 9; i++) {
				for (int j = 0; j < input.length; j++) {
					int currEle = input[j];
					//Reading digit at 'k' significant position.
					int digitPositionVal = Integer.parseInt(String.valueOf(currEle).toCharArray()[k - 1] + "");
					if (digitPositionVal == i) {
						output[outpuIndex] = currEle;
						outpuIndex++;
					}
				}
			}
			k--;
			//Copying resultant array into 'input' to make it input for next iteration.
			System.out.println("Iteration " + k + ", resultant arry " + Arrays.toString(output));
			for (int l = 0; l < output.length; l++) {
				input[l] = output[l];
			}
		}

		System.out.println("Sorted array " + Arrays.toString(input));
	}
}
