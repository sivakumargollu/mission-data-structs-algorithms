package com.ds.practice.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StackTest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stackSize = Integer.parseInt(br.readLine());
		StackUsingArray stackUsingArray = new StackUsingArray(stackSize);
		while (stackSize > 0) {
			stackUsingArray.push(stackSize * 3);
			stackSize--;
		}
		stackUsingArray.printStack();
	}
}
