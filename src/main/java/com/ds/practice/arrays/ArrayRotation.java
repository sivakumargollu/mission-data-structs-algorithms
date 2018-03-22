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

		int[] tmp = new int[k];
		Integer counter = 0;
		int i = 0;
		for(; i < k ; i++){
			tmp[i] = arr[i];
		}
		i = 0;
		while (i < arr.length-k){
			arr[i] = arr[i+k];
			i++;
		}

		while (counter < k){
			arr[i] = tmp[counter];
			i++;
			counter++;
		}
		return arr;
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

}
