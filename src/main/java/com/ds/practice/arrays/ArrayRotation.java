package com.ds.practice.arrays;

public class ArrayRotation {

	/**
	 *
	 * @param arr
	 * @param k
	 * @return
	 *
	 * Rotates the given input array k times,
	 * Below logic uses temporary memory space.
	 */
	public int[] roate(int[] arr, int k){

		if(arr.length <= 0){
			return arr;
		}

		if(k > arr.length) {
			k = k % arr.length;
		}

		int[] result = new int[arr.length];
		Integer counter = 0;
		while (counter < arr.length){
			int element = arr[counter];
			int targetIndex = counter + k;
			if(targetIndex >= arr.length){
				targetIndex =  targetIndex % arr.length;
			}
			result[targetIndex] = element;
			counter++;
		}
		return result;
	}

	/**
	 *
	 * @param input
	 * @param k
	 * @return
	 * Rotate array by k times towards right direction.
	 * It doesn't use any additional memeory instead modifies the original array by doing single rotation k times.
	 * Tim complexity - O(k * n) where k is number of rotations and 'n' is number of elements in the array.
	 * Sapce complexity - O(n)
	 *
	 */
	public int[] rotateInPlace(int[] input, int k){

		if(input.length <= 0){
			return input;
		}

		if(k > input.length){
			k = k % input.length;
		}

		while (k > 0){
			  Integer cIPV = 0;
			  Integer tmp = 0;
			 for(int i = 0 ; i < input.length; i++){
			 	if(i == 0) {
					cIPV = input[input.length - 1];
				}
				 tmp = input[i];
				 input[i] = cIPV;
				 cIPV = tmp;
				}
             k--;
			 }
		return input;
	}

	public int[] rortateKtimes(int[] input, int k) {
		if(input.length <= 0){
			return input;
		}

		if(k > input.length){
			k = k % input.length;
		}

		Integer cIPV;
		Integer tmp;

		for(int index=0; index < input.length; index++){
			Integer targetIndex = index + k;
			if(targetIndex > input.length){
				targetIndex = targetIndex % input.length;
			}
			cIPV = input[targetIndex];
			input[index] = cIPV;


		}

	}


}
