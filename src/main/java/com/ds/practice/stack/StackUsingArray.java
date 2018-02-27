package com.ds.practice.stack;


public class StackUsingArray<T> {

	int currentIndex = -1;
	int[] stack;
	int stackSize;

	public StackUsingArray(int stackSize){
		this.stackSize = stackSize;
		stack = new int[stackSize];
	}

	int pop() throws Exception {
		if(currentIndex < 0){
			throw new Exception("Stack is empty");
		}
		int ele =  stack[currentIndex];
		currentIndex--;
		return ele;
	}

	void push(int v) throws Exception {
		if(currentIndex < stackSize) {
			stack[++currentIndex] = v;
		} else {
			throw new Exception("Stack overflown");
		}
	}

	void printStack() throws Exception {
		while (!isStackEmpty()){
			System.out.print(pop() + ", ");
		}
		System.out.println("");
	}

	boolean isStackEmpty(){
		return stack.length == 0;
	}
}
