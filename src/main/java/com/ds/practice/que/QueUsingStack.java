package com.ds.practice.que;

import com.ds.practice.stack.StackUsingList;

public class QueUsingStack {

	public Integer length = 0;
	StackUsingList containerStack;
	StackUsingList tmpStack;

	public QueUsingStack(Integer size){
		containerStack = new StackUsingList(size);
		tmpStack = new StackUsingList(size);
	}

	public void  enque(Integer value) throws Exception {

		while (!containerStack.isEmpty()){
			tmpStack.push(containerStack.pop());
		}

		tmpStack.push(value);
		length++;

		while (!tmpStack.isEmpty()){
			containerStack.push(tmpStack.pop());
		}
	}

	public Integer deque() throws Exception {
		System.out.println("Dequeing ");
		if(!containerStack.isEmpty()){
			length--;
			return  containerStack.pop();
		} else {
			throw new Exception("Empty que");
		}
	}

	public boolean isEmpty() {
		return length == 0;
	}
}
