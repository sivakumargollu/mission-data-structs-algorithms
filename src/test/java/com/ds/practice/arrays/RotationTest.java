package com.ds.practice.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RotationTest {
	ArrayRotation rotation = new ArrayRotation();

	@Test
	public void arrayRotateTets(){
		int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] result = rotation.roate(input, 3);
		System.out.println(Arrays.toString(result));
		Assert.assertEquals(result.length, 9);
	}

	@Test
	public void emptyArrayRotate(){
		int[] input = new int[]{};
		int[] result = rotation.roate(input, 3);
		System.out.println(Arrays.toString(result));
		Assert.assertEquals(result.length, 0);
	}

	@Test
	public void arrayFullRotate(){
		int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] result = rotation.roate(input, input.length + 1);
		System.out.println(Arrays.toString(result));
		Assert.assertEquals(result.length, 9);
	}

	@Test
	public void arrayRotateInPlaceTets(){
		int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] result = rotation.rotateInPlace(input, 3);
		System.out.println(Arrays.toString(result));
		Assert.assertEquals(result.length, 9);
	}

	@Test
	public void emptyArrayRotateInPlace(){
		int[] input = new int[]{};
		int[] result = rotation.rotateInPlace(input, 3);
		System.out.println(Arrays.toString(result));
		Assert.assertEquals(result.length, 0);
	}

	@Test
	public void arrayFullRotateInPlace(){
		int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] result = rotation.rotateInPlace(input, input.length + 1);
		System.out.println(Arrays.toString(result));
		Assert.assertEquals(result.length, 9);
	}


}
