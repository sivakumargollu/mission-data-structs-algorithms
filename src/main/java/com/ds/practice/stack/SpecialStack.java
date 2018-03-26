package com.ds.practice.stack;

import com.ds.practice.stack.StackUsingList;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 * push
 * pop
 * isFull
 * isEmpty
 * getMin
 *
 * All operations supported in O(1) time complexity
 */
public class SpecialStack {

	private Integer size = 0;
	private Integer length = 0;

	Stack<Integer> stack1;
	Stack<Integer> minStack;

	public SpecialStack(Integer size){
		stack1 = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(Integer element) throws Exception {

		stack1.push(element);
		if(minStack.isEmpty()){
			minStack.push(element);
		} else {
			Integer prevLow = minStack.pop();
			if (prevLow > element) {
				minStack.push(prevLow);
				minStack.push(element);
			} else {
				minStack.push(prevLow);
				minStack.push(prevLow);
			}
		}
		length++;
	}

	public int pop() throws Exception {
		Integer ret =  stack1.pop();
		Integer min = minStack.pop();
		length--;
		return ret;
	}

	public boolean isFull(){
		return size == length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public Integer getMin() throws Exception {
		Integer s =  minStack.pop();
		minStack.push(s);
		return s;
	}
}
